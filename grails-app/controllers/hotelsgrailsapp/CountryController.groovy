package hotelsgrailsapp

class CountryController {

    CountryService countryService

    def index() {
        respond([countryTotal: Country.count(), countryList: countryService.list()])
    }

    def add(){
        render(view: 'add')
    }

    def addCountry(Country country){
        println(country.name)
        countryService.save(country)

        redirect action: 'index'
    }

    def updateCountry(Country country) {
        Country countryToUpdate = countryService.get(params.countryId)
        countryToUpdate.name = country.name
        countryToUpdate.capital = country.capital
//        log.info("Идет сохранение Country[name:${country.name}, capital:${country.capital}]...")
        countryService.save(countryToUpdate)

        redirect action: 'index'
    }

    def edit(int id) {
        respond([country: countryService.get(id)])
    }

    def delete(int id){
        //todo сть оповещение что отели тоже удаляются
        println(id)
        countryService.delete(id)

        redirect action: 'index'
    }
}
