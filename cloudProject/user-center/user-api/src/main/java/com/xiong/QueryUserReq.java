package com.xiong;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import sun.invoke.util.VerifyAccess;

import java.io.Serializable;

/**
 * Created with IDEA
 * Date:2020/9/7
 * Time:20:05
 */
@Data
public class QueryUserReq implements Serializable {

    @ApiModelProperty(value = "编号")
    private Long id;
    @ApiModelProperty(value = "名称")
    private String name;

}
