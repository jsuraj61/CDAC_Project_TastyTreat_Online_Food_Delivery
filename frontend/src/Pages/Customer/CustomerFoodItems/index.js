import axios from "axios";
import { useEffect, useState } from "react";
import { useLocation } from "react-router"
import { Link } from "react-router-dom";
import { toast } from "react-toastify";
import FoodItemVertical from "../../../Components/FoodItemVertical";
import { URL } from '../../../config'
import './index.css'

const CustomerFoodItems = (props) => {
    const { state } = useLocation();
    const { restId, restName } = state ?? {};

    const [foodItems, setFoodItems] = useState([])

    const loadFoodItems = () => {
        const url = `${URL}/fooditems/restaurant/${restId}`
        axios.get(url).then(response => {
            const result = response.data;
            if(result.status === "SUCCESS") {
                setFoodItems(result.data)
            } else {
                toast.error(result.message);
            }
        })
    }

    const addToCart = (foodId, restaurantId) => {
        if(sessionStorage.getItem("foodItemMap") === null) {
            sessionStorage["foodItemMap"] = "[]";
        }

        // check if restaurant id is set
        if(sessionStorage.getItem("restaurantId") === null) {
            sessionStorage["restaurantId"] = `${restaurantId}`;
        } 
        // restaurant id is set

        // check restaurantId vs sessionStorage.getItem("restaurantId")
        // if same, means customer is ordering from same restaurant
        if(restaurantId === parseInt(sessionStorage["restaurantId"])) {
            // add to cart

            // gether map from sessionStorage
            let foodItemMap = new Map(JSON.parse(sessionStorage["foodItemMap"]))

            // check if quantity is assigned, if not, set it
            if(foodItemMap.get(foodId) !== undefined || foodItemMap.get(foodId) !== null) {
                foodItemMap.set(foodId, 1);
            }

            // toast
            toast.success("Added to cart")

            // stringify and store
            sessionStorage["foodItemMap"] = JSON.stringify(Array.from(foodItemMap.entries()));
        } else {
            // else, dont add to cart

            // toast
            toast.error("Can't add to cart. Please order from same restaurant.")
        }
        
        
    }

    useEffect (() => {
        if(state !== null)
            loadFoodItems();
    }, [])

    return (
        <div>
            {/* {state === null ? <div>State not defined</div> : <div>State defined {console.log(state)}</div>} */}
            {
                state !== null ?
                <div>
                    <h2 className="mt-3">Food Items from {restName}</h2>
                    <div className="food-items-container">
                        {foodItems.map(foodItem =>
                            <FoodItemVertical key={foodItem.id}
                                id={foodItem.id}
                                name={foodItem.name}
                                price={foodItem.price}
                                imagePath={foodItem.imagePath}
                                restaurantId={foodItem.restaurantId}
                                addToCart={addToCart}
                            />
                        )}
                    </div>
                </div>

                : <div>Something went wrong, please <Link to="/customer/signin">try Signing In again</Link></div>
            }
        </div>
    )
}

export default CustomerFoodItems