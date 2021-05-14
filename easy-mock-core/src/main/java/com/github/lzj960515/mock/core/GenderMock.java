package com.github.lzj960515.mock.core;

import com.github.lzj960515.mock.annotation.Gender;

import java.lang.annotation.Annotation;
import java.util.Random;

/**
 * gender mock
 *
 * @author Zijian Liao
 * @since 0.0.1
 */
public class GenderMock extends Mock {

    Random random = new Random();

    @Override
    public Object getMockData(Annotation annotation) {
        Gender gender = (Gender) annotation;
        return random.nextInt(2) == 0 ? gender.man() : gender.female();
    }
}
