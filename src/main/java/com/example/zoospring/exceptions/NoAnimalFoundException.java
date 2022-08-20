package com.example.zoospring.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class NoAnimalFoundException extends RuntimeException{

    public NoAnimalFoundException(String msg){

        super(msg);
    }
}
