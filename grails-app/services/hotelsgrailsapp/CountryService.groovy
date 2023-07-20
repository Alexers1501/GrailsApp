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

    def list() {
        Country.list()
    }

    Country save(Country country) {
        country.save()
    }

    def delete(id) {
        Country.get(id).delete()
    }
}
