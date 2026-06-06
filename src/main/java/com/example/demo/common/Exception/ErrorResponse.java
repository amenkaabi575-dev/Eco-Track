package com.example.demo.common.Exception;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Map;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorResponse {

    private String message;
    private int statusCode;
    private LocalDateTime timestamp;
    private String path;
    private String errorCode;
    private Map<String,String> errors;


}
