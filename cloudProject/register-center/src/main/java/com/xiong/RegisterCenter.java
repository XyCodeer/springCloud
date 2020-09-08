package com.xiong;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;


/**  springCloud 注册中心
 * Created with IDEA
 * Date:2020/9/7
 * Time:18:54
 */
@EnableEurekaServer
@SpringBootApplication
public class RegisterCenter {

    public static void main(String[] args) {
        SpringApplication.run(RegisterCenter.class, args);
    }

}
