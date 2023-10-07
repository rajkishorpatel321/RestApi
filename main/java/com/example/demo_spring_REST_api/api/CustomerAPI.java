package com.example.demo_spring_REST_api.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo_spring_REST_api.dto.CustomerDTO;
import com.example.demo_spring_REST_api.exception.InfyBankException;
import com.example.demo_spring_REST_api.service.CustomerService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value="/infybank")
@Validated
public class CustomerAPI {

	@Autowired
	private CustomerService customerSercvice;
	
	@GetMapping(value="/customers")
	public ResponseEntity<List<CustomerDTO>> getAllCustomer() throws InfyBankException{
		List<CustomerDTO> customerList = customerSercvice.getAllCustomer();
		return new ResponseEntity<>(customerList,HttpStatus.OK);
	}
	
	@GetMapping(value="/customer/{customerId}")
	public ResponseEntity<CustomerDTO> getCustomer(@PathVariable Integer customerId)throws InfyBankException{
		CustomerDTO customer = customerSercvice.getCustomer(customerId);
		
		return new ResponseEntity<>(customer,HttpStatus.OK);
	}
	
	@PostMapping(value="/customers")
	public ResponseEntity<String> addCustomer(@Valid @RequestBody CustomerDTO customer)throws InfyBankException{
		customerSercvice.adddCustomer(customer);
		
		return new ResponseEntity<>("Customer added susssefully",HttpStatus.CREATED);
	}
	@PutMapping(value="/customers/{customerId}")
	public ResponseEntity<String> updateCustomer
	(@PathVariable Integer customerId,@Valid @RequestBody CustomerDTO customer) throws InfyBankException{
		customerSercvice.updateCustomr(customerId, customer.getEmailId());
		return new ResponseEntity<>("user updated sussesfully",HttpStatus.OK);
	}
	
	@DeleteMapping(value="/customers/{customerId}")
	public ResponseEntity<String> delietCustomer
	(@PathVariable Integer customerId) throws InfyBankException{
		customerSercvice.deletCustomr(customerId);
		return new ResponseEntity<>("user deleted sussesfully",HttpStatus.OK);
	}
}




