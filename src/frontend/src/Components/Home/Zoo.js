import React from "react";

function Zoo({zoo}){



    return(

        <div className="card">

            <p class="cardLabel" id="cardLabel">${zoo.country}</p>
             <p class="added_at" id="added_at">${zoo.mail}</p>


        </div>
    )


}

export default Zoo