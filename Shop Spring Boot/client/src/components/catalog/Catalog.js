import React, {useEffect} from "react";
import style from "./Catalog.module.css"
import Item from "./Item";


let Catalog = (props) => {
    let items = props.items.map(el => <Item product={el}/>)


    return (
        <div>
            <h1>Список товаров</h1>
            <div className={style.catalog}>
                {items}
            </div>
        </div>
    )
}

export default Catalog