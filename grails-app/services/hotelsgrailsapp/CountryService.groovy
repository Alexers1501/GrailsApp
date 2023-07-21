package hotelsgrailsapp

import grails.gorm.transactions.Transactional

@Transactional
class CountryService {

    Country get(id){
        Country.get(id)
    }

    Country getByName(String name){
        Country.findByName(name)
    }

    def list(max = 10, offset = 0) {
        def criteria = Country.createCriteria()
        def result = criteria.list (max: max, offset: offset){
            order("name", "asc")
        }
        return result
    }

    Country save(Country country) {
        country.save()
    }

    def delete(id) {
        Country.get(id).delete()
    }

    def filterCountryBySearchBar(String countryName,
                                 max = 10, offset = 0){
        def criteria = Country.createCriteria()
        def result = criteria.list (max: max, offset: offset){
            ilike("name", "%${countryName}%")
            order("name", "asc")
        }
        return result
    }
}
