package com.sisipapa.userservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

// IDE내에서 application port를 변경해서 실행하는 방법
// terminal에서 mvn spring-boot:run -Dspring-boot.run.jvmArgumennts='-Dserver.port=9003'
// java -jar -Dserver.port=9004 ./target/user-service-0.0.1-SNAPSHOT.jar
@SpringBootApplication
@EnableDiscoveryClient
public class UserServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserServiceApplication.class, args);
    }

}
