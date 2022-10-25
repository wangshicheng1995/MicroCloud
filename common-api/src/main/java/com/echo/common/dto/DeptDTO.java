package com.echo.common.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * 该类主要实现部门数据结构的映射，实现数据的远程传输
 * @author echo
 * @version 1.0
 * @date 2022/10/24 23:24
 */
@Data
public class DeptDTO implements Serializable {  // 定义数据传输类
    private Long deptno;    // 部门编号
    private String dname;   // 部门名称
    private String loc;     // 部门位置
}
