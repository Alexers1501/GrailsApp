package hotelsgrailsapp

class Hotel {

    String name
    Country country
    int rate
    String site

    static belongsTo = [country: Country]

    static constraints = {
        name nullable: false, unique: 'country', maxSize: 255
        country nullable: false
        rate nullable: false, min: 1, max: 5
        site nullable: true
    }
}
