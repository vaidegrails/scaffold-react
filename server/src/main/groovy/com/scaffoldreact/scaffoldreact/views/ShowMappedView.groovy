package com.scaffoldreact.scaffoldreact.views

import com.scaffoldreact.scaffoldreact.views.buttons.AbstractButton

/**
 * Class that maps SHOW Views (Show details of the object, without the possibility to edit)
 */
class ShowMappedView extends AbstractMappedView{
    public final static String TYPE = "SHOW"

    @Override
    protected Map getDefaultConfigMap() {
        return [
                title: "Details of ${annotatedClass.simpleName}",
                subTitle: "It shows the details of this ${annotatedClass.simpleName}",
                baseURL: "${baseURL}",
                roles: (["ROLE_${annotatedClass.simpleName.toUpperCase()}_SHOW"]),
                buttons:
                    [
                        [
                                "name": "button-list",
                                "label": "Listar",
                                "type": "REDIRECT",
                                "classCss": "btn btn-circle btn-default",
                                "icon": [
                                        "class": "fa fa-list",
                                        "position": "left"
                                ],
                                "positions": [
                                        "show-top"
                                ],
                                "permissions": [],
                                "url": ""
                        ],
                        [
                                "name": "button-edit-show",
                                "label": "Editar",
                                "type": "REDIRECT",
                                "classCss": "btn btn-circle btn-primary",
                                "icon": [
                                        "class": "fa fa-pencil",
                                        "position": "left"
                                ],
                                "positions": [
                                        "show-top"
                                ],
                                "permissions": [],
                                "url": ""
                        ]
                    ],
                menu: false
        ]
    }

    @Override
    protected String getDefaultBaseURL() {
        return "show"
    }

    @Override
    protected String getDefaultTitle() {
        return "Details of ${annotatedClass.simpleName}"
    }

    @Override
    protected String getDefaultSubtitle() {
        return "It shows the details of this ${annotatedClass.simpleName}"
    }

    @Override
    protected String getDefaultController() {
        return "scaffoldViews"
    }

    @Override
    String getMetaController() {
        "meta"
    }

    @Override
    String getMetaAction() {
        return null
    }

    @Override
    protected List<AbstractButton> getDefaultButtons() {
        return null
    }

    @Override
    protected getDefaultRoles() {
        String defaultRole = "ROLE_${pluginName}_${annotatedClass.simpleName.toUpperCase()}_${this.class.TYPE}"
        return [defaultRole]
    }

    ShowMappedView(Map<String, String> descriptor, Class aClass, String classBaseUrl, String pluginName) {
        super(descriptor, aClass, classBaseUrl, pluginName);
    }

    @Override
    Map generateMetadata() {
        return null
    }
//    @Override
//    MappedMenu createMenuItem(Map<String, String> descriptor, Class aClass) {
//
//
//    }
}
