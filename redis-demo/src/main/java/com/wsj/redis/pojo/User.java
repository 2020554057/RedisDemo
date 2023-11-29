package com.wsj.redis.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ClassName:User
 * Package:IntelliJ IDEA
 * Description:
 *
 * @Author 吴苏杰
 * @Create 2023/11/29 10:00
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String name;
    private Integer age;

}
