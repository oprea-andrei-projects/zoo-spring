

export default class Api{


    api(path, method='GET',body=null){

        const url = "http://localhost:8080/" + path;

        const options = {

                method,
                
                headers:{

                    'Content-Type':'application/json; charset=utf-8',
                    'X-Requested-With': 'XMLHttpRequest'


                },

        };

        if(body!==null){
            options.body = JSON.stringify(body);
        }

      

        return fetch(url, options);

    }

    async getAllTheZoos(){

        let data = await this.api('api/v1/allTheZoos','GET');

        let data2 = await data.json();

        console.log(data2);

        return data2;
    }

    async addAzoo(zoo){

        let data = await this.api('api/v1/addAZoo','POST',zoo);

        let data2 = await data.json();

        console.log(data2);

        return data2;

    }

    async updateTheZoo(id, zoo){


        let data = await this.api(`api/v1/updateAZoo?id=${id}`,`PUT`,zoo);

        let data2 = await data.json();

        console.log(data2);

        return data2;
    }

    async deleteAzoo(id){

        let data = await this.api(`api/v1/deleteAZoo?id=${id}`,`DELETE`);

        let data2 = await data.json();

        console.log(data2);

        return data2;


    }



}