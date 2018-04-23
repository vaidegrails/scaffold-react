import React, { Component } from 'react';
import '../css/sb2admin/sb-admin-2.css'


class ScaffoldPage extends Component {

    constructor(props) {
        super(props);
        console.log ("Constructor")

        this.state = {
          scaffoldMeta: {},
          objectValues: {},
          fields: {},
          serverURL: props.serverURL

        }

    }

    render() {
        console.log ("Render")
        console.log(this.state.scaffoldMeta)
        console.log(this.state.serverURL)
        return (
            <React.Fragment>
                <div className="row">
                                    <div className="col-lg-12">
                                        <h1 className="page-header">{this.state.scaffoldMeta.title}</h1>
                                    </div>
                </div>
                <div className="row">
                    <div className="col-lg-12">
                        <div className="panel panel-default">
                            <div className="panel-heading">
                                {this.state.scaffoldMeta.subtitle}
                            </div>
                            <div className="panel-body">
                                {this.createFields()}
                            </div>
                        </div>
                    </div>
                </div>
            </React.Fragment>
        );
    }

      componentDidMount() {
        console.log ("Did Mount")
        fetch(this.state.serverURL + 'core/campusScaffolding/meta/show', {
             method: 'GET',
             headers: {
                                  'Accept': 'application/json',

                          },
             credentials: 'include', // you need to add this line,


        })
          .then(r => r.json())
          .then(json => {this.setState({scaffoldMeta: json, fields: json.fields})}


          )
          .catch(error => console.error('Error connecting to server: ' + error));


      fetch(this.state.serverURL + 'core/campusScaffolding/5', {
      method: 'GET',
      headers: {
          'Accept': 'application/json',
        },
        credentials: 'include'

      })
        .then(r => r.json())
        .then(json => {this.setState({objectValues: json})}


        )
        .catch(error => console.error('Error connecting to server: ' + error));


      }

      createFields() {
      const fields = this.state.scaffoldMeta.fields;
      console.log (fields);
      {
      return fields ? fields.map(field => {
                        const resultado = (
                        <div key={field.key} className="form-group col-lg-6">


                            <label for={"value_"+field.key}>{field.label}</label>
                            <div id={"value_"+field.key}>
                                {this.state.objectValues[field.key]}
                            </div>

                        </div>
                        )
                        return resultado
                      }) : null
                      }

      }

}

export default ScaffoldPage;