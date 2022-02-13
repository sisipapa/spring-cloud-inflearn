package com.sisipapa.userservice.service;

import com.sisipapa.userservice.dto.UserDto;
import com.sisipapa.userservice.jpa.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

//@Import(WebSecurity.class)
@ExtendWith(MockitoExtension.class)
//@SpringBootTest
class UserServiceTest {
//    @Mock
//    @Autowired
//    UserRepository userRepository;

    @Mock
//    @InjectMocks
//    @Autowired
    UserService userService;


    @BeforeEach
    void setUp() {
    }

    @Test
    void createUser() {
        // given
        UserDto mockUserDto = UserDto.builder()
                .email("test4@test.com")
                .name("테스터4")
                .pwd("test4!@#$").build();
        when(userService.createUser(mockUserDto)).thenReturn(mockUserDto);

        // when
        UserDto resultUserDto = userService.createUser(mockUserDto);

        // then
        assertThat(resultUserDto).isNotNull();
        assertThat(mockUserDto.getEmail()).isEqualTo(resultUserDto.getEmail());
        assertThat(mockUserDto.getName()).isEqualTo(resultUserDto.getName());
//        assertThat(resultUserDto.getUserId()).isNotNull();
//        assertThat(resultUserDto.getEncryptedPwd()).isNotNull();
    }

    @Test
    void getUserByUserId() {
        // given
        // when
        // then
    }

    @Test
    void getUserByAll() {
    }
}