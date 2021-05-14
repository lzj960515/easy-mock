package com.github.lzj960515.mock.core;

import com.github.lzj960515.mock.annotation.Age;

import java.lang.annotation.Annotation;

/**
 * age mock
 *
 * @author Zijian Liao
 * @since 0.0.1
 */
public class AgeMock extends Mock {

    @Override
    public Object getMockData(Annotation annotation) {
        return faker.number().numberBetween(0, 100);
    }
}
