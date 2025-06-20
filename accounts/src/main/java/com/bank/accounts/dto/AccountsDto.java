package com.bank.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Schema(
    name = "Accounts",
    description = "Schema to hold Account Information"
    )
public class AccountsDto {

    
    @NotEmpty(message = "Account Number can not be a null or empty")
    @Pattern(regexp = "(^$|[0-9]{10})" , message = "Account number must be 10 digits" )
    @Schema(
    description = "Account number of bank account", example = "123456789"
    )
    private Long accountNumber;

    @NotEmpty(message = "Account type can not be a null or empty")
   @Schema(
    description = "Account type of bank account", example = "Saving"
    )
    private String accountType;

    @Schema(
    description = "Branch of Bank Account", example = "Dehradun"
    )
    @NotEmpty(message = "Branch can not be a null or empty")
    private String branch;

    @Schema(
    description = "Branch  Address of Bank Account", example = "Dehradun, UK"
    )
    @NotEmpty(message = "Branch Address can not be a null or empty")
    private String branchAddress;
}
