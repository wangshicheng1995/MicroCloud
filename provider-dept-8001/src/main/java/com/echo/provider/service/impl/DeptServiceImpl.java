package com.echo.provider.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.echo.common.dto.DeptDTO;
import com.echo.common.util.DeepBeanUtils;
import com.echo.provider.dao.IDeptDAO;
import com.echo.provider.vo.Dept;
import com.echo.service.IDeptService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author echo
 * @version 1.0
 * @date 2022/10/25 19:13
 */
@Service
public class DeptServiceImpl implements IDeptService {

    @Autowired
    private IDeptDAO deptDAO;

    @Override
    public DeptDTO get(long id) {
        DeptDTO dto = new DeptDTO(); // 实例化传输对象
        // 在本地端通过了 VO 类实现类数据的加载，随后将此数据拷贝到 DTO 对象之中
        BeanUtils.copyProperties(deptDAO.selectById(id), dto); // 属性拷贝
        return dto;
    }

    @Override
    public boolean add(DeptDTO dto) {
        Dept dept = new Dept();
        BeanUtils.copyProperties(dto, dept);
        return deptDAO.insert(dept) > 0;
    }

    @Override
    public List<DeptDTO> list() {
        QueryWrapper<Dept> wrapper = new QueryWrapper<>();
        return DeepBeanUtils.copyListProperties(
                deptDAO.selectList(wrapper), DeptDTO::new); // 集合数据拷贝
    }

    @Override
    public Map<String, Object> page(int currentPage, int lineSize, String column, String keyword) {
        QueryWrapper<Dept> wrapper = new QueryWrapper<>();
        wrapper.like(column, keyword); // 设置模糊查询
        int count = deptDAO.selectCount(wrapper);
        // 实现数据的查询处理
        IPage<Dept> page = deptDAO.selectPage(new Page<>(currentPage, lineSize, count), wrapper);
        Map<String, Object> map = new HashMap<>();  // 包装返回结果
        map.put("allDepts", DeepBeanUtils.copyListProperties(page.getRecords(), DeptDTO::new));
        map.put("allRecorders", page.getTotal());
        map.put("allPages", page.getPages());
        return map;
    }
}
