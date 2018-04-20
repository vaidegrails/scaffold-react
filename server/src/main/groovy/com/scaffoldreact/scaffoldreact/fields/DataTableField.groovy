package com.scaffoldreact.scaffoldreact.fields

import com.scaffoldreact.scaffoldreact.views.AbstractMappedView
import com.scaffoldreact.scaffoldreact.views.buttons.AbstractButton
import com.scaffoldreact.scaffoldreact.views.buttons.RedirectButton
import grails.util.Holders
import org.grails.datastore.mapping.model.PersistentEntity
import org.grails.datastore.mapping.model.PersistentProperty

class DataTableField extends AbstractField{

    final static String TYPE = "DATATABLE_FIELD"

    String title


    ArrayList<Map<String, String>> columns = new ArrayList<Map<String,String>>()

    HashMap<String, List<AbstractButton>> buttons = new HashMap<>()
    Boolean pagination
    Boolean searchable
    Boolean ordering
    String sort
    Integer numPaginate
    Map url

    DataTableField(AbstractMappedView view, Map configurations = null) {
        super(view, configurations)

        if (!configurations) {
            initializeWithDefaultValues(view)

        }
        else {
            //TODO: Implement
        }

    }

    private void initializeWithDefaultValues(AbstractMappedView view) {
        title = "List ${view.annotatedClass.simpleName}"
        pagination = true
        searchable = false
        ordering = true
        sort = "id"
        numPaginate = 10
        url = [
                path  : view.generateUrl(),
                action: "GET"
        ]
        buttons << [DATATABLE_LINE: [new RedirectButton([:])]]
        initializeFieldsWithDefaultValues(view)
    }

    private void initializeFieldsWithDefaultValues(AbstractMappedView view) {


        PersistentEntity persistentEntity = Holders.grailsApplication.mappingContext.getPersistentEntity(view.annotatedClass.name)
//        DomainClassArtefactHandler domainClassHandler = Holders.grailsApplication.getArtefact(DomainClassArtefactHandler.TYPE, )


        //Handles domain classes
        if (persistentEntity) {
            persistentEntity.persistentProperties.each { PersistentProperty persistentProperty ->
                columns << [
                        name: persistentProperty.name, title: persistentProperty.getCapitilizedName(),
                        key: persistentProperty.name.toUpperCase(), length: null, type: "INPUT", order: 0, orderable: false]
//                {"name":"id","title":"Id","key":"ID","length":null,"type":"HIDDEN","order":0,"orderable":true}
            }
//            columns << [
//                    name: "version", title: "version",
//                    key: "version".toUpperCase(), length: null, type: "HIDDEN", order: 0, orderable: false
//            ]
        }
        else {
            //TODO: Handle not domain classes
        }
    }
}
