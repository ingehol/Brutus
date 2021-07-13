import React, { Component } from 'react';
import Container from 'react-bootstrap/Container';
import Form from 'react-bootstrap/Form';
import {Button} from 'react-bootstrap';

class SimpleForm extends Component {
    constructor(props) {
        super(props);
        this.state = {
            seq: null,
            firstname: null,
            lastname: null,
            age: null,
            street: null,
            city: null,
            state: null,
            latitude: null,
            longitude: null,
            ccnumber: null
          };
          
          this.handleChange = this.handleChange.bind(this);
          this.handleSubmit = this.handleSubmit.bind(this);
      }

    handleChange(e) {
        const {name, value} = e.target;
        this.setState({ [name]: value});
        console.log(this.state)
    } 
    
    async handleSubmit(e) {
        e.preventDefault();
        //const {seq, firstname, lastname, age, street, city, state, latitude, longitude, ccnumber} = this.state;
        console.log(this.state)
        this.props.history.push({
            pathname: '/listOfPeople',
            state: {people: this.state}});
    };

  render() {
    const { seq, firstname, lastname, age, street, city, state, latitude, longitude, ccnumber } = this.state
    return (
    <Container>
    <div className="SimpleForm">
        <header className="header">
        <h1>Brutus A/S</h1>
        <p>Informasjon kan legges inn her, hvis ikke søkes det gjennom hele databasen.</p>
      </header>
      <Form onKeyPress={event => event.key === "Enter" && this.handleSubmit(event)}>
        <Form.Group controlId="form.Seq">
            <Form.Label>Seq</Form.Label>
            <Form.Control type="text" placeholder="Skriv inn seq" name="seq" value={seq} onChange={this.handleChange}/>
        </Form.Group>
        <Form.Group controlId="form.Firstname">
            <Form.Label>Fornavn</Form.Label>
            <Form.Control type="text" placeholder="Skriv inn fornavn" name="firstname" value={firstname} onChange={this.handleChange}/>
        </Form.Group>
        <Form.Group controlId="form.Lastname">
            <Form.Label>Etternavn</Form.Label>
            <Form.Control type="text" placeholder="Skriv inn etternavn" name="lastname" value={lastname} onChange={this.handleChange}/>
        </Form.Group>
        <Form.Group controlId="form.Age">
            <Form.Label>Alder</Form.Label>
            <Form.Control type="text" placeholder="Skriv inn alder" name="age" value={age} onChange={this.handleChange}/>
        </Form.Group>
        <Form.Group controlId="form.Street">
            <Form.Label>Gatenavn</Form.Label>
            <Form.Control type="text" placeholder="Skriv inn gatenavn" name="street" value={street} onChange={this.handleChange} />
        </Form.Group>
        <Form.Group controlId="form.City">
            <Form.Label>Bynavn</Form.Label>
            <Form.Control type="text" placeholder="Skriv inn bynavn" name="city" value={city} onChange={this.handleChange}/>
        </Form.Group>
        <Form.Group controlId="formState">
                                <Form.Label>Stat</Form.Label>
                                <Form.Control as="select" name="state" value={state} onChange={this.handleChange}>
                                    <option value={null}></option>
                                    <option value="AL">Alabama</option>
                                    <option value="AK">Alaska</option>
                                    <option value="AZ">Arizona</option>
                                    <option value="AR">Arkansas</option>
                                    <option value="CA">California</option>
                                    <option value="CO">Colorado</option>
                                    <option value="CT">Connecticut</option>
                                    <option value="DE">Delaware</option>
                                    <option value="DC">District Of Columbia</option>
                                    <option value="FL">Florida</option>
                                    <option value="GA">Georgia</option>
                                    <option value="HI">Hawaii</option>
                                    <option value="ID">Idaho</option>
                                    <option value="IL">Illinois</option>
                                    <option value="IN">Indiana</option>
                                    <option value="IA">Iowa</option>
                                    <option value="KS">Kansas</option>
                                    <option value="KY">Kentucky</option>
                                    <option value="LA">Louisiana</option>
                                    <option value="ME">Maine</option>
                                    <option value="MD">Maryland</option>
                                    <option value="MA">Massachusetts</option>
                                    <option value="MI">Michigan</option>
                                    <option value="MN">Minnesota</option>
                                    <option value="MS">Mississippi</option>
                                    <option value="MO">Missouri</option>
                                    <option value="MT">Montana</option>
                                    <option value="NE">Nebraska</option>
                                    <option value="NV">Nevada</option>
                                    <option value="NH">New Hampshire</option>
                                    <option value="NJ">New Jersey</option>
                                    <option value="NM">New Mexico</option>
                                    <option value="NY">New York</option>
                                    <option value="NC">North Carolina</option>
                                    <option value="ND">North Dakota</option>
                                    <option value="OH">Ohio</option>
                                    <option value="OK">Oklahoma</option>
                                    <option value="OR">Oregon</option>
                                    <option value="PA">Pennsylvania</option>
                                    <option value="RI">Rhode Island</option>
                                    <option value="SC">South Carolina</option>
                                    <option value="SD">South Dakota</option>
                                    <option value="TN">Tennessee</option>
                                    <option value="TX">Texas</option>
                                    <option value="UT">Utah</option>
                                    <option value="VT">Vermont</option>
                                    <option value="VA">Virginia</option>
                                    <option value="WA">Washington</option>
                                    <option value="WV">West Virginia</option>
                                    <option value="WI">Wisconsin</option>
                                    <option value="WY">Wyoming</option>
                                </Form.Control>
                            </Form.Group>
        <Form.Group controlId="form.Latitude">
            <Form.Label>Breddegrad</Form.Label>
            <Form.Control type="text" placeholder="Skriv inn breddegrad" name="latitude" value={latitude} onChange={this.handleChange}/>
        </Form.Group>
        <Form.Group controlId="form.Longitude">
            <Form.Label>Lengdegrad</Form.Label>
            <Form.Control type="text" placeholder="Skriv inn lengdegrad" name="longitude" value={longitude} onChange={this.handleChange}/>
        </Form.Group>
        <Form.Group controlId="form.Ccnumber">
            <Form.Label>CC-Nummer</Form.Label>
            <Form.Control type="text" placeholder="Skriv inn CC-Nummer" name="ccnumber" value={ccnumber} onChange={this.handleChange}/>
        </Form.Group>
      </Form>
      <Button variant="primary" onClick={this.handleSubmit} className="linkSpaceBottom">Søk</Button>{' '}
    </div>
    </Container>
    );
  }
       
}
 export default SimpleForm;