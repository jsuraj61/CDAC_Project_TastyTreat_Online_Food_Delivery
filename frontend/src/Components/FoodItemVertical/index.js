import './index.css'

const FoodItemVertical = (props) => {
    return (
        <div className='food-item'>
            
            <img src={props.imagePath} className='food-item-image' alt={props.name}/>
            <div className='food-item-text food-item-name'>{props.name}</div>
            <div className='food-item-text'>Rs {props.price}</div>
            <button className='btn btn-primary mt-2 mb-4 food-item-button' onClick={()=> {props.addToCart(props.id, props.restaurantId)}}>Add To Cart</button>
        </div>
    )
}

export default FoodItemVertical;