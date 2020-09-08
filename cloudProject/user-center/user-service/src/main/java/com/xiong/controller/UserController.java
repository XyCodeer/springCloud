package com.xiong.controller;

import com.xiong.QueryUserReq;
import com.xiong.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IDEA
 * Date:2020/9/7
 * Time:20:19
 */
@Api(value = "用户管理Api")
@RestController
public class UserController {

    Map<Long,User> userMap;

    @PostConstruct
    public void init(){
        userMap = new HashMap<>();
        userMap.put(1L, User.builder().name("yx").age(20).build());
        userMap.put(2L, User.builder().name("qa").age(30).build());
        userMap.put(3L, User.builder().name("cd").age(40).build());
    }

    @ApiOperation(value = "用户查询")
    @PostMapping("/getUser")
    public String queryUser(@RequestBody QueryUserReq queryUserReq){
        User user = userMap.get(queryUserReq.getId());
        return user.toString();
    }

    @ApiOperation(value = "用户查询默认")
    @GetMapping("/queryDefaultUser")
    public String queryDefaultUser(){
        User user = userMap.get(1L);
        return user.toString();
    }


}
