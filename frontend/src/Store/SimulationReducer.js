import { UPDATE_SIM_RESULT } from "./Actions";

const initialState = {
  winPercentage: 0
};
const simulationReducer = (state = initialState, action) => {
  switch (action.type) {
    case UPDATE_SIM_RESULT:
      return {...state,  winPercentage: action.payload};
    default:
      return state;
  }
};

export default simulationReducer;