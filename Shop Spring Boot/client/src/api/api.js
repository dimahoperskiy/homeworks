import axios from "axios";

let ax = axios.create({
    baseURL: "http://localhost:8095/api/"
})


let api = {
    getItems() {
        return ax.get("products")
    },
    getItem(id) {
        return ax.get("products/" + id)
    }
}

export default api