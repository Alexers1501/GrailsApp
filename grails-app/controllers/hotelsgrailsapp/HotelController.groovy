package hotelsgrailsapp

import org.h2.jdbc.JdbcSQLIntegrityConstraintViolationException

class HotelController {

    HotelService hotelService
    CountryService countryService

    def currentFilterParams = [filterName: "", countryName: "Любая"]

    def index() {
        initCatalogPage()
    }

    def catalog(){
        initCatalogPage()
    }

    private def initCatalogPage(){
        if (!params.offset){
            params.offset = 0
            params.max = 10
            currentFilterParams.filterName = ""
            currentFilterParams.countryName = "Любая"
        }
        String message = "Количество найденных отелей: ${Hotel.count()}"
        respond([messageCountHotels: message,
                 hotelList: hotelService.list(params.max, params.offset),
                 countryList: countryService.list(),
                 filterParams: currentFilterParams])
    }

    def add(){
        Hotel hotel = new Hotel()
        respond([hotel: hotel, countryList: countryService.list()])
    }

    def addHotel(Hotel hotel){
        hotel.setCountry(countryService.getByName(hotel.country.name))

        if (!hotel.validate()){
            log.error("Отель не был сохранен!")
            render view: 'add', model: [hotel: hotel, countryList: countryService.list()]
        }
        else{
            hotelService.save(hotel)
            redirect action: 'catalog'
        }

    }

    def updateHotel(Hotel hotel) {
        hotel.setCountry(countryService.getByName(hotel.country.name))

        if (!hotel.validate()){
            hotel.setId(params.hotelId.toLong())
            log.error("Отель не был изменен!")
            render view: 'edit', model: [hotel: hotel, countryList: countryService.list()]
        }
        else{
            Hotel hotelToUpdate = hotelService.get(params.hotelId)
            hotelToUpdate.setCountry(countryService.getByName(hotel.country.name))
            hotelToUpdate.name = hotel.name
            hotelToUpdate.rate = hotel.rate
            hotelToUpdate.site = hotel.site
            hotelService.save(hotelToUpdate)
            redirect action: 'catalog'
        }

    }

    def edit(int id) {
        respond([hotel: hotelService.get(id), countryList: countryService.list()])
    }

    def delete(int id){
        hotelService.delete(id)

        redirect action: 'catalog'
    }

    def searchByIndexPage(String filterName, String countryName){
        def model = searchHotelsByFilter(filterName, countryName)

        render view: 'index', model: model
    }

    def searchByCatalogPage(String filterName, String countryName){
        def model = searchHotelsByFilter(filterName, countryName)

        render view: 'catalog', model: model
    }

    private def searchHotelsByFilter(String filterName, String countryName){

        if (countryName){
            currentFilterParams.filterName = filterName
            currentFilterParams.countryName = countryName
        }

        if (!params.offset){
            params.offset = 0
            params.max = 10
        }

        def results = hotelService.filterHotelsBySearchBar(currentFilterParams.filterName,
                currentFilterParams.countryName, params.max, params.offset)
        String message
        if (results.size() == 0){
            message = "По Вашему запросу ничего не найдено"
        }
        else{
            message = "Количество найденных отелей: ${results.totalCount}"
        }

        def model = [messageCountHotels: message,
                     hotelList: results,
                     countryList: countryService.list(),
                     filterParams: currentFilterParams]

        return model
    }
}
