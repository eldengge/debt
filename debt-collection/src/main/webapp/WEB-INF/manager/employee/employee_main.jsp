<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/themes/icon.css">
<title>员工管理</title>
</head>
<body>
	<table id="listInner"></table>
	<div id="pp" style="background:#efefef;border:1px solid #ccc;"></div> 
	<a href="javascript:add()" class="easyui-linkbutton" data-options="iconCls:'icon-add'">Add</a>
	<a href="javascript:del()" class="easyui-linkbutton" data-options="iconCls:'icon-remove'">Remove</a>
	<a href="javascript:edit()" class="easyui-linkbutton" data-options="iconCls:'icon-edit'">Edit</a>
	<div id="win"></div>
</body>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.easyui.min.js"></script>
<script type="text/javascript">
	$(function(){
		showTable(1,3);
	});
	function showPagination(data){
		$('#pp').pagination({ 
			total:data.totalno, 
			pageSize:data.pagesize,
			showPageList:false,
			onSelectPage:function(pageNumber, pageSize){
				$(this).pagination('loading');
				showTable(pageNumber, pageSize);
				$(this).pagination('loaded');
			},
			onRefresh:function(){
			}
		}); 
	}
	function showTable(pageno, pagesize){
		var url='${pageContext.request.contextPath}/getPageEmployeeListJson.do';
		$.ajax({
			url:url,
			type:"post",
			data:{
				pageno: pageno,
		    	pagesize: pagesize
			},
			success:function(data){
				$('#listInner').datagrid('loadData',data.datas);
				showPagination(data);
			}
		});
		$('#listInner').datagrid({
		    columns:[[    
		        {field:'id',title:'id',width:80},
		        {field:'status',title:'员工状态',align:'center',width:80,
		        	formatter: function(value,row,index){
						// 处理字段值的代码
						switch(row.status)
						{
							case 0:
								return '停用';
						  		break;
							case 1:
								return '使用';
						  		break;
							default:
								return '';
						}  
					} 
		        },
		        {field:'loginName',title:'账号',align:'center',width:80},
		        {field:'userName',title:'员工姓名',align:'center',width:100},
		        {field:'sex',title:'性别',align:'center',width:60,
		        	formatter: function(value,row,index){
						// 处理字段值的代码
						switch(row.status)
						{
							case 1:
								return '男';
						  		break;
							case 2:
								return '女';
						  		break;
							default:
								return '';
						}  
					}
		        },
		        {field:'joinTime',title:'入职时间',width:150,align:'center',
		        	formatter: function(value,row,index){
		        		var d = new Date(value);
		        		var str = d.toLocaleString();
						return str;
					}	
		        },
		        {field:'positionName',title:'岗位',width:100,align:'center'},
		        {field:'organizationName',title:'机构',width:100,align:'center'},
		        {field:'createTime',title:'录入时间',width:150,align:'center',
		        	formatter: function(value,row,index){
		        		var d = new Date(value);
		        		var str = d.toLocaleString();
						return str;
					}	
		        },
		        {field:'modifyTime',title:'修改时间',width:150,align:'center',
		        	formatter: function(value,row,index){
		        		var d = new Date(value);
		        		var str = d.toLocaleString();
						return str;
					}	
		        }
		    ]]    
		});
	}
	function add(){
		$('#win').window({ 
			href:"${pageContext.request.contextPath}/employee_add.htm",
			title:"添加",
		    width:600,    
		    height:400,    
		    modal:true  
		}); 
	}
	function edit(){
	}
	function del(){
	}
</script>
</html>