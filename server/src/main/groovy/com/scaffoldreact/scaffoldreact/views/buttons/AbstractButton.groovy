package com.scaffoldreact.scaffoldreact.views.buttons

abstract class AbstractButton {

    public static String TYPE = "ABSTRACT_BUTTON"


    public abstract String getType()
    String name
    String label
//    String type
    String classCss
    Map icon
    ArrayList<String> positions
    ArrayList<String> roles
    String url

    protected abstract String getDefaultName()
    protected abstract String getDefaultLabel()
//    protected abstract String getDefaultType()
    protected abstract String getDefaultClassCss()
    protected abstract Map getDefaultIcon()
    protected abstract ArrayList<String> getDefaultPositions()
    protected abstract ArrayList<String> getDefaultRoles()
    protected abstract String getDefaultUrl()

    AbstractButton(Map configuration) {
        name = configuration.name?:getDefaultName()
        label = configuration.label?:getDefaultLabel()
//        type = configuration.type?:getDefaultType()
        classCss = configuration.classCss?:getDefaultClassCss()
        icon = configuration.icon?:getDefaultIcon()
        positions = configuration.positions?:getDefaultPositions()
        roles = configuration.roles?:getDefaultRoles()
        url = configuration.url?:getDefaultUrl()
    }

}
