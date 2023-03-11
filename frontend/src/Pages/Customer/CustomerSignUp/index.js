import axios from "axios";
import { useState } from "react"
import { useNavigate } from "react-router";
import { Link } from "react-router-dom";
import { toast } from "react-toastify";
import { URL } from '../../../config'

const CustomerSignUp = () => {

    const [name, setName] = useState("");
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");
    const [confirmPassword, setConfirmPassword] = useState("");
    const [address, setAddress] = useState("");
    const [pinCode, setPinCode] = useState(0);

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
        if(address === "") {
            toast.error("Please enter your address");
            return false;
        }
        if(pinCode === "") {
            toast.error("Please enter your pin code");
            return false;
        }

        if (password !== confirmPassword) {
            toast.error("Password does not match with confirm password");
            return false;
        }

        return true;
    }

    const signUpCustomer = () => {
        if(validateInput) {
            const url = `${URL}/customers/signup`;
            const body = {
                name,
                email,
                password,
                addressText: address,
                pinCode
            }
            axios.post(url, body).then(response => {
                const result = response.data;
                if(result.status === "SUCCESS") {
                    toast.success("Customer successfully signed up")
                    navigate("/customer/signin")
                } else {
                    toast.error(result.message)
                }
            })
        }
    }


    return (
        <div>
            <h2 className="title">Fill details to Sign Up</h2>

            <div className="row">
                <div className="col"></div>
                <div className="col">
                    <div className="form">

                        {/* name */}
                        <div className="mb-3">
                            <label htmlFor="name" className="label-control">
                                Name
                            </label>
                            <input type="text" placeholder="Enter your name" required onChange={ (e) => setName(e.target.value) } value={name} className="form-control" id="name"/>
                        </div>

                        {/* email */}
                        <div className="mb-3">
                            <label htmlFor="email" className="label-control">
                                Email Address
                            </label>
                            <input type="email" placeholder="Enter your email Id" required onChange={ (e) => setEmail(e.target.value) } value={email} className="form-control" id="email"/>
                        </div>

                        {/* password */}
                        <div className="mb-3">
                            <label htmlFor="password" className="label-control">
                                Password
                            </label>
                            <input type="password" required onChange={ (e) => setPassword(e.target.value) } value={password}  className="form-control" id="confirmPassword"/>
                        </div>

                        {/* confirm password */}
                        <div className="mb-3">
                            <label htmlFor="confirmPassword" className="label-control">
                                Confirm Password
                            </label>
                            <input type="password" onChange={ (e) => setConfirmPassword(e.target.value) } value={confirmPassword}  className="form-control" id="password"/>
                        </div>

                        {/* address */}
                        <div className="mb-3">
                            <label htmlFor="address" className="label-control">
                                Address
                            </label>
                            <textarea placeholder="Enter address here" onChange={ (e) => setAddress(e.target.value) } value={address}  className="form-control" id="address"> </textarea>
                        </div>

                        {/* pin code */}
                        <div className="mb-3">
                            <label htmlFor="pinCode" placeholder="enter your pin" className="label-control">
                                Pin Code
                            </label>
                            <input 
                                type="number" 
                                id="pinCode" 
                                onChange={ (e) => setPinCode(e.target.value) } 
                                value={pinCode} 
                                className="form-control"
                            />
                        </div>

                        <div className="mb-3">
                            <div>
                                Already have an account? <Link to="/customer/signin">Sign in here!</Link>
                            </div>
                            <button className="btn btn-primary" onClick={signUpCustomer}>Sign Up</button>
                        </div>
                    </div>
                </div>
                <div className="col"></div>
            </div>
        </div>
    )    
}

export default CustomerSignUp