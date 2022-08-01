package com.gtf.cloud.consumer.client.hystrix;

import com.gtf.cloud.consumer.client.DepartmentFeignClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * 部门请求熔断器
 *
 * @author : GTF
 * @version : 1.0
 * @date : 2022/6/28 16:15
 */
@Slf4j
@Component
public class DepartmentHystrix implements FallbackFactory<DepartmentFeignClient> {

    @Override
    public DepartmentFeignClient create(Throwable cause) {
        log.error("user02服务降级了!请稍后重试!");
        return () -> "user02-服务降级了!请稍后重试!";
    }
}
