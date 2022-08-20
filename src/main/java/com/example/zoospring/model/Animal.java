package com.example.zoospring.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name = "Animal")
@Table(name = "animal")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Animal {

    @Id
    @SequenceGenerator(

            name = "animal_sequence",
            allocationSize = 1
    )

    @GeneratedValue(

            strategy = GenerationType.SEQUENCE,
            generator = "animal_sequence"

    )

    Long id;

    @Column(

            name = "breed",
            nullable = false,
            columnDefinition = "TEXT"
    )
    String breed;


    @Column(

            name = "added_at",
            columnDefinition ="DATE",
            nullable = false

    )
    LocalDate added_at;


    @Column(

            name = "noOfAnim",
            nullable = false,
            columnDefinition = "INTEGER"

    )
    int noOfAnim;

    public Animal(String breed, LocalDate added_at, int noOfAnim){

        this.breed = breed;
        this.added_at = added_at;
        this.noOfAnim = noOfAnim;
    }

    @ManyToOne
    @JsonBackReference
    @JoinColumn(

            name ="zoo_id",
            referencedColumnName ="id",
            foreignKey = @ForeignKey(
                name ="zoo_id_fk"
            )
    )
    private Zoo zoo;


    @Override
    public boolean equals(Object o){

        Animal a = (Animal) o;

        return this.breed.equals(a.breed);
    }





}
