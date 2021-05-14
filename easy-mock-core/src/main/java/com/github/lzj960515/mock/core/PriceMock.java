package com.github.lzj960515.mock.core;

import java.lang.annotation.Annotation;

/**
 * Price mock
 *
 * @author Zijian Liao
 * @since 0.0.1
 */
public class PriceMock extends Mock {
    @Override
    public Object getMockData(Annotation annotation) {
        return faker.commerce().price();
    }
}
