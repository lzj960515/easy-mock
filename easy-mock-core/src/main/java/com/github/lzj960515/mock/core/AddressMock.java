package com.github.lzj960515.mock.core;

import java.lang.annotation.Annotation;

/**
 * address mock
 *
 * @author Zijian Liao
 * @since 0.0.1
 */
public class AddressMock extends Mock {

    @Override
    public Object getMockData(Annotation annotation) {
        return faker.address().cityName() + faker.address().streetAddress();
    }
}
