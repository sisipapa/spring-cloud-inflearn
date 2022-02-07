package com.sisipapa.userservice.dto;

import com.sisipapa.userservice.vo.ResponseOrder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

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

    private List<ResponseOrder> orders;
}
