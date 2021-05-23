import api from "../../api/api";

const SET_ITEMS = "SET_ITEMS"
const SET_CURRENT_ITEM = "SET_CURRENT_ITEM"


let initialState = {
    itemList: [],
    currentItem: {}
}

const catalogReducer = (state=initialState, action) => {
    switch (action.type) {
        case SET_ITEMS:
            return {
                ...state, itemList: [...action.itemList]
            }
        case SET_CURRENT_ITEM:
            return {
                ...state, currentItem: action.currentItem
            }
        default:
            return state
    }

}

export const setItemsThunk = () => {
    return (dispatch) => {
        api.getItems()
            .then(response => {
                dispatch(setItemList(response.data))
            })
    }
}

export const setCurrentItemThunk = (id) => {
    return (dispatch) => {
        api.getItem(id)
            .then(response => {
                dispatch(setCurrentItem(response.data))
            })
    }
}

export const setItemList = (itemList) => ({type: SET_ITEMS, itemList})
export const setCurrentItem = (currentItem) => ({type: SET_CURRENT_ITEM, currentItem})

export default catalogReducer