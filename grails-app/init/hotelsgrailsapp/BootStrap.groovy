package hotelsgrailsapp

import groovy.transform.CompileStatic

@CompileStatic
class BootStrap {

    CountryService countryService
    HotelService hotelService


    def init = { servletContext ->

        Country russia = new Country(name: 'Russia', capital: 'Moscow')
        Country germany = new Country(name: 'Germany', capital: 'Berlin')
        Country france = new Country(name: 'France', capital: 'Paris')
        countryService.save(russia)
        countryService.save(germany)
        countryService.save(france)

        hotelService.save(new Hotel(name: 'Вятка', country: russia, rate: 4))
        hotelService.save(new Hotel(name: 'Monk', country: russia, rate: 3))
        hotelService.save(new Hotel(name: 'Monte', country: france, rate: 5))
    }
    def destroy = {
    }
}
