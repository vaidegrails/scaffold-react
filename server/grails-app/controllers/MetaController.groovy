import com.scaffoldreact.scaffoldreact.fields.DataTableField
import com.scaffoldreact.scaffoldreact.mapper.ScaffoldViewsMapper
import com.scaffoldreact.scaffoldreact.views.ListMappedView
import grails.converters.JSON

class MetaController {
//    ScaffoldViewsMapper scaffoldViewsMapper

    def menu() {
        //response.setStatus(401)

        def scaffoldViewsMapper = new ScaffoldViewsMapper()
        scaffoldViewsMapper.map()
        def menuList = scaffoldViewsMapper.menuList
        render ([data: menuList] as JSON)

    }

    def login() {
        render ([
                username: "706827",
                roles: ["ROLE_BOOK_LIST"]
        ] as JSON)
    }

    def quantitativo() {
        response.setStatus(402)
    }

    def list() {
        Class resourceClass = Class.forName(params.resourceClass)
        ListMappedView mappedView = (ListMappedView) scaffoldViewsMapper.findMappedViewByClassAndType(
                resourceClass, ListMappedView.TYPE)

//render (mappedView as JSON)
        respond(
                dataTable: mappedView.findFieldByType(DataTableField.TYPE),
                title: mappedView.title,
                actions: [:],
                buttons:
                        ((DataTableField) mappedView.findFieldByType(DataTableField.TYPE)).buttons
                /*["DATATABLE_LINE":[]]*/
//                        "DATATABLE_TOP": [
//                                        [
//                                                "name": "button-insert",
//                                                "label": "Novo",
//                                                "type": "REDIRECT",
//                                                "classCss": "btn btn-circle btn-success",
//                                                "icon": [
//                                                        "class": "fa fa-plus-circle",
//                                                        "position": "left"
//                                                ],
//                                                "rota": "/scaffolding/core11256939264/listar/"
//                                        ]
//                                ],
//                                "DATATABLE_LINE": [
//                                        [
//                                                "name": "button-show",
//                                                "label": "",
//                                                "type": "REDIRECT",
//                                                "classCss": "btn btn-default btn-sm",
//                                                "icon": [
//                                                        "class": "fa fa-eye",
//                                                        "position": "left"
//                                                ],
//                                                "rota": "/scaffolding/core11256939264/listar/:id"
//                                        ],
//                                        [
//                                                "name": "button-edit",
//                                                "label": "",
//                                                "type": "REDIRECT",
//                                                "classCss": "btn btn-primary btn-sm",
//                                                "icon": [
//                                                        "class": "fa fa-pencil",
//                                                        "position": "left"
//                                                ],
//                                                "rota": "/scaffolding/core11256939264/listar/:id"
//                                        ]
//                                ]
//                ]
        )

//        if (mappedView) {
//            render mappedView.generateMetadata()
//        }
//
//        render(
//                [
//                        dataTable:
//                                ["pagination": true,
//                                 "searchable": true,
//                                 "ordering": true,
//                                 "sortable": true,
//                                 "order": "desc",
//                                 "sort": "atributo",
//                                 "title": "Espaço Físico - Listar Atributo sala",
//                                 "numPaginate": 10,
//                                 "url": [
//                                         "path": "/scaffoldViews/Book/list",
//                                         "action": "GET"
//                                 ],
//                                 "columns": [
//                                         [
//                                                 "name": "id",
//                                                 "title": "Id",
//                                                 "key": "id",
//                                                 "length": null,
//                                                 "type": "HIDDEN",
//                                                 "order": 0,
//                                                 "orderable": false
//                                         ],
//                                         [
//                                                 "name": "atributo",
//                                                 "title": "Atributo",
//                                                 "key": "atributo",
//                                                 "length": null,
//                                                 "type": "INPUT",
//                                                 "order": 2,
//                                                 "orderable": false
//                                         ]
//                                 ]
//                                ],
//                        "title": "Espaço Físico - Listar Atributo sala",
//                        "actions": [
//                                "create": [
//                                        "title": "Criar",
//                                        "url": [
//                                                "path": "/core/atributoSalaScaffolding",
//                                                "action": "POST"
//                                        ]
//                                ],
//                                "edit": [
//                                        "title": "Editar",
//                                        "url": [
//                                                "path": "/core/atributoSalaScaffolding/:id",
//                                                "action": "PUT"
//                                        ]
//                                ],
//                                "delete": [
//                                        "title": "Deletar",
//                                        "url": [
//                                                "path": "/core/atributoSalaScaffolding/:id",
//                                                "action": "DELETE"
//                                        ]
//                                ],
//                                "show": [
//                                        "title": "Visualizar",
//                                        "url": [
//                                                "path": "/core/atributoSalaScaffolding/:id",
//                                                "action": "GET"
//                                        ]
//                                ],
//                                "list": [
//                                        "title": "Listar",
//                                        "url": [
//                                                "path": "/core/atributoSalaScaffolding",
//                                                "action": "GET"
//                                        ]
//                                ],
//                                "select": [
//                                        "title": "null",
//                                        "url": [
//                                                "path": "/core/atributoSalaScaffolding",
//                                                "action": "GET"
//                                        ]
//                                ]
//                        ]
//                        ,
//                        "buttons": [
////                                "DATATABLE_TOP": [
////                                        [
////                                                "name": "button-insert",
////                                                "label": "Novo",
////                                                "type": "REDIRECT",
////                                                "classCss": "btn btn-circle btn-success",
////                                                "icon": [
////                                                        "class": "fa fa-plus-circle",
////                                                        "position": "left"
////                                                ],
////                                                "rota": "/scaffolding/core11256939264/listar/"
////                                        ]
////                                ],
//                                "DATATABLE_LINE": [
//                                        [
//                                                "name": "button-show",
//                                                "label": "",
//                                                "type": "REDIRECT",
//                                                "classCss": "btn btn-default btn-sm",
//                                                "icon": [
//                                                        "class": "fa fa-eye",
//                                                        "position": "left"
//                                                ],
//                                                "rota": "/scaffolding/core11256939264/listar/:id"
//                                        ],
//                                        [
//                                                "name": "button-edit",
//                                                "label": "",
//                                                "type": "REDIRECT",
//                                                "classCss": "btn btn-primary btn-sm",
//                                                "icon": [
//                                                        "class": "fa fa-pencil",
//                                                        "position": "left"
//                                                ],
//                                                "rota": "/scaffolding/core11256939264/listar/:id"
//                                        ]
//                                ]
//
//
//                        ]]
//                                as JSON)


    }
    def example() {
        respond (
                [data:[
                        [
                                name: "Teste",
                                key: "teste",
                                icon: [class: "", position: null],
                                items: [
                                        name: "",
                                        key: "subteste",
                                        url: "",
                                        roles: ["ROLE_1", "ROLE_2"],
                                        root: "teste",
                                        icon: [class: "", position: null],
                                        visible: true

                                ]
                        ]
                ]
                ]
        )
    }


    def show() {
        render ([
            "title":"Cadastros Gerais - Visualizar Campus",
            "subtitle":"Informações do Campus",
            "fields":[
                    [   "key":"nome",
                        "label":"Nome",
                        "id":"Campus.nome",
                        "type":"STATIC",
                        "params":["required":true],
                        "group":null,
                        "defaultValue":null,
                        "readonly":true
                    ],
                    [
                        "key":"id",
                         "label":"Id",
                         "id":"Campus.id",
                         "type":"STATIC",
                         "params":["required":true],
                         "group":null,
                         "defaultValue":null,
                         "readonly":true
                    ],
                    [
                        "key":"version",
                        "label":"Version",
                        "id":"Campus.version",
                        "type":"STATIC",
                        "params":["required":true],
                        "group":null,
                        "defaultValue":null,
                        "readonly":true
                    ]
            ],
            "hasMany":[
                    [
                        "key":"core-campus",
                        "url":"/core/campusScaffolding/:id/unidade",
                        "name":"Unidade",
                        "roles":null,
                        "root":null,
                        "icon":null,
                        "visible":true
                    ]
            ],
            "url":["path":"/core/campusScaffolding/:id","action":"GET"],
            "actions":[
                "create":[
                    "title":"Criar",
                    "url":["path":"/core/campusScaffolding","action":"POST"]
                ],
                "edit":[
                    "title":"Editar",
                    "url":["path":"/core/campusScaffolding/:id","action":"PUT"]
                ],
                "delete":[
                    "title":"Deletar",
                    "url":["path":"/core/campusScaffolding/:id","action":"DELETE"]
                ],
                "show":[
                    "title":"Visualizar",
                    "url":["path":"/core/campusScaffolding/:id","action":"GET"]
                ],
                "list":[
                    "title":"Listar",
                    "url":["path":"/core/campusScaffolding","action":"GET"]
                ],
                "select":[
                    "title":"null",
                    "url":["path":"/core/campusScaffolding","action":"GET"]
                ]
            ],
            "buttons":[
                "SHOW_TOP":[
                    [
                        "name":"button-list",
                        "label":"Listar",
                        "type":"REDIRECT",
                        "classCss":"btn btn-circle btn-default",
                        "icon":["class":"fa fa-list","position":"left"],
                        "rota":"/scaffolding/core-campus/listar"
                    ],
                    [
                        "name":"button-edit-show",
                        "label":"Editar",
                        "type":"REDIRECT",
                        "classCss":"btn btn-circle btn-primary",
                        "icon":["class":"fa fa-pencil","position":"left"],
                        "rota":"/scaffolding/core-campus/editar/:id"
                    ]
                ]
            ]
        ] as JSON)
    }

    def get(Long id) {
        render ([id:5,
                 text:"Valparaíso",
                 version:	0,
                 nome:	'Valparaíso'] as JSON)
    }
}
