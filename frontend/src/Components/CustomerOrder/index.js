import FoodItemHorizontal from "../FoodItemHorizontal";
import './index.css'

const CustomerOrder = (props) => {
    let total = 0;
    props.foodItems.forEach(item => {
        total += item.foodPrice;
    })


    return (
        <div className="customer-order-container">
            <h3>Order No: {props.orderId}</h3>
            {
                props.foodItems.map(foodItem => 
                    <FoodItemHorizontal 
                        key={foodItem.foodItemId}
                        imagePath={foodItem.foodItemUrl}
                        name={foodItem.foodName}
                        quantity={foodItem.foodQuantity}
                        displayQuantityCounter={false}
                        price={foodItem.foodPrice}
                        displayEdit={false}
                    />
                )
            }
            <div className="row">
                <div className="col mt-3">
                    <h4>Restaurant Details</h4>
                    <span className="small-bold-title">{props.restaurant.name}</span> <br />
                    <div>{props.restaurant.adressText}</div>
                    <div>{props.restaurant.pinCode}</div>
                </div>
                <div className="col mt-3">
                    <h4>Order Status</h4>
                    <span className="small-bold-title text-capitalize">{props.status}</span>
                    <div>Order total: Rs {total}</div>
                </div>
            </div>
        </div>
    )
}

export default CustomerOrder