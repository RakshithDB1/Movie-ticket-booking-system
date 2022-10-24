import React, { Component } from "react";
import { Link } from "react-router-dom";

class AdminDashBoard extends Component{
    render(){
        return(
            <div>
                <h1>Admin DASHBOARD</h1>
                
                <div>
                    <h1>Hello Admin</h1>
                   
                   <div>
                       <a href="/addmovie"> 
                       <h1>Add Movies</h1>
                       </a>
                   </div>

                   <div>
                       <a href="/addcinemahall"> 
                       <h1>Add Cinemahall</h1>
                       </a>
                   </div>

                   <div>
                       <a href="/removemovie">
                           <h1>Remove Movies</h1>
                       </a>
                   </div>


                   <div>
                       <a href="/removecinemahall"> 
                       <h1>Remove Cinemahall</h1>
                       </a>
                   </div>

                </div>
            </div>
        )
    }
}

export default AdminDashBoard;