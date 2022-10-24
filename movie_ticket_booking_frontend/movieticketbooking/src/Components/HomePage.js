import React, { Component } from "react";
import { Link } from "react-router-dom";

class HomePage extends Component {
  render() {
    return(
        <div>
            <h1>WELCOME TO MOVIE TICKET BOOKING SYSTEM</h1>
            <div>
            <Link to="/signup" className="text-light">
                  New User Register here
                </Link>
                <a href="/signup">
                New User Register here

                </a>
                

            </div>
           



            </div>

    ); 
  }
}

export default HomePage;