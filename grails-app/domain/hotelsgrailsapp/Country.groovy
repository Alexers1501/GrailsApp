package hotelsgrailsapp

class Country {

    String name
    String capital

    static hasMany = [hotels: Hotel]
    static mappedBy = [hotels: "country"]

    static constraints = {
        name nullable: false, unique: true, maxSize: 255
        capital nullable: false, maxSize: 128
    }
}
