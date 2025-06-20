package com.bank.accounts.service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestHeader;

import com.bank.accounts.dto.CardsDto;

@FeignClient(name="cards", fallback = CardsFallback.class)
public interface CardsFeignClient {
    @GetMapping(value="/api/fetch", consumes="application/json")
    public ResponseEntity<CardsDto> fetchCardDetails(@RequestHeader("bank-correlation-id") String CorrelationId,@RequestParam String mobileNumber);

}
