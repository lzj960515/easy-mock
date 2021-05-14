package com.github.lzj960515.mock.core;

import java.io.UnsupportedEncodingException;
import java.lang.annotation.Annotation;
import java.nio.charset.StandardCharsets;
import java.util.Random;

/**
 * address mock
 *
 * @author Zijian Liao
 * @since 0.0.1
 */
public class ChineseMock extends Mock {
    Random random = new Random();

    @Override
    public Object getMockData(Annotation annotation) {
        int i = random.nextInt(10);
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < i; j++) {
            sb.append(getChinese());
        }
        return sb.toString();
    }

    private String getChinese(){
        // B0 + 0~39(16~55) 一级汉字所占区
        int highCode = (176 + random.nextInt(39));
        // A1 + 0~93 每区有94个汉字
        int lowCode = (161 + random.nextInt(93));
        byte[] b = new byte[2];
        b[0] = (Integer.valueOf(highCode)).byteValue();
        b[1] = (Integer.valueOf(lowCode)).byteValue();
        try {
            return new String(new String(b, "GBK").getBytes(), StandardCharsets.UTF_8);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "str";
    }
}
