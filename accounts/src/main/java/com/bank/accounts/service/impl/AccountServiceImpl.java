package com.bank.accounts.service.impl;

import java.util.Optional;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.bank.accounts.constants.AccountsConstants;
import com.bank.accounts.dto.AccountsDto;
import com.bank.accounts.dto.CustomerDto;
import com.bank.accounts.entity.Accounts;
import com.bank.accounts.entity.Customer;
import com.bank.accounts.exception.CustomerAlreadyExistsException;
import com.bank.accounts.exception.ResourceNotFound;
import com.bank.accounts.mapper.AccountsMapper;
import com.bank.accounts.mapper.CustomerMapper;
import com.bank.accounts.repository.AccountsRepository;
import com.bank.accounts.repository.CustomerRepository;
import com.bank.accounts.service.IAccountService;

import lombok.AllArgsConstructor;

@Service @AllArgsConstructor
public class AccountServiceImpl implements IAccountService{

    private AccountsRepository accountsRepository;
    private CustomerRepository customerRepository;
   
    @Override
    public void createAccount(CustomerDto customerDto) {
        Customer customer = CustomerMapper.mapToCustomer(customerDto,new Customer());

        Optional<Customer> optionalCustomer = customerRepository.findByMobile(customerDto.getMobile());

        if(optionalCustomer.isPresent())
        {
            throw new CustomerAlreadyExistsException("Customer Already Registered With Given Mobile Number"
            + customerDto.getMobile());
        }
        
        Customer savedCustomer = customerRepository.save(customer);
        accountsRepository.save(this.createNewAccount(savedCustomer));
    }

    
    private Accounts createNewAccount(Customer customer)
    { 
        Accounts newAccounts = new Accounts();
        newAccounts.setCustId(customer.getId());
        Long randomAccNumber = 100000000L + new Random().nextInt(900000000);
        newAccounts.setAccountNumber(randomAccNumber);
        newAccounts.setAccountType(AccountsConstants.SAVINGS);
        newAccounts.setBranch(AccountsConstants.BRANCH);
        newAccounts.setBranchAddress(AccountsConstants.BRANCH_ADDRESS);

        return newAccounts;
    }


    @Override
    public CustomerDto fetchAccount(String mobile) {
        
        Customer customer = customerRepository.findByMobile(mobile).orElseThrow(
            () -> new ResourceNotFound("Customer", "Mobile", mobile)
        );

        Accounts accounts = accountsRepository.findByCustId(customer.getId()).orElseThrow(
            () -> new ResourceNotFound("Account", "CustomerId", customer.getId()+"")
        );
        
        CustomerDto customerDto = CustomerMapper.mapToCustomerDto(customer, new CustomerDto());
        customerDto.setAccountsDto(AccountsMapper.mapToAccountsDto(accounts, new AccountsDto()));
        return customerDto;
    }


    @Override
    public boolean updateAccount(CustomerDto customerDto) {
    
        boolean isUpdated = false;
        AccountsDto accountsDto = customerDto.getAccountsDto();
        if(accountsDto != null)
        {
            Accounts accounts = accountsRepository.findById(accountsDto.getAccountNumber()).orElseThrow(
                () -> new ResourceNotFound("Account", "AccountNumber", accountsDto.getAccountNumber().toString())
            );

            AccountsMapper.mapToAccounts(accountsDto, accounts);
            accounts = accountsRepository.save(accounts);

            Long customerId = accounts.getCustId();
            Customer customer = customerRepository.findById(customerId).orElseThrow(
                () -> new ResourceNotFound("Customer", "CustomerID", customerId.toString())
            );

            CustomerMapper.mapToCustomer(customerDto, customer);
            customerRepository.save(customer);
            isUpdated = true;
        }
        return isUpdated;
    }


    @Override
    public boolean deleteAccount(String mobile) {
        
        Customer customer = customerRepository.findByMobile(mobile).orElseThrow(
            () -> new ResourceNotFound("Customer", "Mobile", mobile)
        );

        accountsRepository.deleteByCustId(customer.getId());
        customerRepository.deleteById(customer.getId());
        return true;
    }
}
