package com.example.adhardetails.exception;

import org.springframework.stereotype.Service;

@Service
public class UserException extends Exception{

    public String name;

    public UserException(String name){
        super();
    }
    public UserException(){

    }

    @Override
    public String toString() {
        return "UserException{" +
                "name='" + name + '\'' +
                '}';
    }
}
