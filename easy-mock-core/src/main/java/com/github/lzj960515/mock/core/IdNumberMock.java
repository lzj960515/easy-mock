package com.github.lzj960515.mock.core;

import java.lang.annotation.Annotation;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

/**
 * idNumber mock
 *
 * @author Zijian Liao
 * @since 0.0.1
 */
public class IdNumberMock extends Mock {

    private static String SUFFIX = "500233";

    @Override
    public Object getMockData(Annotation annotation) {
        return SUFFIX + faker.date().birthday().toInstant().atZone(ZoneId.systemDefault()).toLocalDate().format(DateTimeFormatter.ofPattern("yyyyMMdd")) + faker.number().numberBetween(1000, 9999);
    }
}
