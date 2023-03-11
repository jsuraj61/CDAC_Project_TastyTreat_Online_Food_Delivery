import axios from "axios";
import { useState } from "react"
import { useNavigate } from "react-router";
import { Link } from "react-router-dom";
import { toast } from "react-toastify";
import { URL } from '../../../config'

const ManagerSignUp = () => {

    const [managerName, setManagerName] = useState("");
    const [managerEmail, setManagerEmail] = useState("");
    const [managerPassword, setManagerPassword] = useState("");
    const [confirmManagerPassword, setConfirmManagerPassword] = useState("");
    const [restaurantName,setRestaurantName]=useState("");
    const [restaurantAdressText,setRestaurantAdressText]=useState("");
    const [restaurantPinCode,setRestaurantPinCode]=useState(0);
    

    const navigate = useNavigate();
    
    const validateInput = () => {
        if(managerName === "") {
            toast.error("Please enter your name");
            return false;
        }
        if(managerEmail === "") {
            toast.error("Please enter your email");
            return false;
        }
        if(managerPassword === "") {
            toast.error("Please enter your password");
            return false;
        }
        if(confirmManagerPassword === "") {
            toast.error("Please enter confirm password");
            return false;
        }
        if(restaurantName === "") {
            toast.error("Please enter restaurant name");
            return false;
        }
        if(restaurantAdressText === "") {
            toast.error("Please enter restaurannt address");
            return false;
        }
        if(restaurantPinCode === "") {
            toast.error("Please enter restaurant pin code");
            return false;
        }
        if (managerPassword !== confirmManagerPassword) {
            toast.error("Password does not match with confirm password");
            return false;
        }

        return true;
    }

    const signUpManager = () => {
        if(validateInput) {
            const url = `${URL}/restaurantmanager/signup`;
            const body = {
                managerName,
                managerEmail,
                managerPassword,
                restaurantName,
                restaurantAdressText,
                restaurantPinCode
            }
            axios.post(url, body).then(response => {
                const result = response.data;
                if(result.status === "SUCCESS") {
                    toast.success("Manager successfully signed up")
                    navigate("/manager/signin")
                } else {
                    toast.error(result.message)
                }
            })
        }
    }


    return (
        <div>
            <h2 className="title">Manager Sign Up</h2>

            <div className="row">
                <div className="col"></div>
                <div className="col">
                    <div className="form">

                        {/* name */}
                        <div className="mb-3">
                            <label htmlFor="managerName" className="label-control">
                                Manager Name
                            </label>
                            <input type="text" onChange={ (e) => setManagerName(e.target.value) } value={managerName} className="form-control" id="managerName"/>
                        </div>

                        {/* email */}
                        <div className="mb-3">
                            <label htmlFor="managerEmail" className="label-control">
                                Manager Email Address
                            </label>
                            <input type="text" onChange={ (e) => setManagerEmail(e.target.value) } value={managerEmail} className="form-control" id="managerEmail"/>
                        </div>

                        {/* password */}
                        <div className="mb-3">
                            <label htmlFor="managerPassword" className="label-control">
                                Manager Password
                            </label>
                            <input type="password" onChange={ (e) => setManagerPassword(e.target.value) } value={managerPassword}  className="form-control" id="managerPassword"/>
                        </div>

                        {/* confirm password */}
                        <div className="mb-3">
                            <label htmlFor="confirmManagerPassword" className="label-control">
                                Confirm Password
                            </label>
                            <input type="password" onChange={ (e) => setConfirmManagerPassword(e.target.value) } value={confirmManagerPassword}  className="form-control" id="confirmManagerPassword"/>
                        </div>

                        {/* restaurantName */}
                        <div className="mb-3">
                            <label htmlFor="restaurantName" className="label-control">
                                Restaurant Name
                            </label>
                            <input type="text" onChange={ (e) => setRestaurantName(e.target.value) } value={restaurantName} className="form-control" id="restaurantName"/>
                        </div>

                        {/* restaurantAdressText */}
                        <div className="mb-3">
                            <label htmlFor="restaurantAdressText" className="label-control">
                                Restaurant Address
                            </label>
                            <input type="text" onChange={ (e) => setRestaurantAdressText(e.target.value) } value={restaurantAdressText} className="form-control" id="restaurantAdressText"/>
                        </div>

                        {/* restaurantPinCode */}
                        <div className="mb-3">
                            <label htmlFor="managerEmail" className="label-control">
                                Restaurant Pin Code
                            </label>
                            <input type="number" onChange={ (e) => setRestaurantPinCode(e.target.value) } value={restaurantPinCode} className="form-control" id="restaurantPinCode"/>
                        </div>
                     


                        <div className="mb-3">
                            <div>
                                Already have an account? <Link to="/manager/signin">Sign in here!</Link>
                            </div>
                            <button className="btn btn-primary" onClick={signUpManager}>Sign Up</button>
                        </div>
                    </div>
                </div>
                <div className="col"></div>
            </div>
        </div>
    )    
}

export default ManagerSignUp