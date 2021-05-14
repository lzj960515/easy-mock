package com.github.lzj960515.mock.core;

import java.lang.annotation.Annotation;
import java.util.Random;

/**
 * 默认mock
 *
 * @author Zijian Liao
 * @since 0.0.1
 */
public class DefaultMock extends Mock {

    Random random = new Random();

    String letter = "abcdefghijklmnopqrstuvwxyz";

    @Override
    public Object getMockData(Annotation annotation) {
        int start = random.nextInt(10);
        int end = random.nextInt(16) + 11;
        return letter.substring(start, end);
    }
}
