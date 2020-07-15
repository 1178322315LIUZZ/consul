package com.bw;

import com.bw.controller.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({Student.class})
public class Startsa {
    public static void main(String[] args) {
        SpringApplication.run(Startsa.class);
    }
}
