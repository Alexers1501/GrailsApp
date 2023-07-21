package hotelsgrailsapp

import groovy.transform.CompileStatic

@CompileStatic
class BootStrap {

    CountryService countryService
    HotelService hotelService


    def init = { servletContext ->

        Country russia = new Country(name: 'Россия', capital: 'Москва')
        Country germany = new Country(name: 'Германия', capital: 'Берлин')
        Country france = new Country(name: 'Франция', capital: 'Париж')
        countryService.save(russia)
        countryService.save(germany)
        countryService.save(france)

        hotelService.save(new Hotel(name: 'Вятка', country: russia, rate: 4))
        hotelService.save(new Hotel(name: 'Monk', country: russia, rate: 3))
        hotelService.save(new Hotel(name: 'Monte', country: france, rate: 5))
        hotelService.save(new Hotel(name: 'Monte1', country: france, rate: 5))
        hotelService.save(new Hotel(name: 'Monte2', country: france, rate: 5))
        hotelService.save(new Hotel(name: 'Monte3', country: france, rate: 5))
        hotelService.save(new Hotel(name: 'Monte4', country: france, rate: 5))
        hotelService.save(new Hotel(name: 'Monte5', country: france, rate: 5))
        hotelService.save(new Hotel(name: 'Monte6', country: france, rate: 5))
        hotelService.save(new Hotel(name: 'Monte7', country: france, rate: 5))
        hotelService.save(new Hotel(name: 'Monte8', country: france, rate: 5))
        hotelService.save(new Hotel(name: 'Monte9', country: france, rate: 5))
        hotelService.save(new Hotel(name: 'Monte10', country: france, rate: 5))
        hotelService.save(new Hotel(name: 'Monte11', country: france, rate: 5))
    }
    def destroy = {
    }
}
