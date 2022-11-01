package com.echo.consumer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * 实现 RestTemplate 的相关配置
 * @author echo
 * @version 1.0
 * @date 2022/10/26 15:47
 */
@Configuration
public class RestTemplateConfig {
    @Bean // 向 Spring 容器之中进行 Bean 注册
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
