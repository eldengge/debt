<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>组织机构增</title>
</head>
<body>
  <form action="${pageContext.request.contextPath}/organization_add.do" method="post">
  	上级机构:<select name="parentId" id="select_parent">
  	</select><br><br>
  	机构类型:<select name="type">
  		<option value="1">总公司</option>
  		<option value="2">分公司</option>
  		<option value="3">小组</option>
  	</select><br><br>
  	负责人:<select name="principalId">
  		<option value="1">张三</option>
  		<option value="2">李四</option>
  		<option value="3">王二麻子</option>
  	</select><br><br>
  	机构名称:<input type="text" name="name" value="什么玩意儿分公司3"><br><br>
  	地址:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="address" value="不详"><br><br>
  	电话号码:<input type="text" name="phone" value="1"><br><br>
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