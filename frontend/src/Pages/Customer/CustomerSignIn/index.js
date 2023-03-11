import { useEffect, useState } from "react"
import { toast } from "react-toastify";
import { Link } from "react-router-dom";
import axios from "axios";
import { useNavigate } from "react-router";
import { URL } from '../../../config'

const CustomerSignIn = () => {
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");

    const navigate = useNavigate()

    useEffect( ()=> {
        if (sessionStorage["personType"] === "customer" && sessionStorage["loginStatus"] === "1") {
            navigate("/customer/home")
        }
    }, [navigate])

    const signInCustomer = () => {
        if(email.length === 0)
            toast.warning("Please enter email")
        else if (password.length === 0)
            toast.warning("Please enter password")
        else {
            const body = {
                email,
                password
            }
            const url = `${URL}/customers/signin`
            axios.post(url, body).then((response) => {
                const result = response.data

                if(result.status === "SUCCESS") {
                    toast.success("Welcome to Tatsty-Treat")
                    const { id, name, email, addressText, pinCode } = result.data;

                    sessionStorage['id'] = id;
                    sessionStorage['name'] = name;
                    sessionStorage['email'] = email;
                    sessionStorage['addressText'] = addressText;
                    sessionStorage['pinCode'] = pinCode;

                    sessionStorage['loginStatus'] = '1';
                    sessionStorage['personType'] = 'customer';
                    sessionStorage["foodItemMap"] = "[]";

                    navigate('/customer/home')

                } else {
                    toast.error(result.message)
                }
            })


        }
    }

    return (
        <div>
            <h2 className="title">Customer Sign In</h2>

            <div className="row">
                <div className="col"></div>
                <div className="col">
                    <div className="form">

                        <div className="mb-3">
                            <label htmlFor="email" className="label-control">
                                Email Address
                            </label>
                            <input type="email" onChange={ (e) => setEmail(e.target.value) } value={email} className="form-control" />
                        </div>

                        <div className="mb-3">
                            <label htmlFor="password" className="label-control">
                                Password
                            </label>
                            <input type="password" onChange={ (e) => setPassword(e.target.value) } value={password}  className="form-control"/>
                        </div>

                        <div className="mb-3">
                            <div>
                                No account? <Link to="/customer/signup">Sign up here!</Link>
                            </div>
                            <button className="btn btn-primary" onClick={signInCustomer}>Sign In</button>
                        </div>
                    </div>
                </div>
                <div className="col"></div>
            </div>
        </div>
    )
}

export default CustomerSignIn