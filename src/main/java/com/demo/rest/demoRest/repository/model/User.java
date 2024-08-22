package com.demo.rest.demoRest.repository.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private UUID userUid;
    private String name;
    private Integer age;
    private LocalDate createdAt;
    private String sensitiveInformation;
}
