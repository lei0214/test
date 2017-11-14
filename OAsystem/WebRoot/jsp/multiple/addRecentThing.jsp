<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'addRecentThing.jsp' starting page</title>
    
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
		#text{
			width:300px;
			height:200px;
			resize:none;
		}
	
	</style>
  </head>
  
  <body>
    	
    <div class="admin-main">
		<blockquote class="layui-elem-quote">
        	<span id="title">
        		添加最近安排
        	</span>
        
        </blockquote>
        <fieldset class="layui-elem-field" style="background-color:rgba(30,159,255,0.3)">
            <legend>请输入您的安排</legend>
            <div class="layui-field-box layui-form">
            	<form action="${pageContext.request.contextPath}/recent/savething.action" class="layui-form">
            	<div class="layui-container">
				  <div class="layui-row layui-col-space10">
				   <div class="layui-col-md6">
					  <div style="position:absolute;right:10px;">
					  	<span id="leftWords"></span>
					  </div>
					  <div class="layui-form-item">
					    <label class="layui-form-label">内容</label>
					    <div class="layui-input-block">
					      <textarea name="content" id="text" maxlength="100" onKeyUp="limit(this)"></textarea>
						</div>
					  </div>
					  <div class="layui-form-item" style="width:500px; text-align:center">
	            	 	<input type="submit" value="立即提交" class="layui-btn layui-btn-radius layui-btn-warm">
	            	 </div>	
				   </div>
				   </div>
				   </div>
            	</form>
            </div>
        </fieldset>
        <div style="font-size:20px;color:red;text-align:center;">${message}</div>
    </div>
    <script type="text/javascript">
    	function limit(text){
    		var leftWords=100-text.value.length;
    		$("#leftWords").html("您还可以输入"+leftWords+"个字");
    		
    	}
    
    </script>
  </body>
</html>
