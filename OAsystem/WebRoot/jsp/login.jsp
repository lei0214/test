<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>登录</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" href="layui/css/layui.css">
	<script src="layui/layui.all.js"></script>
	<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
	
	
	<style type="text/css">
		body{
			background-image:url("image/denglu_bg1.jpg");
			background-size:100%;
			overflow:hidden;
		}
		#head{
			height:200px;
			line-height:100px;
			text-align:center;
		}
		#head_title{
			position:absolute;
			top:100px;
			left:450px;
		}
		#container{
			background-color:rgba(255,87,34,0.5);
			border-radius:20px;
		}
		#icon1{
			position:absolute;
			top:10px;
			left:10px;
		}
		#input1{
			padding-left:30px;
		}
		#icon2{
			position:absolute;
			top:10px;
			left:10px;
		}
		#input2{
			padding-left:30px;
		}
		.label{
			font-size:20px;
			font-weight:bold;
			color:#01aaed;
			font-family: "楷体","楷体_GB2312";
		}
	</style>
  </head>
  
  <body>
    <div id="first" class="layui-fluid">
	  	<div class="layui-row layui-col-space10">
		  <div id="head" class="layui-col-md12">
		  	<img id="head_title" src="${pageContext.request.contextPath}/image/title1.png">
		  </div>
		  
		  <!-- 预留空间 -->
		  <div class="layui-col-md4"></div>
		  <div id="container" class="layui-col-md4">
		  	<form class="layui-form" action="${pageContext.request.contextPath}/User/login.action" style="margin-top:20px;">
			  <div class="layui-form-item">
			    <label class="layui-form-label label">账号</label>
			    <div class="layui-input-inline" style="width:300px;">
			      <i id="icon1" class="layui-icon">&#xe612;</i> 
			      <input id="input1" type="text" name="userName" placeholder="请输入账号" class="layui-input">
			    </div>
			  </div>
			  <div class="layui-form-item">
			    <label class="layui-form-label label" >密码</label>
			    <div class="layui-input-inline" style="width:300px;">
			      <i id="icon1" class="layui-icon">&#xe60c;</i>
			      <input id="input2" type="password" name="password" placeholder="请输入密码" class="layui-input">
			    </div>
			  </div>
			  <div class="layui-form-item" style="width:300px;text-algin:center;margin-left:110px;">
					  <div style="margin-top:20px">
					  	<input type="checkbox" name="remember" title="记住密码" checked>
					  	<div style="display:inline;float:right">
					  		<a href="">忘记密码？</a>
					  		<a href="${pageContext.request.contextPath}/jsp/register.jsp">立即注册</a>
					  	</div>
					  </div>
				  </div>
			   <div class="layui-form-item" style="text-align:center;">
			    
			      <input type="submit" value="立即登录" class="layui-btn layui-btn-radius layui-btn-normal">
			    
			  </div>
			 </form>
					  
		  </div>
		  
		   <!-- 预留空间 -->
		  <div class="layui-col-md4"></div>
		</div>
	</div>
    
  </body>
</html>
