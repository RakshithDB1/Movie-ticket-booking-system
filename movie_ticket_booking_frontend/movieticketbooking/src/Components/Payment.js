import React, {Component} from 'react';
import {Container,Row,Col} from 'react-bootstrap';

class Payment extends Component {
    constructor(props){
        super(props)
        this.state={
            cardHolderName: '',
            cardNumber: '',
            cardExpDate: '',
            cvv: ''
        }
        this.changeCardHolderNameHandler = this.changeCardHolderNameHandler.bind(this);
        this.changeCardNumberHandler = this.changeCardNumberHandler.bind(this);
        this.changeCardExpDateHandler = this.changeCardExpDateHandler.bind(this);
        this.changeCvvHandler = this.changeCvvHandler.bind(this);
        this.payment = this.payment.bind(this);
    }

    changeCardHolderNameHandler = (event) => {
        this.setState({cardHolderName: event.target.value});
    }

    changeCardNumberHandler = (event) => {
        this.setState({cardNumber:event.target.value});
    }

    changeCardExpDateHandler = (event) => {
        this.setState({cardExpDate:event.target.value});
    }

    changeCvvHandler = (event) => {
        this.setState({cvv:event.target.value});
    }

    payment = (e) => {
        e.preventDefault();
        alert("Your payment is successful!")
       
    }

    render() {
        return (
            <Container>
                <Row>
                    <Col className="text-center" style = {{width:"100%", marginLeft:"5%", marginTop:"5%"}}>
                        <form >
                            <h2>Payment</h2>
                            <table align="center">
                                <tr><td>
                            Card Holder Name: <span style={{ color: "red" }}>*</span>
                            </td>
                            <td>
                                <input type="text" placeholder="Enter Card Holder Name" value={this.state.cardHolderName} onChange={this.changeCardHolderNameHandler} required/>
                                </td></tr>
                            <br />
                            <tr><td>
                            Card Number: <span style={{ color: "red" }}>*</span>
                                </td>
                                <td>
                                <input type="text" placeholder="Enter Card Number" value={this.state.cardNumber} onChange={this.changeCardNumberHandler} />
                            </td>
                            </tr>
                            <br />
                            <tr>
                            <td>
                            Card Expiration Date: <span style={{ color: "red" }}>*</span>
                                </td>
                                <td>
                                <input type="text" placeholder="Enter Card Expiration Date" value={this.state.cardExpDate} onChange={this.changeCardExpDateHandler} />
                            </td>
                            </tr>
                            <br/>
                            <tr>
                            <td>
                            CVV: <span style={{ color: "red" }}>*</span>
                                </td>
                                <td>
                                <input type="text" placeholder="Enter CVV" value={this.state.cvv} onChange={this.changeCvvHandler} />
                            </td>
                            </tr>
                            <br/>
                            <tr>
                                <td>
                            <button type="submit" className="btn-primary" onClick={this.payment}>payment</button>
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
export default Payment