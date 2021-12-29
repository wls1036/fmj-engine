package com.xinyou.office.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @Description:
 * @author: jianfeng.zheng
 * @since: 2021/10/20 8:11 下午
 * @history: 1.2021/10/20 created by jianfeng.zheng
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.definesys.*","com.xinyou.office.web.*"})
public class OfficeWebAppliaction extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(OfficeWebAppliaction.class);
    }

    /**
     * 解决跨域问题
     *
     * @return
     */
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedHeaders("*")
                        .allowedOrigins("*")
                        .allowCredentials(true);
            }
        };
    }
}
