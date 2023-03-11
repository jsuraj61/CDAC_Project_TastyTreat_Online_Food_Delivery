import axios from "axios";
import { useEffect, useState } from "react";
import { useNavigate } from 'react-router'
import { Link } from "react-router-dom";
import { toast } from "react-toastify";
import { URL } from '../../../config'
import RestaurantManagerOrder from "../../../Components/RestaurantManagerOrder";
import RestaurantManagerHeader from "../../../Components/RestaurantManagerHeader";

const ManagerHome = () => {
    const loginStatus = sessionStorage['loginStatus'];
    const restaurantId = sessionStorage['restaurantId'];
    const restaurantName = sessionStorage['restaurantName'];
    const name = sessionStorage['name'];
    const [orders, setorders] = useState([]);

    const navigate = useNavigate();

    const assignDeliveryPerson = (orderId) => {
        navigate("/manager/assigndelivery", {
            state: { orderId: orderId }
        })
    }

    const loadOrders = () => {
        const url = `${URL}/restaurantmanager/arrivedorders/${restaurantId}`
        axios.post(url).then((response) => {
            const result = response.data;
            if(result.status === "SUCCESS") {
                setorders(result.data);
            } else {
                toast.error(result.message);
            }
        })
    }

    useEffect (() => {
        loadOrders();
    }, [])

    return (
        loginStatus === '1' ? 
        <div>
            <RestaurantManagerHeader 
                restaurantName ={restaurantName}
                name={name}
            />

            <div>
                {orders && orders.map(order =>
                    <RestaurantManagerOrder 
                        key={order.orderId}
                        orderId={order.orderId}
                        foodItems={order.foodItems}
                        customer={order.customer}
                        restaurant={order.restaurant}
                        status={order.status}
                        deliveryPerson={order.deliveryPerson}
                        assignDeliveryPerson={assignDeliveryPerson}
                        displayAssignedTo={false}
                        displayAssignButton={true}
                    />
                )}
            </div>
        </div>
        
        :  <div>You have not Signed In. Please <Link to="/manager/signin">Sign In here</Link></div>
        
    )
}

export default ManagerHome