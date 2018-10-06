import React, {Component} from "react";
import { connect } from "react-redux";
import './SimulationResults.css';

const mapStateToProps = (state) => {
    return {
        winPercentage: state.winPercentage
    }
}

class SimulationResults extends Component {

    render() {
        return <div className="SimulationResults">Simulation result: {this.props.winPercentage}% win rate</div>
    }
}

export default connect(mapStateToProps)(SimulationResults)
