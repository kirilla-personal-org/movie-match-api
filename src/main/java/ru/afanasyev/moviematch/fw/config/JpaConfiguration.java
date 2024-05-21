package ru.afanasyev.moviematch.fw.config;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = {"ru.afanasyev.moviematch.adapter"})
@EntityScan(basePackages = "ru.afanasyev.moviematch.domain")
public class JpaConfiguration {
}
