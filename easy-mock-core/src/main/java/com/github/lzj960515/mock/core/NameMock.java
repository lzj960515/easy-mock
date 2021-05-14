package com.github.lzj960515.mock.core;

import java.lang.annotation.Annotation;

/**
 * 名字 mock
 *
 * @author Zijian Liao
 * @since 0.0.1
 */
public class NameMock extends Mock {

    @Override
    public Object getMockData(Annotation annotation) {
        return faker.name().fullName();
    }
}
