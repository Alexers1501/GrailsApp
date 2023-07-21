package hotelsgrailsapp

class HotelController {

    HotelService hotelService
    CountryService countryService

    def currentFilterParams = [filterName: "", countryName: "Любая"]

    def index() {
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
            redirect action: 'index'
        }

    }

    def updateHotel(Hotel hotel) {
        Hotel hotelToUpdate = hotelService.get(params.countryId)
        hotelToUpdate.name = hotel.name

        hotelService.save(hotelToUpdate)

        redirect action: 'index'
    }

    def edit(int id) {
        respond([hotel: hotelService.get(id)])
    }

    def delete(int id){
        hotelService.delete(id)

        redirect action: 'index'
    }

    def searchHotelsByFilter(String filterName, String countryName){

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

        render view: 'index',
                model: [messageCountHotels: message,
                        hotelList: results,
                        countryList: countryService.list(),
                        filterParams: currentFilterParams]
    }
}
