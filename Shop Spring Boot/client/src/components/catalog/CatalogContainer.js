import React, {useEffect} from "react";
import {connect} from "react-redux"
import Catalog from "./Catalog";
import {setItemsThunk} from "../../redux/reducers/catalogReducer";
import {compose} from "redux";
import {withRouter} from "react-router";

let CatalogContainer = (props) => {
    useEffect(() => {
        props.setItemsThunk()
        console.log("mount")
    }, [])

    useEffect(() => {
        console.log(props.match.params)
    })

    return (
        <Catalog items={props.itemList}/>
    )
}

let mapStateToProps = (state) => {
    return {
        itemList: state.catalog.itemList
    }
}

let mapDispatchToProps = {
    setItemsThunk
}

export default compose(
    withRouter,
    connect(mapStateToProps, mapDispatchToProps)
)(CatalogContainer)

