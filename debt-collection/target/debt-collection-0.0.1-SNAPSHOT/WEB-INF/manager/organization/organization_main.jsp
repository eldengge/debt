<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/themes/icon.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>组织机构管理</title>
</head>
<body>
	<%-- <ul>
		<li><a href="${pageContext.request.contextPath}/organization_add.htm">增</a></li>
		<li><a href="${pageContext.request.contextPath}/organization_delete.htm">删</a></li>
		<li><a href="${pageContext.request.contextPath}/organization_update.htm">改</a></li>
	</ul> --%>
		<!-- <div id="listInner" class="easyui-treegrid"></div> -->
	<table id="listInner"></table>
	<a href="javascript:add()" class="easyui-linkbutton" data-options="iconCls:'icon-add'">Add</a>
	<a href="javascript:del()" class="easyui-linkbutton" data-options="iconCls:'icon-remove'">Remove</a>
	<a href="javascript:edit()" class="easyui-linkbutton" data-options="iconCls:'icon-edit'">Edit</a>
	<div id="win"></div>
</body>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.easyui.min.js"></script>
<script type="text/javascript">
	$(function(){
		//showList();
		showTable();
	});
	/* function showList(){
		$.ajax({
			url:"${pageContext.request.contextPath}/getOrganizationList.do",
			type:"POST",
			success:function(data){
				$("#ListInner").html(data);
			}
		});
	} */
	function showTable(){
		// 异步查询
		/* $('#listInner').datagrid({    
		    url:'${pageContext.request.contextPath}/getOrganizationListJson.do',   
		    columns:[[    
		        {field:'id',title:'id',width:100},    
		        {field:'name',title:'公司名称',width:100},    
		        {field:'parentId',title:'上级id',width:300}
		    ]]    
		}); */
		$('#listInner').treegrid({    
		    url:'${pageContext.request.contextPath}/getOrganizationMapJson.do',  
		    idField:'id',  //关键字段来标识树节点，不能重复  
		    treeField:'name',  //树节点字段，也就是树节点的名称
		    columns:[[
		        {field:'id',title:'id',width:60,align:'left'},    
		        {field:'name',title:'机构名称',width:200,align:'left'},    
		        {field:'type',title:'机构类型',width:80,align:'center',
		        	formatter: function(value,row,index){
						// 处理字段值的代码
							switch(row.type)
							{
								case 1:
									return '总公司';
							  		break;
								case 2:
									return '分公司';
							  		break;
								case 3:
									return '小组';
							  		break;
								default:
									return '';
							}  
					} 
		        },
		        {field:'code',title:'机构编码',width:80,align:'center'},
		        {field:'createTime',title:'创建时间',width:200,align:'center',
		        	formatter: function(value,row,index){
		        		var d = new Date(value);
		        		var str = d.toLocaleString();
						return str;
					}	
		        },
		        {field:'modifyTime',title:'修改时间',width:200,align:'center',
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
			href:"${pageContext.request.contextPath}/organization_add.htm",
			title:"添加",
		    width:600,    
		    height:400,    
		    modal:true  
		}); 
	}
	function edit(){
		var node=$('#listInner').treegrid('getSelected');
		if(node==null){
			$.messager.alert('警告','请选择一条记录'); 
		}else{
			$('#win').window({
				//method:"post",
				//queryParams:{id:node.id},
				href:"${pageContext.request.contextPath}/organization_edit.htm?id="+node.id,
				title:"修改",
			    width:600,    
			    height:400,    
			    modal:true  
			});			
		}
	}
	function del(){
		var node=$('#listInner').treegrid('getSelected');
		var idList=new Array()
		if(node==null){
			$.messager.alert('警告','请选择一条记录'); 
		}else{
			var id=node.id;
			idList[0]=id;
			var ids=$('#listInner').treegrid('getChildren',id);
			$.each(ids,function(i,node){
				idList[i+1]=node.id;
			});
			$.messager.confirm('确认','您确认想要删除'+node.name+'及其子机构吗？',function(r){    
			    if (r){
			    	$.ajax({
			    		type:"post",
			    		url:"${pageContext.request.contextPath}/organization_del.do",
			    		data:{
			    			ids:idList
			    		},
			    		success:function (data){
			    			$.messager.alert('提示',data.message);
			    			showTable();
			    		}
			    	});
			    }    
			});
		}
	}
</script>

</html>