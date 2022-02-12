package com.sisipapa.userservice.jpa;

import com.netflix.discovery.converters.Auto;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


//@DataJpaTest
@ExtendWith(MockitoExtension.class)
class UserRepositoryTest {

    private String uuid = UUID.randomUUID().toString();

    @Mock
//    @Autowired
    private UserRepository userRepository;

    @BeforeEach
    void setUp() {
        UserEntity userEntity = new UserEntity();
        userEntity.setName("테스트1");
        userEntity.setEmail("test1@test.com");
        userEntity.setEncryptedPwd("ecrtypt_pwd");
        userEntity.setUserId(uuid);
        userRepository.save(userEntity);
    }

    @Test
    void findByUserId(){
        // given
        UserEntity userEntity = new UserEntity();
        userEntity.setName("테스트1");
        userEntity.setEmail("test1@test.com");
        userEntity.setEncryptedPwd("ecrtypt_pwd");
        userEntity.setUserId(uuid);
        when(userRepository.findByUserId(uuid)).thenReturn(userEntity);
        // when
        final UserEntity resultUserEntity = userRepository.findByUserId(uuid);

        // then
        verify(userRepository, atLeastOnce()).findByUserId(uuid);
        assertThat(resultUserEntity.getEmail()).isEqualTo("test1@test.com");
        assertThat(resultUserEntity.getName()).isEqualTo("테스트1");
    }
}