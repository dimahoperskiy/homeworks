import React, {useEffect} from "react";
import {connect} from "react-redux"
import {setCurrentItemThunk} from "../../../redux/reducers/catalogReducer";
import {compose} from "redux";
import {withRouter} from "react-router";
import ItemPage from "./ItemPage";

let ItemPageContainer = (props) => {
    useEffect(() => {
        props.setCurrentItemThunk(props.match.params.itemId)
    }, [])

    return (
        <ItemPage item={props.currentItem}/>
    )
}

let mapStateToProps = (state) => {
    return {
        currentItem: state.catalog.currentItem
    }
}

let mapDispatchToProps = {
    setCurrentItemThunk
}

export default compose(
    withRouter,
    connect(mapStateToProps, mapDispatchToProps)
)(ItemPageContainer)

