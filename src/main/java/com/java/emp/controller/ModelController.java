package com.java.emp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author: tmyue
 * @date: 2020/5/24 10:28
 */
@Controller
@RequestMapping("/model")
public class ModelController {

    /**
     * 去往员工管理界面
     * @return
     */
    @RequestMapping("/toEmp")
    public String toEmp() {
        return "emp.jsp";
    }
}
