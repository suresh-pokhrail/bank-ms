package com.bank.accounts.exception;

import java.net.http.HttpHeaders;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.bank.accounts.dto.ErrorResponseDto;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{
   
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
        MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {  
            Map<String, String> validationErrors = new HashMap<String,String>();
            List<ObjectError>  validationErrorList = ex.getBindingResult().getAllErrors();

            validationErrorList.forEach((error) ->{
                String fieldName = ((FieldError) error).getField();
                String validationMsg = error.getDefaultMessage();
                validationErrors.put(fieldName,validationMsg);
            });
            return new ResponseEntity<>(validationErrors, HttpStatus.BAD_REQUEST);
        }

    @ExceptionHandler(CustomerAlreadyExistsException.class)
    public ResponseEntity<ErrorResponseDto> handleCustomerAlreadyExistsException(CustomerAlreadyExistsException exception,
        WebRequest webRequest)
    {
        ErrorResponseDto errorResponseDto = new ErrorResponseDto(
        webRequest.getDescription(false) ,
        HttpStatus.BAD_REQUEST,
        exception.getMessage(), 
        LocalDateTime.now()
        );

        return new ResponseEntity<>(errorResponseDto,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ResourceNotFound.class)
    public ResponseEntity<ErrorResponseDto> handleResourceNotFound(ResourceNotFound exception,
        WebRequest webRequest)
    {
        ErrorResponseDto errorResponseDto = new ErrorResponseDto(
        webRequest.getDescription(false) ,
        HttpStatus.BAD_REQUEST,
        exception.getMessage(), 
        LocalDateTime.now()
        );

        return new ResponseEntity<>(errorResponseDto,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDto> handleGlobalException(Exception exception,
        WebRequest webRequest)
    {
        ErrorResponseDto errorResponseDto = new ErrorResponseDto(
        webRequest.getDescription(false) ,
        HttpStatus.INTERNAL_SERVER_ERROR,
        exception.getMessage(), 
        LocalDateTime.now()
        );

        return new ResponseEntity<>(errorResponseDto,HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
