package com.bank.accounts.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.bank.accounts.dto.CustomerDetailsDto;
import com.bank.accounts.dto.ErrorResponseDto;
import com.bank.accounts.service.ICustomerService;

import org.apache.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.Pattern;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Tag(
    name = "CRUD REST APIs for Accounts in Bank",
    description = "CRUD REST APIs in Bank To FETCH Customer details"
)
@RestController
@RequestMapping(path="/api",produces = (MediaType.APPLICATION_JSON_VALUE))

@Validated
public class CustomerController {

    private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);
    private final ICustomerService iCustomerService;

    public CustomerController(ICustomerService iCustomerService){
        this.iCustomerService = iCustomerService;
    }

     @Operation(
        summary = "Fetch Customer Details REST API",
        description = "REST API to Fetch Customer Details based on a mobile number"
    )
    @ApiResponses({
        @ApiResponse(
            responseCode = "200",
            description = "HTTP Status OK"
        ),
        @ApiResponse(
            responseCode = "500",
            description = "HTTP Status Internal Server Error",
            content = @Content(
                schema = @Schema(implementation = ErrorResponseDto.class)
            )
        )
    })
    @GetMapping("/fetchCustomerDetails")
    public ResponseEntity<CustomerDetailsDto> fetchCustomerDetails(@RequestHeader("bank-correlation-id") String correlationId, 
                                            @RequestParam  @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number must be 10 digits")
                                            String mobileNumber){

                                                logger.debug("BanK Accounts Correlation_id found{]:", correlationId);
        CustomerDetailsDto customerDetailsDto = iCustomerService.customerDetailsDto(correlationId,mobileNumber);

        return ResponseEntity.status(HttpStatus.SC_OK).body(customerDetailsDto);
    }

}
