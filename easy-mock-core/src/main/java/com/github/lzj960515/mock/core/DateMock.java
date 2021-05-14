package com.github.lzj960515.mock.core;

import java.lang.annotation.Annotation;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * date mock
 *
 * @author Zijian Liao
 * @since 0.0.1
 */
public class DateMock extends Mock {

    @Override
    public Object getMockData(Annotation annotation) {
        return LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }
}
