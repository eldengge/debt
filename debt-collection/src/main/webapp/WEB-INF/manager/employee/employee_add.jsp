<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>员工增</title>
</head>
<body>
  <form action="${pageContext.request.contextPath}/employee_add.do" method="post">
  	账号:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="loginName" value="1234"><br><br>
  	初始密码:<input type="text" name="password" value="1234"><br><br>
  	姓名:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="userName" value="1234"><br><br>
  	性别:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" name="sex" value="1">男
  		<input type="radio" name="sex" value="2">女<br><br>
  	联系方式:<input type="text" name="contactMode" value="1"><br><br>
  	坐席用户:<input type="text" name="ccLogin" value="1"><br><br>
  	坐席密码:<input type="text" name="ccPwd" value="1"><br><br>
  	服务地址:<input type="text" name="ccServer" value="1"><br><br>
  	坐席号:&nbsp;&nbsp;&nbsp;<input type="text" name="ccPhone" value="1"><br><br>
	
  	地址:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="address" value="不详"><br><br>
  	邮政编码:<input type="text" name="postCode" value="1"><br><br>
  	传真号:&nbsp;&nbsp;&nbsp;<input type="text" name="fax" value="1"><br><br>
  	<input type="submit" value="提交">
  </form>
  <script type="text/javascript">
	$(function(){
		addSelect_parent()
	});
	function addSelect_parent(){
		var context='';
		$.ajax({
			type:"POST",
			url:"${pageContext.request.contextPath}/getOrganizationListJson.do",
			success:function(data){
				$.each(data,function(i,org){
					context+='<option value="'+org.id+'">'+org.name+'</option>'
				});
				$("#select_parent").html(context);
			}
		});
	}
</script>
</body>
</html>