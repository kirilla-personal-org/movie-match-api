package ru.afanasyev.moviematch.fw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(scanBasePackages = "ru.afanasyev.moviematch")
@EnableScheduling
public class MovieMatchApplication {
    public static void main(String[] args) {
        SpringApplication.run(MovieMatchApplication.class, args);
    }
}