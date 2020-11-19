package org.effective.guava;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;


/**
 * @author 6c6763
 * @date 2020/11/18
 */
public class OptionalAction {
    private static final Logger logger = LoggerFactory.getLogger(OptionalAction.class);

    public static void main(String[] args) {
        optional();
    }

    private static void optional() {
        logger.info("isPresent:{}", Optional.empty().isPresent());
        com.google.common.base.Optional<Object> optional = com.google.common.base.Optional.of(new Object());
    }
}
