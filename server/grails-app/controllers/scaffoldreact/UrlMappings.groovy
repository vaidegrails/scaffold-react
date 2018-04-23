package scaffoldreact

class UrlMappings {

    static mappings = {
        delete "/$controller/$id(.$format)?"(action:"delete")
        get "/$controller(.$format)?"(action:"index")
        get "/$controller/$id(.$format)?"(action:"show")
        post "/$controller(.$format)?"(action:"save")
        put "/$controller/$id(.$format)?"(action:"update")
        patch "/$controller/$id(.$format)?"(action:"patch")

        "/"(controller: 'application', action:'index')
        "/meta/menu"(controller: 'meta', action: 'menu')
        "/meta/show"(controller: 'meta', action: 'show')
        "/meta/get/$id"(controller: 'meta', action: 'get')
        "500"(view: '/error')
        "404"(view: '/notFound')
    }
}
