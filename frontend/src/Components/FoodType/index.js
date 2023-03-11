
const FoodType = (props) => {
    const{ foodType }=props

    return(

        <div>
            <div className="col"></div>
                <div className="col">
                    <div className="mb-2">
                        <label htmlFor="" className="label-control">
                                Food Type
                        </label>
                    </div>
                    <div>
                        <select className="form-select" aria-label="Default select example">
                                <option selected>Open this select menu</option>
                                <option value={foodType.id}>{foodType.name}</option>
                            
                        </select>
                            
                    </div>
                </div>
            <div className="col"></div>
        </div>
    )
}
export default FoodType