import React, { useEffect, useState } from "react"
import Api from "../../Api";
import Zoo from "./Zoo";

export default function Home(){

    let [zoos, setZoos] = useState([]);

    let fetchZoos = async ()=>{

        let api = new Api();

        let x = await api.getAllTheZoos();

        setZoos(x);


    }

    useEffect(()=>{

        fetchZoos();

    },[])




    return(

        <div className="container">
            <header class="searchArea">

            <ul class="meniu">
                <li class="add">Add</li>
                <li class="delete">Delete</li>
                <li class="update">Update</li>
            </ul>

            <div class="serachItems">

                <input type="text" class="input-search" />
                <input type="button" class="searchBTN" value="search" />

            </div>



            </header>

            <main class="displayArea">

                <h1>Zoos blabla</h1>


                {
                    zoos.length ==0
                    ?
                    (
                    <p>Loading...</p>
                    )
                    :
                    (
                        zoos.map(element=>{

                            return <Zoo zoo={element} />
                        })
                    )

                }

                

                
            </main>

            <aside class="pagination">


            </aside>

            <footer class="contactArea">


                <div class="fdiv1">

                    

                    <a href="#" class="fa fa-facebook"></a>
                    <a href="#" class="fa fa-twitter"></a>
                    <a href="#" class="fa fa-instagram"></a>

                </div>

            </footer>
                
    
        </div>
    )

}