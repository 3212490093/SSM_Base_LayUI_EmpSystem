package com.java.emp.mapper;

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
}
