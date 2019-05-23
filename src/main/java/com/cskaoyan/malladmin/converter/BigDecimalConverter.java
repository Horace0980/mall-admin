package com.cskaoyan.malladmin.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * @Author: yyc
 * @Date: 2019/5/22 22:40
 */
@Component
public class BigDecimalConverter implements Converter<String, BigDecimal> {
    @Override
    public BigDecimal convert(String s) {
        return new BigDecimal(s);
    }
}
