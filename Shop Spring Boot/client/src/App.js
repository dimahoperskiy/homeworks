import './App.css';
import Home from "./components/home/Home";
import {Route} from "react-router"
import Nav from "./components/nav/Nav";
import CatalogContainer from "./components/catalog/CatalogContainer";
import ItemPageContainer from "./components/catalog/ItemPage/ItemPageContainer";

function App() {
  return (
    <div className="App">
        <header>
            <Nav/>
        </header>
        <Route path="/home" component={Home}/>
        <Route exact path="/catalog" component={CatalogContainer}/>
        <Route path="/catalog/:itemId" component={ItemPageContainer}/>
        <Route exact path="/" component={Home}/>
    </div>
  );
}

export default App;
