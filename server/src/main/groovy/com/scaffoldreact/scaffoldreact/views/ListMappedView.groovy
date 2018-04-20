package com.scaffoldreact.scaffoldreact.views

import com.scaffoldreact.scaffoldreact.fields.DataTableField
import com.scaffoldreact.scaffoldreact.views.buttons.AbstractButton

/**
 * Class that maps LIST Views (List with pagination of all the elements in database)
 */
class ListMappedView extends AbstractMappedView {
    public final static String TYPE = "LIST"

    @Override
    protected Map getDefaultConfigMap() {
        return [:]
    }

    @Override
    protected String getDefaultBaseURL() {
        return "list"
    }

    @Override
    protected String getDefaultTitle() {
        return "List"
    }

    @Override
    protected String getDefaultSubtitle() {
        return "List all the elements in database"
    }

    @Override
    protected String getDefaultController() {
        return "scaffoldViews"
    }

    @Override
    String getMetaController() {
        return "meta"
    }

    @Override
    String getMetaAction() {
        return "list"
    }

    @Override
    protected List<AbstractButton> getDefaultButtons() {
        []
    }

    @Override
    protected getDefaultRoles() {
        String defaultRole = "ROLE_${pluginName}_${annotatedClass.simpleName.toUpperCase()}_${this.class.TYPE}"
        return [defaultRole]
    }

    ListMappedView(Map<String, String> descriptor, Class aClass, String classBaseUrl, String pluginName) {
        super(descriptor, aClass, classBaseUrl, pluginName)


        this.fields << new DataTableField(this, descriptor.dataTable)
        //;
//        this.baseURL = descriptor.get(AbstractMappedView.BASE_URL) ?: baseURL
//        this.roles = descriptor.get(AbstractMappedView.ROLES) ?: roles
//        this.title = descriptor.get(AbstractMappedView.TITLE) ?: title
//        this.subTitle = descriptor.get(AbstractMappedView.SUB_TITLE) ?: subTitle
//        this.annotatedClass = aClass
    }

    @Override
    Map generateMetadata() {
        return null
    }
}
