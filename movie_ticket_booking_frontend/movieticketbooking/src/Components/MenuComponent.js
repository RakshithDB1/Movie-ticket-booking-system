import React from 'react';
import 'bootstrap/dist/css/bootstrap.css';
import * as RB from "react-bootstrap";
import {Form, FormControl,Button} from "react-bootstrap";

function MenuComponent(props){

    if(props.loggedIn){
        return(
            <RB.Navbar bg="dark" variant="dark">
                
                <RB.Navbar.Brand href="/">Movie Ticket Booking System</RB.Navbar.Brand>
                <RB.Nav.Link href="/login">Home</RB.Nav.Link>
                <RB.Nav.Link href="/moviescard">Movies</RB.Nav.Link>
                <RB.Nav.Link href="/login">Sign In</RB.Nav.Link>
                <RB.Nav.Link href="/signup">Sign Up</RB.Nav.Link>
            </RB.Navbar>
        )
    }
    else if(props.loggedIn){
        return(
            <RB.Navbar bg="dark" variant="dark">
                
                <RB.Navbar.Brand href="/">Movie Ticket Booking System</RB.Navbar.Brand>
                <RB.Nav.Link href="/login">Home</RB.Nav.Link>
                <RB.Nav.Link href="/moviescard">Movies</RB.Nav.Link>
                <Form className="d-flex">
                <FormControl
                  type="search"
                  placeholder="Search"
                  className="me-2"
                  aria-label="Search"
                />
               <Button variant="outline-success">Search</Button>
               </Form>
               <RB.Nav.Link href="/profile">My Profile</RB.Nav.Link>
               <RB.Nav.Link href="/login">Logout</RB.Nav.Link>
            </RB.Navbar>
        )
    }
    else{
        return(
            <RB.Navbar bg="dark" variant="dark">
                
                <RB.Navbar.Brand href="/">Movie Ticket Booking System</RB.Navbar.Brand>
                <RB.Nav.Link href="/addmovie">Add Movies</RB.Nav.Link>
                <RB.Nav.Link href="/addcinemahall">Add Cinemahall</RB.Nav.Link>
                <RB.Nav.Link href="/removemovie">Remove movies</RB.Nav.Link>
                <RB.Nav.Link href="/removecinemahall">Remove Cinemahall</RB.Nav.Link>
                <RB.Nav.Link href="/signin">Logout</RB.Nav.Link>
            </RB.Navbar>
        )
    }

}

export default MenuComponent;

