<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'empBiz.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" href="layui/css/layui.css">
	<script src="layui/layui.js"></script>
	<script type="text/javascript" src="js/jquery.min.js"></script>

  <script type="text/javascript">
        $(document).ready(function(){
              getStudentInfo();
              //点击搜索时 搜索数据
              $("#selectButton").click(function(){ 
                getStudentInfo();//然后进行分页的初始化
              })
        });
        function deleteRow(){
        	var con;
			con=confirm("您真的要开除他（们）吗?");
			if(con==true){
			
		        layui.use('table', function(){
					var table = layui.table;
					var checkStatus = table.checkStatus('idTest'); //test即为基础参数id对应的值
	 				var data=checkStatus.data;  //获取选中行的数据
	 				var ids="";
	 				var array=[];
	 				$.each(data,function(index,obj){
	 					var id=obj.userId;
	 					
	 					array.push(id);
	 				});
	 				var str=array.join(",");
	 
	 				$.post("${pageContext.request.contextPath}/User/fire.action",
	 				{ids:str},function(data){
	 					var isSuccess=data["isSuccess"];
	 					if(isSuccess-1){
	 						alert("删除失败")
	 					}else{
	 						getStudentInfo();
	 					}
	 				});
				});
			}else{
				alert("谢谢您的开恩！")
			}  
        }
        
        
        function getStudentInfo(){
        	layui.use('table', function(){
			  var table = layui.table;
			  table.render({
        	  page: true,
        	  method:"post",
        	  url:"${pageContext.request.contextPath}/User/showemp.action",
        	  even: true,
        	  request: {
  				pageName: 'start' //页码的参数名称，默认：page
  				,limitName: 'limit' //每页数据量的参数名，默认：limit
			  },
			  elem: '#t_customerInfo',
			  where:{selectValue:$("#selectValue").val()},
			  id: 'idTest',
			  limits: [2,5,8],
  			  limit: 8,
			  cols:  [[ 
			    {checkbox: true}
			    ,{field: 'userId', title: '员工编号', width: 120}
			    ,{field: 'nickname', title: '员工姓名', width: 120}
			    ,{field: 'phone', title: '员工电话', width: 120}
			    ,{field: 'sex', title: '性别', width: 80}
			   	,{field: 'bossname', title: '上级领导', width: 150}
			  ]]
			});
			  
			  
			});
        }		
    </script>
   
</head>
<body>


    <div class="admin-main">
		<blockquote class="layui-elem-quote">
        	<form class="layui-form" action="" >
        		<div class="layui-form-item">
       				 <div class="layui-input-inline">
            			<input type="text" id="selectValue" lay-verify="required" placeholder="员工姓名" autocomplete="off" class="layui-input">
       				 </div>
       				<button class="layui-btn" type="button" id="selectButton">搜索</button>
        		</div>
        	</form>
        
        </blockquote>
        <fieldset class="layui-elem-field">
            <legend>学员列表</legend>
            <div class="layui-field-box layui-form">
            	<a href="javascript:deleteRow()"><i id="icon1" class="layui-icon">&#xe640;Fire</i></a>
            	<table class="layui-table admin-table"  lay-filter="test" id="t_customerInfo" lay-data="{id: 'idTest'}">
                </table>
            </div>
        </fieldset>
    </div>
  
</body>
</html>
