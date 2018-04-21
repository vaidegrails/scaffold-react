import React, { Component } from 'react';
import 'whatwg-fetch';
import { BrowserRouter, NavLink, Route } from 'react-router-dom'
import Teste from './Teste';


class MenuItem extends Component {
  constructor(props) {
    super(props);

    this.state = {

    };

  }

  render() {



        return ((

        <div>
        <div>


            <NavLink to={'/' + this.props.menuItem.key} activeClassName='hurray'><li key={this.props.menuItem.name}>{this.props.menuItem.name}</li></NavLink>


</div>
<div><Route path={'/' + this.props.menuItem.key} render={(app) => <Teste />}/></div>
</div>
)

        );
  }
}

export default MenuItem;
