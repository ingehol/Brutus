import React, { Component } from "react";
import { Link} from "react-router-dom";
import { userService } from "../dataHelper";
import {Button} from 'react-bootstrap';

export class ListOfPeople extends React.Component {
    constructor(props) {
        super(props);
        console.log(props)
        this.state = { 
            people: [],
            seq: props?.location?.state?.people?.seq,
            firstname: props?.location?.state?.people?.firstname,
            lastname: props?.location?.state?.people?.lastname,
            age: props?.location?.state?.people?.age,
            street: props?.location?.state?.people?.street,
            city: props?.location?.state?.people?.city,
            state: props?.location?.state?.people?.state,
            latitude: props?.location?.state?.people?.latitude,
            longitude: props?.location?.state?.people?.longitude,
            ccnumber: props?.location?.state?.people?.ccnumber,
            onDismissSuccess: true,
            loading: true
        };
        
    }

    componentDidMount() {
        this.getPeople();
    }
        
    //Fetches all people from the given parameters.
    async getPeople(){
        let value = [this.state.seq, this.state.firstname, this.state.lastname, this.state.age, this.state.street, this.state.city, this.state.state, this.state.latitude, this.state.longitude, this.state.ccnumber]
        let check = ["seq", "firstname", "lastname", "age", "street", "city", "state", "latitude", "longitude", "ccnumber"]
        console.log(value);
        console.log(check);
        let toSearch = "";
        for(let i=0; i<value.length; i++) {
            if(!(value[i] == undefined || value[i] == "")) {
                if(toSearch == "") {
                    toSearch = check[i] + "=" + value[i];
                } else {
                    toSearch = toSearch + "&" + check[i] + "=" + value[i];
                }
            }
        }
        const fetchPeople = await userService.fetchData('/peopleSearch?'+toSearch);
        console.log(fetchPeople)
        this.setState({people: fetchPeople, loading:false});
    }

    //Currently doesnt work. Just removes the person from the view, but its still in the database, and will show if the page is being refreshed.
    confirmDeletePerson(toDelete) {
        if(window.confirm("Vil du slette denne personen?")) {
            console.log(toDelete)
            //State before deleting anything.
            const currentPerson = this.state.people;
            //Remove deleted person from state.
            this.setState({onDismissSuccess: false,
              people: currentPerson.filter(people => people.seq !== toDelete)
            })
            //Runs the deleteData-function made in the file "dataHelper.js"
            userService.deleteData('/people', toDelete);
          } else {
            console.log("Cancelled");
          }
    }

    //Table with all the people
    renderPeopleTable(people) {
        return(
            <div>
            <h1 id="tabelLabel" >Søkeresultat</h1>
            <h2>Antall: {people.length}</h2>
            <p>Personer med angitt info.</p>
            <table className='table table-striped' aria-labelledby="tabelLabel">
              <thead>
                <tr>
                  <th>Seq</th>
                  <th>Fornavn</th>
                  <th>Etternavn</th>
                  <th>Alder</th>
                  <th>Gate</th>
                  <th>By</th>
                  <th>Stat</th>
                  <th>Breddegrad</th>
                  <th>Lengdegrad</th>
                  <th>CC-nummer</th>
                  <th></th>
                </tr>
              </thead>
              <tbody>
                      {people.map(people => 
                         <tr className="tableR" key={people.seq}> 
                             <td>{people.seq}</td>
                              <td>{people.firstname}</td>
                              <td>{people.lastname}</td>
                              <td>{people.age}</td>
                              <td>{people.street}</td>
                              <td>{people.city}</td>
                              <td>{people.state}</td>
                              <td>{people.latitude}</td>
                              <td>{people.longitude}</td>
                              <td>{people.ccnumber}</td>
                              <td onClick={e => e.stopPropagation()}><Button variant="primary" onClick={() => this.confirmDeletePerson(people.seq)}>Slett</Button></td>
                          </tr>
                )}
              </tbody>
            </table>
            </div>
        );
    }

    render() {
        let contents;
            contents = this.state.loading
            ? <p><em>Loading...</em></p>
            : this.renderPeopleTable(this.state.people);
            return(
                <div>
                    <Link to="/"><Button variant="primary" size="sm">Tilbake til søkesiden</Button></Link>
                    {contents}
            </div>
      );
    }
}
