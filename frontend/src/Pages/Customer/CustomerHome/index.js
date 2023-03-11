import axios from "axios";
import { useEffect, useState } from "react";
import { useNavigate } from 'react-router'
import { Link } from "react-router-dom";
import { toast } from "react-toastify";
import { URL } from '../../../config'

const CustomerHome = () => {
    const loginStatus = sessionStorage['loginStatus'];
    const [restaurants, setRestaurants] = useState([]);

    const navigate = useNavigate();

    const loadRestaurants = () => {
        const url = `${URL}/restaurants`
        axios.get(url).then((response) => {
            const result = response.data;
            if(result.status === "SUCCESS") {
                setRestaurants(result.data);
            } else {
                toast.error(result.message);
            }
        })
    }

    useEffect (() => {
        loadRestaurants();
    }, [])

    return (
        loginStatus === '1' ? 
        <div>
            <table className="table">
                <thead>
                    <tr>
                        <th>Restaurant</th>
                        <th>Food Items</th>
                    </tr>
                </thead>
                <tbody>
                    {restaurants.map(rest =>
                            <tr key={rest.id}>
                                <td>{rest.name}</td>
                                <td>
                                    <button
                                        className="btn btn-primary"
                                        onClick={ () => navigate("/customer/fooditems", { state : {
                                            restId: rest.id,
                                            restName: rest.name}  }) }
                                        >
                                            View Food Items
                                    </button>
                                </td>
                            </tr>
                    )}
                </tbody>
            </table>
        </div>
        
        :  <div>You have not Signed In. Please <Link to="/customer/signin">Sign In here</Link></div>
        
    )
}

export default CustomerHome