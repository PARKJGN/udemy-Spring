package com.in28minutes.springboot.myfirstwebapp.login;

import org.springframework.stereotype.Service;

@Service
public class loginAuthenticationService {

    public boolean authenticate(String username, String password){

        boolean isValiduser = username.equalsIgnoreCase("in28minutes");
        boolean isValidPassword = password.equalsIgnoreCase("dummy");
        return isValiduser && isValidPassword;
    }

}
