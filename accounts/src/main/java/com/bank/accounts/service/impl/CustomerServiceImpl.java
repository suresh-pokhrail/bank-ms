package com.bank.accounts.service.impl;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.bank.accounts.dto.AccountsDto;
import com.bank.accounts.dto.CardsDto;
import com.bank.accounts.dto.CustomerDetailsDto;
import com.bank.accounts.dto.LoansDto;
import com.bank.accounts.entity.Accounts;
import com.bank.accounts.entity.Customer;
import com.bank.accounts.exception.ResourceNotFound;
import com.bank.accounts.mapper.AccountsMapper;
import com.bank.accounts.mapper.CustomerMapper;
import com.bank.accounts.repository.AccountsRepository;
import com.bank.accounts.repository.CustomerRepository;
import com.bank.accounts.service.ICustomerService;
import com.bank.accounts.service.client.CardsFeignClient;
import com.bank.accounts.service.client.LoansFeignClient;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements ICustomerService{

    private AccountsRepository accountsRepository;
    private CustomerRepository customerRepository;

    private CardsFeignClient cardsFeignClient;
    private LoansFeignClient loansFeignClient;
    
    @Override
    public CustomerDetailsDto customerDetailsDto(String CorrelationId,String mobileNumber) {
     Customer customer = customerRepository.findByMobile(mobileNumber).orElseThrow(
            () -> new ResourceNotFound("Customer", "Mobile", mobileNumber)
        );

        Accounts accounts = accountsRepository.findByCustId(customer.getId()).orElseThrow(
            () -> new ResourceNotFound("Account", "CustomerId", customer.getId()+"")
        );
        
        CustomerDetailsDto customerDetailsDto = CustomerMapper.mapToCustomerDetailsDto(customer,new CustomerDetailsDto());
        customerDetailsDto.setAccountsDto(AccountsMapper.mapToAccountsDto(accounts,new AccountsDto()));
//System.out.println(CorrelationId);
        ResponseEntity<LoansDto> loansDtoResponseEntity = loansFeignClient.fetchLoanDetails(CorrelationId,mobileNumber);
        if(null != loansDtoResponseEntity){
        customerDetailsDto.setLoansDto(loansDtoResponseEntity.getBody());}

        ResponseEntity<CardsDto> cardsDtoResponseEntity = cardsFeignClient.fetchCardDetails(CorrelationId,mobileNumber);
        if(null != cardsDtoResponseEntity){
        customerDetailsDto.setCardsDto(cardsDtoResponseEntity.getBody());}

        return customerDetailsDto;
    }

    
}
