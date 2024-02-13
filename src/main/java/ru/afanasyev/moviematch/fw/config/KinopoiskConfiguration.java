package ru.afanasyev.fw.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

@Configuration
public class KinopoiskConfiguration {
    @Bean(name = "kinopoisk-tokens")
    public Deque<String> availableTokens(KinopoiskProperties properties) {
        return new ArrayDeque<>(properties.tokens);
    }

    @Component
    @ConfigurationProperties(prefix = "kinopoisk")
    @Getter
    @Setter
    public static class KinopoiskProperties {
        private List<String> tokens;
    }
}
