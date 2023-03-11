import './index.css'

const DpOrder = (props) => {
    return (
        <div className="mt-3 dp-order-container">
            <h3>Order No {props.orderId}</h3>
            <div className="row mt-3">
                <div className="col-sm-12 col-md-6">
                    Pickup From : <br />
                    <span className="font-weight-bold">{props.restaurantName}</span> <br />
                    {props.restaurantAddress} <br />
                    {props.restaurantPinCode}
                </div>
                <div className="col-sm-12 col-md-6">
                    Deliver To : <br />
                    <span className="font-weight-bold">{props.customerName}</span> <br />
                    {props.customerAddress} <br />
                    {props.customerPinCode} <br />
                </div>
                { props.markPickupComplete &&
                    <button className="btn btn-primary ml-3 mt-3" onClick={ () => props.markPickupComplete(props.orderId) }>Mark Pickup Complete</button>
                }
                { props.markDeliveryComplete &&
                    <button className="btn btn-primary ml-3 mt-3" onClick={ () => props.markDeliveryComplete(props.orderId) }>Mark Delivery Complete</button>
                }
            </div>
        </div>

    )
}

export default DpOrder