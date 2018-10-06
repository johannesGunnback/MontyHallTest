import { createStore } from "redux";
import rootReducer from "./SimulationReducer";
const store = createStore(rootReducer);
export default store;