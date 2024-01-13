package com.example.diploma2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "com.example.diploma2") // Додайте цю аннотацію
@EnableJpaRepositories(basePackages = "com.example.diploma2") // Додайте цю аннотацію, якщо її немає
public class Diploma2Application {
    public static void main(String[] args) {
        SpringApplication.run(Diploma2Application.class, args);
    }
}
