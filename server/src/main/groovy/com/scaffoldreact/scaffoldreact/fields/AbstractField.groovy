package com.scaffoldreact.scaffoldreact.fields

import com.scaffoldreact.scaffoldreact.views.AbstractMappedView


abstract class AbstractField {

    final static String TYPE = "ABSTRACT_FIELD"

    ArrayList<String> roles = new ArrayList<String>()
    Object defaultValue = null
    Boolean acl = false
    Boolean enabled = true
    Boolean visible = true
    Boolean editable = true
    String id = "notDefinedId"
    Integer order = 0
    Map icon = [:]
    String label = "Not Defined"


    String mask
    String classes
    String helpBlock
    String placeholder
    String autofocus
    String tabindex
    String keypress
    String required

    AbstractField(AbstractMappedView view, Map configurations = null) {
        if (configurations) {
            //TODO: Implement
        }
    }
}
