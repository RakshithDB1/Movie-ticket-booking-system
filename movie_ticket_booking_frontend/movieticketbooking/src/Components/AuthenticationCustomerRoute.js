import React, { Component } from "react";
import {Route, Redirect } from "react-router-dom";
import AuthenticationCustomerService from "./AuthenticationCustomerService";

class AuthentcationCustomerRoute extends Component{
    render(){
        if(AuthenticationCustomerService.isCustomerLoggedIn()){
            return <Route {...this.props} />

        }else{
            return <Redirect to="/" />

        }

    }
}

export default  AuthentcationCustomerRoute;