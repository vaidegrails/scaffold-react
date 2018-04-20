package com.scaffoldreact.scaffoldreact.views

import com.scaffoldreact.scaffoldreact.fields.AbstractField
import com.scaffoldreact.scaffoldreact.menu.MappedMenuItem
import com.scaffoldreact.scaffoldreact.views.buttons.AbstractButton

/**
 * Abstract class to map Views.
 */
abstract class AbstractMappedView implements Serializable{
    protected final static String BASE_URL = "baseURL";
    protected final static String ROLES = "roles";
    protected final static String TITLE = "title";
    protected final static String SUB_TITLE = "subTitle";
    protected final static String MENU = "menu"

    protected final static String CONTROLLER = "controller";


    //TODO: Extract
    protected final static String FIELDS = "fields";
    protected final static String HAS_MANY = "hasMany";
    protected final static String ACTIONS = "actions";
    protected final static String BUTTONS = "buttons";

    public final static String TYPE = ""

    String baseURL
    String title
    String subTitle
    String pluginName
    String controller

    Class annotatedClass
    MappedMenuItem menuItem


    ArrayList<String> roles = []
    ArrayList<AbstractButton> buttons = []
    ArrayList<AbstractField> fields = []



    protected abstract Map getDefaultConfigMap()
    protected abstract String getDefaultBaseURL()
    protected abstract String getDefaultTitle()
    protected abstract String getDefaultSubtitle()
    protected abstract String getDefaultController()
    abstract String getMetaController()
    abstract String getMetaAction()
    protected abstract List<AbstractButton> getDefaultButtons()

    String classBaseUrl


    protected abstract getDefaultRoles()

    public AbstractMappedView(Map<String, String> scaffoldConfigMap, Class aClass, String classBaseUrl, String pluginName){
        this.pluginName = pluginName
        this.annotatedClass = aClass

        def configMap = getDefaultConfigMap() + scaffoldConfigMap
        this.classBaseUrl = classBaseUrl
        baseURL = scaffoldConfigMap.get(AbstractMappedView.BASE_URL)?:getDefaultBaseURL()
        roles = scaffoldConfigMap.get(AbstractMappedView.ROLES)?:getDefaultRoles()
        title = scaffoldConfigMap.get(AbstractMappedView.TITLE)?:getDefaultTitle()
        subTitle = scaffoldConfigMap.get(AbstractMappedView.SUB_TITLE)?:getDefaultSubtitle()
        controller = scaffoldConfigMap.get(AbstractMappedView.CONTROLLER)?:getDefaultController()

        this.menuItem = createMenuItem(scaffoldConfigMap, aClass, classBaseUrl)

    }

    MappedMenuItem createMenuItem(Map<String, String> descriptor, Class aClass, String classBaseUrl){
        MappedMenuItem mappedMenuItem = new MappedMenuItem(descriptor[MENU])
        mappedMenuItem.url = getCompleteUrl(classBaseUrl)
        mappedMenuItem.roles.addAll(roles)
        mappedMenuItem.root = mappedMenuItem.root?:aClass.simpleName.toLowerCase()
        mappedMenuItem.key = pluginName.toLowerCase() + "-" + aClass.simpleName.toLowerCase() + "-" + baseURL

        return mappedMenuItem
    }

    private String getCompleteUrl(String classBaseUrl) {
        return pluginName + "/" + classBaseUrl + "Scaffolding"// + "/" + baseURL
    }

    public String generateUrl() {
        "/${this.pluginName}/${classBaseUrl}/${this.getBaseURL()}"
    }

    public String generateMetaUrl() {
        "/${this.pluginName}/${classBaseUrl}Scaffolding/meta/${this.getBaseURL()}"
    }


    public abstract Map generateMetadata()

    def findFieldByType(String type) {
        fields.find{ AbstractField field ->
            field.class.TYPE == type

        }

    }
}
