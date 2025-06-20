package com.bank.cards.dto;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
@Schema(
    name = "Error Response",
    description = "Schema to hold error response information"
    )
public class ErrorResponseDto {

    @Schema(
    description = "API path invoked by client"
    )
    private String apiPath;

    @Schema(
    description = "Error code representing the error happend"
    )
    private HttpStatus errorCode;

    @Schema(
    description = "Error message representing the error happend"
    )
    private String errorMsg;

    @Schema(
    description = "Time representing when error happend"
    )
    private LocalDateTime errorTime;
}