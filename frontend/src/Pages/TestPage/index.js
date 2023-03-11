import './index.css'
import FoodItemVertical from "../../Components/FoodItemVertical"
import FoodItemHorizontal from "../../Components/FoodItemHorizontal"
import RestaurantManagerOrder from '../../Components/RestaurantManagerOrder'
import { useEffect, useState } from 'react'
import axios from 'axios'
import { toast } from 'react-toastify'

const TestPage = () => {

    const url = "http://localhost:8084/api/v1/restaurantmanager/arrivedorders/2";
    const [arrivedOrders, setArrivedOrders] = useState([])

    const assignDeliveryPerson = (orderId) => {
        console.log("Order No: " + orderId + " is to be assigned")
    }

    const loadArrivedOrders = () => {
        axios.post(url).then(response => {
            const result = response.data;
            if(result.status === "SUCCESS") {
                setArrivedOrders(result.data)
                // console.log(arrivedOrders);
            } else {
                toast.error(result.message);
            }
        })
    }

    useEffect(() => {
        loadArrivedOrders();
    }, [])

    return (

        // <div className="food-items-container">
        //     <FoodItemVertical 
        //         name="Food Name"
        //         price="150"
        //         imagePath="https://images.unsplash.com/photo-1546069901-ba9599a7e63c"
        //     />
        //     <FoodItemVertical 
        //         name="Food Name"
        //         price="150"
        //         imagePath="https://images.unsplash.com/photo-1546069901-ba9599a7e63c"
        //     />
        //     <FoodItemVertical 
        //         name="Food Name"
        //         price="150"
        //         imagePath="https://images.unsplash.com/photo-1546069901-ba9599a7e63c"
        //     />
        //     <FoodItemVertical 
        //         name="Food Name"
        //         price="150"
        //         imagePath="https://images.unsplash.com/photo-1546069901-ba9599a7e63c"
        //     />
        //     <FoodItemVertical 
        //         name="Food Name"
        //         price="150"
        //         imagePath="https://images.unsplash.com/photo-1546069901-ba9599a7e63c"
        //     />
            

        //     <div>
        //         <FoodItemHorizontal
        //             imagePath="https://images.unsplash.com/photo-1546069901-ba9599a7e63c"
        //             name="Paneer Pizza"
        //             quantity="2"
        //             displayQuantityCounter={true}
        //             price="120"
        //             displayEdit={true}
        //         />

        //         <FoodItemHorizontal
        //             imagePath="https://images.unsplash.com/photo-1546069901-ba9599a7e63c"
        //             name="Paneer Pizza"
        //             quantity="2"
        //             displayQuantityCounter={true}
        //             price="120"
        //             displayEdit={true}
        //         />

        //         <FoodItemHorizontal
        //             imagePath="https://images.unsplash.com/photo-1546069901-ba9599a7e63c"
        //             name="Paneer Pizza"
        //             quantity="2"
        //             displayQuantityCounter={true}
        //             price="120"
        //             displayEdit={true}
        //         />
        //     </div>

        // </div>

        <div>
            {arrivedOrders.map(order => <RestaurantManagerOrder 
                key={order.orderId}
                orderId={order.orderId}
                foodItems={order.foodItems}
                customer={order.customer}
                restaurant={order.restaurant}
                status={order.status}
                assignDeliveryPerson={assignDeliveryPerson}
            />)}
        </div>
    )

}

export default TestPage