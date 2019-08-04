package com.example.lzh.jvmtest;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@MapperScan(basePackages = "com.example.lzh.jvmtest.dao")
@SpringBootApplication
public class JvmTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(JvmTestApplication.class, args);
    }



//    extends SpringBootServletInitializer
    // 继承SpringBootServletInitializer 实现configure 方便打war 外部服务器部署。 extends SpringBootServletInitializer
//    @Override
//    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
//        return application.sources(JvmTestApplication.class);
//    }
}
