package hotelsgrailsapp

import groovy.transform.CompileStatic

@CompileStatic
class BootStrap {

    CountryService countryService
    HotelService hotelService


    def init = { servletContext ->

        Country c1 = new Country(name: 'Россия', capital: 'Москва')
        Country c2 = new Country(name: 'Германия', capital: 'Берлин')
        Country c3 = new Country(name: 'Франция', capital: 'Париж')
        Country c4 = new Country(name: 'США', capital: 'Вашингтон')
        Country c5 = new Country(name: 'Великобритания', capital: 'Лондон')
        Country c6 = new Country(name: 'Швеция', capital: 'Стокгольм')
        Country c7 = new Country(name: 'Австралия', capital: 'Канберра')
        Country c8 = new Country(name: 'Казахстан', capital: 'Нур-Султан')
        Country c9 = new Country(name: 'Белоруссия', capital: 'Минск')
        countryService.save(c1)
        countryService.save(c2)
        countryService.save(c3)
        countryService.save(c4)
        countryService.save(c5)
        countryService.save(c6)
        countryService.save(c7)
        countryService.save(c8)
        countryService.save(c9)

        hotelService.save(new Hotel(name: 'Вятка', country: c1, rate: 3, site: "https://www.vyatkahotel.ru/"))
        hotelService.save(new Hotel(name: 'Marins Park Hotel', country: c1, rate: 3))
        hotelService.save(new Hotel(name: 'Марриотт Гранд ', country: c1, rate: 5, site: "https://moscowgrandhotel.ru/"))
        hotelService.save(new Hotel(name: 'Best Western Hotel Peine-Salzgitter', country: c2, rate: 3))
        hotelService.save(new Hotel(name: 'Michel Hotel Magdeburg', country: c2, rate: 4, site: "https://www.h-hotels.com/en/hplus/hotels/hplus-hotel-magdeburg"))
        hotelService.save(new Hotel(name: 'The Talbot Hotel', country: c5, rate: 4))
        hotelService.save(new Hotel(name: '2Home Stockholm South', country: c6, rate: 3))
        hotelService.save(new Hotel(name: 'At Six', country: c6, rate: 5))
        hotelService.save(new Hotel(name: 'Berns Hotel', country: c6, rate: 4))
        hotelService.save(new Hotel(name: 'Adabco Boutique Hotel ', country: c7, rate: 4))
        hotelService.save(new Hotel(name: 'AInterContinental Sydney', country: c7, rate: 5))
        hotelService.save(new Hotel(name: 'Marengo Motel', country: c7, rate: 3))
        hotelService.save(new Hotel(name: 'Alamanda Palm Cove By Lancemore', country: c7, rate: 2, site: "https://tophotels.ru/hotel/al156166"))
        hotelService.save(new Hotel(name: 'Тенгри', country: c8, rate: 3))
        hotelService.save(new Hotel(name: 'Ренессанс Актау', country: c8, rate: 5))
        hotelService.save(new Hotel(name: 'Отель Тифлис', country: c8, rate: 1))
        hotelService.save(new Hotel(name: 'Жайлау', country: c8, rate: 2))

    }
    def destroy = {
    }
}
