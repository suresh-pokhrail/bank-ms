package com.bank.accounts.service;

import com.bank.accounts.dto.CustomerDto;

public interface IAccountService {
    
    void createAccount(CustomerDto usersDto);

     CustomerDto fetchAccount (String mobile);

     boolean updateAccount(CustomerDto customerDto);
     
     boolean deleteAccount(String mobile);
}
