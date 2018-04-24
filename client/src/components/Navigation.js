import React, { Component } from 'react';
import '../css/sb2admin/sb-admin-2.css'

import NavigationBarHeader from './NavigationBarHeader.js'
import NavigationBarTopLinks from './NavigationBarTopLinks.js'
import NavigationSideBar from './NavigationSideBar.js'

class Navigation extends Component {
    constructor(props) {
        super(props);

        this.state = {
//          scaffoldMeta: props.scaffoldMeta,
          serverURL: props.serverURL

        }

    }

    render() {


    //    console.log(menus);
        return (
        <nav className="navbar navbar-default navbar-static-top" style={{marginBottom: 0}}>
            <NavigationBarHeader/>
            <NavigationBarTopLinks/>
            <NavigationSideBar serverURL = {this.state.serverURL}/>
        </nav>
        );
    }

}

export default Navigation;