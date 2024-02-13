package ru.afanasyev.app.impl.beanmanagement;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Управление бинами Spring: Order
 */
@Component
@Order(value = Ordered.HIGHEST_PRECEDENCE)
@Slf4j
public class FirstOrderValidator implements Validator {
    @Override
    public void validate(Object target) {
        if (target != null) {
            log.info("First order validation for {} passed", target);
        }
    }
}
