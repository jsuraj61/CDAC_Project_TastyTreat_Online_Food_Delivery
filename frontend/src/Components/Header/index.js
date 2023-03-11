import { useNavigate } from 'react-router';
import './index.css'
import logo from './logo.png'
import { Link } from 'react-router-dom'
import { Container } from 'react-bootstrap';
import CustomerSignUp from '../../Pages/Customer/CustomerSignUp';


const Header = () => {

    const navigate = useNavigate()

    const logout = () => {
        sessionStorage.clear()
        navigate("/")
    }

    return (
        // d-flex flex-column flex-md-row align-items-center p-3 px-md-4 py-md-4 mb-3 bg-white border-bottom shadow-sm
        <Container>
        <div className="d-flex flex-md-row align-items-center p-2 px-md-4 mb-3 bg-red border-bottom shadow-sm">
            <div className="logo-container">
                <img className="logo" src={logo} alt="logo" />
            </div>
            
            <nav class="navbar navbar-danger " >
                
                <div class="container-fluid">
                <Link class="navbar-brand" to="/" className="title">Tasty-Treat</Link>  
                </div> 

                             
            </nav>
    

            
            
            {(sessionStorage["personType"] === "customer" && sessionStorage["loginStatus"] === "1") ?
                <div className='d-flex align-items-center flex-md-row'>
                    <nav className="my-5 my-md-3 mr-md-3" >
                        <Link className="p-2 text-dark" to="/customer/home" >Home</Link>
                        <Link className="p-2 text-dark" to="/customer/orders">All Orders</Link>
                        <Link className="p-2 text-dark" to="/customer/cart">Cart</Link>
                        {/* <Link className="p-2 text-dark" to="/customer/home">Hello {name}</Link> */}
                    </nav>
                    <a className="btn btn-outline-primary" href="#" onClick={() => logout()}>Log Out</a>
                </div>
                : <div></div>
            }
            {(sessionStorage["personType"] === "manager" && sessionStorage["loginStatus"] === "1") ?
                <div className='d-flex align-items-center'>
                    <nav className="my-2 my-md-0 mr-md-3">
                        <Link className="p-2 text-dark" to="/manager/home">Home</Link>
                        <Link className="p-2 text-dark" to="/manager/restaurantmenu">Restaurant Menu</Link>
                        <Link className="p-2 text-dark" to="/manager/allorders">All Orders</Link>
                    </nav>
                    <a className="btn btn-outline-primary" href="#" onClick={() => logout()}>Log Out</a>
                </div>
                : <div></div>
            }
            {(sessionStorage["personType"] === "deliveryPerson" && sessionStorage["loginStatus"] === "1") ?
                <div className='d-flex align-items-center'>
                    <nav className="my-2 my-md-0 mr-md-3">
                        <Link className="p-2 text-dark" to="/dp/home">Home</Link>
                        <Link className="p-2 text-dark" to="/dp/allorders">All Orders</Link>
                    </nav>
                    <a className="btn btn-outline-primary" href="#" onClick={() => logout()}>Log Out</a>
                </div>
                : <div></div>
            }
        </div>
        </Container>
    )
}

export default Header