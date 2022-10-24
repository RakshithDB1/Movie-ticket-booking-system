import React from 'react';
import userService from '../Services/userService';

class Profile extends React.Component {

    constructor(props){
        super(props)
        this.state = {
            user: ''
        }
    }

    componentDidMount(){
        userService.getUser(this.props.custId,this.props.password).then((response) => {
            this.setState({ user: response.data})
        });
    }

    render (){
        return (
            <div>
                <h2 className = "text-center"> Profile</h2>
                <center>
                <img
                src='./img/profile.jfif'
                className='img-fluid rounded-circle'
                alt=''
                style={{ maxWidth: '24rem', maxHeight:'10rem' }}
               />
               </center>
                <table className = "table table-striped">
                    <thead>
                        <tr>

                            <td> User Id</td>
                            <td> User Name</td>
                            <td> User Email Id</td>
                            <td> User Mobile No.</td>
                            <td> User Address</td>
                        </tr>

                    </thead>
                    <tbody>
                        {
                                user => 
                                <tr key = {user.user_id}>
                                     <td> {user.user_name}</td>  
                                     <td> {user.user_email}</td>   
                                     <td> {user.user_mobile}</td>   
                                     <td> {user.user_address}</td>   
                                </tr>
                        }

                    </tbody>
                </table>

            </div>

        )
    }
}

export default Profile