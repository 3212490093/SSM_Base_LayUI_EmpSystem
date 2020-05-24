package com.java.emp.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;

@Component
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"})
public class Emp implements Serializable {
    /** 员工编号 */
    private Integer empno;

    /** 姓名 */
    private String ename;

    /** 工作 */
    private String job;

    /** 上司编号 */
    private Double mgr;

    /** 工资 */
    private Double sal;

    /** 入职时间 */
    @JsonFormat(pattern = "yyyy-MM-hh HH:mm:ss",timezone = "GMT+8")
    private Date hiredate;

    /** 奖金 */
    private Double comm;

    /** 部门编号 */
    private Integer deptno;

    /* 部门信息 */
    private Dept dept;

    public Integer getEmpno() {
        return empno;
    }

    public void setEmpno(Integer empno) {
        this.empno = empno;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename == null ? null : ename.trim();
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job == null ? null : job.trim();
    }

    public Double getMgr() {
        return mgr;
    }

    public void setMgr(Double mgr) {
        this.mgr = mgr;
    }

    public Double getSal() {
        return sal;
    }

    public void setSal(Double sal) {
        this.sal = sal;
    }

    public Date getHiredate() {
        return hiredate;
    }

    public void setHiredate(Date hiredate) {
        this.hiredate = hiredate;
    }

    public Double getComm() {
        return comm;
    }

    public void setComm(Double comm) {
        this.comm = comm;
    }

    public Integer getDeptno() {
        return deptno;
    }

    public void setDeptno(Integer deptno) {
        this.deptno = deptno;
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "empno=" + empno +
                ", ename='" + ename + '\'' +
                ", job='" + job + '\'' +
                ", mgr=" + mgr +
                ", sal=" + sal +
                ", hiredate=" + hiredate +
                ", comm=" + comm +
                ", deptno=" + deptno +
                '}';
    }
}