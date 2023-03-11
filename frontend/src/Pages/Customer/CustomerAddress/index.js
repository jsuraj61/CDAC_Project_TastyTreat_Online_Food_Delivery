import axios from "axios";
import { useEffect, useState } from "react"
import { toast } from "react-toastify";
import { URL } from '../../../config'
import { useNavigate } from "react-router";

const CustomerAddress = () => {

    const navigate = useNavigate();
    const [addressText, setAddressText] = useState(sessionStorage["addressText"]);
    const [pinCode, setPinCode] = useState(sessionStorage["pinCode"]);

    const updateAddress = (e) => {
        e.preventDefault();

        if(sessionStorage["updateMode"] === "true") {
            document.getElementById("updateAddressButton").classList.remove("btn-outline-primary");
            document.getElementById("updateAddressButton").classList.add("btn-outline-danger");

            document.getElementById("prevButton").disabled = true;
            document.getElementById("nextButton").disabled = true;

            document.getElementById("address").disabled = false;
            document.getElementById("pinCode").disabled = false;
            sessionStorage["updateMode"] = "false";
        } else {
            document.getElementById("updateAddressButton").classList.add("btn-outline-primary");
            document.getElementById("updateAddressButton").classList.remove("btn-outline-danger");

            document.getElementById("prevButton").disabled = false;
            document.getElementById("nextButton").disabled = false;

            document.getElementById("address").disabled = true;
            document.getElementById("pinCode").disabled = true;

            // update address
            const customerId = sessionStorage["id"];
            const url = `${URL}/customers/${customerId}/address`;
            const body = {
                addressText,
                pinCode
            }
            axios.put(url, body).then(response => {
                const result = response.data;
                if(result.status === "SUCCESS") {
                    toast.success("Address successfully updated");
                    sessionStorage["addressText"] = addressText;
                    sessionStorage["pinCode"] = pinCode;
                } else {
                    toast.error(result.message);
                    setAddressText(sessionStorage["addressText"]);
                    setPinCode(sessionStorage["pinCode"]);
                }
            }).catch(error => {
                console.log(error);
                setAddressText(sessionStorage["addressText"]);
                setPinCode(sessionStorage["pinCode"]);
            })

            sessionStorage["updateMode"] = "true";
        }
    }

     
    useEffect( ()=> {
        sessionStorage["updateMode"] = "true";
    }, [])

    return (
        <div>
            <h3>Address</h3>

            <div className="row">
                <div className="col"></div>
                <div className="col">
                    <div className="form">

                        <div className="mb-3">
                            <label htmlFor="address" className="label-control">
                                Address
                            </label>
                            <textarea 
                                id="address" 
                                onChange={ (e) => setAddressText(e.target.value) } 
                                value={addressText} 
                                className="form-control"
                                disabled={true} >
                            </textarea>
                        </div>

                        <div className="mb-3">
                            <label htmlFor="pinCode" className="label-control">
                                Pincode
                            </label>
                            <input 
                                type="number" 
                                id="pinCode" 
                                onChange={ (e) => setPinCode(e.target.value) } 
                                value={pinCode} 
                                className="form-control"
                                disabled={true} />
                        </div>

                        <div className="mb-3">
                            <button
                                className="btn btn-outline-primary" 
                                id="updateAddressButton"
                                onClick={(e) => { updateAddress(e) }}>
                                    Update Address
                            </button>
                        </div>

                    </div>
                </div>
                <div className="col"></div>
            </div>


            <div className="mt-4">
                <button className="btn btn-outline-primary" id="prevButton" onClick={ () => {navigate("/customer/cart")}}>Previous</button>
                <button className="btn btn-primary float-right" id="nextButton" onClick={() => { navigate("/customer/payment") }}>Next</button>
            </div>
        </div>
    )
}

export default CustomerAddress;