class MenuController {

    def index() {
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
}
