package com.demo.rest.demoRest.service.dto;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {
    private String name;
    private Integer age;
    private String sensitiveInformation;
}
