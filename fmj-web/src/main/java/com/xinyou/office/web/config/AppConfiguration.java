package com.xinyou.office.web.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @Description:
 * @author: jianfeng.zheng
 * @since: 2021/12/21 9:03 下午
 * @history: 1.2021/12/21 created by jianfeng.zheng
 */
@Configuration
@ConfigurationProperties(prefix = "app")
public class AppConfiguration {

    private String host;

    private String officeService;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getOfficeService() {
        return officeService;
    }

    public void setOfficeService(String officeService) {
        this.officeService = officeService;
    }
}
