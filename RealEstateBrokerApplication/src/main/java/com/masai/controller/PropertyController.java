package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.masai.entity.Property;
import com.masai.entity.PropertyCriteria;
import com.masai.service.PropertyService;

@RestController
@RequestMapping("/users")
public class PropertyController {
	@Autowired
	private PropertyService propSer;
	@PostMapping("/property/{brokerId}")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Property addPropertyHandler(@PathVariable Integer brokerId,@RequestBody  Property property) {
		return propSer.saveProperty(brokerId,property);
	}
	@PutMapping("/property/{propId}")
	@ResponseStatus(code = HttpStatus.OK)
	public Property updatePropertyHandler(@PathVariable Integer propId,@RequestBody Property property,@RequestParam Integer brokerId) {
		return propSer.updateProperty(propId, property,brokerId);
	}
	@DeleteMapping("/property/{propId}")
	@ResponseStatus(code = HttpStatus.OK)
	public Property deletePropertyHandler(@PathVariable Integer propId) {
		return propSer.deleteProperty(propId);
	}
	@GetMapping("/property/{propId}")
	@ResponseStatus(code = HttpStatus.OK)
	public Property viewPropertyHandler(@PathVariable  Integer propId) {
		return propSer.viewProperty(propId);
	}
	@GetMapping("/propertys")
	@ResponseStatus(code = HttpStatus.OK)
	public List<Property> ViewAllPropertyHandler(){
		return propSer.listAllProperty();
	}
	@GetMapping("/property/criteria")
	@ResponseStatus(code = HttpStatus.OK)
	public List<Property> listPropertyBycriteriaHandler(@RequestBody  PropertyCriteria criteria){
		return propSer.listPropertyBycriteria(criteria);
	}

}
