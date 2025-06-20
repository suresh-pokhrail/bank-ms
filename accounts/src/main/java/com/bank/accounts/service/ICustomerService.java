package com.bank.accounts.service;

import com.bank.accounts.dto.CustomerDetailsDto;

public interface ICustomerService {

    CustomerDetailsDto customerDetailsDto(String correlationId,String mobileNumber);

}
