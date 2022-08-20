package com.example.zoospring.web;


import com.example.zoospring.DTO.ZooDTO;
import com.example.zoospring.model.Animal;
import com.example.zoospring.model.Zoo;
import com.example.zoospring.service.ZooService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin
public class ZooController {

    ZooService zooService;

    public ZooController(ZooService zooService){

        this.zooService = zooService;
    }


    @GetMapping("/allTheZoos")
    public ResponseEntity<List<Zoo>> alltheZoos(){
        List<Zoo> myZooList = zooService.getAllZoos();
        return new ResponseEntity<>(myZooList, HttpStatus.ACCEPTED);
    }

    @GetMapping("/getZooByID/{id}")
    public ResponseEntity<Zoo> getZooById(@PathVariable Long id){
        Zoo z = this.zooService.getZooById(id);
        return new ResponseEntity<>(z, HttpStatus.ACCEPTED);
    }

    @PostMapping("/addAZoo")
    public ResponseEntity<Zoo> addZoo(@RequestBody Zoo z){
        this.zooService.addAZoo(z);
        return new ResponseEntity<>(z,HttpStatus.CREATED);

    }

    @DeleteMapping("/deleteAZoo")
    public ResponseEntity<Long> deleteZoo(@RequestParam Long id){
        this.zooService.deleteAZoo(id);
        return new ResponseEntity<>(id, HttpStatus.ACCEPTED);
    }


    @PutMapping("/updateAZoo")
    public ResponseEntity<Zoo> updateZoo(@RequestParam Long id, @RequestBody Zoo updatedZoo){
        this.zooService.updateAZoo(id, updatedZoo);
        return new ResponseEntity<>(updatedZoo, HttpStatus.CREATED);

    }

    @GetMapping("/getAnimalList/{id}")
    public ResponseEntity<List<Animal>> getAnimals(@PathVariable Long id){
        List<Animal> animals = this.zooService.getAnimalsByZooId(id);
        return new ResponseEntity<>(animals, HttpStatus.ACCEPTED);

    }

    @PostMapping("/login")
    public ResponseEntity<Zoo> loginare(@RequestBody ZooDTO zooDTO){
        Zoo z = this.zooService.login(zooDTO);
        return new ResponseEntity<>(z, HttpStatus.ACCEPTED);
    }

    @GetMapping("/sumOfAnimals/{id}")
    public ResponseEntity<Integer> sumOfAnimals(@PathVariable Long id){
        int sum = this.zooService.sumOfAnimPerZoo(id);
        return new ResponseEntity<>(sum, HttpStatus.ACCEPTED);


    }

    @PostMapping("/addAnimalToZoo/{id}")
    public ResponseEntity<Animal> addAnimalToZoo(@PathVariable Long id, @RequestBody Animal animal){
        this.zooService.addAnimal(id,animal);
        return new ResponseEntity<>(animal, HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteTheAnimal")
    public ResponseEntity<Long> deleteAnimal(@RequestParam Long zooId, @RequestParam Long animId){
        this.zooService.deleteTheAnimal(zooId,animId);
        return new ResponseEntity<>(animId, HttpStatus.ACCEPTED);
    }

    @PutMapping("/updateTheAnimal")
    public ResponseEntity<Animal> updateAnimal(@RequestParam Long zooId, @RequestBody Animal animal){
        Animal animal1 = this.zooService.updateTheAnimal(zooId,animal);
        return new ResponseEntity<>(animal1, HttpStatus.OK);
    }





}
