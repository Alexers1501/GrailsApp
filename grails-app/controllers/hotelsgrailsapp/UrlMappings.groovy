package hotelsgrailsapp

class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }
        "/"(controller: "hotel")
        "500"(view:'/error')
        "404"(view:'/notFound')
    }
    def index(){
        redirect action: '/hotel/index'
    }
}
