package com.example.zoospring.model;


import com.example.zoospring.exceptions.NoAnimalFoundException;
import com.example.zoospring.exceptions.NoAnimalInThisZooException;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Entity(name="Zoo")
@Table(name="zoo")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Zoo {

    @Id
    @SequenceGenerator(

            name ="zoo_sequence",
            allocationSize = 1

    )
    @GeneratedValue(

            strategy = GenerationType.SEQUENCE,
            generator = "zoo_sequence"
    )

    Long id;


    @Column(

        name = "country",
        nullable = false,
        columnDefinition = "TEXT"
    )

    String country;

    @Column(

            name = "address",
            nullable = false,
            columnDefinition = "TEXT"
    )

    String address;

    @Column(

            name = "mail",
            nullable = false,
            columnDefinition = "TEXT"

    )

    String mail;

    @Column(

            name = "password",
            nullable = false,
            columnDefinition = "TEXT"

    )

    String password;


    public Zoo (String country, String address, String mail, String password) {


        this.country = country;
        this.address = address;
        this.mail = mail;
        this.password = password;
    }

    @JsonManagedReference
    @OneToMany(

            mappedBy ="zoo",
            cascade ={CascadeType.ALL},
            fetch =FetchType.EAGER,
            orphanRemoval = true
    )
    List<Animal>animalList = new ArrayList<>();

    public void addAnimal(Animal animal){

           this.animalList.add(animal);
           animal.setZoo(this);

    }

    public void deleteAnimal(Long id){

        List<Animal> theAnimal = this.animalList.stream()
                .filter(e->e.getId() == id)
                .collect(Collectors.toList());

        if(theAnimal.isEmpty()==false){

            this.animalList.remove(theAnimal.get(0));
            theAnimal.get(0).setZoo(null);
        }else{
            throw new NoAnimalFoundException("ID-ul este gresit !!!");
        }
    }

    @Override
    public String toString() {
        return "Zoo{" +
                "id=" + id +
                ", country='" + country + '\'' +
                ", address='" + address + '\'' +
                ", mail='" + mail + '\'' +
                ", password='" + password + '\'' +
                ", animalList="  +
                '}';
    }

    @Override
    public boolean equals(Object o){

        Zoo zoo = (Zoo) o;

        return this.getAddress().equals(zoo.getAddress());
    }
}
