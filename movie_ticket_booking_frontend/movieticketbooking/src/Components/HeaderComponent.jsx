import React, { Component } from "react";
import { Link } from "react-router-dom";
import { Container, Navbar, Nav, NavDropdown } from "react-bootstrap";
import AuthenticationAdminService from "./AuthenticationAdminService";
import AuthentcationCustomerService from "./AuthenticationCustomerService";
import { withRouter } from "react-router";

class HeaderComponent extends Component {
  render() {
    let flag = false;

    const isAdminLoggedIn = AuthenticationAdminService.isAdminLoggedIn();
    console.log(isAdminLoggedIn);

    const isCustomerLoggedIn =
      AuthentcationCustomerService.isCustomerLoggedIn();

    if (isCustomerLoggedIn || isAdminLoggedIn) {
      flag = true;
    }

    return (
      <header>
        <Navbar collapseOnSelect expand="lg" bg="dark" variant="dark">
          <Container>
            <Navbar.Brand href="/">Movie Ticket Booking System</Navbar.Brand>
            <Navbar.Toggle aria-controls="responsive-navbar-nav" />
            <Navbar.Collapse id="responsive-navbar-nav">
              <Nav className="justify-content-end" style={{ width: "100%" }}>
                <Link to="/" style={{ textDecoration: 'none' }}>
                  <Nav.Link
                    className="mr-auto"
                    href="/"
                    onClick={() => {
                      AuthentcationCustomerService.customerLogout();
                      AuthenticationAdminService.adminLogout();
                    }}
                  >
                    Home
                  </Nav.Link>
                </Link>

                <Link to="/about" style={{ textDecoration: 'none' }}>
                  <Nav.Link
                    href="/about"
                    onClick={() => {
                      AuthentcationCustomerService.customerLogout();
                      AuthenticationAdminService.adminLogout();
                    }}
                  >
                    About
                  </Nav.Link>
                </Link>

                {!flag && (
                  <NavDropdown title="Dropdown" id="collasible-nav-dropdown">
                    <Link to="/adminLogin" style={{ textDecoration: 'none' }}>
                      {" "}
                      <NavDropdown.Item href="/adminLogin">
                        Admin Login
                      </NavDropdown.Item>{" "}
                    </Link>
                    <Link to="/customerLogin" style={{ textDecoration: 'none' }}>
                      {" "}
                      <NavDropdown.Item href="/customerLogin">
                        User Login
                      </NavDropdown.Item>{" "}
                    </Link>
                  </NavDropdown>
                )}

                <Nav.Link>
                  {isAdminLoggedIn && (
                    <Link
                      to="/logout"
                      className="text-light"
                      onClick={AuthenticationAdminService.adminLogout}
                      style={{ textDecoration: 'none' }}
                    >
                      Logout
                    </Link>
                  )}
                </Nav.Link>

                <Nav.Link>
                  {isCustomerLoggedIn && (
                    <Link
                      to="/logout"
                      className="text-light"
                      onClick={AuthentcationCustomerService.customerLogout}
                      style={{ textDecoration: 'none' }}
                    >
                      Logout
                    </Link>
                  )}
                </Nav.Link>
              </Nav>
            </Navbar.Collapse>
          </Container>
        </Navbar>
      </header>
    );
  }
}

export default withRouter(HeaderComponent);
