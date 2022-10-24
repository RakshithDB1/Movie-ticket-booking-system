import React, {Component} from 'react';
import {Container,Row,Col} from 'react-bootstrap';
import movieService from '../Services/movieService';

class RemoveMovie extends Component {
    constructor(props){
        super(props)
        this.state={
            movieCode: '',
            movieName: ''
        }
        this.changeMovieCodeHandler = this.changeMovieCodeHandler.bind(this);
        this.changeMovieNameHandler = this.changeMovieNameHandler.bind(this);
        this.removeMovies = this.removeMovies.bind(this);
    }

    changeMovieCodeHandler= (event) => {
        this.setState({movieCode: event.target.value});
    }

    changeMovieNameHandler = (event) => {
        this.setState({movieName:event.target.value});
    }

    removeMovies(movieCode){
        movieService.removeMovies(movieCode).then( res => {
            this.setState({movieCode:this.state.movieCode});

            alert("Movie deleted!")
        });
       
    }

    render() {
        return (
            <Container>
                <Row>
                    <Col className="text-center" style = {{width:"100%", marginLeft:"5%", marginTop:"5%"}}>
                        <form onSubmit={this.submitHandler} >
                            <h2>Remove Movie</h2>
                            <br/>
                            <table align="center">
                                <tr><td>
                            Movie Code: <span style={{ color: "red" }}>*</span>
                            </td>
                            <td>
                                <input type="text" placeholder="Enter movie code" value={this.state.movieCode} onChange={this.changeMovieCodeHandler} />
                                </td></tr>
                            <br />
                            <tr><td>
                            Movie Name: <span style={{ color: "red" }}>*</span>
                                </td>
                                <td>
                                <input type="text" placeholder="Enter movie name" value={this.state.movieName} onChange={this.changeMovieNameHandler} />
                            </td>
                            </tr>
                            <br />
                            <tr>
                                <td>
                            <button type="submit" className="btn-primary" onClick={ () => this.removeMovies(this.state.movieCode)}>Remove</button>
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
export default RemoveMovie