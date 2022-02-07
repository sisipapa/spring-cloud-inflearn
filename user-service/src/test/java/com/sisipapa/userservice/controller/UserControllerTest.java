package com.sisipapa.userservice.controller;

import com.sisipapa.userservice.dto.UserDto;
import com.sisipapa.userservice.service.UserService;
import com.sisipapa.userservice.vo.RequestUser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@WebMvcTest(UserController.class)
class UserControllerTest {

    @Autowired
    MockMvc mvc;

    @Autowired
    Environment env;

    @MockBean
    UserService userService;

    @BeforeEach
    void setUp() {
    }

    @Test
    void status() throws Exception {
        // given
        String returnMessage = "It's Working in User Service.";

        // when
        final ResultActions actions =
                mvc.perform(get("/health_check"));
        // then
        actions
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(content().string(returnMessage))
                .andDo(print());
    }

    @Test
    void welcome() throws Exception {
        // given
        String returnMessage = env.getProperty("greeting.message");

        // when
        final ResultActions actions =
                mvc.perform(get("/welcome"));
        // then
        actions
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(content().string(returnMessage))
                .andDo(print());
    }

    @Test
    void createUser() throws Exception {
        // given
        RequestUser mockRequestUser = RequestUser.builder().email("test3@test.com").name("테스터3").pwd("test3!@#$").build();
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        UserDto userDto = mapper.map(mockRequestUser, UserDto.class);
        when(userService.createUser(userDto)).thenReturn(userDto);

        // when
        final ResultActions actions =
                mvc.perform(post("/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .characterEncoding("UTF-8")
                        .content("{" +
                                    "\"email\" : \"test3@test.com\"," +
                                    "\"name\" : \"테스터3\"," +
                                    "\"pwd\" : \"test3!@#$\"" +
                                "}"));
        // then
        actions
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(jsonPath("email").value("test3@test.com"))
                .andExpect(jsonPath("name").value("테스터3"))
                .andDo(print());
    }
}