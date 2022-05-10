package com.ynu.lossfound;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@MapperScan("com.ynu.lossfound.mapper")
@SpringBootApplication
public class LossFoundApplication {

    public static void main(String[] args) {
        SpringApplication.run(LossFoundApplication.class, args);
    }

}
