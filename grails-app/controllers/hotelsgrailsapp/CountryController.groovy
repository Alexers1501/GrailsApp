package hotelsgrailsapp

class CountryController {

    CountryService countryService

    def index() {
        respond([countryList: countryService.list()])
    }

    def updateName(String name) {
        session.name = name
        flash.message = "Name has been updated"

        redirect action: 'index'
    }

    def edit(int id) {
        respond([country: countryService.get(id)])
    }
}
