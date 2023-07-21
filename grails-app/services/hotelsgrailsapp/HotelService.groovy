package hotelsgrailsapp

import grails.gorm.transactions.Transactional

@Transactional
class HotelService {

    CountryService countryService

    Hotel get(id){
        Hotel.get(id)
    }

    def list(max = 10, offset = 0) {
        def criteria = Hotel.createCriteria()
        def result = criteria.list (max: max, offset: offset){
            order("rate", "desc")
            order("name", "asc")
        }
        return result
    }

    Hotel save(Hotel hotel) {
        hotel.save()
    }

    def delete(id) {
        Hotel.get(id).delete()
    }

    def filterHotelsBySearchBar(String filterName, String countryName,
                                max = 10, offset = 0){
        def result
        def criteria = Hotel.createCriteria()
        if (countryName == "Любая"){
            result = criteria.list (max: max, offset: offset){
                ilike("name", "%${filterName}%")
                order("rate", "desk")
                order("name", "asc")
            }
        }
        else{
            result = criteria.list (max: max, offset: offset){
                ilike("name", "%${filterName}%")
                country {
                    eq('name', countryName)
                }

                order("rate", "desk")
                order("name", "asc")
            }
        }
        return result

    }
}
