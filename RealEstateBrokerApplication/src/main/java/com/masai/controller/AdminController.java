package com.masai.controller;

import java.util.List;

import javax.validation.Valid;

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
import com.masai.exception.LoginException;
import com.masai.exception.PropertyException;
import com.masai.model.Admin;
import com.masai.model.Broker;
import com.masai.model.Property;
import com.masai.model.PropertyCriteria;
import com.masai.service.AdminService;
import com.masai.service.BrokerService;
import com.masai.service.PropertyService;
@RestController
public class AdminController {
	@Autowired
	 private AdminService adminservice;
	@Autowired
	private BrokerService brokerService;
	@Autowired
	private PropertyService propService;
	
	@PostMapping("/admins")
	public ResponseEntity<Admin> saveAdminHandler(@Valid @RequestBody Admin admin) throws AdminException{
		return new ResponseEntity<>(adminservice.createAdmin(admin),HttpStatus.CREATED);
	}
	@PutMapping("/admins")
	public ResponseEntity<Admin> updateAdminHandler(@Valid @RequestBody Admin admin,@RequestParam(required = false) String key) throws AdminException,LoginException{
		return new ResponseEntity<>(adminservice.updateAdmin(admin, key),HttpStatus.CREATED);
	}
	
	@PostMapping("/broker")
	public ResponseEntity<Broker> saveBrokerHandler(@Valid @RequestBody Broker broker,@RequestParam(required =false ) String key) throws BrokerException,LoginException{
		return new ResponseEntity<>(brokerService.saveBroker(broker,key),HttpStatus.CREATED);
	}
	@PutMapping("/broker")
	public ResponseEntity<Broker> EditBrokerHandler(@Valid @RequestBody Broker broker,@RequestParam(required =false ) String key) throws BrokerException,LoginException{
		return new ResponseEntity<>(brokerService.editBroker(broker,key),HttpStatus.CREATED);
	}
	
	@DeleteMapping("/broker/{Id}")
	public ResponseEntity<Broker> deleteBrokerHandler(@PathVariable("id") Integer id,@RequestParam(required =false ) String key) throws BrokerException,LoginException{
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
	@PostMapping("/addproperty")
	public ResponseEntity<Property> savePropertyHandler(@Valid @RequestBody Property property ,@RequestParam(required =false ) String key) throws PropertyException,LoginException{
		return new ResponseEntity<>(propService.saveProperty(property, key),HttpStatus.CREATED);
	}
	@DeleteMapping("/property/{propId}")
	public ResponseEntity<Property> deletePropertyHandler(@Valid @PathVariable Integer propId ,@RequestParam(required =false ) String key) throws PropertyException,LoginException{
		return new ResponseEntity<>(propService.deleteProperty(propId, key),HttpStatus.OK);
	}
	@PutMapping("/property/{propId}")
	public ResponseEntity<Property> updatePropertyHandler(@Valid @RequestBody Property property,@PathVariable Integer PropId ,@RequestParam(required =false ) String key) throws PropertyException,LoginException{
		property.setPropId(PropId);
		Property prop=propService.updateProperty(property, key);
		return new ResponseEntity<>(prop,HttpStatus.OK);
	}
	@GetMapping("/property/{propId}")
	public ResponseEntity<Property> viewPropertyHandler(@Valid @PathVariable Integer propId ,@RequestParam(required =false ) String key) throws PropertyException,LoginException{
		return new ResponseEntity<>(propService.viewProperty(propId, key),HttpStatus.OK);
	}
	@GetMapping("/properties")
	public ResponseEntity<List<Property>>viewPropertyHandler(@RequestParam(required =false ) String key) throws PropertyException,LoginException{
		return new ResponseEntity<>(propService.listAllProperty(key),HttpStatus.OK);
	}
	
	@GetMapping("/propertiesCriteria")
	public ResponseEntity<List<Property>>viewPropertyByCriteriaHandler(@RequestBody PropertyCriteria criteria,@RequestParam(required =false ) String key) throws PropertyException,LoginException{
		return new ResponseEntity<>(propService. listPropertyBycriteria(criteria, key),HttpStatus.OK);
	}
	
	
	
	
	

}
