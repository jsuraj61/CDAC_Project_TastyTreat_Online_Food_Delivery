import axios from "axios";
import { useEffect, useState } from "react"
import { useNavigate } from "react-router";
import { toast } from "react-toastify";
import DpOrder from "../../../Components/DpOrder"
import { URL } from '../../../config'

const DeliveryPersonHome = () => {

    const navigate = useNavigate();

    const [pickUpOrders, setPickUpOrders] = useState([]);
    const [deliverOrders, setDeliverOrders] = useState([]);

    const deliveryPersonId = sessionStorage["id"];

    const ofdStatus = "out for delivery";
    const pickedUpStatus = "picked up";
    const deliveredStatus = "delivered"

    const markPickupComplete = (orderId) => {
        // console.log("Mark pickup complete for " + orderId)
        const url = `${URL}/deliveryperson/${orderId}/${pickedUpStatus}`
        axios.post(url).then(response => {
            const result = response.data;
            if(result.status === "SUCCESS") {
                toast.success("Delivery status changed")
            } else {
                toast.error(result.message)
            }
        })
        setTimeout(loadPickUpOrders, 100);
        setTimeout(loadDeliveryOrders, 100);
        // navigate("/dp/home");
    }

    const markDeliveryComplete = (orderId) => {
        // console.log("Mark delivery complete for " + orderId)
        const url = `${URL}/deliveryperson/${orderId}/${deliveredStatus}`
        axios.post(url).then(response => {
            const result = response.data;
            if(result.status === "SUCCESS") {
                toast.success("Delivery status changed")
            } else {
                toast.error(result.message)
            }
        })
        setTimeout(loadPickUpOrders, 100);
        setTimeout(loadDeliveryOrders, 100);
        // navigate("/dp/home");
    }

    const loadPickUpOrders = () => {
        const url = `${URL}/deliveryperson/${deliveryPersonId}/status/${ofdStatus}`
        axios.get(url).then(response => {
            const result = response.data;
            if(result.status === "SUCCESS") {
                setPickUpOrders(result.data);
            }
        })
    }

    const loadDeliveryOrders = () => {
        const url = `${URL}/deliveryperson/${deliveryPersonId}/status/${pickedUpStatus}`
        axios.get(url).then(response => {
            const result = response.data;
            if(result.status === "SUCCESS") {
                setDeliverOrders(result.data);
            } 
        })
    }

    useEffect ( () => {
        loadPickUpOrders();
        loadDeliveryOrders();
    }, [])

    return (
        <div>
            <h3>Orders ready for pickup</h3>

            {
                pickUpOrders.map(order => <DpOrder 
                    key={order.orderId}
                    orderId={order.orderId}
                    restaurantName={order.restaurantName}
                    restaurantAddress={order.restaurantAddress}
                    restaurantPinCode={order.restaurantPinCode}
                    customerName={order.customerName}
                    customerAddress={order.customerAddress}
                    customerPinCode={order.customerPinCode}
                    markPickupComplete={markPickupComplete}
                />)
            }


            <h3 className="mt-3">Orders ready for delivery</h3>

            {
                deliverOrders.map(order => <DpOrder 
                    key={order.orderId}
                    orderId={order.orderId}
                    restaurantName={order.restaurantName}
                    restaurantAddress={order.restaurantAddress}
                    restaurantPinCode={order.restaurantPinCode}
                    customerName={order.customerName}
                    customerAddress={order.customerAddress}
                    customerPinCode={order.customerPinCode}
                    markDeliveryComplete={markDeliveryComplete}
                />)
            }
        </div>
        
    ) 
}

export default DeliveryPersonHome