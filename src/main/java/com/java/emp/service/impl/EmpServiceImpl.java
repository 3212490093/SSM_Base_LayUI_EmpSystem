package com.java.emp.service.impl;

import com.java.emp.entity.Emp;
import com.java.emp.service.EmpService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author: tmyue
 * @date: 2020/5/23 22:24
 */
@Service
@Transactional(readOnly = false)
public class EmpServiceImpl extends BaseServiceImpl<Emp>
        implements EmpService {

}
