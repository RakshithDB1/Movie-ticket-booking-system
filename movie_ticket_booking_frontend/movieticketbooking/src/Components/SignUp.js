import React, { Component } from "react";
import validator from "validator";
import { Container,Row,Col} from "react-bootstrap";
import userService from '../Services/userService';

class SignUp extends Component {
  constructor(props) {
    super(props);
    this.state = {
        name: "",
        email: "",
        mobileNo: "",
        address: "",
        password: "",

        namerror: "",
        emailerror: "",
        mobileerror: "",
        addresserror: "",
        passworderror: ""
    }

    this.handleNameChange = this.handleNameChange.bind(this)
    this.handleEmailChange = this.handleEmailChange.bind(this)
    this.handlePasswordChange = this.handlePasswordChange.bind(this)
    this.handleMobileChange=this.handleMobileChange.bind(this)
    this.handleaddressChange=this.handleaddressChange.bind(this)

    this.loginClicked = this.loginClicked.bind(this);
  }

  handleEmailChange(event) {
    if (validator.isEmail(event.target.value)) {
      this.setState({
        email: event.target.value,
        emailerror: "",
      });
    } else {
      this.setState({
        email: event.target.value,
        emailerror: "Email is Invalid",
      });
    }
  }

  handlePasswordChange(event) {
    if (event.target.value.length < 5) {
      this.setState({
        password: event.target.value,
        passworderror: "Minimum 5 Characters",
      });
    } else {
      this.setState({
        password: event.target.value,
        passworderror: "",
      });
    }
  }

  handleNameChange(event) {
      if(validator.isEmpty(event.target.value)) {
      this.setState({
        name: event.target.value,
        namerror: "Name is required",
      });
    } else {
      this.setState({
        name: event.target.value,
        namerror: "",
      });
    }
  }

  handleMobileChange(event) {
    if (event.target.value.length < 10) {
      this.setState({
        mobileNo: event.target.value,
        mobileerror: "Enter valid Mobile Number",
      });
    } else {
      this.setState({
        mobileNo: event.target.value,
        mobileerror: "",
      });
    }
  }

  handleaddressChange(event) {
    if(validator.isEmpty(event.target.value)) {
      this.setState({
        address: event.target.value,
        addresserror: "Address is required",
      });
    } else {
      this.setState({
        address: event.target.value,
        addresserror: "",
      });
    }
  }

  loginClicked() {
    console.log("loginclicked");
    const cust = {
        user_id: 7,
        user_name: this.state.name,
        user_email: this.state.email,
        user_mobile: this.state.mobileNo,
        user_address: this.state.address,
        user_password: this.state.password
    };
    console.log(cust);
    userService.createuserSignup(cust)
      .then((response) => {
        console.log(response);
        console.log("successfull login");
        this.setState({ signInMessage: "SignIn successfull" });
      })
      .catch(() => {
        this.setState({ signInMessage: "SignIn failed" });
      });
  }

  render() {
    return (
      <div>
        <Container >
            <p style={{paddingBottom:"40px",fontSize:"40px"}}>Welcome To Registration</p>
        </Container>

        {this.state.emailerror && (
          <div className="alert alert-warning">{this.state.emailerror}</div>
        )}
        {this.state.passworderror && (
          <div className="alert alert-warning">{this.state.passworderror}</div>
        )}
        {this.state.namerror && (
          <div className="alert alert-warning">{this.state.namerror}</div>
        )}
        {this.state.mobileerror && (
          <div className="alert alert-warning">{this.state.mobileerror}</div>
        )}
        {this.state.addresserror && (
          <div className="alert alert-warning">{this.state.cityerror}</div>
        )}
        {this.state.stateerror && (
          <div className="alert alert-warning">{this.state.addresserror}</div>
        )}

        <div className="container">
          {this.state.signInMessage && (
            <div className="alert alert-warning">
              {this.state.signInMessage}
            </div>
          )}
          <Container>
          <Row className="justify-content-md-center">
           <Col xs lg="4" style={{paddingTop:"50px",backgroundColor:"#e9ecef",paddingLeft:"20px",paddingRight:"20px",height:"600px"}}>


           <div className="form-group">
          <p align="left" style={{paddingTop:"20px"}}>User Name:</p>
            <input style={{"borderRadius":"20px"}}
              className="form-control"
              type="text"
              name="name"
              placeholder="Enter User Name"
              onChange={this.handleNameChange}
            />
          </div>
          <div className="form-group">
            <p align="left">User Email:</p>
            <input style={{"borderRadius":"20px"}}
              className="form-control"
              type="email"
              name="email"
              placeholder="Enter Email ID"
              onChange={this.handleEmailChange}
              required
            />
          </div>

          <div className="form-group">
          <p align="left" style={{paddingTop:"20px"}}>Phone Number:</p>
            <input style={{"borderRadius":"20px"}}
              className="form-control"
              type="number"
              name="mobileNo"
              placeholder="Enter Phone Number"
              onChange={this.handleMobileChange}
            />
          </div>

          <div className="form-group">
          <p align="left" style={{paddingTop:"20px"}}>City:</p>
            <input style={{"borderRadius":"20px"}}
              className="form-control"
              type="text"
              name="address"
              placeholder="Enter City"
              onChange={this.handleaddressChange}
            />
          </div>
          <div className="form-group">
          <p align="left" style={{paddingTop:"20px"}}>Enter password:</p>
            <input style={{"borderRadius":"20px"}}
              className="form-control"
              placeholder="Enter Customer Password"
              type="password"
              name="password"
              onChange={this.handlePasswordChange}
            />
          </div>

          <button
            className="btn btn-primary btn-md btn-block mt-3"
            type="submit"
            onClick={this.loginClicked}
          >
            Sign Up
          </button>
          </Col>
          <Col xs lg="4" style={{backgroundColor:"#09f",height:"600px"}}>
            <div style={{height:"300px",width:"100%"}} >
                <p style={{paddingTop:"300px",color:"white",fontSize:"30px"}}>Register Page</p>
            </div>
            </Col>
          </Row>
        </Container>
        </div>
      </div>
    );
  }
}

export default SignUp;
