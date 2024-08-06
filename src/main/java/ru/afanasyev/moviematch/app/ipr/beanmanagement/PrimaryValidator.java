package ru.afanasyev.moviematch.app.ipr.beanmanagement;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/**
 * Управление бинами Spring: Order
 */
@Component
@Slf4j
@Primary
public class PrimaryValidator implements Validator {
    @Override
    public void validate(Object target) {
        log.info("Primary validation for {} passed", target);
    }
}
