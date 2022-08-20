package com.example.zoospring.model;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class AnimalTest {

    @Test
    void animEqualsTest(){

        Animal a1 = new Animal("myBreed", LocalDate.of(2022,01,01),11);

        Animal a2 = new Animal("myBreed", LocalDate.of(2021,01,02),12);

        assertEquals(a1.equals(a2),true);
    }

}