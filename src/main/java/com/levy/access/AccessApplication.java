package com.levy.access;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author levy
 * @date 2020/12/2
 */
@SpringBootApplication(scanBasePackages = {"com.levy.access"})
@Configuration
@EnableSwagger2
@MapperScan("com.levy.access.mapper")
public class AccessApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccessApplication.class, args);
    }

}
