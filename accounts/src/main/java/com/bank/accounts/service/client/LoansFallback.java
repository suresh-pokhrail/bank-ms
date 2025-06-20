package com.bank.accounts.service.client;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.bank.accounts.dto.LoansDto;

@Component
public class LoansFallback implements LoansFeignClient{

    @Override
    public ResponseEntity<LoansDto> fetchLoanDetails(String CorrelationId, String mobileNumber) {
  
        return null;
    }
    
}