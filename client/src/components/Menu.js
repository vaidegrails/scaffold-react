import React, { Component } from 'react';
//import { SERVER_URL, CLIENT_VERSION, REACT_VERSION } from './config';
import 'whatwg-fetch';

class Menu extends Component {

  constructor(serverURL) {
    super();

    this.state = {
      menus: null,

      serverURL: serverURL
//      serverURL
    }

  }

  componentDidMount() {
//    console.log (this.state.serverURL)
    fetch(this.state.serverURL.serverURL + 'meta/menu')
      .then(r => r.json())
      .then(json => this.setState({menus: json})
      )
      .catch(error => console.error('Error connecting to server: ' + error));

  }

  render() {
    const serverURL = this.state.serverURL;
//    const clientInfo = this.state.clientInfo;
    const menus = this.state.menus;
//    console.log(menus);
    return (
      <div>
        <div>
BLAHBLAH
          <ul>
            {menus ? menus.data.map(menu => {
              return <li key={menu.name}><a href={serverURL.serverURL + menu.name}>{ menu.name }</a> </li>;
            }) : null }

          </ul>
        </div>
      </div>
    );
  }
}

export default Menu;
