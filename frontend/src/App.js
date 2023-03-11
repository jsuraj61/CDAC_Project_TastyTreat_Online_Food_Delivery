import { ToastContainer } from 'react-toastify';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import 'react-toastify/dist/ReactToastify.css'

import Header from './Components/Header';
import Home from './Pages/Home'
import CustomerSignIn from './Pages/Customer/CustomerSignIn'

import './App.css';
import CustomerHome from './Pages/Customer/CustomerHome';
import CustomerCart from './Pages/Customer/CustomerCart';
import CustomerFoodItems from './Pages/Customer/CustomerFoodItems';
import CustomerAddress from './Pages/Customer/CustomerAddress';
import CustomerPayment from './Pages/Customer/CustomerPayment';
import CustomerOrders from './Pages/Customer/CustomerOrders';
import CustomerSignUp from './Pages/Customer/CustomerSignUp';
import ManagerSignIn from './Pages/Restaurant Manager/ManagerSignIn';
import ManagerHome from './Pages/Restaurant Manager/ManagerHome';
import ManagerSignUp from './Pages/Restaurant Manager/ManagerSignUp';

import DeliveryPersonSignIn from './Pages/DeliveryPerson/DpSignin';
import DeliveryPersonHome from './Pages/DeliveryPerson/DpHome';
import DeliveryPersonSignUp from './Pages/DeliveryPerson/DpSignUp';


import TestPage from './Pages/TestPage';
import ManagerAssignDelivery from './Pages/Restaurant Manager/AssignDelivery';
import ManagerAllOrders from './Pages/Restaurant Manager/ManagerAllOrders';
import ManagerRestaurantMenu from './Pages/Restaurant Manager/ManagerRestaurantMenu';
import ManagerEditFoodItem from './Pages/Restaurant Manager/ManagerEditFoodItem';
import ManagerAddFoodItem from './Pages/Restaurant Manager/ManagerAddFoodItem';
import DeliveryPersonAllOrders from './Pages/DeliveryPerson/DpAllOrders';
import Footer from './Components/Header/Footer';

function App() {
  return (
    <BrowserRouter>
      <div>
        <Header />
        <div className="container">
            <Routes>
            
              <Route path="/" element={<Home />} />
              <Route path="/customer/signin" element={<CustomerSignIn />} />
              <Route path="/customer/home" element={<CustomerHome />} />
              <Route path="/customer/fooditems" element={<CustomerFoodItems />} />
              <Route path="/customer/cart" element={<CustomerCart />} />
              <Route path="/customer/address" element={<CustomerAddress />} />
              <Route path="/customer/payment" element={<CustomerPayment />} />
              <Route path="/customer/orders" element={<CustomerOrders />} />
              <Route path="customer/signup" element={<CustomerSignUp />} />

              <Route path="/manager/signin" element={<ManagerSignIn />} />
              <Route path="/manager/signup" element={<ManagerSignUp/>}/>
              <Route path="/manager/home" element={<ManagerHome />} />
              <Route path="/manager/assigndelivery" element={<ManagerAssignDelivery />} />
              <Route path="/manager/allorders" element={<ManagerAllOrders />} />
              <Route path="/manager/restaurantmenu" element={<ManagerRestaurantMenu />} />
              <Route path="/manager/editfooditem" element={<ManagerEditFoodItem />} />
              <Route path="/manager/addfooditem" element={<ManagerAddFoodItem />} />

              <Route path="/dp/signin" element={<DeliveryPersonSignIn />} />
              <Route path="/deliveryperson/signup" element={<DeliveryPersonSignUp/>}/>
              <Route path="/dp/home" element={<DeliveryPersonHome />} />
              <Route path="/dp/allorders" element={<DeliveryPersonAllOrders />} />
              
              <Route path="/testpage" element={<TestPage />} />
            </Routes>  
          <ToastContainer theme='colored' />
        </div>
        <Footer />
      </div>
    </BrowserRouter>
  );
}

export default App;
