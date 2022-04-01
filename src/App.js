
import './App.css';
import {BrowserRouter as Router,Route,Switch} from 'react-router-dom';
import HeaderComponent from './components/HeaderComponent';
import FooterComponent from './components/FooterComponent';
import CreateComponent from './components/CreateComponent';
import UpdateComponent from './components/UpdateComponent';
import ListComponents from './components/ListComponents';
import ViewComponent from './components/ViewComponts';
function App() {
  return (
     <div className="App">
      <Router>
    <HeaderComponent />
    <div className='container'>
    <Switch>
    <Route path="/" exact component={ListComponents }></Route>
    <Route path="/users" exact  component={ListComponents}></Route>
    <Route path="/add-user/:id" component={CreateComponent }></Route>
    <Route path="/update-user/:id" component={UpdateComponent}></Route>
    <Route path="/view-user/:id" component={ViewComponent }></Route>
    </Switch>
    </div>
    <FooterComponent />
    </Router>
    </div>
  );
}

export default App;
