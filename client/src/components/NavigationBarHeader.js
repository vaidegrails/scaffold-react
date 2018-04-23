import React, { Component } from 'react';
import '../css/sb2admin/sb-admin-2.css'

class NavigationBarHeader extends Component {


    render() {
        return (
            <div className="navbar-header">
                <button type="button" className="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span className="sr-only">Toggle navigation</span>
                    <span className="icon-bar"></span>
                    <span className="icon-bar"></span>
                    <span className="icon-bar"></span>
                </button>
                <a className="navbar-brand" href="index.html">SB Admin v2.0</a>
            </div>
        );
    }

}

export default NavigationBarHeader;