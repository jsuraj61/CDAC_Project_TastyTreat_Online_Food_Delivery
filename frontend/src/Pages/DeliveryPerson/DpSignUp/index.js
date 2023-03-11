import axios from "axios";
import { useState } from "react"
import { useNavigate } from "react-router";
import { Link } from "react-router-dom";
import { toast } from "react-toastify";
import { URL } from '../../../config'

const DeliveryPersonSignUp = () => {

    const [name, setName] = useState("");
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");
    const [confirmPassword, setConfirmPassword] = useState("");
  
    

    const navigate = useNavigate();
    
    const validateInput = () => {
        if(name === "") {
            toast.error("Please enter your name");
            return false;
        }
        if(email === "") {
            toast.error("Please enter your email");
            return false;
        }
        if(password === "") {
            toast.error("Please enter your password");
            return false;
        }
        if(confirmPassword === "") {
            toast.error("Please enter confirm password");
            return false;
        }
        if (password !== confirmPassword) {
            toast.error("Password does not match with confirm password");
            return false;
        }

        return true;
    }

    const signUpDeliveryPerson = () => {
        if(validateInput()) {
            const url = `${URL}/deliveryperson/signup`;
            const body = {
                name,
                email,
                password,
                available: true
               
            }
            axios.post(url, body).then(response => {
                const result = response.data;
                if(result.status === "SUCCESS") {
                    toast.success("deliveryPerson successfully signed up")
                    navigate("/dp/signin")
                } else {
                    toast.error(result.message)
                }
            })
        }
    }


    return (
        <div>
            <h2 className="title">Delivery Person Sign Up</h2>

            <div className="row">
                <div className="col"></div>
                <div className="col">
                    <div className="form">

                        {/* name */}
                        <div className="mb-3">
                            <label htmlFor="name" className="label-control">
                                Name
                            </label>
                            <input type="text" onChange={ (e) => setName(e.target.value) } value={name} className="form-control" id="name"/>
                        </div>

                        {/* email */}
                        <div className="mb-3">
                            <label htmlFor="email" className="label-control">
                                Email Address
                            </label>
                            <input type="text" onChange={ (e) => setEmail(e.target.value) } value={email} className="form-control" id="email"/>
                        </div>

                        {/* password */}
                        <div className="mb-3">
                            <label htmlFor="password" className="label-control">
                                Password
                            </label>
                            <input type="password" onChange={ (e) => setPassword(e.target.value) } value={password}  className="form-control" id="confirmPassword"/>
                        </div>

                        {/* confirm password */}
                        <div className="mb-3">
                            <label htmlFor="confirmPassword" className="label-control">
                                Confirm Password
                            </label>
                            <input type="password" onChange={ (e) => setConfirmPassword(e.target.value) } value={confirmPassword}  className="form-control" id="password"/>
                        </div>

                     


                        <div className="mb-3">
                            <div>
                                Already have an account? <Link to="/DP/signin">Sign in here!</Link>
                            </div>
                            <button className="btn btn-primary" onClick={signUpDeliveryPerson}>Sign Up</button>
                        </div>
                    </div>
                </div>
                <div className="col"></div>
            </div>
        </div>
    )    
}

export default DeliveryPersonSignUp