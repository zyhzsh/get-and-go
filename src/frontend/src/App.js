import React from "react";
//Pages
import Home from "./pages/Home";
import Admin from "./pages/Admin";
import Vendor from './pages/Vendor';
import { BrowserRouter as Router, Switch, Route } from "react-router-dom";
function App() {
  return (
    <Router>
      {
        <Switch>
          <Route exact path="/admin" component={Admin}/>
          <Route exact path="/vendor" component={Vendor}/>
          <Route path="/" component={Home} />
        </Switch>
      }
    </Router>
  );
}
export default App;
