package com.example.zoospring.repo;

import com.example.zoospring.model.Zoo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ZooRepo extends JpaRepository<Zoo,Long> {

    @Query("select z from Zoo z where z.mail = ?1 and z.password = ?2")
    List<Zoo> getZooByCredentials(String mail, String password);


}
