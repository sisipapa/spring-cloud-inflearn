package com.sisipapa.userservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private String email;
    private String pwd;
    private String name;
    private String userId;
    private LocalDate createdAt;

    private String encryptedPwd;
}
