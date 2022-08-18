package com.gtf.cloud.consumer.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gtf.cloud.common.vo.DeptUpdateQo;
import com.gtf.cloud.common.vo.EmployeeUpdateQo;
import com.gtf.cloud.consumer.client.DepartmentFeignClient;
import com.gtf.cloud.consumer.po.Employee;
import com.gtf.cloud.consumer.service.EmployeeService;
import com.gtf.cloud.consumer.mapper.EmployeeMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 *
 * @author GTF
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee>
    implements EmployeeService{

    private final DepartmentFeignClient departmentFeignClient;

    private final EmployeeMapper employeeMapper;

    @Override
    public void updateEmployee(EmployeeUpdateQo qo) {
        Employee employee = new Employee();
        employee.setId(qo.getEmployeeId());
        employee.setEmployeeName(qo.getEmployeeName());
        employee.setEmployeeDesc(qo.getEmployeeDesc());
        employeeMapper.updateById(employee);

        DeptUpdateQo deptUpdateQo = new DeptUpdateQo();
        deptUpdateQo.setDeptId(qo.getDeptId());
        deptUpdateQo.setDeptName(qo.getDeptName());
        deptUpdateQo.setDeptDesc(qo.getDeptDesc());
        departmentFeignClient.updateDept(deptUpdateQo);
    }
}




