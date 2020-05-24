package com.java.emp.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author: tmyue
 * @date: 2020/5/23 21:44
 */
public interface BaseMapper<T> {
    int deleteByPrimaryKey(Integer empno);

    int insert(T t);

    int insertSelective(T t);

    T selectByPrimaryKey(Integer empno);

    int updateByPrimaryKeySelective(T t);

    int updateByPrimaryKey(T t);

    /**
     * 分页条件查询所有
     * @param t 条件
     * @return 数据
     */
    List<T> selWherePageAll(@Param("t") T t) throws Exception;

    /**
     * 查询所有信息
     * @return
     */
    List<T> selAll() throws Exception;
}
