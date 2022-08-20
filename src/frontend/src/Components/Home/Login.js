import React from "react";

export default function Login(){






    return(

        <div className="container">
        
           

            <form className ="myForm">
                <div className="container2">
                    <h1>Login</h1>
                
                
                
                    <label for="email"><b>Email</b></label>
                    <input type="text" placeholder="Enter Email" name="mail" id="mail" className="mail" />
                
                    <label for="psw"><b>Password</b></label>
                    <input type="password" placeholder="Enter Password" name="psw" id="psw" className="psw" />
                
            
                
                    <button type="button" className="loginbtn">Login</button>
                </div>
        
            
            </form>
        
        
        </div>
    )





}