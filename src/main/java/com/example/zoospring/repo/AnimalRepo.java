package com.example.zoospring.repo;


import com.example.zoospring.model.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalRepo extends JpaRepository<Animal, Long> {

    @Query("select sum(a.noOfAnim) from Animal a where a.zoo.id = ?1 ")
    int sumOfAnimals(Long id);
}
