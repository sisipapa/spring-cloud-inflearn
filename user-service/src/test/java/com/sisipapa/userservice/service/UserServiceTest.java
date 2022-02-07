package com.sisipapa.userservice.service;

import com.sisipapa.userservice.dto.UserDto;
import com.sisipapa.userservice.jpa.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

//@Import(WebSecurity.class)
//@ExtendWith(MockitoExtension.class)
@SpringBootTest
class UserServiceTest {
//    @Mock
    @Autowired
    UserRepository userRepository;

//    @InjectMocks
    @Autowired
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

        // when
        UserDto resultUserDto = userService.createUser(mockUserDto);

        // then
        assertThat(mockUserDto.getEmail()).isEqualTo(resultUserDto.getEmail());
        assertThat(mockUserDto.getName()).isEqualTo(resultUserDto.getName());
        assertThat(resultUserDto.getUserId()).isNotNull();
        assertThat(resultUserDto.getEncryptedPwd()).isNotNull();
    }

    @Test
    void getUserByUserId() {
    }

    @Test
    void getUserByAll() {
    }
}