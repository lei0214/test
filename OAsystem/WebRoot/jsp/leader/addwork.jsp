<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'addwork.jsp' starting page</title>
    
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
		#ss:after{
			 content:'';
    		 display:table;
    		 clear:both;	
		}
		#emp{
			display:block;
			height:30px;
			width:200px;
		}
	</style>
  </head>
  
  <body>
    	
    <div class="admin-main">
		<blockquote class="layui-elem-quote">
        	<span id="title">
        		发布任务
        	</span>
        </blockquote>
        <fieldset class="layui-elem-field" style="background-color:rgba(30,159,255,0.3)">
            <legend>请输入任务信息</legend>
            <div class="layui-field-box layui-form">
            	<form action="${pageContext.request.contextPath}/recent/savework.action" method="post" class="layui-form">
	            	<div class="layui-container">
					  <div class="layui-row layui-col-space10">
					   <div id="ss" class="layui-col-md6">
					   		
					   	  <div class="layui-form-item">
					   	  	 <label class="layui-form-label">指定员工</label>
						   	 <select id="emp" name="empname" lay-verify="required">
						        <option value="" selected>请选择</option>
						     </select>
						  </div>
						  
						  <div style="position:absolute;right:10px;">
						  	<span id="leftWords"></span>
						  </div>
						  
						  
						  <div class="layui-form-item">
						    <label class="layui-form-label">内容</label>
						    <div class="layui-input-block">
						      <textarea name="content" id="text" maxlength="100" onKeyUp="limit(this)"></textarea>
							</div>
						  </div>
						  
						  
						  <div class="layui-form-item">
						    <label class="layui-form-label">完成日期</label>
						    <div class="layui-input-block" style="width:300px;">
						    	<input type="text" name="completedate" id="test1" required  lay-verify="required" placeholder="完成日期" autocomplete="off" class="layui-input">
							</div>
						  </div>
						  
						  
						  <div class="layui-form-item" style="width:500px; text-align:center">
		            	 	<input type="button" onclick="checkData()" class="layui-btn layui-btn-radius layui-btn-normal" value="立即提交">	
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
    	var url='${pageContext.request.contextPath}/User/showempleft.action';
		$.get(url,function(data){
			var $div=$("#emp");
			$(data).each(function(){
				$div.append($("<option value="+this.userName+">"+this.nickname+"</option>"));	
			});
		},"json");
    </script>
    
    
    <script type="text/javascript">
    	function checkData(){
    		var content=document.getElementsByName("content")[0].value;
			var completedate=document.getElementsByName("completedate")[0].value;
    		var index=document.getElementById("emp").selectedIndex;//获取当前选择项的索引.
			var empid=document.getElementById("emp").options[index].value;//获取当前选择项的值.
			if(content.length<=0){
				alert("请输入工作内容");
			}else if(completedate.length<=0){
				alert("请输入完成时间");
			}else if(empid.length<=0){
				alert("请选择一个员工来完成");
			}else{
				var form=document.getElementsByTagName("form")[0];
				form.submit();
			}	
    	
    	}
    	
    </script>
    
      <script>
		layui.use('laydate', function(){
		  var laydate = layui.laydate;
		  
		  //执行一个laydate实例
		  laydate.render({
		    elem: '#test1' //指定元素
		  });
		});
	</script>
    <script type="text/javascript">
    	function limit(text){
    		var leftWords=100-text.value.length;
    		$("#leftWords").html("您还可以输入"+leftWords+"个字");
    		
    	}
    
    </script>
  </body>
</html>
