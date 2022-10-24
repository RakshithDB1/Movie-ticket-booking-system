//import logo from './logo.svg';
//import logo from './logo.svg';
import './App.css';
import {BrowserRouter,Switch,Route} from 'react-router-dom'
import { Col, Row } from 'react-bootstrap';
import RightSide from './Components/RightSide';
import MenuComponent from './Components/MenuComponent.js'
import CompanyDetailsComponent from './Components/CompanyDetailsComponent.js'
import CompaniesListComponent from './Components/CompaniesListComponent.js'
import LoginComponent from './Components/LoginComponent.js';
import WatchListComponent from './Components/WatchListComponent.js'
import PerformanceComponent from './Components/PerformanceComponent.js';
import FooterComponent from './Components/Footer';
import SignUp from './Components/SignUp.js';
import Cards from './Components/Cards';
import AddMovie from './Components/AddMovie';
import AddCinemahall from './Components/AddCinemahall';
import RemoveMovie from './Components/RemoveMovie';
import RemoveCinemahall from './Components/RemoveCinemahall';
import Profile from './Components/Profile.js'
import Payment from './Components/Payment';
import HeaderComponent from './Components/HeaderComponent';
import AdminLogin from './Components/AdminLogin';
import CustomerLogin from './Components/CustomerLogin';
import AdminDashBoard from './Components/AdminDashBoard';
import AuthentcationAdminRoute from "./Components/AuthenticatedAdminRoute";
import CustomerDashBoard from './Components/CustomerDashBoard';
import AuthentcationCustomerRoute from './Components/AuthenticationCustomerRoute';
import HomePage from './Components/HomePage';
import LogoutComponent from './Components/LogoutComponenet';

function App() {
  return (

    <BrowserRouter>
      <div>
        {/*<LoginComponent/>*/}
        <HeaderComponent />
          <Switch>
          <Route path="/" exact component={HomePage} />
          <Route path="/login" component={LoginComponent} exact={true}/>
           <Route path="/companies" component={CompaniesListComponent}/>
           <Route path="/signup" component={SignUp}/>
          <Route path="/cards" component={Cards}/>
          <Route path="/compareperformance" component={PerformanceComponent}/>
          <AuthentcationAdminRoute path="/addmovie" component={AddMovie}/>
          <AuthentcationAdminRoute path="/removemovie" component={RemoveMovie}/>
          <AuthentcationAdminRoute path="/addcinemahall" component={AddCinemahall}/>
          <AuthentcationAdminRoute path="/removecinemahall" component={RemoveCinemahall}/>
          <AuthentcationCustomerRoute path="/profile" component={Profile}/>
          <AuthentcationCustomerRoute path="/moviescard" component={CompaniesListComponent}/>
          <AuthentcationCustomerRoute path="/payment" component={Payment}/>
          <Route path="/adminLogin" component={AdminLogin}/>
          <Route path="/customerLogin" component={CustomerLogin} />
          <AuthentcationAdminRoute path="/admindashboard" component={AdminDashBoard}/>
          <AuthentcationCustomerRoute path="/customerdashboard" component={CustomerDashBoard}/>
          <AuthentcationAdminRoute path="/logout" component={LogoutComponent}/>
       </Switch>
      </div>
    </BrowserRouter>
  


  );
}

export default App;