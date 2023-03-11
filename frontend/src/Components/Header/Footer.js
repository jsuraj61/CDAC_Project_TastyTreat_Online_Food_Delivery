import React from "react"
import "./index.css";
const Footer=()=>{
const current= new Date;
const year= `${current.getFullYear()}`;
  return(
    <div className="footer"> 
    <h4 style={{color:"whitesmoke"}}>Copyright@Tasty-Treat : {year}</h4>
    </div>
)
}
export default Footer;