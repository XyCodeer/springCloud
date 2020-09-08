package com.xiong;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**  服务网关
 * Created with IDEA
 * Date:2020/9/8
 * Time:8:23
 */
@SpringBootApplication
/** 服务网关 **/
@EnableZuulProxy
public class GateWayZuul {

    public static void main(String[] args) {
        SpringApplication.run(GateWayZuul.class, args);
    }

}
