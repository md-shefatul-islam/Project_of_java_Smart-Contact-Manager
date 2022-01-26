package com.model;


import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class Email {

    @Valid
    @NotNull(message="Can not be empty")
    private String userEmail;


    public String getUserEmail(){
        return userEmail;
    }
    public void setUserEmail(String userEmail){
        this.userEmail=userEmail;
    }
}