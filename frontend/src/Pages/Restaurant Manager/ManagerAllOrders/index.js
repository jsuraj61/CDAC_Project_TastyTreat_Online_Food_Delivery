import axios from "axios";
import { useEffect, useState } from "react";
import { toast } from "react-toastify";
import RestaurantManagerHeader from "../../../Components/RestaurantManagerHeader";
import RestaurantManagerOrder from "../../../Components/RestaurantManagerOrder";
import { URL } from '../../../config'

const ManagerAllOrders = () => {
    const restaurantName = sessionStorage['restaurantName'];
    const name = sessionStorage['name'];
    const restaurantId = sessionStorage["restaurantId"]

    const [orders, setOrders] = useState([]);

    const loadAllOrders = () => {
        const url = `${URL}/restaurantmanager/allorders/${restaurantId}`
        axios.post(url).then(response => {
            const result = response.data;
            if(result.status === "SUCCESS") {
                setOrders(result.data)
            } else {
                toast.error(result.message)
            }
        })
    }

    useEffect( () => {
        loadAllOrders();
    }, [])


    return (
        <div>
            <RestaurantManagerHeader 
                restaurantName ={restaurantName}
                name={name}
            />

            {orders.map(order =>
                <RestaurantManagerOrder 
                    key={order.orderId}
                    orderId={order.orderId}
                    foodItems={order.foodItems}
                    customer={order.customer}
                    restaurant={order.restaurant}
                    status={order.status}
                    deliveryPerson={order.deliveryPerson}
                    displayAssignedTo={true}
                    displayAssignButton={false}
                    displayStatus={true}
                />
            )}
        </div>
    )
}

export default ManagerAllOrders