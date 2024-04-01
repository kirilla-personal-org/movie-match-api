package ru.afanasyev.moviematch.app.impl.beanmanagement;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Управление бинами Spring: Order
 */
@Component
@Order(value = Ordered.LOWEST_PRECEDENCE)
@Slf4j
public class LastOrderValidator implements Validator {
    @Override
    public void validate(Object target) {
        if (target instanceof String) {
            log.info("Last order validation for {} passed", target);
        }
    }
}
