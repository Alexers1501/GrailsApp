package hotelsgrailsapp

import grails.gorm.transactions.Transactional

@Transactional
class CountryService {

    Country get(id){
        Country.get(id)
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
