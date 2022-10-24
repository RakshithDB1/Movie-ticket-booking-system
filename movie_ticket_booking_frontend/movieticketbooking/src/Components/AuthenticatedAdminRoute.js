import React, { Component } from "react";
import {Route, Redirect } from "react-router-dom";
import AuthenticationAdminService from "./AuthenticationAdminService";

class AuthentcationAdminRoute extends Component{
    render(){
        if(AuthenticationAdminService.isAdminLoggedIn()){
            return <Route {...this.props} />

        }else{
            return <Redirect to="/" />

        }

    }
}

export default AuthentcationAdminRoute;