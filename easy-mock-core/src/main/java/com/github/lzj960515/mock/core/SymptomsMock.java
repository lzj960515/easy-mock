package com.github.lzj960515.mock.core;

import java.lang.annotation.Annotation;

/**
 * Symptoms mock
 *
 * @author Zijian Liao
 * @since 0.0.1
 */
public class SymptomsMock extends Mock {
    @Override
    public Object getMockData(Annotation annotation) {
        return faker.medical().symptoms();
    }
}
