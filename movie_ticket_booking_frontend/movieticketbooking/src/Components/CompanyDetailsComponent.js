import React from 'react';
import {Row,Card,Col} from 'react-bootstrap';
import axios from 'axios';

function CompanyDetailsComponent(props){
    if(props.loggedIn){
        if(props.watch){
            return(
                <Col lg={4}>
                    <Card className="m-3">
                        <Card.Body>
                            <Card.Title>{props.movieName}</Card.Title>
                            <Card.Text>{props.movieCast}</Card.Text>
                            <Row className="d-flex px-3">
                                <span style={{fontWeight:'bold'}}>
                                Today's Price : ${props.currentStockPrice}
                                </span>
                            <button class="ml-auto bg-danger text-white" onClick={props.onClick}>Remove</button>
                            </Row>
                        </Card.Body>
                    </Card>
                </Col>
            )
        }
        else{
            return(

                <Col lg={4}>
                    <Card className="m-3">
                        <Card.Img variant="top" src="holder.js/100px180" src={props.postermage} />  
                        <Card.Body>
                            <Card.Title>{props.movieName}</Card.Title>
                            <Card.Text>{props.movieCast}</Card.Text>
                            <Row className="d-flex px-3">
                                <span style={{fontWeight:'bold'}}>
                                Today's Price : ${props.price}
                                </span>
                                <a href="/payment" className="btn btn-outline-success">Book</a>
                            </Row>
                        </Card.Body>
                    </Card>
                </Col>
            )
        }
    }
    else{
        return(
            <div>
                <header>{props.movieName}</header>
                <p>{props.movieCast}</p>
                <footer>Today's Price : ${props.price}</footer>
            </div>
        )
    }
}

export default CompanyDetailsComponent;
