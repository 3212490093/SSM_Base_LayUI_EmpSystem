package com.java.emp.controller;

import com.java.emp.entity.Emp;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author: tmyue
 * @date: 2020/5/23 22:29
 */
@Controller
@RequestMapping("/emp")
public class EmpController extends BaseController<Emp> {


}
