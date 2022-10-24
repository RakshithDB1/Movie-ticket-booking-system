import React,{Component} from "react";
import Card from "./CardUI";

import img1 from "../assets/image1.jfif"
import img2 from "../assets/image2.jfif"
import img3 from "../assets/image3.jfif"

class Cards extends Component{
    render(){
        return(
            <div className="container-fluid d-flex justify-content-center">
                <div className="row row-cols-1 row-cols-md-3">
                    <div className="col-md-4">
                        <Card imgsrc={img1} title="Water Bottles"/>
                    </div>
                    <div className="col-md-4">
                    <Card imgsrc={img2} title="Water Bottles"/>
                    </div>
                    <div className="col-md-4">
                    <Card imgsrc={img3} title="Candies"/>
                    </div>
                    <div className="col-md-4">
                    <Card imgsrc={img2} title="Candies"/>
                    </div>
                    <div className="col-md-4">
                    <Card imgsrc={img1} title="Water Bottles"/>
                    </div>
                    <div className="col-md-4">
                    <Card imgsrc={img3} title="Water Bottles"/>
                    </div>
                </div>
            </div>

        );
    }
}

export default Cards;