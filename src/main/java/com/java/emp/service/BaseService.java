package com.java.emp.service;

import java.util.List;
import java.util.Map;

/**
 * @author: tmyue
 * @date: 2020/5/23 22:22
 */
public interface BaseService<T> {

    /**
     * 分页条件查询所有
     * @param page 当前页
     * @param limit 每页展示大小
     * @param t 条件
     * @return 数据
     */
    Map<String,Object> selWherePageAll(Integer page, Integer limit, T t) throws Exception;

    /**
     * 查询所有信息
     * @return
     */
    List<T> selAll() throws Exception;
}
