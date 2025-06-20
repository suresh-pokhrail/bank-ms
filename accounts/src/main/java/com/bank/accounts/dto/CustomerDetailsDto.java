package com.bank.accounts.dto;

import java.util.Date;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Schema(
    name = "Customer",
    description = "Schema to hold Customer, Account, Cards And Loans Information"
)
public class CustomerDetailsDto {

    @Schema(
    description = "Name Of Customer", example = "Suresh"
    )
    @NotEmpty(message = "Name can not be a null or empty")
    @Size(min=5, max=40,message = "The length of the customer name should be between 5 and 40")
    private String name;

    @Schema(
    description = "Mobile Number Of Customer", example = "9874561230"
    )
    @NotEmpty(message = "Mobile can not be a null or empty")
    @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number must be 10 digits")
	private String mobile;
	
    @Schema(
    description = "Gender Of Customer", example = "M"
    )
    @NotEmpty(message = "Gender can not be a null or empty")
    @Pattern(regexp = "(^$|[MFT]{1})", message = "Gender Should M, F, T")
    private String gender; 
	
    @Schema(
    description = "Address Of Customer", example = "Dehradun"
    )
    @NotEmpty (message = "Address can not be a null or empty")
    private String address;
	
    @Schema(
    description = "Aadhar Number Of Customer", example = "123456789987"
    )
    @NotEmpty(message = "Aadhar Number can not be a null or empty")
    @Pattern(regexp = "(^$|[0-9]{12})", message = "Aadhar number must be 12 digits")
    private String ssno;
	
    @Schema(
    description = "Date Of Birth Of Customer", example = "2000-01-01"
    )
    private Date dob;      
	
    @Schema(
    description = "Qualification Of Customer", example = "BCA"
    )
    @NotEmpty (message = "Qualification can not be a null or empty")
    private String qualification;
	
    @Schema(
    description = "Email Of Customer", example = "suresh@mail.com"
    )
    @NotEmpty(message = "Email can not be a null or empty")
    @Email(message = "Email address should be valid value")
    private String email;
	
    @Schema(
    description = "Status Of Customer", example = "Active"
    )
    private String status;

    @Schema(
    description = "Accounts details Of Customer"
    )
    private AccountsDto accountsDto;

    @Schema(
        description = "Loans details Of Customer"
        )
    private LoansDto loansDto;

    @Schema(
        description = "Cards details Of Customer"
        )
    private CardsDto cardsDto;
}

