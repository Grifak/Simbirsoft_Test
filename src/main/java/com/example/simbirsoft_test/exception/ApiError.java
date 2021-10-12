package com.example.simbirsoft_test.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.sql.Timestamp;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ApiError {
    private Timestamp timestamp;
    private HttpStatus status;
    private String debugMessage;
}
