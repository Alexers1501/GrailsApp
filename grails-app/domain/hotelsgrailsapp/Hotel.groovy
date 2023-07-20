package hotelsgrailsapp

class Hotel {

    String name
    Country country
    int rate
    String site

    static constraints = {
        //todo уинкальне в пределах страны и потом другие поля тоже
        name nullable: false, unique: true, maSize: 255
        country nullable: false
        rate nullable: false, min: 1, max: 5
        site nullable: true
    }
}
