package com.scaffoldreact.scaffoldreact.views.buttons

class RedirectButton extends  AbstractButton{
    public static String TYPE = "REDIRECT"
    String rota

    RedirectButton(Map configuration) {
        super(configuration)
        this.rota = "/scaffolding/core-campus/:id"
    }

    @Override
    String getType() {
        return this.class.TYPE
    }

    @Override
    protected String getDefaultName() {
        return "button-show"
    }

    @Override
    protected String getDefaultLabel() {
        return ""
    }

    @Override
    protected String getDefaultClassCss() {
        return "btn btn-default btn-sm"
    }

    @Override
    protected Map getDefaultIcon() {
        return ["class":"fa fa-eye","position":"left"]
    }

    @Override
    protected ArrayList<String> getDefaultPositions() {
        return null
    }

    @Override
    protected ArrayList<String> getDefaultRoles() {
        return null
    }

    @Override
    protected String getDefaultUrl() {
        return "/scaffolding/core-campus/:id"
//        return null
    }
}
