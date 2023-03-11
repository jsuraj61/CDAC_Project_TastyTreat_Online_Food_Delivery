import axios from "axios";
import { useEffect, useState } from "react";
import { Link } from "react-router-dom"
import FoodItemHorizontal from "../../../Components/FoodItemHorizontal";
import { URL } from '../../../config'
import { useNavigate } from "react-router";

const CustomerCart = () => {

    const navigate = useNavigate();

    let foodItemArray = [];
    const [foodItems, setFoodItems] = useState([])
    
    let foodItemMap = new Map(JSON.parse(sessionStorage["foodItemMap"]));
    
    const [total, setTotal] = useState(0.00);

    const loadFoodItems = () => {
        const url = `${URL}/fooditems/cart`
        foodItemMap = new Map(JSON.parse(sessionStorage["foodItemMap"]));

        foodItemArray = [];
        foodItemMap.forEach(((value, key, map) => {
            foodItemArray.push(key);
        }))

        const body = {
            itemIds: [...foodItemArray]
        }

        axios.post(url, body).then(response => {
            const result = response.data;
            if(result.status === "SUCCESS") {
                const cart = result.data;
                sessionStorage["sessionCart"] = JSON.stringify(cart);
                setFoodItems(cart);
            }
        })
    }

    const addQtyBtn = (id) => {

        // get data from session
        const cart = JSON.parse(sessionStorage["sessionCart"]);
        foodItemMap = new Map(JSON.parse(sessionStorage["foodItemMap"]));

        // add quantity
        cart.forEach(food => {
            if(food.id === id) {
                foodItemMap.set(id, foodItemMap.get(id) + 1);
            }
        });

        sessionStorage["sessionCart"] = JSON.stringify(cart);
        sessionStorage["foodItemMap"] = JSON.stringify(Array.from(foodItemMap.entries()));
        setFoodItems(cart);

        // triggers
        // update total
        updateTotal();
    }

    const delQtyBtn = (id) => {
        let cart = JSON.parse(sessionStorage["sessionCart"]);
        let foodIdToDelete = undefined;

        foodItemMap = new Map(JSON.parse(sessionStorage["foodItemMap"])); // get map

        cart.forEach(food => {
            if(food.id === id) {
                // food.quantity = food.quantity - 1;
                foodItemMap.set(id, foodItemMap.get(id) - 1);
                if(foodItemMap.get(id) <= 0) { // if qty <= 0
                    foodIdToDelete = food.id; // store for later, to remove from cart
                    foodItemMap.delete(id); // remove from map
                }
            }
        });
        if(foodIdToDelete){ // remove from cart (if qty < 0, this value is set)
            cart = cart.filter(food => !(food.id===foodIdToDelete))
        }
        
        // save in session
        sessionStorage["foodItemMap"] = JSON.stringify(Array.from(foodItemMap.entries()));
        sessionStorage["sessionCart"] = JSON.stringify(cart);
        setFoodItems(cart); // update state of cart

        // triggers
        // update total
        updateTotal();
    }

    const updateTotal = () => {
        // reset count
        setTotal(0.0);

        // get items from session
        let cart = JSON.parse(sessionStorage["sessionCart"]);
        foodItemMap = new Map(JSON.parse(sessionStorage["foodItemMap"])); // get map

        // calculate total
        let tempTotal = 0.0;
        cart.forEach(foodItem => {
            tempTotal += foodItemMap.get(foodItem.id) * foodItem.price; // qty * price
        })

        // set total
        setTotal(tempTotal);
    }

    useEffect ( () => {
        loadFoodItems();
        setTimeout(updateTotal, 1000);
    }, [])

    return (

        <div>
            <h2>Cart</h2>
            {(sessionStorage["foodItemMap"] === null) || (sessionStorage["foodItemMap"] === undefined) || (sessionStorage["foodItemMap"] === "[]") ? 
                <div className="mt-4">
                    Your cart is empty. Add some food items to cart to continue. <br />
                    <Link to="/customer/home"><button className="btn btn-primary mt-3">Browse restaurants</button></Link>
                </div> :

                // FoodItemHorizontal container
                <div>
                    {
                    foodItems.map(foodItem => <FoodItemHorizontal
                        key={foodItem.id}
                        id={foodItem.id}
                        imagePath={foodItem.imagePath}
                        name={foodItem.name}
                        quantity={foodItemMap.get(foodItem.id)}
                        displayQuantityCounter={true}
                        price={foodItem.price}
                        displayEdit={false}
                        addQtyBtn={addQtyBtn}
                        delQtyBtn={delQtyBtn}
                    />
                    )}

                    <div className="row">
                        <div className="col">
                            <h5 className="mt-3">Total: {total}</h5>
                        </div>
                    </div>
                    <button className="btn btn-primary float-right" onClick={() => {navigate("/customer/address")}}>Next</button>
                </div>
            }
        </div>
    )
}
export default CustomerCart