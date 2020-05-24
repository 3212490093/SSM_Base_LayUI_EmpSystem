<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<head>
    <base href="<%=basePath%>"/>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>员工信息展示</title>
    <!--引入layui的样式文件-->
    <link rel="stylesheet" href="static/lib/layui/css/layui.css">
    <!--引入layui的js文件-->
    <script src="static/lib/layui/layui.js"></script>
</head>
<body>
    <div align="center" class="layui-container">
        <h1>员工数据</h1>
        <%--功能区--%>
        <div class="funArea layui-row" style="margin-top: 20px">
            <div class="layui-col-md3">
                <%--功能按钮--%>
                <button class="insBtn layui-btn layui-btn-radius"  >
                    <i class="layui-icon">&#xe608;</i>新增
                </button>
                    <button class="delBatchBtn layui-btn layui-btn-danger layui-btn-radius" >
                    <i class="layui-icon">&#xe640;</i>批量删除
                </button>
            </div>
            <div class="layui-col-md9">
                <%--条件查询--%>
                <form class="layui-form" action="" >
                    <div class="layui-form-item">
                        <div class="layui-inline">
                            <select id="querySelect" name="goodType">
                                <%--js动态添加--%>
                            </select>
                        </div>
                        <div class="layui-inline">
                            <label class="layui-form-label">员工姓名：</label>
                            <div class="layui-input-inline">
                                <input type="text" name="ename" placeholder="请输入查询的员工姓名" autocomplete="off" class="layui-input">
                            </div>
                        </div>
                        <div class="layui-inline">
                            <button class="layui-btn layui-btn-normal" lay-submit="" lay-filter="demo2">
                                <i class="layui-icon">&#xe615;</i>查询
                            </button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
        <table id="demo" lay-filter="test"></table>
    </div>
    <%--员工的操作div引入--%>
    <%--<%@ include file="operationGood.jsp"%>--%>
</body>
<!--引入自定义的js文件-->
<script src="static/js/emp.js"></script>
<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>
</html>