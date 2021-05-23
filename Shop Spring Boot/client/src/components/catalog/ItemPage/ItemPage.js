import React from "react";
import style from "./ItemPage.module.css"
import {NavLink} from "react-router-dom";

let ItemPage = (props) => {
    let item = props.item

    return (
    <div>
        {item.model !== undefined ?
            <div className={style.itemPage}>
                <img src="https://cdn.svyaznoy.ru/upload/iblock/487/ruru_iphone12_q121_black_pdp-image-1b.jpg"
                     alt="" className={style.img}/>
                <div className={style.info}>
                    <h1>{`${item.model.manufacturer.name} ${item.model.name}`}</h1>
                    <p>Страна производителя: {item.model.country.name}</p>
                    <p>Цвет: {item.color}</p>
                    <p>Цена: {item.price}</p>
                    <p>Артикул: #{item.vendorCode}</p>
                </div>
            </div>
            :
            null}
    </div>
    )
}

export default ItemPage