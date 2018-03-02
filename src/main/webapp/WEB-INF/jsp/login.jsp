<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="../../jquery/jquery-3.3.1.js"></script>
<script type="text/javascript">
function login(btn) {
	//debugger;
    var $btn = $(btn);
    var account = $("#account").val();
    var passwd = $("#passwd").val();
    console.log("name:"+name+",passwd"+passwd);
    $.ajax({
        type: 'post',
        url: 'http://localhost:8090/api/user/login',
        contentType: "application/json;charset=UTF-8",
        /*当dataType指定为json后,1.4+以上的jquery版本对json格式要求更加严格.如果不是严格的json格式,就不能正常执行success回调函数.
        JSON格式总结下，详细的去json.org 查看。 　　 
				1）键名称：用双引号 括起 　　 
				2）字符串：用使用双引号 括起 
				3）数字，布尔类型不需要 使用双引号 括起
      */
        data: "{\"account\": \""+account+"\", \"passwd\": \""+passwd+"\"}",
       /*  xhrFields: {
            withCredentials: true
        }, */
        dataType: 'json'
    }).then(
            function (obj) {
            	console.log(JSON.stringify(obj));
                $("#show").html(JSON.stringify(obj));
            },
            function () {
            	$("#show").html('error...');
            }
    )
}

</script>
</head>
<body>
 <h1><font color="green">登录</font></h1>
 <table>
   <form action="api/user/login" method="post">
	   <tr>
		   <td>账号：</td>
		   <td><input type="text" id="account" name="account" /></td>
	   </tr>
	   <tr>
		   <td>密码：</td>
		   <td><input type="text" id="passwd" name="passwd" /></td>
	   </tr>
	   <tr>
	 	   <td colspan="2"><input type="submit" value="登录"/></td>
	   </tr>
   </form>
 </table>
 <p id="show"></p>
</body>
</html>