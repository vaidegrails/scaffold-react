import React, { Component } from 'react';
import '../css/sb2admin/sb-admin-2.css';
import '../css/sb2admin/metismenu/react-metismenu-standart.css';


import FontAwesomeIcon from '@fortawesome/react-fontawesome';
import faEnvelope from '@fortawesome/fontawesome-free-solid/faEnvelope';
import faAngleRight from '@fortawesome/fontawesome-free-solid/faAngleRight';
import faTasks from '@fortawesome/fontawesome-free-solid/faTasks';
import faCaretDown from '@fortawesome/fontawesome-free-solid/faCaretDown';
import faBell from '@fortawesome/fontawesome-free-solid/faBell';
import faComment from '@fortawesome/fontawesome-free-solid/faComment';
import faUser from '@fortawesome/fontawesome-free-solid/faUser';

import '@fortawesome/fontawesome-free-webfonts/css/fontawesome.css';
import '@fortawesome/fontawesome-free-webfonts/css/fa-solid.css';



import MetisMenu from 'react-metismenu';
//import faFw from '@fortawesome/fontawesome-free-solid/faFw';

const menu = [
  {
    icon: 'dashboard',
    label: 'Menu 1',
    to: 'menu-1',
  },
  {
    icon: 'bell',
    label: 'Menu 2',
    to: 'menu-2',
  },
  {
    icon: 'bolt',
    label: 'Menu 3',
    content: [
      {
        icon: 'bolt',
        label: 'Sub Menu',
        to: 'sub-menu',
      },
    ],
  },
  {
    icon: 'external-link',
    label: 'External Link',
    externalLink: true,
    to: 'https://www.google.com',
  },
];

class NavigationSideBar extends Component {

    constructor(props) {
        super(props)

        this.state = {
            menuData: [],
            serverURL: props.serverURL

        }
    }


    componentDidMount() {
        fetch(this.state.serverURL + 'scaffolding/meta/menu', {
              method: 'GET',
              headers: {
                  'Accept': 'application/json',
                },
                credentials: 'include'

              })
                .then(r => r.json())
                .then(json => {this.setState({menuData: json.data})})
                .catch(error => console.error('Error connecting to server: ' + error));
    }


    render() {
    console.log("Menu data")
    console.log(this.state.menuData)
        const menu = this.state.menuData.map(menuItem => {
            const newMenuItem = {
                icon: menuItem.icon.class,
                label: menuItem.name,
                to: 'menu-2',
                content: menuItem.items.map( subMenuItem => {
                    return {
                        icon: subMenuItem.icon.class,
                        label: subMenuItem.name,
                        to: subMenuItem.url

                    }
                    })


            }
            return newMenuItem

        })



        return (
            <div className="navbar-default sidebar" role="navigation">
                <div className="sidebar-nav navbar-collapse">

                    <ul className="nav" id="side-menu">
                        <li className="sidebar-search">
                            <div className="input-group custom-search-form">
                                <input type="text" className="form-control" placeholder="Search..."/>
                                <span className="input-group-btn">
                                <button className="btn btn-default" type="button">
                                    <i className="fa fa-search"></i>
                                </button>
                            </span>
                            </div>
                        </li>
                    </ul>

                </div>
                <MetisMenu content={menu} className="sidebar-nav navbar-collapse"  classNameLink="" classNameItem="a"/>



            </div>


        );
    }

}

export default NavigationSideBar;















