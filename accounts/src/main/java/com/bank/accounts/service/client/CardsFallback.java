package com.bank.accounts.service.client;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.bank.accounts.dto.CardsDto;

@Component
public class CardsFallback implements CardsFeignClient{

    @Override
    public ResponseEntity<CardsDto> fetchCardDetails(String CorrelationId, String mobileNumber) {
       
        return null;
    }
    
}
