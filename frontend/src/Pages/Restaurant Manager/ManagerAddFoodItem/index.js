import axios from "axios";
import { useEffect, useState } from "react";
import { useNavigate } from "react-router";
import { toast } from "react-toastify";
import RestaurantManagerHeader from "../../../Components/RestaurantManagerHeader";
import { URL } from '../../../config'

const ManagerAddFoodItem = () => {
    const restaurantName = sessionStorage['restaurantName'];
    const name = sessionStorage['name'];

    const restaurantId = sessionStorage["restaurantId"];
    const [foodName, setFoodName] = useState("");
    const [foodTypes, setFoodTypes] = useState([]);
    const [foodTypeId, setFoodTypeId] = useState(0);
    const [price, setPrice] = useState(0.00);
    const [imagePath, setImagePath] = useState("");
    const [isVegetarian, setIsVegetarian] = useState(false); 

    const navigate = useNavigate();

    const addFoodItem = () => {
        const url = `${URL}/restaurantmanager/addfooditem`
        const body = {
            foodTypeId: foodTypeId,
            restaurantId: restaurantId,
            name: foodName,
            price: price,
            imagePath: imagePath,
            vegetarian: isVegetarian
        }

        // console.log(body);
        axios.post(url, body).then(response => {
            const result = response.data;
            if(result.status === "SUCCESS") {
                toast.success("Food item edited successfully");
                navigate("/manager/restaurantmenu");
            } else {
                toast.error(result.message);
            }
        })
    }

    const getFoodTypes = () => {
        //setFoodTypes
        const url = `${URL}/foodtypes`
        axios.get(url).then(response => {
            const result = response.data;
            if(result.status === "SUCCESS") {
                setFoodTypes(result.data)
            } else {
                toast.error("There was an error processing your request")
            }
        })
    }

    useEffect ( () => {
        getFoodTypes();
    }, [])

    return (
        <div>
            <RestaurantManagerHeader 
                restaurantName ={restaurantName}
                name={name}
            />

            <h3>Add Food Item</h3>

            <div className="row">
                <div className="col"></div>
                <div className="col">
                    <div className="form">

                        {/* name */}
                        <div className="mb-3">
                            <label htmlFor="foodName" className="label-control">
                                Item Name
                            </label>
                            <input type="text" onChange={ (e) => setFoodName(e.target.value) } value={foodName} className="form-control" />
                        </div>

                        {/* food type */}
                        <div className="mb-3">
                            <label htmlFor="foodTypeId" className="label-control">
                                Food Type
                            </label>

                            <select className="form-select form-control"
                                onChange={ (e) => setFoodTypeId(e.target.value) }
                                value={foodTypeId}
                                >
                                <option defaultValue={true}>
                                        -- Select an option --
                                </option>
                                {
                                    foodTypes.map(foodType => 
                                        <option value={foodType.id} key={foodType.id}>
                                            {foodType.name}
                                        </option>
                                    )
                                }
                            </select>

                        </div>

                        {/* price */}
                        <div className="mb-3">
                            <label htmlFor="price" className="label-control">
                                Price
                            </label>
                            <input type="text" onChange={ (e) => setPrice(e.target.value) } value={price} className="form-control" />
                        </div>

                        {/* image url */}
                        <div className="mb-3">
                            <label htmlFor="imagePath" className="label-control">
                                Image URL
                            </label>
                            <input type="text" onChange={ (e) => setImagePath(e.target.value) } value={imagePath}  className="form-control"/>
                        </div>

                        {/* is Vegetarian */}
                        <div className="mb-3">
                            <label htmlFor="isVegetarian" className="label-control">
                                Is Vegetarian
                            </label>
                            <input
                                type="checkbox"
                                onChange={ (e) => setIsVegetarian(e.target.checked) }
                                value={isVegetarian}
                                className="form-control"
                                checked={isVegetarian}
                            />
                        </div>

                        {/* button */}
                        <div className="d-flex justify-content-between">
                            <div className="mb-3">
                               <button className="btn btn-outline-primary" onClick={() => {navigate("/manager/restaurantmenu")}}>Cancel</button>
                            </div>
                            <div className="mb-3 float-right">
                               <button className="btn btn-primary" onClick={() => {addFoodItem()}}>Add Item</button>
                            </div>
                        </div>

                        
                    </div>
                </div>
                <div className="col"></div>
            </div>
        </div>
    )
}

export default ManagerAddFoodItem