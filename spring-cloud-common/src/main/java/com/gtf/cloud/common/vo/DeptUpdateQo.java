package com.gtf.cloud.common.vo;

import lombok.Data;
import lombok.ToString;

/**
 * TODO
 *
 * @author : GTF
 * @version : 1.0
 * @date : 2022/8/17 18:09
 */
@Data
@ToString
public class DeptUpdateQo {

    private Long deptId;

    private String deptDesc;

    private String deptName;
}
