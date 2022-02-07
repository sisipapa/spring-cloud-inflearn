package com.sisipapa.userservice.controller;

import com.sisipapa.userservice.dto.UserDto;
import com.sisipapa.userservice.service.UserService;
import com.sisipapa.userservice.vo.RequestUser;
import com.sisipapa.userservice.vo.ResponseUser;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/")
@RestController
public class UserController {

    private final Environment env;
    private final UserService userService;

    @GetMapping("/user-service/health_check")
    public String status(){
        return String.format("It's Working in User Service on PORT %s", env.getProperty("local.server.port"));
    }

    @GetMapping("/user-service/welcome")
    public String welcome(){
        return env.getProperty("greeting.message");
    }

    @PostMapping("/user-service/users")
    public ResponseEntity createUser(@RequestBody RequestUser user){

        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        UserDto userDto = mapper.map(user, UserDto.class);
        userService.createUser(userDto);

        ResponseUser responseUser = mapper.map(userDto, ResponseUser.class);

        return ResponseEntity.status(HttpStatus.CREATED).body(responseUser);
    }

}
