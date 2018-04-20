package com.scaffoldreact.scaffoldreact.views

class MappedViewFactory {

    ArrayList<Class<AbstractMappedView>> registeredMappedViews = new ArrayList<>()
    private static instance
    static getInstance() {

        if (instance == null) {
            instance = new MappedViewFactory()
            //TODO: Auto register mapped views
            instance.registeredMappedViews.add(ShowMappedView)
            instance.registeredMappedViews.add(ListMappedView)
        }
        return instance
    }

    public AbstractMappedView createView(String type, Map parameters, Class objectClass, String classBaseUrl, String pluginName) {
        AbstractMappedView generatedView = null
        Class<AbstractMappedView> abstractMappedView = registeredMappedViews.find {
            it.TYPE == type
        }
        if (abstractMappedView) {
            generatedView = abstractMappedView.newInstance(parameters, objectClass, classBaseUrl, pluginName)
        }
        return generatedView
    }

}
