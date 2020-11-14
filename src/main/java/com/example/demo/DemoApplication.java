package com.example.demo;

import com.example.demo.service.ClockService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Date;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {

        // TODO - 00 : 코드 설명
        ConfigurableApplicationContext context = SpringApplication.run(DemoApplication.class, args);
        ClockService service = context.getBean(ClockService.class);
        Date date = service.fetchCurrentDate();

        System.out.println("-------------------------------" + date);
    }

}
