import React, { Component } from 'react';
import 'whatwg-fetch';
import MenuItem from './MenuItem.js'
// using ES6 modules
import { BrowserRouter, Switch } from 'react-router-dom'

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


        <BrowserRouter>
            <Switch>
              <ul>
                {menus ? menus.data.map(menu => {
                  const resultado = <MenuItem menuItem={menu}/>
                  return resultado
                }) : null }

              </ul>
          </Switch>
                  </BrowserRouter>
        </div>
      </div>
    );
  }
}

export default Menu;
