package com.masai.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
     @PutMapping("/update")
     @ResponseStatus(code = HttpStatus.OK)
     public Broker updateBrokerHandler(@RequestBody Broker broker,@RequestParam(required = true) String key ) {
    	 return broService.editBroker(broker, key);
     }
	
	
	
	

}
