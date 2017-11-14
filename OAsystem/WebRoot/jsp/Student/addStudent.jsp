<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'addStudent.jsp' starting page</title>
    
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
	<script src="${pageContext.request.contextPath }/js/jquery.min.js"></script>
	
	<style type="text/css">
		#title{
			font-size:30px;
			font-weight:bold;
			color:#E75526;
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
        <fieldset class="layui-elem-field" style="background-color:rgba(30,159,255,0.3)">
            <legend>学员信息</legend>
            <div class="layui-field-box layui-form">
            	<form action="${pageContext.request.contextPath}/JR/save.action" class="layui-form">
            	<div class="layui-container">
				  <div class="layui-row layui-col-space10">
				   <div class="layui-col-md6">
				     <div class="layui-form-item">
					    <label class="layui-form-label">学号</label>
					    <div class="layui-input-block" style="width:300px;">
					      <input type="text" name="no" required lay-verify="required" placeholder="请输入学号" autocomplete="off" class="layui-input">
					    </div>
					  </div>
				     <div class="layui-form-item">
					    <label class="layui-form-label">姓名</label>
					    <div class="layui-input-block" style="width:300px;">
					      <input type="text" name="name" required  lay-verify="required" placeholder="请输入姓名" autocomplete="off" class="layui-input">
					    </div>
					  </div>
					  <div class="layui-form-item">
					    <label class="layui-form-label">性别</label>
					    <div class="layui-input-block">
					      <input type="radio" name="sex" value="男" title="男">
						  <input type="radio" name="sex" value="女" title="女" checked>
						</div>
					  </div>
					  <div class="layui-form-item">
					    <label class="layui-form-label">出生日期</label>
					    <div class="layui-input-block" style="width:300px;">
					      <input type="text" name="birthday" id="test1" required  lay-verify="required" placeholder="请输入出生日期" autocomplete="off" class="layui-input">
					    </div>
					  </div>
					  
				   </div>
				   <div class="layui-col-md6">
				    <div class="layui-form-item">
					    <label class="layui-form-label">学校</label>
					    <div class="layui-input-block" style="width:300px;">
					      <input type="text" name="school" required  lay-verify="required" placeholder="请输入学校" autocomplete="off" class="layui-input">
					    </div>
					  </div>
					  <div class="layui-form-item">
					    <label class="layui-form-label">专业</label>
					    <div class="layui-input-block" style="width:300px;">
					      <input type="text" name="major" required lay-verify="required" placeholder="请输入专业" autocomplete="off" class="layui-input">
					    </div>
					  </div>
					  <div class="layui-form-item">
					    <label class="layui-form-label">班级</label>
					    <div class="layui-input-block" style="width:300px;">
					      <input type="text" name="classNo" required lay-verify="required" placeholder="请输入班级" autocomplete="off" class="layui-input">
					    </div>
					  </div>
					  <div class="layui-form-item">
					    <label class="layui-form-label">入学时间</label>
					    <div class="layui-input-block" style="width:300px;">
					      <input type="text" id="test2" name="indate" required lay-verify="required" placeholder="请输入入学时间" autocomplete="off" class="layui-input">
					    </div>
					  </div>
				   </div>
				 				     
				  </div>
				</div>  
            	 <div class="layui-form-item" style="text-align:center">
            	 	<input type="submit" value="立即提交" class="layui-btn layui-btn-radius layui-btn-warm">
            	 
            	 </div>	
            	
            	</form>
            </div>
        </fieldset>
        
        <div style="font-size:20px;color:red;text-align:center;">${message}</div>
    </div>
    <script>
		layui.use('laydate', function(){
		  var laydate = layui.laydate;
		  
		  //执行一个laydate实例
		  laydate.render({
		    elem: '#test1' //指定元素
		  });
		  laydate.render({
		    elem: '#test2' //指定元素
		  });
		});
	</script>
	<script>
//Demo
	layui.use('form', function(){
	  var form = layui.form;
	});
	</script>
  </body>
</html>
