package com.masai.controller;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
//	@Autowired
//	private UserService userservice;
//	@Autowired
//	private CustomerService customerService;
//	@PostMapping("/users")
//	public ResponseEntity<User> saveUserHandler(@Valid @RequestBody User user) throws UserException{
//		return new ResponseEntity<User>(userservice.createUser(user),HttpStatus.CREATED);
//	}
//	@PutMapping("/users")
//	public ResponseEntity<User> updateUserHandler(@Valid @RequestBody User user,@RequestParam(required = false) String key) throws UserException{
//		return new ResponseEntity<User>(userservice.updateUser(user, key),HttpStatus.CREATED);
//	}
//	@PostMapping("/customer")
//	public ResponseEntity<Customer> addCustomerHandler(@Valid @RequestBody  Customer customer) throws CustomerException{
//		return new ResponseEntity<>(customerService.addCoustomer(customer),HttpStatus.CREATED);
//	}
//	@PutMapping("/customer")
//	public ResponseEntity<Customer> editCustomerHandler(@Valid @RequestBody  Customer customer,@RequestParam(required = false) String key) throws CustomerException{
//		return new ResponseEntity<>(customerService.editCoustomer(customer,key),HttpStatus.CREATED);
//	}
//	@DeleteMapping("/customer/{custId}")
//	public ResponseEntity<Customer> deleteCustomerHandler(@PathVariable("custId") Integer custId,@RequestParam(required = false) String key) throws CustomerException{
//		return new ResponseEntity<>(customerService.removeCoustomer(custId,key),HttpStatus.CREATED);
//	}
//	@GetMapping("/customer/{custId}")
//	public ResponseEntity<Customer> viewCustomerHandler(@PathVariable("custId") Integer custId) throws CustomerException{
//		return new ResponseEntity<>(customerService.viewCoustomer(custId),HttpStatus.FOUND);
//	}
//	@GetMapping("/customers")
//	public ResponseEntity<List<Customer>> viewAllCustomerHandler() throws CustomerException{
//		return new ResponseEntity<>(customerService.viewAllCoustomer(),HttpStatus.FOUND);
//	}

}
