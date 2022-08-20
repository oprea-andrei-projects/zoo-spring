package com.example.zoospring.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ZooAlreadyExistsException extends RuntimeException{

    public ZooAlreadyExistsException(String msg){

        super(msg);
    }
}
