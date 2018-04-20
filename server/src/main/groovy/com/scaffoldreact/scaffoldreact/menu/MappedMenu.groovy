package com.scaffoldreact.scaffoldreact.menu

class MappedMenu {
    Map icon = [
            class: "",
            position: null
    ]
    String root = ""
    String title = ""
    String getName(){
        return title
    }
    String getKey() {
        return root
    }
    Boolean enabled = false
    Boolean visible = false

    List<MappedMenuItem> items = []
//    String url = ""
//    List<String> roles = []

}
