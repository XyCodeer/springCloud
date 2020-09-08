package com.xiong;

import com.xiong.config.RestTemplateConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.client.RestTemplate;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created with IDEA
 * Date:2020/9/7
 * Time:20:56
 */
@SpringBootApplication
@EnableEurekaClient
@EnableSwagger2
@EnableFeignClients
//@RibbonClients({
//        @RibbonClient(name = "user-client", configuration = RestTemplateConfig.class)
//})
// 开启服务限流降级
@EnableHystrix
public class RibbonCenter {

    public static void main(String[] args) {
        SpringApplication.run(RibbonCenter.class, args);
    }

}
