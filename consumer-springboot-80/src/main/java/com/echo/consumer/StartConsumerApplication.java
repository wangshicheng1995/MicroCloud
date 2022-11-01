package com.echo.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author echo
 * @version 1.0
 * @date 2022/10/26 19:17
 */
@SpringBootApplication
//@EnableDiscoveryClient
//// 如果此时要有多个配置项，可以使用@RibbonClients注解，该注解可以配置多个@RibbonClient
//@RibbonClient(name = "dept.provider", configuration = DeptProviderRibbonConfig.class) // 自定义Ribbon配置
//@ComponentScan({"com.yootk.service", "com.yootk.consumer"})
//@EnableFeignClients(basePackages = {"com.yootk.service"}, defaultConfiguration = FeignConfig.class) // Feign扫描包
public class StartConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(StartConsumerApplication.class, args);
    }
}
