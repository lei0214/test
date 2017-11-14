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
    
    <title>My JSP 'headImgupload.jsp' starting page</title>
    
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
		#container1{
  			background-image:url("image/bg7.jpg");
			background-size:100%;
			overflow:hidden;
			background-repeat:no-repeat;
			height:750px;
  		}
		.change{
			background-color:rgba(255,184,0,0.5);
			border-radius:20px;
			height:500px;
			position:relative;
		}
		#tou{
  			height:100px;
  			text-align:center;
  			line-height:150px;
  			position: relative;
  		}
  		#title1{
  			color:#393D49;
  			font-size:40px;
  			font-weight:bold;
  		}
  		.t_man{
			color:#5FB878;
		}
		.t_woman{
			color:#FFB800;
		}
		#fanhui{
			position:fixed;
			right:200px;
			top:60px;
		}
		#container2{
  			background-image:url("image/bg8.jpg");
			background-size:100%;
			overflow:hidden;
			background-repeat:no-repeat;
			height:650px;
  		}
  		#title2{
  			height:100px;
  			background-color:#2F4056;
  			line-height:100px;
  			text-align:center;
  		}
  		#content2{
  			font-size:50px;
  			font-weight:bold;
  			font-family: "楷体","楷体_GB2312";
  			color:#FF5722;
  		}
  		#container{
  			background-color:rgba(47,64,86,0.5);
			border-radius:20px;
			height:600px;
			overflow:auto;
  		}
  		#file{
  			padding:6px 0;
  			width:200px;
		    height: 40px;
		    line-height: 50px;
		    position: relative;
		    cursor: pointer;
		    color: #888;
		    background: #fafafa;
		    border: 1px solid #ddd;
		    border-radius: 4px;
		    overflow: hidden;
		    display: inline-block;
		    *display: inline;
		    *zoom: 1
  		}
	</style>
  </head>
  
  <body>
	  <div id="container1" class="layui-fluid">
	  	<div class="layui-row layui-col-space10">
	  	<!-- 预留位置 -->
	  	  <div id="tou" class="layui-col-md12" style="height:150px">
	  	  	<span id="title1"><a class="t_${user.sex}" href="#">${user.nickname}&nbsp;</a>的个人主页</span>
			<a id="fanhui" href="${pageContext.request.contextPath }/annouse/show.action">
	  			<button  class="layui-btn layui-btn-radius layui-btn-danger">返回</button>
	  		</a>
	  	  </div>
		  <div class="layui-col-md1"></div>
		  
		  
		  <div class="layui-col-md4">
		    <div class='change'>
				<form action="${pageContext.request.contextPath }/UpLoad" method="post" enctype="multipart/form-data">
					<div class="layui-form-item" style="padding-top:50px;">
					  <label class="layui-form-label">修改昵称</label>
					  <div class="layui-input-inline" style="width:200px;">
					      <input type="text" name="title" value="${user.nickname}" class="layui-input">
					  </div>
					</div>
					<div class="layui-form-item" style="padding-top:20px;">
					    <label class="layui-form-label">更改头像</label>
					    <div class="layui-input-inline" >
					      <input type="file" name="upimg" id="file">
						</div>
					</div>
					<div class="layui-form-item" style="padding-top:20px;">
					    
					    <div class="layui-input-inline" style="position:absolute;bottom:30px;left:160px;">
					      <input type="submit" value="立即提交" class="layui-btn layui-btn-radius">
						</div>
					</div>
				</form>
			</div>
		  </div>
		  <!-- 	预留位置 -->
		  <div class="layui-col-md5"> </div>
		</div>
	  </div>
	  <!-- 我的留言 -->
	  <div id="title2">
  		<span id="content2">
  			我的信息
  		</span>
	  </div>
	  <div id="container2" class="layui-col-md12">
	   <!-- 预留空间 -->
	  	<div class="layui-col-md3" style="height:100px;"></div>
	  	
	  	
	  	<div id="container" class="layui-col-md6" style="margin-top:20px;">
		   		
	  	</div>
  	
	  <!-- 预留空间 -->
	  <div class="layui-col-md3"></div>
	</div>
  </body>
</html>
