package hotelsgrailsapp

import grails.gorm.transactions.Transactional

@Transactional
class HotelService {

    Hotel get(id){
        Hotel.get(id)
    }

    def list() {
        Hotel.list()
    }

    Hotel save(Hotel hotel) {
        hotel.save()
    }

    def delete(id) {
        Hotel.get(id).delete()
    }

//    boolean validate(Hotel hotel){
//        hotel.
//    }
}
