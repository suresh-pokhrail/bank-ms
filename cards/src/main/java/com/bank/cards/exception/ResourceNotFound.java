package com.bank.cards.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class ResourceNotFound extends RuntimeException{

    public ResourceNotFound(String resourceName, String fieldName,String fieldValue)
    {
        super(String.format("%s not found with given input data %s: %s", resourceName,fieldName,fieldValue));
    }

}
