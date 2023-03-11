import FoodItemHorizontal from "../FoodItemHorizontal";
import './index.css'

const RestaurantManagerOrder = (props) => {
    const foodItems = props.foodItems;
    let total = 0;
    props.foodItems.forEach(item => {
        total += item.foodPrice;
    })


    return (
        <div className="restaurant-manager-order-container">
            <h4>Order No: {props.orderId}</h4>
            {foodItems.map(foodItem => 
                <FoodItemHorizontal 
                    key={foodItem.foodItemId}
                    imagePath={foodItem.foodItemUrl}
                    name={foodItem.foodName}
                    quantity={foodItem.foodQuantity}
                    displayQuantityCounter={false}
                    price={foodItem.foodPrice}
                    displayEdit={false}
                />
            )}

            <div className="mt-3"><span className="restaurant-manager-order-text-header">Order Total:</span> Rs {total}</div>

            <div className="mt-3 row">
                <div className="col-md-6">
                    <span className="restaurant-manager-order-text-header">Deliver To</span> <br />
                    {props.customer.name} <br />
                    {props.customer.addressText}
                </div>
                { (props.displayAssignedTo && props.deliveryPerson) &&
                    <div className="col-md-6">
                        <span className="restaurant-manager-order-text-header">Assigned To</span> <br />
                        {props.deliveryPerson.name} <br /> 
                        {(props.displayStatus && props.status) &&
                            <div className="text-capitalize">Order Status: {props.status}</div>
                        }
                    </div>
                }
                
            </div>
            { props.displayAssignButton && 
                <button className="btn btn-primary mt-3"
                    onClick={() => {
                                if(props.assignDeliveryPerson)
                                props.assignDeliveryPerson(props.orderId)
                            }
                        }
                    >Assign Delivery
                </button>
            }
            
        </div>
    )
}

export default RestaurantManagerOrder