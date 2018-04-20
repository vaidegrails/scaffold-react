package com.scaffoldreact.scaffoldreact.menu

/**
 * Represents a menu mapped by the ScaffoldViews Plugin
 */
class MappedMenuItem {
    String icon = ""
    String root = ""
    String title = ""
    Boolean enabled = false
    Boolean visible = false
    String url = ""
    String key
    List<String> roles = []

    String getName () {
        return title
    }

//    String getKey() {
//        return root/* + this.hashCode()*/
//    }

}
