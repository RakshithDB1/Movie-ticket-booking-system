import React, {Component} from 'react';
import {Container,Row,Col} from 'react-bootstrap';
import cinemahallService from '../Services/cinemahallService';

class AddCinemahall extends Component {
    constructor(props){
        super(props)
        this.state={
            cinemahallName: '',
            cinemahallLocation: '',
            movieId: '',
            noOfSeats: ''
        }
        this.changeCinemahallNameHandler = this.changeCinemahallNameHandler.bind(this);
        this.changeCinemahallLocationHandler = this.changeCinemahallLocationHandler.bind(this);
        this.changeMovieIdHandler = this.changeMovieIdHandler.bind(this);
        this.changeNoOfSeatsHandler = this.changeNoOfSeatsHandler.bind(this);
        this.saveCinemahall = this.saveCinemahall.bind(this);
    }

    changeCinemahallNameHandler= (event) => {
        this.setState({cinemahallName: event.target.value});
    }

    changeCinemahallLocationHandler = (event) => {
        this.setState({cinemahallLocation:event.target.value});
    }

    changeMovieIdHandler = (event) => {
        this.setState({movieId:event.target.value});
    }

    changeNoOfSeatsHandler = (event) => {
        this.setState({noOfSeats: event.target.value});
    }

    saveCinemahall = (e) => {
        e.preventDefault();
        let cinemahall = { 
            cinemahall_id: 4,
            cinemahall_name: this.state.cinemahallName,
            cinemahall_location: this.state.cinemahallLocation,
            movie_ID: this.state.movieId,
            no_of_seats: this.state.noOfSeats,
         };
        console.log('cinemahall => ' + JSON.stringify(cinemahall));

        cinemahallService.addCinemahall(cinemahall).then(res =>{
                this.props.history.push('/addCinemahall');
        });

        alert("Cinemahall added successfully!");
       
    }

    render() {
        return (
            <Container>
       <Row>
        <Col className="text-center" style = {{width:"100%", marginLeft:"5%", marginTop:"5%"}}>
        <form onSubmit={this.submitHandler} >
            <h2>Add Cinemahall</h2>
            <table align="center">
                <tr><td>
                Cinemahall Name: <span style={{ color: "red" }}>*</span>
            </td>
            <td>
            <input type="text" placeholder="Cinemahall name" value={this.state.cinemahallName} onChange={this.changeCinemahallNameHandler} />
                </td></tr>
            <br />
            <tr><td>
            Cinemahall Location: <span style={{ color: "red" }}>*</span>
                </td>
                <td>
                <input type="text" placeholder="Cinemahall Location" value={this.state.cinemahallLocation} onChange={this.changeCinemahallLocationHandler} />
            </td>
            </tr>
            <br />
            <tr>
            <td>
            Movie ID: <span style={{ color: "red" }}>*</span>
                </td>
                <td>
                <input type="text" placeholder="Movie ID" value={this.state.movieId} onChange={this.changeMovieIdHandler} />
            </td>
            </tr>
            <br/>
            <tr>
            <td>
            No. of seats: <span style={{ color: "red" }}>*</span>
                </td>
                <td>
                <input type="text" placeholder="No. of seats " value={this.state.noOfSeats} onChange={this.changeNoOfSeatsHandler} />
            </td>
            </tr>
            <br/>
            <tr>
                <td>
            <button type="submit" className="btn-primary" onClick={this.saveCinemahall}>Save</button>
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
export default AddCinemahall