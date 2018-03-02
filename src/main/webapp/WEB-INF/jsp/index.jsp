<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>仅仅测试session共享，因此需要把前端页面与后端服务放到同一个项目中，这样就不会存在跨域问题了</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="../../jquery/jquery-3.3.1.js"></script>
<script type="text/javascript">

function checkLogin(btn) {
    var $btn = $(btn);
    $.ajax({
        type: 'post',
        url: 'http://localhost:8090/api/user/login',
        contentType: "application/json;charset=UTF-8",
        xhrFields: {
            withCredentials: true
        }
    }).then(
            function (obj) {
                $btn.next('p').html(JSON.stringify(obj));
            },
            function () {
                $btn.next('p').html('error...');
            }
    )
}

function getUsers(btn) {
	console.log("getUsers");
    var $btn = $(btn);
    $.ajax({
        type: 'get',
        url: 'http://localhost:8090/api/user/getList',
        contentType: "application/x-www-form-urlencoded;charset=UTF-8"  //如果改为 application/json ，则是复杂的跨域请求 
     }).then(
            function (obj) {
                $btn.next('p').html(JSON.stringify(obj));
            },
            function () {
                $btn.next('p').html('error...');
            }
    )
}

function addUser(btn) {
    var $btn = $(btn);
    var name = $btn.next('input').val();
    if (!name) {
        $btn.next('input').next('p').html('用户名不能为空');
        return;
    }
    $.ajax({
        type: 'post',
        url: 'http://localhost:8090/api/user/addUser',
        contentType: "application/json;charset=UTF-8",
        data: "{\"account\":\""+name+"\"}", 
        dataType: 'json'
    }).then(
            function (obj) {
                $btn.next('input').next('p').html(JSON.stringify(obj));
            },
            function () {
                $btn.next('input').next('p').html('error...');
            }
    )
}

</script>
</head>
<body>
 <h>你已成功访问到主页面！</h><br/>
 <hr>
 <input type="button" value="登录校验" id="checkLogin" onclick="checkLogin(this)">
 <p color="green"></p>
 <hr>
 
 <input type="button" value="获取用户" id="getUsers" onclick="getUsers(this)">
 <p class="am-text-danger"></p>
 <hr>
 
 <input type="button" value="添加用户" id="complex_cors" onclick="addUser(this)">
 <input type="text" placeholder="用户名">
 <p color="red"></p>
 
</body>
</html>
