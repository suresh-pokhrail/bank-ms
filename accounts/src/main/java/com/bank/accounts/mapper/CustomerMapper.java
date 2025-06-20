package com.bank.accounts.mapper;

import com.bank.accounts.dto.CustomerDetailsDto;
import com.bank.accounts.dto.CustomerDto;
import com.bank.accounts.entity.Customer;

public class CustomerMapper {
 
    public static CustomerDto mapToCustomerDto(Customer customer,CustomerDto customerDto)
    {
        customerDto.setName(customer.getName());
        customerDto.setMobile(customer.getMobile());
        customerDto.setGender(customer.getGender());
        customerDto.setAddress(customer.getAddress());
        customerDto.setSsno(customer.getSsno());
        customerDto.setDob(customer.getDob());
        customerDto.setQualification(customer.getQualification());
        customerDto.setEmail(customer.getEmail());
        customerDto.setStatus(customer.getStatus());

        return customerDto;
    }

    public static CustomerDetailsDto mapToCustomerDetailsDto(Customer customer,CustomerDetailsDto customerDetailsDto)
    {
        customerDetailsDto.setName(customer.getName());
        customerDetailsDto.setMobile(customer.getMobile());
        customerDetailsDto.setGender(customer.getGender());
        customerDetailsDto.setAddress(customer.getAddress());
        customerDetailsDto.setSsno(customer.getSsno());
        customerDetailsDto.setDob(customer.getDob());
        customerDetailsDto.setQualification(customer.getQualification());
        customerDetailsDto.setEmail(customer.getEmail());
        customerDetailsDto.setStatus(customer.getStatus());

        return customerDetailsDto;
    }

    
    public static Customer mapToCustomer(CustomerDto customerDto,Customer customer)
    {
        customer.setName(customerDto.getName());
        customer.setMobile(customerDto.getMobile());
        customer.setGender(customerDto.getGender());
        customer.setAddress(customerDto.getAddress());
        customer.setSsno(customerDto.getSsno());
        customer.setDob(customerDto.getDob());
        customer.setQualification(customerDto.getQualification());
        customer.setEmail(customerDto.getEmail());
        customer.setStatus(customerDto.getStatus());
        return customer;
    }
}
