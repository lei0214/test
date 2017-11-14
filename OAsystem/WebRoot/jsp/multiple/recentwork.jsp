<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'recentwork.jsp' starting page</title>
    
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
        
        function getStudentInfo(){
        	layui.use('table', function(){
			  var table = layui.table;
				  table.render({
		        	  page: true,
		        	  method:"post",
		        	  url:"${pageContext.request.contextPath}/recent/recentwork.action",
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
					    ,{field: 'forwho', title: '领导', width: 100}
					    ,{field: 'content', title: '内容', width: 300}
					    ,{field: 'pubdate', title: '发布日期', width: 120}
					    ,{field: 'completedate', title: '完成日期', width: 120}
					  ]]
				  });	  
			});
		}
    </script>
   
</head>
<body>


    <div class="admin-main">
        <fieldset class="layui-elem-field">
            <legend>待办事项列表</legend>
            <div class="layui-field-box layui-form">
                <table class="layui-table admin-table"  lay-filter="test" id="t_customerInfo" lay-data="{id: 'idTest'}">
                </table>
            </div>
        </fieldset>
    </div>
  </body>
</html>
