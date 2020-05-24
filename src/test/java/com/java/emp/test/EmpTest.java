package com.java.emp.test;

import com.java.emp.entity.Emp;
import com.java.emp.service.EmpService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.Map;

/**
 * @author: tmyue
 * @date: 2020/5/24 11:14
 */

public class EmpTest {
    //日志对象
    private Logger log = LogManager.getLogger(EmpTest.class.getName());
    //application
    private ApplicationContext app = null;
    //service
    private EmpService empService = null;

    @Before
    public void before() {
        app = new ClassPathXmlApplicationContext("spring-main.xml");
        empService = app.getBean("empServiceImpl",EmpService.class);
    }

    @Test
    public void test01() {
        System.out.println(app);
        System.out.println(empService);
    }

    @Test
    public void selAll() throws Exception {
        Emp emp = new Emp();
        emp.setEname("曹");
        Map<String, Object> map = empService.selWherePageAll(1, 5, emp);
        List<Emp> lists = (List<Emp>)map.get("data");
        for(Emp e : lists) {
            log.info(e);
            log.info("部门信息："+e.getDept());
        }
        log.info("总条数："+map.get("count"));
    }
}
