import React, { Component } from 'react';
//import { Grid } from 'react-bootstrap';
//import AppNav from './AppNav';
//import Menu from './components/Menu';
import Navigation from './components/Navigation';

//import grailsLogo from './images/grails-cupsonly-logo-white.svg';
//import reactLogo from './images/logo.svg';


import { SERVER_URL, CLIENT_VERSION, REACT_VERSION } from './config';
import 'whatwg-fetch';

class App extends Component {

  constructor() {
    super();

    this.state = {
      serverInfo: {},
      clientInfo: {
        version: CLIENT_VERSION,
        react: REACT_VERSION
      },
      serverURL: SERVER_URL
    }
  }

  componentDidMount() {
//    fetch(this.state.SERVER_URL + 'application')
//      .then(r => r.json())
//      .then(json => this.setState({serverInfo: json}))
//      .catch(error => console.error('Error connecting to server: ' + error));

  }

  render() {
    const serverInfo = this.state.serverInfo;
    const clientInfo = this.state.clientInfo;

    return (
      <div id="wrapper">
        <Navigation/>
      </div>
    );
  }
}

export default App;
