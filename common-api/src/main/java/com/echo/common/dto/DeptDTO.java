package com.echo.common.dto;

import java.io.Serializable;

/**
 * 该类主要实现部门数据结构的映射，实现数据的远程传输
 *
 * @author echo
 * @version 1.0
 * @date 2022/10/24 23:24
 */
public class DeptDTO implements Serializable {  // 定义数据传输类
    private Long deptno;    // 部门编号
    private String dname;   // 部门名称
    private String loc;     // 部门位置

    @Override
    public String toString() {
        return "DeptDTO{" +
                "deptno=" + deptno +
                ", dname='" + dname + '\'' +
                ", loc='" + loc + '\'' +
                '}';
    }

    public DeptDTO() {
    }

    public DeptDTO(String dname, String loc) {
        this.deptno = null;
        this.dname = dname;
        this.loc = loc;
    }

    public Long getDeptno() {
        return deptno;
    }

    public void setDeptno(Long deptno) {
        this.deptno = deptno;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }
}
