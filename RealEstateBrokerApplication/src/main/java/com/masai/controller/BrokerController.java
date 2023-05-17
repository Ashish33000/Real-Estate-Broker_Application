package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.masai.entity.Broker;
import com.masai.service.BrokerService;

@RestController
@RequestMapping("/users")
public class BrokerController {
	@Autowired
	private BrokerService broService;
	@PostMapping("/broker")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Broker addBroker(@RequestBody Broker broker) {
		return broService.saveBroker(broker);
	}
	@PatchMapping("/broker/{broId}")
	@ResponseStatus(code = HttpStatus.OK)
	public Broker UpdateBrokerHandler(@PathVariable  Integer broId,@RequestBody Broker broker) {
		return broService.editBroker(broId,broker);
	}
	@DeleteMapping("/broker/{broId}")
	@ResponseStatus(code = HttpStatus.OK)
	public Broker deleteBrokerHandler(@PathVariable Integer broId) {
		return broService.removeBroker(broId);
	}
	@GetMapping("/broker/{broId}")
	@ResponseStatus(code = HttpStatus.OK)
	public Broker viewBrokerByID(@PathVariable Integer broId) {
		return broService.viewBroker(broId);
	}
	@GetMapping("/brokers")
	@ResponseStatus(code = HttpStatus.OK)
	public List<Broker> viewAllBrokers(){
		return broService.viewAllBrokers();
	}

}
