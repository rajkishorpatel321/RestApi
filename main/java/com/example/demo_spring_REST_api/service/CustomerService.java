package com.example.demo_spring_REST_api.service;

import java.util.List;

import com.example.demo_spring_REST_api.dto.CustomerDTO;
import com.example.demo_spring_REST_api.exception.InfyBankException;

public interface CustomerService {
	public CustomerDTO getCustomer(Integer customerId) throws InfyBankException;
	public List<CustomerDTO> getAllCustomer() throws InfyBankException;
	public Integer adddCustomer(CustomerDTO customerDTO) throws InfyBankException;
	public void updateCustomr(Integer customerId,String emailId) throws InfyBankException;
	public void deletCustomr(Integer customerId) throws InfyBankException;
}
