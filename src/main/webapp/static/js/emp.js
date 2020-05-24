layui.use(['layer','table','form'], function(){ //独立版的layer无需执行这一句
    var $ = layui.jquery,
        form = layui.form,
        table = layui.table;

    //查询条件
    var queryWhere = {};

    //表格对象
    var currTable = null;

    //当前页
    var page = 1;

    //加载表格
    tableLoad(queryWhere);

    //加载部门数据
    deptLoad();

    //条件查询监听
    form.on('submit(demo2)', function(data){
        var queryData = data.field;
        //处理部门数据（仅保留部门id）
        queryData = deptToDeptId(queryData);
        //重新加载数据表格
        reloadTable(1,queryData);
        return false; //阻止表单跳转。如果需要表单跳转，去掉这段即可。
    });

    //加载表格
    function tableLoad(queryWhere) {
        //表格加载
        currTable = table.render({
            elem: '#demo'
            ,height: 412
            ,url: '/emp/selWherePageAll' //数据接口
            ,where: queryWhere  //查询条件
            ,page: true //开启分页
            ,limit: 7   //默认显示的条数
            ,limits: [1,3,5,7,9,13] //条数显示
            ,cols: [[ //表头
                {field: 'empno', title: '编号', width:120, sort: true, fixed: 'left'}
                ,{field: 'ename', title: '员工姓名', width:120}
                ,{field: 'job', title: '工作', width:120, sort: true}
                ,{field: 'mgr', title: '上司编号', width:120, sort: true}
                ,{field: 'sal', title: '工资', width:120}
                ,{field: 'hiredate', title: '入职时间', width: 177, sort: true}
                ,{field: 'comm', title: '奖金', width:120, sort: true}
                ,{field: 'dname', title: '部门', width:120, templet: "<div>{{d.dept.dname}}</div>" }
                ,{field: 'loc', title: '部门地址', width: 177, sort: true, templet: "<div>{{d.dept.loc}}</div>"}
                ,{field: 'right', title: '操作', toolbar:"#barDemo", width:120,fixed:'right'}
            ]]
            ,done: function(res, curr, count){
                //如果是异步请求数据方式，res即为你接口返回的信息。
                //如果是直接赋值的方式，res即为：{data: [], count: 99} data为当前页数据、count为数据总长度
                page = curr;
            }
        });
    }

    //重载数据表格
    function reloadTable(page,where) {
        //这里以搜索为例
        currTable.reload({
            where: where
            ,page: {
                curr: page //重新从第 page 页开始
            }
        });
    }

    //加载部门数据
    function deptLoad() {
        $.ajax({
            url:"/dept/selAll"
            ,type:"get"
            ,dataType:"json"
            ,success:function (data) {
                if(data!=null) {
                    //调用下拉框填充
                    selectFill(data)
                } else {
                    layui.alert("部门数据为空",{icon:5})
                }
            }
            ,error:function () {
                console.error("部门数据加载失败");
            }
        })
    }

    //填充下拉框
    function selectFill(data) {
        var selectData = "<option value='' id='defaultOption'> --请选择部门-- </option>";
        $.each(data,function (i,dept) {
            selectData += "<option value='"+dept.deptno+","+dept.dname+"'>"+dept.dname+"</option>";
        })
        $("#querySelect").html(selectData);
        form.render('select'); //刷新select选择框渲染
    }

    //处理部门数据（仅保留部门id）
    function deptToDeptId(data) {
        var deptno = data["dept"].split(",")[0];
        data['deptno'] = deptno;
        delete data['dept'];
        return data;
    }
})