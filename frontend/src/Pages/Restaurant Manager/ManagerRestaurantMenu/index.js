import axios from "axios";
import { useEffect, useState } from "react";
import { useNavigate } from "react-router";
import { toast } from "react-toastify";
import FoodItemHorizontal from "../../../Components/FoodItemHorizontal";
import RestaurantManagerHeader from "../../../Components/RestaurantManagerHeader";
import { URL } from '../../../config'


const ManagerRestaurantMenu = () => {
    const restaurantName = sessionStorage['restaurantName'];
    const name = sessionStorage['name'];
    let restaurantId = sessionStorage["restaurantId"]
    const [foodItems, setFoodItems] = useState([])

    const navigate = useNavigate();

    const loadFoodItems = () => {
        const url = `${URL}/fooditem/restaurant/${restaurantId}`
        axios.get(url).then(response => {
            const result = response.data;
            if(result.status === "SUCCESS") {
                setFoodItems(result.data)
            } else {
                toast.error(result.message);
            }
        })
    }

    const editFoodItem = (foodItemId) => {
        // console.log(foodItemId);
        navigate("/manager/editfooditem", {
            state: {foodItemId}
        })
    }

    const addFoodItem = () => {
        navigate("/manager/addfooditem");
    }

    useEffect( () => {
        loadFoodItems();
    }, [])

    return (
        <div>
            <RestaurantManagerHeader 
                restaurantName ={restaurantName}
                name={name}
            />
            <div className="row mt-3">
                <h4 className="col">Restaurant Menu</h4>
                <h4 className="col text-right">
                    <button className="btn btn-primary" onClick={() => {addFoodItem()}}>
                        Add Item
                    </button>
                </h4>
            </div>
            

            {foodItems.map(item => 
                <FoodItemHorizontal
                    key={item.id}
                    id={item.id}
                    imagePath={item.imagePath}
                    name={item.name}
                    price={item.price}
                    editFoodItem={editFoodItem}
                    displayEdit={true}
                />
            )}
        </div>
    )
}

export default ManagerRestaurantMenu