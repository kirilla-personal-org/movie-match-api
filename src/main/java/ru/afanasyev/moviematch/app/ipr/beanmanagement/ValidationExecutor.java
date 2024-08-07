package ru.afanasyev.moviematch.app.ipr.beanmanagement;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Управление бинами Spring: Order
 */
@Component
@RequiredArgsConstructor
public class ValidationExecutor {
    private final List<Validator> validators;

    public void validate(Object target) {
        validators.forEach(validator -> validator.validate(target));
    }
}
