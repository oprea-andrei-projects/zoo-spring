package com.example.zoospring.service;

import com.example.zoospring.DTO.ZooDTO;
import com.example.zoospring.exceptions.NoAnimalFoundException;
import com.example.zoospring.exceptions.NoAnimalInThisZooException;
import com.example.zoospring.exceptions.NoZooFoundException;
import com.example.zoospring.exceptions.ZooAlreadyExistsException;
import com.example.zoospring.model.Animal;
import com.example.zoospring.model.Zoo;
import com.example.zoospring.repo.AnimalRepo;
import com.example.zoospring.repo.ZooRepo;
import org.springframework.stereotype.Service;


import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ZooService {

   private ZooRepo zooRepo;
    private AnimalRepo animalRepo;

    public ZooService(ZooRepo zooRepo, AnimalRepo animalRepo){

        this.zooRepo = zooRepo;
        this.animalRepo = animalRepo;
    }

    public List<Zoo> getAllZoos (){

        List<Zoo> allthezoos = zooRepo.findAll();

        if(allthezoos.isEmpty()){

            throw new NoZooFoundException("Nu exista nici o zoo !");
        }

        return allthezoos;
    }

    public Zoo getZooById(Long id){

        Optional<Zoo> myOp = this.zooRepo.findById(id);

        if(myOp.isEmpty()){

            throw new NoZooFoundException("Nu exista aceasta zoo !!! ");
        }

        return myOp.get();
    }

    public void addAZoo(Zoo zoo){

        if(Collections.frequency(getAllZoos(),zoo)!=0){

            throw new ZooAlreadyExistsException("Zoo already in list");
        }
        this.zooRepo.save(zoo);

    }

    public void deleteAZoo(Long id){

        Optional<Zoo> optionalZoo = Optional.of(getZooById(id));

        if(optionalZoo.isEmpty()){

            throw new NoZooFoundException("No such zoo !!!");
        }

        this.zooRepo.delete(optionalZoo.get());

    }

    public void updateAZoo(Long id, Zoo updatedZoo){

        Zoo z1 = this.zooRepo.findById(id).get();
        z1.setCountry(updatedZoo.getCountry());
        z1.setAddress(updatedZoo.getAddress());
        z1.setMail(updatedZoo.getMail());
        z1.setPassword(updatedZoo.getPassword());


        this.zooRepo.save(z1);



    }

    public Zoo login(ZooDTO zooDTO){

      Zoo z =  this.zooRepo.getZooByCredentials(zooDTO.getMail(), zooDTO.getPassword()).get(0);

        if(z==null){

            throw new NoZooFoundException("Credentialele nu sunt corecte !!!");

        }else{

            return z;
        }

    }


    public List<Animal> getAnimalsByZooId(Long id){

        Zoo z = getZooById(id);

        return  z.getAnimalList();

    }

    public int sumOfAnimPerZoo(Long id){

        if(zooRepo.findById(id).isEmpty()){

            throw new NoZooFoundException("Zoo doesn't exist !!!");
        }

        return this.animalRepo.sumOfAnimals(id);

    }

    public void addAnimal(Long zooId, Animal animal){

        Zoo z = this.getZooById(zooId);

        z.addAnimal(animal);

        this.zooRepo.save(z);


    }

    public Animal getAnimById(Long zooId,Long animId){

        Zoo z = this.getZooById(zooId);



        Optional <Animal> myAnim = this.animalRepo.findById(animId);

        if(myAnim.isEmpty()){
            throw new NoAnimalFoundException("Wrong animal ID !!!");
        }else if(Collections.frequency(z.getAnimalList(),myAnim.get())==0){

            throw new NoAnimalInThisZooException("No animal here !!!");


        }else{

            return myAnim.get();
        }

    }

    public void deleteTheAnimal(Long zooId, Long animId){

        Zoo z = this.getZooById(zooId);
        z.deleteAnimal(animId);
        this.zooRepo.save(z);

    }

    public Animal updateTheAnimal(Long zooId,Animal a){

        Animal a1 = getAnimById(zooId, a.getId());

        a1.setBreed(a.getBreed());
        a1.setAdded_at(a.getAdded_at());
        a1.setNoOfAnim(a.getNoOfAnim());

        this.animalRepo.save(a1);

        return a1;

    }








}
