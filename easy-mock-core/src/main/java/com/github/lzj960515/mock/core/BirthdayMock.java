package com.github.lzj960515.mock.core;

import java.lang.annotation.Annotation;
import java.time.ZoneId;

/**
 * Birthday mock
 *
 * @author Zijian Liao
 * @since 0.0.1
 */
public class BirthdayMock extends Mock {

    @Override
    public Object getMockData(Annotation annotation) {
        return faker.date().birthday().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }
}
