package com.example.zoospring;

import com.example.zoospring.DTO.ZooDTO;
import com.example.zoospring.model.Animal;
import com.example.zoospring.model.Zoo;
import com.example.zoospring.repo.AnimalRepo;
import com.example.zoospring.repo.ZooRepo;
import com.example.zoospring.service.ZooService;
import com.github.javafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class ZooSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZooSpringApplication.class, args);
    }


    @Bean
    CommandLineRunner commandLineRunner(AnimalRepo animalRepo){

        return args -> {

//            Faker faker = new Faker();
//
//            for (int i = 0; i<10; i++){
//
//                Zoo zoo  = new Zoo(faker.country().name(), faker.address().streetAddress(), faker.internet().emailAddress(), faker.internet().password());
//
//                for(int j =0; j<5;j++){
//
//                   zoo.addAnimal(new Animal(faker.animal().name(), LocalDate.of(2000+i, 1+i, 1+j+i),faker.number().numberBetween(1,100)));
//                }
//
//                zooRepo.save(zoo);
//
//            }

           //Zoo z = new Zoo(11L,"MyCountry","10downingstreet","mail@mail.com","pass");

//            System.out.println(zooRepo.findAll().size());
//
//
//                zooRepo.findAll().stream().forEach(System.out::println);
//

//            System.out.println(zooService.login(zooDTO));
//
//            ZooDTO zooDTO = new ZooDTO("barry.towne@yahoo.com","9mdtfh6lhlv27");
//            ZooService zooService = new ZooService(zooRepo);

        // List<Zoo> zooList= zooRepo.getZooByCredentials("barry.towne@yahoo.com","9mdtfh6lhlv27");

//            ZooDTO zooDTO = new ZooDTO("barry.towne@yahoo.com","9mdtfh6lhlv27");
//
//           Zoo z = zooService.login(zooDTO);
//
//            System.out.println(z);
          //  System.out.println(zooService.getAnimById(1L,70L));



        };
    }
}
