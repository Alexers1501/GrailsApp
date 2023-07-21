package hotelsgrailsapp

class CountryController {

    CountryService countryService

    private String currentFilterCountryName = ""

    def index() {

        if (!params.offset){
            params.offset = 0
            params.max = 10
            currentFilterCountryName = ""
        }

        def message = "Количество найденных стран: ${Country.count()}"
        respond([messageCountCountry: message,
                countryList: countryService.list(),
                filterName: currentFilterCountryName])
    }

    def add(){
        render(view: 'add')
    }

    def addCountry(Country country){
        countryService.save(country)

        redirect action: 'index'
    }

    def updateCountry(Country country) {
        Country countryToUpdate = countryService.get(params.countryId)
        countryToUpdate.name = country.name
        countryToUpdate.capital = country.capital
        countryService.save(countryToUpdate)

        redirect action: 'index'
    }

    def edit(int id) {
        respond([country: countryService.get(id)])
    }

    def delete(int id){
        println(id)
        countryService.delete(id)

        redirect action: 'index'
    }

    def searchCountry(String filterName){
        currentFilterCountryName = filterName

        if (!params.offset){
            params.offset = 0
            params.max = 10
        }
        def results = countryService.filterCountryBySearchBar(currentFilterCountryName, params.max, params.offset)
        String message
        if (results.size() == 0){
            message = "По Вашему запросу ничего не найдено"
        }
        else{
            message = "Количество найденных стран: ${results.totalCount}"
        }

        def model = [messageCountCountry: message,
                     countryList: results,
                     filterName: currentFilterCountryName]

        render view: 'index', model: model
    }
}
