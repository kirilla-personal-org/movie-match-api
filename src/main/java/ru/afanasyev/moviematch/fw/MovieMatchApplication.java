package ru.afanasyev.moviematch.fw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import ru.afanasyev.visualizer.starter.AutoBeanVisualizationConfig;

@SpringBootApplication
@EnableScheduling
public class MovieMatchApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(MovieMatchApplication.class, args);
        System.out.println(context.getBean(AutoBeanVisualizationConfig.class));
    }
}