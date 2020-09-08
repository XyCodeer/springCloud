package com.xiong;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created with IDEA
 * Date:2020/9/7
 * Time:23:02
 */
@FeignClient("user-center")
public interface UserFeign {

    @PostMapping("/getUser")
    public String queryUser(@RequestBody QueryUserReq queryUserReq);

    @PostMapping("/queryDefaultUser")
    public String queryDefaultUser();

}
