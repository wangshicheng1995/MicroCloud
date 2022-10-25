package com.echo.service;

import com.echo.common.dto.DeptDTO;

import java.util.List;
import java.util.Map;

// 业务接口
public interface IDeptService {

    /**
     * 根据部门编号获取部门的完整信息
     *
     * @param id 要查询的部门编号
     * @return 编号存在则返回 DTO 对象，不存在则返回 null
     */
    public DeptDTO get(long id);

    /**
     * 增加部门对象
     *
     * @param dto 保存要增加部门的详细数据
     * @return 增加成功则返回 true，否则返回 false
     */
    public boolean add(DeptDTO dto);

    /**
     * 列出所有的部门信息
     *
     * @return 全部数据的集合，如果没有任何的集合数据则集合为空（size() == 0）
     */
    public List<DeptDTO> list();

    /**
     * 部门分页
     * @param currentPage 当前所在页
     * @param lineSize 每页加载的数据行数
     * @param column 模糊查询的数据列
     * @param keyword 模糊查询的关键字
     * @return 部门集合数据以及统计数据，返回的数据项包括：
     * 1、key = allDepts value = List 集合（部门的全部数据对象）
     * 2、key = allRecorders value = 总记录数
     * 3、key = allPages value = 页数
     */
    public Map<String, Object> split(int currentPage, int lineSize, String column, String keyword);
}
