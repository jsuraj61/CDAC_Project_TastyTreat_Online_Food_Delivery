import axios from "axios"
import { useEffect, useState } from "react"
import { toast } from "react-toastify"
import DpOrder from "../../../Components/DpOrder"
import { URL } from '../../../config'

const DeliveryPersonAllOrders = () => {
    const [orders, setOrders] = useState([])
    const deliveryPersonId = sessionStorage["id"]

    const loadOrders = () => {
        const url = `${URL}/orders/deliveryperson/${deliveryPersonId}`
        axios.get(url).then(response => {
            const result = response.data;
            if(result.status === "SUCCESS") {
                setOrders(result.data)
            } else {
                toast.error("Could not fetch orders")
            }
        })
    }

    useEffect( () => {
        loadOrders();
    }, [])

    return (
        <div>
            {
                orders.map(order => <DpOrder 
                    key={order.orderId}
                    orderId={order.orderId}
                    restaurantName={order.restaurantName}
                    restaurantAddress={order.restaurantAddress}
                    restaurantPinCode={order.restaurantPinCode}
                    customerName={order.customerName}
                    customerAddress={order.customerAddress}
                    customerPinCode={order.customerPinCode}
                />)
            }
        </div>
    )
}

export default DeliveryPersonAllOrders