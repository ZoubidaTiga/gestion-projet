package com.example.testjpa.exceptions;

public class ProjectNotFoundException extends Exception{
    public ProjectNotFoundException(String message){
        super(message);
    }

}
