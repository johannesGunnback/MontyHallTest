import React, {Component} from "react";
import store from "../Store/store";
import { updateSimulationResult } from "../Store/Actions";
import axios from 'axios';
import './SimulationForm.css';

class SimulationForm extends Component {

    constructor(props) {
        super(props);
        this.state = {numberOfSimulations: 0, changeDoor: false};
        this.handleInputChange = this.handleInputChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }

     handleInputChange(event) {
        const target = event.target;
        const value = target.type === 'checkbox' ? target.checked : target.value;
        const name = target.name;

        this.setState({ [name]: value });
      }

    handleSubmit(event) {
        axios.post("montyhall/simulation", this.state)
            .then(res => {
                if (res.status === 200) {
                    store.dispatch( updateSimulationResult(res.data.winPercentage) );
                } else {
                  console.error(res);
                }
              })
              .catch(res => {
                console.error(res);
              });
        event.preventDefault();
    }

    render() {
        return (
        <div className="SimulationForm">
          <form onSubmit={this.handleSubmit}>
              <label>
                Simulation runs:
                <input name="numberOfSimulations" type="text" value={this.state.numberOfSimulations} onChange={this.handleInputChange} />
              </label>
               <label>
                  Player changes door:
                  <input name="changeDoor" type="checkbox" checked={this.state.changeDoor} onChange={this.handleInputChange} />
                </label>
              <input type="submit" value="Run Simulation" />
            </form>
        </div>
        );
    }
}

export default SimulationForm;