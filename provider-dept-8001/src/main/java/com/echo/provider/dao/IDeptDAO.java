package com.echo.provider.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.echo.provider.vo.Dept;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IDeptDAO extends BaseMapper<Dept> {
}
