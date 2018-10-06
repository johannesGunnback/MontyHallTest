import React, { Component } from 'react';
import monty from './monty.jpg';
import './App.css';
import BackendHealth from './BackendHealth/BackendHealth';
import SimulationForm from './SimulationForm/SimulationForm';
import SimulationResults from './SimulationResults/SimulationResults';
import { Provider } from "react-redux";
import store from './Store/store';

class App extends Component {
  render() {
    return (
      <div className="App">
        <header className="App-header">
          <BackendHealth/>
          <img src={monty} className="App-monty" alt="logo" />
          <h1 className="App-title">Welcome to the Monty Hall Simulator</h1>
          <SimulationForm/>
          <Provider store={store}>
            <SimulationResults/>
          </Provider>
        </header>
      </div>
    );
  }
}

export default App;
