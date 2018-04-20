import React from 'react';
import ReactDOM from 'react-dom';
import App from './App';
import Menu from './components/Menu';
// using ES6 modules
import { BrowserRouter, Route, Switch } from 'react-router-dom'

import './css/App.css';
import './css/grails.css';
import './css/main.css';

var menu = new Menu('http://localhost:8080/');
ReactDOM.render((
    <BrowserRouter>
        <Switch>
          <Route exact path='/' component={App}/>
           <Route path='/menu' render={(props) => <Menu serverURL={"http://localhost:8080/"} />}
           />
        </Switch>

    </BrowserRouter>
), document.getElementById('root'));
//
//