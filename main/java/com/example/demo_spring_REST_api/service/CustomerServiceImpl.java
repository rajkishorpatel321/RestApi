package com.example.demo_spring_REST_api.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo_spring_REST_api.dto.CustomerDTO;
import com.example.demo_spring_REST_api.entity.Customer;
import com.example.demo_spring_REST_api.exception.InfyBankException;
import com.example.demo_spring_REST_api.repositry.customerRepositry;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private customerRepositry customerRepository;


	@Autowired
	private ModelMapper modal;
	@Override
	public CustomerDTO getCustomer(Integer customerId) throws InfyBankException {
		// TODO Auto-generated method stub
		Optional<Customer> optional = customerRepository.findById(customerId);
		Customer customer = optional.orElseThrow(()-> new InfyBankException("Service.INVALID_CUSTOMERID"));
		CustomerDTO customerDTO = new CustomerDTO();
		customerDTO.setCustomerId(customer.getCustomerID());
		customerDTO.setDateOfBirth(customer.getDateOfBirth());
		customerDTO.setEmailId(customer.getEmailId());
		customerDTO.setName(customer.getName());
		return customerDTO;
	}
	
	@Override
	public List<CustomerDTO> getAllCustomer() throws InfyBankException {
		// TODO Auto-generated method stub
		List<Customer> customers = customerRepository.findAll();
		List<CustomerDTO> customer = new ArrayList<>();
		for(Customer c:customers) {
			CustomerDTO customerDTO = new CustomerDTO();
			customerDTO.setCustomerId(c.getCustomerID());
			customerDTO.setDateOfBirth(c.getDateOfBirth());
			customerDTO.setEmailId(c.getEmailId());
			customerDTO.setName(c.getName());
			customer.add(customerDTO);
		}
		return customer;
	}

	@Override
	public Integer adddCustomer(CustomerDTO customerDTO) throws InfyBankException {
		// TODO Auto-generated method stub
		Customer customer = modal.map(customerDTO, Customer.class);
		customerRepository.save(customer);
		return customer.getCustomerID();
	}

	@Override
	public void updateCustomr(Integer customerId, String emailId) throws InfyBankException {
		// TODO Auto-generated method stub
		Optional<Customer> findById = customerRepository.findById(customerId);
		Customer customer = findById.orElseThrow(()-> new InfyBankException("No_user_avilable"));
		customer.setEmailId(emailId);
	}

	@Override
	public void deletCustomr(Integer customerId) throws InfyBankException {
		// TODO Auto-generated method stub
		customerRepository.deleteById(customerId);
		
	}

}
