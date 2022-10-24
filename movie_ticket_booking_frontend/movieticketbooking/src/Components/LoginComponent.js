import React, { Component } from 'react';
import {Container,Row,Col} from 'react-bootstrap';
import RightSide from './RightSide';
import userService from '../Services/userService';

class LoginComponent extends Component {

    constructor() {
        super()
        this.initialState = {
            email: "",
            password: "",
            emailerror: "",
            passworderror: ""
        }
        this.handleEmailChange = this.handleEmailChange.bind(this)
        this.handlePasswordChange = this.handlePasswordChange.bind(this)
        this.login = this.login.bind(this);
        this.state = this.initialState;
    }

    handleEmailChange(event) {
        this.setState({email: event.target.value});
    }

    handlePasswordChange(event) {
        this.setState({password: event.target.value});
    }

    onResetClick(e) {
        e.preventDefault();
        this.setState(this.initialState);
    }

    login(email,password) {
        userService.userSignIn(this.state.email, this.state.password).subscribe(res => {
          if (res.result === 'success') {
            global.token = res.token;
            this.props.history.push('/addmovies');
          } 
          else {
            alert(`[ERROR CODE : ${res.statusCode}] ${res.msg}`);
          }
      });
      //this.props.history.push('/addmovies');
      alert("successfully logged in");
    }

    render() {

        return (
            <Container>
                <Row>
                    <Col className="text-center">
                        <form onSubmit={this.submitHandler} style = {{width:"100%", marginLeft:"5%", marginTop:"5%"}}>
                            <h2>Sign In</h2>
                            <h6 style={{ color: "red" }}>Fields marked with * are mandatory</h6>
                            <h6 style={{ color: "red" }}>{this.state.emailerror}</h6>
                            <h6 style={{ color: "red" }}>{this.state.passworderror}</h6>
                            <table align="center"> 
                                <tr><td>
                            Email: <span style={{ color: "red" }}>*</span>
                            </td>
                            <td>

                                <input type="email" placeholder="Enter your email" value={this.state.email} onChange={this.handleEmailChange} required/>
                            </td>
                            </tr>
                            
                            <br />
                            <tr>
                                <td>
                            Pasword: <span style={{ color: "red" }}>*</span>
                            </td>
                            <td>
                                <input type="password" placeholder="Enter your password" value={this.state.password} onChange={this.handlePasswordChange} required/>
                            </td>
                            </tr>
                            
                            <br />
                            <tr>
                            <td>
                            <button type="submit" className="btn-primary" onClick={ () => this.login(this.state.email,this.state.password)}>Submit</button>
                            </td>
                                <td><button className="btn-primary" onClick={this.onResetClick.bind(this)}>Reset</button></td>
                            </tr>
                            </table>
                        </form>
                    </Col>
                    <Col><RightSide /></Col>
                </Row>
            </Container>
        )
    }
}

export default LoginComponent;
