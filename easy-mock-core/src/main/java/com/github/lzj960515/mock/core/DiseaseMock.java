package com.github.lzj960515.mock.core;

import java.lang.annotation.Annotation;

/**
 * 疾病
 *
 * @author Zijian Liao
 * @since 0.0.1
 */
public class DiseaseMock extends Mock {
    @Override
    public Object getMockData(Annotation annotation) {
        return faker.medical().diseaseName();
    }
}
