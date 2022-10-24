import React, {Component} from 'react';
import { Card } from "react-bootstrap";
import movieService from "../Services/movieService";

class MoviesCards extends Component {
  constructor(props) {
    super(props)

    this.state = {
            movies: []
    }

    /*componentDidMount();{
      movieService.getAllMovies().then((res) => {
          this.setState({ movies: res.data});
      });
    }*/
    

   }

  /* render() {
    return (
      <Card style={{ width: "18rem" }} key={index} className="box">
        <Card.Img variant="top" src="holder.js/100px180" src={movies.posterimage} />
        <Card.Body>
          <Card.Title>{movies.movie_name}</Card.Title>
          <Card.Text>{movies.movie_cast}</Card.Text>
        </Card.Body>
      </Card>
    )
   }*/

}

export default MoviesCards;