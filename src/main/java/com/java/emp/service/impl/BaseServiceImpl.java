package com.java.emp.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.java.emp.mapper.BaseMapper;
import com.java.emp.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: tmyue
 * @date: 2020/5/23 22:23
 */
public class BaseServiceImpl<T> implements BaseService<T> {

    //自动依赖注入
    @Autowired
    private BaseMapper<T> baseMapper;

    @Override
    public Map<String, Object> selWherePageAll(Integer page, Integer limit, T t) throws Exception {
        //开启分页
        PageHelper.startPage(page,limit);
        //创建获取数据
        PageInfo<T> queryResult = new PageInfo<>(baseMapper.selWherePageAll(t));
        //装入Map集合
        HashMap<String, Object> map = new HashMap<>();
        map.put("data",queryResult.getList());  //数据
        map.put("count",queryResult.getTotal()); //总条数
        return map;
    }

    @Override
    public List<T> selAll() throws Exception {
        return baseMapper.selAll();
    }
}
