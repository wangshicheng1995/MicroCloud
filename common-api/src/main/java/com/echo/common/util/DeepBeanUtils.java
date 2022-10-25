package com.echo.common.util;

import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

/**
 * 扩充已有的 Bean 工具类
 * @author echo
 * @version 1.0
 * @date 2022/10/25 12:42
 */
public class DeepBeanUtils extends BeanUtils {
    private DeepBeanUtils() {}

    /**
     * 实现 List 集合对象拷贝
     * @param sources 原始对象集合
     * @param target 目标对象集合
     * @param <S> 源对象类型
     * @param <T> 目标对象类型
     * @return 拷贝后的 List 集合
     */
    public static <S, T> List<T> copyListProperties(List<S> sources, Supplier<T> target) {
        List<T> list = new ArrayList<>(sources.size());
        for (S source : sources) {
            T obj = target.get();   // 获取数据
            copyProperties(source, obj);    // 由父类提供的拷贝方法
            list.add(obj);
        }
        return list;
    }
}
