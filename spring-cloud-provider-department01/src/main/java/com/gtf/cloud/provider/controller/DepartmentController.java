package com.gtf.cloud.provider.controller;

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
@RequestMapping("/v1/department")
@RefreshScope
public class DepartmentController {

    @Value("${nacos.provider.key}")
    private String key;

    @Value("${nacos.provider.value}")
    private String value;

    @GetMapping
    public String getDepartment(HttpServletRequest request){
        String authorization = request.getHeader("authorization");
        log.error("authorization is {}", authorization);
        log.error("key is {},value is {}",key,value);
        return "department-01-" + authorization + "key is " + key + "value is " + value;
    }
}
