package com.github.lzj960515.mock.core;

import com.github.javafaker.Faker;

import java.lang.annotation.Annotation;
import java.util.Locale;

/**
 * mock 接口
 *
 * @author Zijian Liao
 * @since 0.0.1
 */
public abstract class Mock {

    protected Faker faker = Faker.instance(Locale.CHINA);

    /**
     * 获取mock数据
     * @param annotation 注解
     * @return mock数据
     */
    public abstract Object getMockData(Annotation annotation);
}
