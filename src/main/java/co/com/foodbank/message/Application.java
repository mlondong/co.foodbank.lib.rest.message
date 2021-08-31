package co.com.foodbank.message;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"co.com.foodbank.message", "co.com.foodbank.message.exception",
        "co.com.foodbank.message.repository",
        "co.com.foodbank.message.restcontroller",
        "co.com.foodbank.message.config", "co.com.foodbank.message.service",
        "co.com.foodbank.message.v1.controller",
        "co.com.foodbank.message.v1.model"})
@EnableAutoConfiguration(exclude = {ErrorMvcAutoConfiguration.class})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

    }

}
