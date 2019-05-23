package com.cskaoyan.malladmin.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Arrays;

/**
 * @Author: yyc
 * @Date: 2019/5/22 22:40
 */
@Component
public class StringArraysConverter implements Converter<String[], String> {

    @Override
    public String convert(String[] strings) {
        return Arrays.toString(strings);
    }
}
