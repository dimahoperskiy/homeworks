import {createStore, combineReducers, applyMiddleware} from "redux";
import thunk from "redux-thunk";
import catalogReducer from "./reducers/catalogReducer";

let reducers = combineReducers({
    catalog: catalogReducer
})

let store = createStore(reducers, applyMiddleware(thunk))

export default store