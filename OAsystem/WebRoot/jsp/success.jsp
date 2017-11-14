<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'success.jsp' starting page</title>
    
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
	<style type="text/css">
		#container{
			margin:30px auto;
		
		}
		#content{
			font-size:30px;
			font-weight:bold;
			color:#FF5722;
			font-family: "楷体","楷体_GB2312";
		}
	</style>
	
	
  </head>
  
  <body>
  
    <div class="admin-main">
		<blockquote class="layui-elem-quote">
        	<span id="title">
        		杰瑞学员信息录入
        	</span>
        
        </blockquote>
        <fieldset class="layui-elem-field">
            <legend>信息</legend>
            <div id="container">
            	<span id="content">
            		添加成功
            	</span>
            </div>
        </fieldset>
    </div>
  </body>
</html>
