package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.AdminException;
import com.masai.exception.BrokerException;
import com.masai.model.Admin;
import com.masai.model.Broker;
import com.masai.service.AdminService;
import com.masai.service.BrokerService;

import jakarta.validation.Valid;

@RestController
public class AdminController {
	@Autowired
	 private AdminService adminservice;
	@Autowired
	private BrokerService brokerService;
	
	@PostMapping("/admin")
	public ResponseEntity<Admin> saveAdminHandler(@Valid @RequestBody Admin admin) throws AdminException{
		return new ResponseEntity<>(adminservice.createAdmin(admin),HttpStatus.CREATED);
	}
	@PutMapping("/admin")
	public ResponseEntity<Admin> updateAdminHandler(@Valid @RequestBody Admin admin,@RequestParam(required = false) String key) throws AdminException{
		return new ResponseEntity<>(adminservice.updateAdmin(admin, key),HttpStatus.CREATED);
	}
	
	@PostMapping("/broker")
	public ResponseEntity<Broker> saveBrokerHandler(@Valid @RequestBody Broker broker,@RequestParam(required =false ) String key) throws BrokerException{
		return new ResponseEntity<>(brokerService.saveBroker(broker,key),HttpStatus.CREATED);
	}
	@PutMapping("/broker")
	public ResponseEntity<Broker> EditBrokerHandler(@Valid @RequestBody Broker broker,@RequestParam(required =false ) String key) throws BrokerException{
		return new ResponseEntity<>(brokerService.editBroker(broker,key),HttpStatus.CREATED);
	}
	
	@DeleteMapping("/broker/{Id}")
	public ResponseEntity<Broker> deleteBrokerHandler(@PathVariable("id") Integer id,@RequestParam(required =false ) String key) throws BrokerException{
		return new ResponseEntity<>(brokerService.removeBroker(id,key),HttpStatus.OK);
	}
	@GetMapping("/broker/{broId}")
	public ResponseEntity<Broker> viewBrokerHandler(@PathVariable("broId") Integer broId) throws BrokerException{
		return new ResponseEntity<>(brokerService.viewBroker(broId),HttpStatus.OK);
	}
	@GetMapping("/brokers")
	public ResponseEntity<List<Broker>> allBrokerHandler() throws BrokerException{
		return new ResponseEntity<>(brokerService.viewAllBrokers(),HttpStatus.OK);
	}
	
	
	
	

}
