import React, { Component } from "react";
import validator  from "validator";
import { Container,Row,Col} from "react-bootstrap";
import userService from "../Services/userService"
import AuthenticationCustomerService from "./AuthenticationCustomerService.js"

class CustomerLogin extends Component {
  constructor(props) {
    super(props);
    this.state = {
      custId: "",
      password: "",
      emailerror: "",
      passworderror: "",
      hasLoginFailed:false

    };
    this.handleEmailChange = this.handleEmailChange.bind(this);
    this.handlePasswordChange = this.handlePasswordChange.bind(this);
    this.loginClicked = this.loginClicked.bind(this);
  }

  handleEmailChange(event) {
    if(validator.isEmail(event.target.value)) {
      this.setState({
        custId: event.target.value,
        emailerror: "",
      });
    } else {
      this.setState({
        custId: event.target.value,
        emailerror: "Email Is Invalid ",
      });
    }
  }

  handlePasswordChange(event) {
    if (event.target.value.length < 5) {
      this.setState({
        password: event.target.value,
        passworderror: "Enter valid password",
      });
    } else {
      this.setState({
        password: event.target.value,
        passworderror: "",
      });
    }
  }

 

  loginClicked(){
      console.log("loginclicked")
      
      console.log(this.state.custId,this.state.password)
      userService.userSignIn(this.state.custId,this.state.password)
        .then(
            response=>{
                console.log(response)
                AuthenticationCustomerService.CustomerSuccessfullLogin(this.state.custId,this.state.password);
                this.props.history.push('/customerdashboard');

                console.log("successfull login");
                
            }
      )
      .catch(
          ()=>{
              this.setState({hasLoginFailed:true})
          }

      )

  }
  render() {
    return (
      <div>
        <Container >
            <p style={{paddingBottom:"40px",fontSize:"40px"}}>Welcome Back, please login to your account!</p>
        </Container>
        {this.state.emailerror &&  (<div className="alert alert-warning">{this.state.emailerror}</div> ) }
        {this.state.passworderror &&  (<div className="alert alert-warning">{this.state.passworderror}</div> ) }
        {this.state.hasLoginFailed && (
            <div className="alert alert-warning"> Login failed</div>
          )}
        <Container>
          <Row className="justify-content-md-center">
           <Col xs lg="4" style={{paddingTop:"50px",backgroundColor:"#e9ecef",paddingLeft:"20px",paddingRight:"20px"}}>
          <div className="form-group">
            <p align="left">Customer ID:</p>
            <input style={{"borderRadius":"20px"}}
              className="form-control"
              type="text"
              value={this.state.custId}
              name="adminId"
              placeholder="Enter Customer ID"
              onChange={this.handleEmailChange}
            />
          </div>
          <div className="form-group">
            <p align="left" style={{paddingTop:"10px"}}>Password:</p>
            <input style={{"borderRadius":"20px"}}
              className="form-control"
              type="password"
              value={this.state.password}
              name="password"
              placeholder="Enter Customer password"
              onChange={this.handlePasswordChange}
            />
          </div>
          <button
            className="btn btn-primary btn-md btn-block mt-3"
            type="submit"
            onClick={this.loginClicked}
          >
            Sign In
          </button>
          </Col>
          <Col xs lg="4" style={{backgroundColor:"#09f"}}>
            <div style={{height:"300px",width:"100%"}} >
                <p style={{paddingTop:"120px",color:"white",fontSize:"30px"}}>Login Customer Page</p>
            </div>
            </Col>
          </Row>
        </Container>
      </div>
      
      
    );
  }
}

export default CustomerLogin;
