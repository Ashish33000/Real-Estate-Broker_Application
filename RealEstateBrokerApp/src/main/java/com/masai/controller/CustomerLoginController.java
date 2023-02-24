package com.masai.controller;

import com.masai.model.AdminLoginDTO;
import com.masai.model.CustomerLoginDTO;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customerlogin")
public class CustomerLoginController {
    @Autowired
    private CustomerLoginService customerLoginService;

    @PostMapping("/login")
    public ResponseEntity<String> customerLoginHandler(@Valid @RequestBody CustomerLoginDTO customerLoginDTO){

       String key= customerLoginService.logIntoAccount(customerLoginDTO);
        return new ResponseEntity<String>(key, HttpStatus.ACCEPTED);
    }

    @GetMapping("/logout/{key}")
    public ResponseEntity<String> customerLogoutHandler(@PathVariable String key){

        String key1 = customerLoginService.logOutFromAccount(key);
        return new ResponseEntity<String>(key1, HttpStatus.ACCEPTED);
    }
}