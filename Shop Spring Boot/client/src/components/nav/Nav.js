import React from "react";
import {NavLink} from "react-router-dom"
import style from "./Nav.module.css"

let Nav = (props) => {
    return (
        <div className={style.nav}>
            <div className={style.linkWrapper}>
                <NavLink to="/home" activeClassName={style.active} className={style.link}>Главная</NavLink>
            </div>
            <div className={style.linkWrapper}>
                <NavLink to="/catalog" activeClassName={style.active} className={style.link}>Каталог</NavLink>
            </div>
        </div>
    )
}

export default Nav