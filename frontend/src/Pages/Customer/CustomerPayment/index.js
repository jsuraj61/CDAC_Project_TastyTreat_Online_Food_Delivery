import axios from "axios";
import { useState } from "react"
import { useNavigate } from "react-router";
import { toast } from "react-toastify";
import { URL } from '../../../config'

const CustomerPayment = () => {

    const [cardNumber, setCardNumber] = useState("");
    const [expiry, setExpiry] = useState("");
    const [nameOnTheCard, setNameOnTheCard] = useState("");
    const [cvv, setCvv] = useState(0);

    const navigate = useNavigate();

    const validateCard = () => {
        if(cardNumber.length === 0 || expiry.length === 0 || nameOnTheCard.length === 0 || cvv === 0) {
            return false;
        }
        return true;
    }

    const processFoodItemsArray = (sessionCart, foodItemMap) => {
        let foodItemsInOrder = [];
        sessionCart.forEach( item => {
            let foodItem = {};
            foodItem.foodItemId = item.id;
            foodItem.foodName = item.name;
            foodItem.foodPrice = item.price;
            foodItem.foodQuantity = foodItemMap.get(item.id);
            foodItemsInOrder.push(foodItem);
        })
        return foodItemsInOrder;
    }

    const placeOrder = () => {
        if(validateCard()) {
            let sessionCart = JSON.parse(sessionStorage["sessionCart"]);
            let foodItemMap = new Map(JSON.parse(sessionStorage["foodItemMap"]));

            const url = `${URL}/orders/place`
            // process foodItemsInOrderArray
            let foodItemsInOrder = processFoodItemsArray(sessionCart, foodItemMap);
            // get restaurantId, customerId
            let restaurantId = sessionStorage["restaurantId"];
            let customerId = sessionStorage["id"];

            // place all of them in body
            const body = {
                foodItemsInOrder,
                restaurantId,
                customerId
            }
            axios.post(url, body).then(response => {
                const result = response.data;
                if(result.status === "SUCCESS") {
                    // toast
                    toast.success("Order successfully placed. Order Id: " + result.data.orderId)

                    // clear order details in sessionStorage
                    // sessionStorage.removeItem("foodItemMap")
                    // sessionStorage.removeItem("sessionCart")
                    
                    sessionStorage["foodItemMap"] = "[]";
                    sessionStorage["sessionCart"] = "[]";
                    // sessionStorage["restaurantId"] = "-1";

                    sessionStorage.removeItem("restaurantId")

                    // navigate to all orders
                    navigate("/customer/orders");

                } else {
                    toast.error("Couldn't place order");
                }

            })


        } else {
            toast.error("Please enter all details")
        }
    }

    return (
        <div>
            <h2 className="title">Payment</h2>

            <div className="row">
                <div className="col"></div>
                <div className="col">
                    <div className="form">

                        {/* CardNumber */}
                        <div className="mb-3">
                            <label htmlFor="cardNumber" className="label-control">
                                Card Number
                            </label>
                            <input
                                type="text" 
                                onChange={ (e) => setCardNumber(e.target.value) } 
                                value={cardNumber} className="form-control" 
                                id="cardNumber"
                            />
                        </div>

                        {/* Expiry */}
                        <div className="mb-3">
                            <label htmlFor="expiry" className="label-control">
                                Expiry
                            </label>
                            <input
                                type="text" 
                                onChange={ (e) => setExpiry(e.target.value) } 
                                value={expiry} className="form-control" 
                                id="expiry"
                            />
                        </div>

                        {/* Name on the card */}
                        <div className="mb-3">
                            <label htmlFor="nameOnTheCard" className="label-control">
                                Name On The Card
                            </label>
                            <input
                                type="text" 
                                onChange={ (e) => setNameOnTheCard(e.target.value) } 
                                value={nameOnTheCard} className="form-control" 
                                id="nameOnTheCard"
                            />
                        </div>

                        {/* CVV */}
                        <div className="mb-3">
                            <label htmlFor="cvv" className="label-control">
                                CVV
                            </label>
                            <input
                                type="text" 
                                onChange={ (e) => setCvv(e.target.value) } 
                                value={cvv} className="form-control" 
                                id="cvv"
                            />
                        </div>

                        
                    </div>
                        
                </div>
                <div className="col"></div>
            </div>

            {/* Buttons */}
            <div className="mb-3">
                <button 
                    className="btn btn-outline-primary" 
                    onClick={() => { navigate("/customer/address") }}
                >
                        Previous
                </button>
                <button 
                    className="btn btn-primary float-right" 
                    onClick={() => { placeOrder() }}
                >
                        Place Order
                </button>
            </div>
        </div>
    )
}

export default CustomerPayment