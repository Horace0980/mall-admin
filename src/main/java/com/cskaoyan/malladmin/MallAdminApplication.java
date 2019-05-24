package com.cskaoyan.malladmin;

import com.github.pagehelper.PageHelper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Properties;

@SpringBootApplication
@MapperScan("com.cskaoyan.malladmin.mapper")
public class MallAdminApplication {

	public static void main(String[] args) {
		SpringApplication.run(MallAdminApplication.class, args);
	}



}
