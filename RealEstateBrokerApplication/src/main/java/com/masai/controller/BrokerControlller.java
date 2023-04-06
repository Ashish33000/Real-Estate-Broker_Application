package com.masai.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.masai.entity.Broker;
import com.masai.service.BrokerService;
@RestController
@RequestMapping("/api/broker")
public class BrokerControlller {
     @Autowired
	private BrokerService broService;
     
     @PostMapping
     @ResponseStatus(code = HttpStatus.CREATED)
     public Broker saveBroker(@RequestBody   Broker broker) {
    	 return broService.saveBroker(broker);
     }
	
	
	
	

}
