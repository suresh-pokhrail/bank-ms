package com.bank.loan.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
@Schema(
    name = "Response",
    description = "Schema to hold successfull response information"
    )
public class ResponseDto {

    @Schema(
    description = "Status Code of response"
    )
    private String statusCode;
    @Schema(
        description = "Status Message of response"
    )
    private String statusMsg;
}