
const RestaurantManagerHeader = (props) => {
    return (
        <div className="row mt-4">
            <div className="col-sm-12 col-md-8 d-flex align-items-center">
                <h2 className="font-weight-bold">{props.restaurantName}</h2>
            </div>
            <div className="col-sm-12 col-md-4">
                <h5>Welcome, <span className="font-weight-bold">{props.name}</span></h5>
                <h6>Manager</h6>
            </div>
        </div>
    )
}

export default RestaurantManagerHeader