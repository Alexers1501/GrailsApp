package hotelsgrailsapp

class HotelController {

    HotelService hotelService
    CountryService countryService

    def index() {
        respond([hotelTotal: Hotel.count(), hotelList: hotelService.list()])
    }

    def add(){
        respond([countryList: countryService.list()])
    }

    def addHotel(Hotel hotel){
        hotel.setCountry(countryService.getByName(hotel.country.name))
        hotelService.save(hotel)

        redirect action: 'index'
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
}
