package com.xiong.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RoundRobinRule;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import com.xiong.UserFeign;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * Created with IDEA
 * Date:2020/9/7
 * Time:20:57
 */
@RestController
public class RibbonController {

    @Resource
    RestTemplate restTemplate;

    private static final String URL="http://user-center";

    @Autowired
    UserFeign userFeign;

    @Bean
    public IRule iRule(){
        return  new RoundRobinRule();
    }

    @ApiOperation(value = "ribbon使用实例")
    @PostMapping("/getFromUser")
    public String queryFromUser(){
        String str = restTemplate.getForObject(URL+ "/queryDefaultUser", String.class);
        return str;
    }

    @ApiOperation(value = "ribbon使用feign")
    @PostMapping("/getFromUserFeign")
    public String getFromUserFeign(){
        String str = userFeign.queryDefaultUser();
        return str;
    }

    // hystrix 限流降级
    @ApiOperation(value = "ribbon使用hystrix")
    @PostMapping("/queryFromUserFeignWithFeignBack")
    @HystrixCommand(fallbackMethod ="queryFromUserFeignBackWithStr", threadPoolKey = "xianliu",
            threadPoolProperties ={@HystrixProperty(name = "coreSize",value = "5")
            })
    public String queryFromUserFeignWithFeignBack() throws InterruptedException {
        String str = userFeign.queryDefaultUser();
//        int i =1/0;
        Thread.sleep(2*1000);
        return str;
    }

    public String  queryFromUserFeignBackWithStr(){
        return new String("系统正在维护中,请稍后重试");
    }


}
