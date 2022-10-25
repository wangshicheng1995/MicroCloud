package com.echo.test;

import com.echo.common.dto.DeptDTO;
import com.echo.common.util.DeepBeanUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author echo
 * @version 1.0
 * @date 2022/10/25 12:53
 */
public class testCopy {
    public static void main(String[] args) {
        List<DeptDTO> sources = new ArrayList<>();
        for (int x = 0; x < 10; x++) {  // 循环生成数据
            DeptDTO deptDTO = new DeptDTO();
            deptDTO.setDeptno(10L + x);
            deptDTO.setDname("学习 Spring Cloud Alibaba - " + x);
            deptDTO.setLoc("上海");
            sources.add(deptDTO);
        }
        List<DeptDTO> copy = DeepBeanUtils.copyListProperties(sources, DeptDTO::new);
        System.out.println(copy);
    }
}
