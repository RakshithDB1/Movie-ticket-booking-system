import React, { Component } from "react";
import { Link } from "react-router-dom";

class CustomerDashBoard extends Component{
    render(){
        return(
            <div>
                <h1>USER DASHBOARD</h1>
                
                <div>
                    <h1>Hello User</h1>
                   
                   <div>
                       <a href="/moviescard"> 
                       <h1>Movies</h1>
                       </a>
                   </div>

                   <div>
                       <a href="/profile"> 
                       <h1>profile</h1>
                       </a>
                   </div>

                   <div>
                       <a href="/">
                           <h1>Booking History</h1>
                       </a>
                   </div>

                </div>
            </div>
        )
    }
}

export default CustomerDashBoard;