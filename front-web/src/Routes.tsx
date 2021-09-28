import { BrowserRouter, Switch, Route } from "react-router-dom";
import Orders from "./components/Orders";
import Home from "./components/Home";
import NavBar from "./components/NavBar";

function Routes() {
    return (
        <BrowserRouter>
            <NavBar />
            <Switch>
                <Route path="/orders">
                    <Orders />
                </Route>
                <Route path="/">
                    <Home />
                </Route>
            </Switch>
        </BrowserRouter>
    );
}

export default Routes;