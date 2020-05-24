package com.java.emp.controller;

import com.java.emp.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * @author: tmyue
 * @date: 2020/5/23 22:28
 */

public class BaseController<T> {

    //自动依赖注入
    @Autowired
    private BaseService<T> baseService;

    /**
     * 条件分页查询所有的数据
     * @param page 当前页
     * @param limit 每页展示大小
     * @param t 查询条件
     * @return 数据
     */
    @RequestMapping("/selWherePageAll")
    @ResponseBody
    public Map<String,Object> selWherePageAll(
            Integer page,
            Integer limit,
            T  t) {
        Map<String, Object> map = null;
        try {
            map = baseService.selWherePageAll(page, limit, t);
            map.put("code",0);
            map.put("msg","查询成功");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("code",200);
            map.put("msg","查询失败");
        }
        return map;
    }

    @RequestMapping("/selAll")
    @ResponseBody
    public List<T> selAll() {
        try {
            return baseService.selAll();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

