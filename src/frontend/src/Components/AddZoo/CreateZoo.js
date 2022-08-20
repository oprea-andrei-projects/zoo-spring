import React, { useEffect, useState } from "react";
import Api from "../../Api";

export default function CreateZoo(){


    let [country, setCountry] = useState('');
    let [address, setAddress] = useState('');
    let [mail, setMail] = useState('');
    let [password, setPassword] = useState('');
    let [animalList, setAnimalList] = useState([]);


    useEffect(()=>{



    },[country,address,mail,password])


    let handleChange = (e)=>{

        let obj = e.target;

        if(obj.classList.contains('ad')){

            setAddress(obj.value);

            console.log(address);
        }

        if(obj.classList.contains('co')){

            setCountry(obj.value);
            console.log(country);
        }

        if(obj.classList.contains('email')){

            setMail(obj.value);
            console.log(mail);
        }

        if(obj.classList.contains('psw')){

            setPassword(obj.value);
            console.log(password);
        }

    }

    // !!! trebuie pusa conditia pt repeat-password !!!

    let handleRegistration = async ()=>{


        let zoo ={

            country,
            address,
            mail,
            password
        }

        let api = new Api();

        let x =  await api.addAzoo(zoo);

    }


    return(


        <div className="container">

            <form className="myForm" onChange={handleChange}>
                
                    <h1>Register</h1>
                    <p>Please fill in this form to create an account.</p>
                


                    <label for="Address"><b>Address</b></label>
                    <input type="text" placeholder="Address" name="ad" id="ad" className="ad" />

                    <label for="Country"><b>Country</b></label>
                    <input type="text" placeholder="Country" name="co" id="co" className="co" />
                
                    <label for="email"><b>Email</b></label>
                    <input type="text" placeholder="Enter Email" name="email" id="email" className="email" />
                
                    <label for="psw"><b>Password</b></label>
                    <input type="password" placeholder="Enter Password" name="psw" id="psw" className="psw" />
                
                    <label for="psw-repeat"><b>Repeat Password</b></label>
                    <input type="password" placeholder="Repeat Password" name="psw-repeat" id="psw-repeat" className="psw-repeat" />
                    
            
                
                    <button type="submit" className="registerbtn" onClick={handleRegistration}>Register</button>
               
        
                <div className="signin">
                    <p>Already have an account? <a href="#" className = "linkage">Sign in</a>.</p>
                </div>

            </form>
        
        </div>
    )

}