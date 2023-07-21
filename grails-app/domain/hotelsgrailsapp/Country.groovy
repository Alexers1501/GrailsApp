package hotelsgrailsapp

class Country {

    String name
    String capital

//    static hasMany = [hotels: Hotel]

    static constraints = {
        name nullable: false, unique: true, maxSize: 255
        capital nullable: false, maxSize: 128
    }

    static mapping = {
        hotels cascade: 'all-delete-orphan'
    }
}
