import React, {Component} from 'react';
import {Container,Row,Col} from 'react-bootstrap';
import cinemahallService from '../Services/cinemahallService';

class RemoveCinemahall extends Component {
    constructor(props){
        super(props)
        this.state={
            cinemahallId: '',
            cinemahallName: ''
        }
        this.changeCinemahallIdHandler = this.changeCinemahallIdHandler.bind(this);
        this.changeCinemahallNameHandler = this.changeCinemahallNameHandler.bind(this);
        this.removeCinemahall = this.removeCinemahall.bind(this);
    }

    changeCinemahallIdHandler= (event) => {
        this.setState({cinemahallId: event.target.value});
    }

    changeCinemahallNameHandler = (event) => {
        this.setState({cinemahallName:event.target.value});
    }


    removeCinemahall(cinemahallId){
        cinemahallService.removeCinemahall(cinemahallId).then( res => {
            this.setState({cinemahallId:this.state.cinemahallId});
            alert("Cinemahall deleted!")
        });
        
    }

    render() {
        return (
            <Container>
                <Row>
                    <Col className="text-center" style = {{width:"100%", marginLeft:"5%", marginTop:"5%"}}>
                        <form onSubmit={this.submitHandler} >
                            <h2>Remove Cinemahall</h2>
                            <br/>
                            <table align="center">
                                <tr><td>
                            Cinemahall Id: <span style={{ color: "red" }}>*</span>
                            </td>
                            <td>
                                <input type="text" placeholder="Enter cinemahall id" value={this.state.cinemahallId} onChange={this.changeCinemahallIdHandler} />
                                </td></tr>
                            <br />
                            <tr><td>
                            cinemahallName Name: <span style={{ color: "red" }}>*</span>
                                </td>
                                <td>
                                <input type="text" placeholder="Enter cinemahall name" value={this.state.cinemahallName} onChange={this.changeCinemahallNameHandler} />
                            </td>
                            </tr>
                            <br />
                            <tr>
                                <td>
                            <button type="submit" className="btn-primary" onClick={ () => this.removeCinemahall(this.state.cinemahallId)}>Remove</button>
                            </td>
                            <td><button type="reset" className="btn-primary">Reset</button></td>
                            </tr>
                            </table>
                        </form>
                    </Col>
                </Row>
            </Container>
        )
    }
}
export default RemoveCinemahall