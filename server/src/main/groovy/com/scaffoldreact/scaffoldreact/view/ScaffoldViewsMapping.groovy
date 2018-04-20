package com.scaffoldreact.scaffoldreact.view

import com.scaffoldreact.scaffoldreact.menu.MappedMenu
import com.scaffoldreact.scaffoldreact.menu.MappedMenuItem
import com.scaffoldreact.scaffoldreact.urlMapping.URLMapper
import com.scaffoldreact.scaffoldreact.util.ClosureReader
import com.scaffoldreact.scaffoldreact.views.AbstractMappedView
import com.scaffoldreact.scaffoldreact.views.MappedViewFactory
import grails.util.Holders
import groovy.util.logging.Slf4j

@Slf4j
class ScaffoldViewsMapping {

    URLMapper urlMapper

    final static String VIEWS = "views"
    final static String MENU = "menu"

    Class annotatedClass

    ArrayList<AbstractMappedView> views = new ArrayList()

    MappedMenu menu

    String classBaseUrl

    String pluginName = ""

    ScaffoldViewsMapping(Class aClass) {

        urlMapper = URLMapper.getInstance()
        log.debug("Mapping class ${aClass.simpleName}")
        this.annotatedClass = aClass
        pluginName = Holders.currentPluginManager().getPluginForClass(annotatedClass)?.name?:"app"
        Closure scaffoldViewsClosure = annotatedClass.scaffoldViews?:defaultClosure
        Map convertedScaffoldViewsClosure = ClosureReader.toMapConfig(scaffoldViewsClosure)
        classBaseUrl = convertedScaffoldViewsClosure.baseUrl?:aClass.simpleName
        handleViews(views, convertedScaffoldViewsClosure)
        handleMenu(views, convertedScaffoldViewsClosure)
        generateURLs()


//        handleNameAndTitle
//        handleDefaultFields
//        handleDefaultController
//        handleDefaultService
//        handleMenu

    }

    private void handleMenu(ArrayList views, Map convertedScaffoldViewsClosure) {
        if (convertedScaffoldViewsClosure[MENU]!=null){
            menu = new MappedMenu(convertedScaffoldViewsClosure[MENU])
        }
        else {
            menu = null
        }
    }

    private void handleViews(ArrayList views, Map convertedScaffoldViewsClosure) {
        convertedScaffoldViewsClosure[VIEWS].each { viewName, parameters ->
            log.debug ("Found view ${viewName}")
            AbstractMappedView mappedView = ((MappedViewFactory)MappedViewFactory.getInstance()).createView(viewName, parameters, annotatedClass, classBaseUrl, pluginName)
            if(mappedView){
                views << mappedView
                log.debug ("View ${viewName} mapped")
            }
        }
    }

    private void generateURLs() {
        views.each { AbstractMappedView view ->
//            urlMapper.registerView(pluginName, classBaseUrl,view.getBaseURL(), view.controller, annotatedClass, view.metaController, view.metaAction)
            urlMapper.registerView(view/*, this*/)
        }

    }

    List<MappedMenuItem> getSubMenuItems(){
        views.collect{ view->
            view.menuItem
        }.findAll{it.enabled == true}
    }


    private defaultClosure = {
        'CREATE' title: "CRIAR"
    }

    AbstractMappedView findByType(String type) {
        this.views.find { AbstractMappedView view ->
            view.class.TYPE == type

        }
    }
}
