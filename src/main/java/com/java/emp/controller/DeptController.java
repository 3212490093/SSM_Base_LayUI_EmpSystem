package com.java.emp.controller;

import com.java.emp.entity.Dept;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author: tmyue
 * @date: 2020/5/23 22:30
 */
@Controller
@RequestMapping("/dept")
public class DeptController extends BaseController<Dept> {
}
