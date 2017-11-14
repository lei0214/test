<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'recentthing.jsp' starting page</title>
    
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
        });
        function deleteRow(){
	        layui.use('table', function(){
				var table = layui.table;
				var checkStatus = table.checkStatus('idTest'); //test即为基础参数id对应的值
 				var data=checkStatus.data;  //获取选中行的数据
 				var ids="";
 				var array=[];
 				$.each(data,function(index,obj){
 					var id=obj.id;
 					array.push(id);
 				});
 				var str=array.join(",");
 				$.post("${pageContext.request.contextPath}/recent/deletething.action",
 				{ids:str},function(data){
 					var isSuccess=data["isSuccess"];
 					if(isSuccess-1){
 						alert("删除失败")
 					}else{
 						getStudentInfo();
 					}
 				});
			});  
        }
        
        
        function getStudentInfo(){
        	layui.use('table', function(){
			  var table = layui.table;
				  table.render({
		        	  page: true,
		        	  method:"post",
		        	  url:"${pageContext.request.contextPath}/recent/recentthing.action",
		        	  even: true,
		        	  request: {
		  				pageName: 'start' //页码的参数名称，默认：page
		  				,limitName: 'limit' //每页数据量的参数名，默认：limit
					  },
					  elem: '#t_customerInfo',
					  id: 'idTest',
					  limits: [2,5,8],
		  			  limit: 8,
					  cols:  [[ 
					    {checkbox: true}
					    ,{field: 'id', title: '编号', width: 80}
					    ,{field: 'content', title: '内容', width: 300}
					    ,{field: 'pubdate', title: '发布日期', width: 120} 
					  ]]
				  });	  
			});
		}
    </script>
   
</head>
<body>


    <div class="admin-main">
        <fieldset class="layui-elem-field">
            <legend>最近安排列表</legend>
            <div class="layui-field-box layui-form">
            	<a href="javascript:deleteRow()"><i id="icon1" class="layui-icon">&#xe640;删除</i></a>
            	<a style="position:absolute;right:600px;" href="${pageContext.request.contextPath}/jsp/multiple/addRecentThing.jsp"><i id="icon1" class="layui-icon">&#xe654;添加</i></a>
                <table class="layui-table admin-table"  lay-filter="test" id="t_customerInfo" lay-data="{id: 'idTest'}">
                </table>
            </div>
        </fieldset>
    </div>
    
  </body>
</html>
