package ru.afanasyev.moviematch.fw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication(scanBasePackages = "ru.afanasyev.moviematch")
public class MovieMatchApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(MovieMatchApplication.class, args);
    }
}