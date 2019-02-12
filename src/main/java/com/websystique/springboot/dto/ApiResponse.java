package com.websystique.springboot.dto;

import lombok.Data;

@Data
public class ApiResponse {
    private String status;
    private String description;
    private String subscriber_message;
}
