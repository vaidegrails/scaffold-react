import React, { Component } from 'react';
import '../css/sb2admin/sb-admin-2.css'
import ScaffoldPage from './ScaffoldPage';


class PageContent extends Component {

    constructor(props) {
        super(props);

        this.state = {
//          scaffoldMeta: props.scaffoldMeta,
          serverURL: props.serverURL

        }

    }


    render() {

        var myHM = new Map();

        myHM.set('a', new String('This string contains A'));
        myHM.set(new String('b'), new String('This string contains B'));
        myHM.set('0', new String('And this string? Zero'));

    //    console.log(menus);
        return (
            <div id="page-wrapper">
                <ScaffoldPage scaffoldMeta = {{myHM}}  serverURL = {this.state.serverURL}/>
            </div>
        );
    }

}

export default PageContent;