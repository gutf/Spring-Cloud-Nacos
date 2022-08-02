package com.gtf.cloud.consumer.controller;

import com.gtf.cloud.consumer.client.DepartmentFeignClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * 用户信息控制器
 *
 * @author : GTF
 * @version : 1.0
 * @date : 2022/6/28 15:05
 */
@Slf4j
@RestController
@RequestMapping("/v1/user")
@RequiredArgsConstructor
@RefreshScope
public class UserController {

    @Value("${nacos.consumer.key}")
    private String key;

    @Value("${nacos.consumer.value}")
    private String value;

    @Value("${server.port}")
    private String port;

    private final DepartmentFeignClient departmentFeignClient;

    @GetMapping
    public String getUser(HttpServletRequest request){
        log.error(port);
        String department = departmentFeignClient.getDepartment();
        log.error("key is {},value is {}",key,value);
        return new StringBuilder("user-").append(port).append("-").append(department).toString();
    }
}
