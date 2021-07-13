import './App.css';
import React from 'react';
import { Route, Switch, BrowserRouter as Router } from "react-router-dom"

import SimpleForm from './components/SimpleForm';
import {ListOfPeople} from './components/ListOfPeople';

function App() {

  return (
    <Router>
      <Switch>
          <Route path="/" component={SimpleForm} exact />
          <Route path="/listOfPeople" component={ListOfPeople} />
      </Switch>
    </Router>
  );
}

export default App;
