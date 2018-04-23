import React, { Component } from 'react';
import '../css/sb2admin/sb-admin-2.css'

import NavigationBarHeader from './NavigationBarHeader.js'
import NavigationBarTopLinks from './NavigationBarTopLinks.js'

class Navigation extends Component {


    render() {


    //    console.log(menus);
        return (
//        <!-- Navigation -->
        <nav className="navbar navbar-default navbar-static-top" style={{marginBottom: 0}}>
            <NavigationBarHeader/>
            <NavigationBarTopLinks/>
        </nav>
        );
    }

}

export default Navigation;