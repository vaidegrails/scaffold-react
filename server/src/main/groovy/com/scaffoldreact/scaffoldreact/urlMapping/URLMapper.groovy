package com.scaffoldreact.scaffoldreact.urlMapping

import com.scaffoldreact.scaffoldreact.views.AbstractMappedView
import grails.util.Holders

/**
 * This class is used to register a new view in the Grails URL Mappings.
 */
class URLMapper {
    def grailsControllerUrlMappings

    private static URLMapper instance

    public static URLMapper getInstance() {
        if (instance == null) {
            instance = new URLMapper()
        }
        return instance
    }

    URLMapper() {
        try {
            grailsControllerUrlMappings = Holders.grailsApplication.mainContext.getBean("grailsUrlMappingsHolder")
        }
        catch (Exception e) {
            grailsControllerUrlMappings = Holders.applicationContext.getBean("grailsUrlMappingsHolder")
        }
    }


    /**
     * Register a view in the Grails URL Mappings
     * @param classBaseUrl The base URL for resources of the class
     * @param viewBaseUrl The specific base URL for the view that is going to be registered
     * @param controller The name of the controller that will respond the request
     * @param aClass The class for which the view is registered.
     */
    public void registerView(AbstractMappedView view/*, ScaffoldViewsMapping scaffoldViewsMapping*/) {
        String url = view.generateUrl()//"/${view.pluginName}/${view.classBaseUrl}/${view.getBaseURL()}"
        this.grailsControllerUrlMappings.addMappings( {
            "$url"(
                    controller: "${view.controller}",
                    action: "${view.getBaseURL()}",
//                    version: "5",
                    method: "GET")/*,
                    plugin: pluginName)*/
        })

        String metaUrl = view.generateMetaUrl()//"/${view.pluginName}/${view.classBaseUrl}Scaffolding/meta/${view.getBaseURL()}"
        this.grailsControllerUrlMappings.addMappings(
                {
                    "$metaUrl"(controller: "${view.metaController}", action: "${view.metaAction}", method: "GET") {
                        resourceClass = view.annotatedClass.canonicalName
                    }
                }
        )




    }
}
