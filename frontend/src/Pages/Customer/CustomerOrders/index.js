import axios from 'axios';
import { useEffect, useState } from 'react';
import { toast } from 'react-toastify';
import CustomerOrder from '../../../Components/CustomerOrder';
import { URL } from '../../../config'


const CustomerOrders = () => {

    const customerId = sessionStorage["id"];
    const [orders, setOrders] = useState([])


    const loadCustomerOrders = () => {
        const url = `${URL}/orders/customer/${customerId}`;
        axios.get(url).then(response => {
            const result = response.data;
            if(result.status === "SUCCESS") {
                setOrders(result.data)
            } else {
                toast.error(result.message)
            }
        })    
    
    }

    useEffect ( () => {
        loadCustomerOrders();
    }, [])
    
    return (
        <div className='mb-4'>
            <h2>Your Orders</h2>
            {orders.map(order => 
                <CustomerOrder
                    key={order.orderId}
                    orderId={order.orderId}
                    foodItems={order.foodItems}
                    restaurant={order.restaurant}
                    status={order.status}
                />
            )}
        </div>
    )
    
}

export default CustomerOrders
