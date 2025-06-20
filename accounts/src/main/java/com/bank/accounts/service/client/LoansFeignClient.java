package com.bank.accounts.service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import com.bank.accounts.dto.LoansDto;

@FeignClient(name="loan", fallback = LoansFallback.class)
public interface LoansFeignClient {
    @GetMapping(value="/api/fetch", consumes="application/json")
    public ResponseEntity<LoansDto> fetchLoanDetails(@RequestHeader("bank-correlation-id") String CorrelationId,@RequestParam String mobileNumber);

}
