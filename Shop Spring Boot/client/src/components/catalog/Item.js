import React from "react";
import style from "./Item.module.css"
import {NavLink} from "react-router-dom";

let Item = (props) => {
    let product = props.product
    return (
        <NavLink to={"/catalog/" + props.product.id} className={style.item}>
                <p>
                    {`${product.model.manufacturer.name} ${product.model.name}`}
                </p>
                <p>Страна производителя: {product.model.country.name}</p>
                <p>Цвет: {product.color}</p>
                <p>Цена: {product.price}</p>
                <p>Артикул: #{product.vendorCode}</p>
        </NavLink>
    )
}

export default Item