import React ,{useState}from "react";
import Api from "../../Api";


export default function UpdateZoo(){


    let [id, setId] = useState(16);
    let [country, setCountry] = useState("sdsdsdsdsd");
    let [address, setAddress] = useState('sdsdsdsd');
    let [mail, setMail] = useState('sdsdsdsdsd');
    let [password, setPassword] = useState('sdsdsdsd');


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

    let handleUpdate = async ()=>{


        let zoo = {

            
            country,
            address,
            mail,
            password

        }

        let api = new Api();

        console.log('inainte');

        let x = await api.updateTheZoo(id, zoo);

        console.log('dupa');

    }

    let handleDelete = async ()=>{


        let api = new Api();

        let x = await api.deleteAzoo(id);

    }




    return(

    <>

        <form className="myForm" onChange={handleChange}>
                
                <h1>Update Zoo</h1>
              
        
                <label for="Address"><b>Address</b></label>
                <input type="text" placeholder="Address" name="ad" id="ad" className="ad" value={address}/>

                <label for="Country"><b>Country</b></label>
                <input type="text" placeholder="Country" name="co" id="co" className="co" value={country}/>
            
                <label for="email"><b>Email</b></label>
                <input type="text" placeholder="Enter Email" name="email" id="email" className="email" value={mail}/>
            
                <label for="psw"><b>Password</b></label>
                <input type="password" placeholder="Enter Password" name="psw" id="psw" className="psw" value={password} />
            
                
                
            
                <button  className="registerbtn" onClick={handleUpdate}>Update</button>
           
                <button  className="deletebtn" onClick={handleDelete}>Delete</button>
          
        </form>

    
    
    
    
    
    </>
    )

}