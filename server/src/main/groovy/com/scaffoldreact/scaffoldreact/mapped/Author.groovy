package com.scaffoldreact.scaffoldreact.mapped

import com.scaffoldreact.scaffoldreact.annotation.ScaffoldViews
import com.scaffoldreact.scaffoldreact.views.ListMappedView
import com.scaffoldreact.scaffoldreact.views.ShowMappedView

@ScaffoldViews
class Author {

    String name
    Integer pages
    Date date

    static scaffoldViews = {
        name "author"
        title "The Author"
        //baseUrl "/core/book"
        views {
            "${ShowMappedView.TYPE}" {
                title "Details of the book"
                subTitle "It shows every detail"
//                baseURL 'show'
                roles (['ROLE_BOOK_SHOW'])
                buttons:
                {

                }
                menu {
                    icon ""
                    root "core"
                    title "Menu Title of Show"
                    enabled true
                    visible true
                }
            }
            "${ListMappedView.TYPE}" {
                title "List of books"
                subTitle "It shows every added book"
                //baseURL 'index'
                roles (['ROLE_BOOK_LIST'])
                buttons:
                {

                }
                menu {
                    icon ""
                    root "author"
                    title "Menu Title of List"
                    enabled true
                    visible true
                }
                controller "Book"
            }
        }
        defaultFields {
            bookTitle order: 2, nullable: false, type: 'email', roles: ['ROLE_BOOK_SHOW_TITLE']
        }

        defaultController "com.portalbll.scaffoldviews.BookController"
        defaultService "com.portalbll.scaffoldviews.BookService"

        menu {
            //icon ""
            root "author"
            title "The Best Author Ever"
            enabled false
            visible false
        }
    }
}
