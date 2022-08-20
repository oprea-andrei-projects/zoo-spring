package com.example.zoospring.web;

import com.example.zoospring.ZooSpringApplication;
import com.example.zoospring.model.Animal;
import com.example.zoospring.model.Zoo;
import com.example.zoospring.repo.AnimalRepo;
import com.example.zoospring.repo.ZooRepo;
import com.example.zoospring.service.ZooService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;

import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;


import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.*;

import static org.mockito.Mockito.*;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@TestPropertySource(
        locations = "classpath:application-it.properties"
)
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ZooSpringApplication.class)
@AutoConfigureMockMvc
class ZooControllerTest {


    @Mock
    private ZooRepo mockZooRepo;

    @Mock
    private AnimalRepo mockAnimalRepo;


    @Mock
    private ZooService mockZooService;


    @Autowired
    private MockMvc mock;



    @Test
    void test_getAllZoos() throws Exception {
        List<Zoo>zoos = new ArrayList<>();
        Zoo z = new Zoo("Romania","Eroilor","mail@mail.com","pass");
        zoos.add(z);

        when(mockZooRepo.findAll()).thenReturn(zoos);
        when(mockZooService.getAllZoos()).thenReturn(zoos);
        ObjectMapper mapper = new ObjectMapper();

        mock.perform(MockMvcRequestBuilders.get("/api/v1/allTheZoos")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isAccepted());

    }

    @Test
    void test_getAllZooAnimals() throws Exception {

        List<Animal> zooAnimals = new ArrayList<>();
        Zoo z = new Zoo(1L,"Romania","Eroilor","mail@mail.com","pass",zooAnimals);

        Animal a1 = new Animal(1L,"epure", LocalDate.of(2001,01,01),11,z);
        Animal a2 = new Animal(2L,"elefant", LocalDate.of(2002,02,02),12,z);
        zooAnimals.add(a1);
        zooAnimals.add(a2);

        ObjectMapper mapper = new ObjectMapper();

        when(mockZooRepo.findById(1L)).thenReturn(Optional.of(z));
        when(mockZooService.getZooById(1L)).thenReturn(z);

        when(mockZooService.getAnimalsByZooId(1L)).thenReturn(zooAnimals);

        mock.perform(MockMvcRequestBuilders.get("/api/v1/getAnimalList/2")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isAccepted())
                .andExpect((ResultMatcher) content().string(mapper.writeValueAsString(zooAnimals)));

    }




    public static String asJsonString(final Object obj) throws JsonProcessingException {
        try{
            return new ObjectMapper().writeValueAsString(obj);

        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

}