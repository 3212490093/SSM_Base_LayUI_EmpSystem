package com.java.emp.service.impl;

import com.java.emp.entity.Dept;
import com.java.emp.service.DeptService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author: tmyue
 * @date: 2020/5/23 22:26
 */
@Service
@Transactional(readOnly = false)
public class DeptServiceImpl extends BaseServiceImpl<Dept>
    implements DeptService {
}
