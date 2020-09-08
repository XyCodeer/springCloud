package com.xiong.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

/**
 * Created with IDEA
 * Date:2020/9/7
 * Time:20:24
 */
@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private Long id;

    private String name;

    private Integer age;

    private String password;

}
