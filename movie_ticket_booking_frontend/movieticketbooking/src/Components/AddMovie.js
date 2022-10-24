import React, {Component} from 'react';
import {Container,Row,Col} from 'react-bootstrap';
import movieService from '../Services/movieService';

class AddMovie extends Component {
    constructor(props){
        super(props)
        this.state={
            movieGenere: '',
            movieName: '',
            movieCast: '',
            posterImage: ''
        }
        this.changeMovieGenereHandler = this.changeMovieGenereHandler.bind(this);
        this.changeMovieNameHandler = this.changeMovieNameHandler.bind(this);
        this.changeMovieCastHandler = this.changeMovieCastHandler.bind(this);
        this.changePosterImageHandler = this.changePosterImageHandler.bind(this);
        this.saveMovie = this.saveMovie.bind(this);
    }

    changeMovieGenereHandler= (event) => {
        this.setState({movieGenere: event.target.value});
    }

    changeMovieNameHandler = (event) => {
        this.setState({movieName:event.target.value});
    }

    changeMovieCastHandler = (event) => {
        this.setState({movieCast:event.target.value});
    }

    changePosterImageHandler = (event) => {
        this.setState({posterImage:event.target.value});
    }

    saveMovie = (e) => {
        e.preventDefault();
        let movie = { 
            movie_id: 5,
            movie_generes: this.state.movieGenere,
            movie_name: this.state.movieName,
            movie_cast: this.state.movieCast,
            posterimage: this.state.posterImage
        
         };
        console.log('movie => ' + JSON.stringify(movie));

        movieService.addMovies(movie).then(res =>{
                this.props.history.push('/addMovie');
        });

        alert("Movie added successfully!")
       
    }

    render() {
        return (
            <Container>
                <Row>
                    <Col className="text-center" style = {{width:"100%", marginLeft:"5%", marginTop:"5%"}}>
                        <form onSubmit={this.submitHandler} >
                            <h2>Add Movie</h2>
                            <h6 style={{ color: "red" }}>{this.state.emailerror}</h6>
                            <h6 style={{ color: "red" }}>{this.state.passworderror}</h6>
                            <table align="center">
                                <tr><td>
                            Movie Genere: <span style={{ color: "red" }}>*</span>
                            </td>
                            <td>
                                <input type="text" placeholder="Enter movie genere" value={this.state.movieGenere} onChange={this.changeMovieGenereHandler} required/>
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
                            Movie Cast: <span style={{ color: "red" }}>*</span>
                                </td>
                                <td>
                                <input type="text" placeholder="Enter movie cast" value={this.state.movie_cast} onChange={this.changeMovieCastHandler} />
                            </td>
                            </tr>
                            <br/>
                            <tr>
                            <td>
                            Poster Image: <span style={{ color: "red" }}>*</span>
                                </td>
                                <td>
                                <input type="file" placeholder="choose image" value={this.state.posterImage} onChange={this.changePosterImageHandler} />
                            </td>
                            </tr>
                            <br/>
                            <tr>
                                <td>
                            <button type="submit" className="btn-primary" onClick={this.saveMovie}>Save</button>
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
export default AddMovie