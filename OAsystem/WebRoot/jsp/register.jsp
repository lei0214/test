<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'register.jsp' starting page</title>
    
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
			background-image:url("image/bg1.jpg");
			background-size:100%;
			overflow:hidden;
		}
		.tc{
			height:50px;
		}
		
		#title{
			text-align:center;
		}
		#title span{
			font-size:50px;
			font-weight:bold;
			color:#ff5722;
			font-family: "楷体","楷体_GB2312";
		}
		
		#tab{
			margin-top:50px;
		}

		#dl{
			text-align:center;
		}
		
		#content{
			margin-top:50px;
			background-color:rgba(0,0,0,0.5);
			border-radius:20px;
		}
		a{
			color:white;
		}
		a:hover{
			text-decoration:underline;
			color:red;
		}
		#message{
			
			margin-left:100px;
		}
		#message span{
			font-size:20px;
			font-weight:bold;
			color:#ff5722;
			font-family: "楷体","楷体_GB2312";
		}
		#check{
			color:red;
			display:none;
		}
		#head_title{
			position:absolute;
			top:0px;
			left:500px;
		}
		#denglu{
			position:absolute;
			left:-600px;
			top:-100px;
		}
		#leader{
			height:30px;
			width:200px;
		}
	</style>
	
  </head>
  
  <body>
    <div id="first" class="layui-fluid">
	  <div class="layui-row layui-col-space10">
	  <div class="layui-col-md12 tc"></div>
	  <div id="title" class="layui-col-md12">
	  	<img id="head_title" src="${pageContext.request.contextPath}/image/title1.png">
	  </div>
	  <div class="layui-col-md12 tc"></div>
	  <div class="layui-col-md5">
	   
	  </div>
	  <div id="content" class="layui-col-md3">
 		 <div id="message">
	  	  	<span id="check">用户已存在</span>
	  	 </div>
	  	 <form action="${pageContext.request.contextPath}/User/register.action" method="post">
		  	  <div class="layui-form-item">
				  <div style="margin-top:30px">
				      <input type="text" name="userName" onblur="checkUser(this)" placeholder="手机号/邮箱/用户名" class="layui-input">
				  </div>
			  </div>
			  <div  class="layui-form-item">
			     <div>
			       <input type="password" name="password" placeholder="请输入密码" class="layui-input">
			     </div>
			     
			  </div>
			   <div  class="layui-form-item">
			       <input type="password" name="password1" placeholder="请确认密码" class="layui-input">
			     </div>
			  <div class="layui-form-item">
			     <div>
			       <input type="number" name="phone" placeholder="请输入手机号" class="layui-input">
			     </div>
			  </div>
			  <div class="layui-form-item">
			     <div style="margin-top:0;text-align:center" >
			       <input type="radio" name="sex" value="man" checked="checked"><span style="color:#1e9fff">男娃子</span>
			       <input type="radio" name="sex" value="woman"><span style="color:#5fb878">女娃子</span>
			     </div>
			  </div>
			 <div class="layui-form-item">
			 	
			    <div>
			      <select id="leader" name="bossid" lay-verify="required">
			        <option value="" selected>请选择你的领导</option>
			      </select>
			    </div>
			 </div>
			 <div class="layui-form-item">
			 	<div style="width:60%;">
			 		<input type="text" name="checkcode"  placeholder="请输入验证码" class="layui-input">
			 		<br>
			 		<img src="${pageContext.request.contextPath}/CheckImgServlet">
			 	</div> 	
			 </div>
			  <div class="layui-form-item" align="center">
			   	<div>
			   		<input type="button" onclick="checkData()" class="layui-btn layui-btn-radius layui-btn-normal" value="立即提交">	
			   	</div>
			  </div>
	  	  </form>
	  	  <button id="denglu" class="layui-btn layui-btn-radius layui-btn-danger" onclick="location='${pageContext.request.contextPath}/jsp/login.jsp' " >返回登录</button>	    		
	  </div>
	  </div>
	  <div class="layui-col-md4">
	    
	  </div>
	  <div id="tcl" class="layui-col-md12"></div> 
	</div>
	<script type="text/javascript">
		var url='${pageContext.request.contextPath}/User/showleader.action';
		$.get(url,function(data){
			var $div=$("#leader");
			$(data).each(function(){
				$div.append($("<option value="+this.userId+">"+this.nickname+"</option>"));	
			});
		},"json");
	</script>
	<script type="text/javascript">
		function checkData(){
			var userName=document.getElementsByName("userName")[0].value;
			var password=document.getElementsByName("password")[0].value;
			var password1=document.getElementsByName("password1")[0].value;
			var phone=document.getElementsByName("phone")[0].value;
			var checkcode=document.getElementsByName("checkcode")[0].value;
			var index=document.getElementById("leader").selectedIndex;//获取当前选择项的索引.
			var bossid=document.getElementById("leader").options[index].value;//获取当前选择项的值.
			
			//开始校验
			if(userName.length<6){
				alert("用户名长度不合法");
				return;
			}
			if(password.length<6){
				alert("密码长度不合法");
				return;
			}
			if(password!=password1){
				alert("两次密码不一致");
				return;
			}
			if(phone.length!=11){
				alert("请输入正确的手机号");
				return;
			}
			if(checkcode.length<4){
				alert("请输入正确的验证码");
				return;
			}
			if(bossid.length<=0){
				alert("请选择你的领导");
				return;
			}
			
			//可以注册了
			
			var form=document.getElementsByTagName("form")[0];
			form.submit();
						
		}
		//校验用户
		function checkUser(cell){
			//ajax请求后台
			$.post("${pageContext.request.contextPath}/User/check.action",{userName:cell.value},function(data){
				var isSuccess=data["check"];
				if(isSuccess==1){
					$("#check").show();
				}else{
					$("#check").hide();
				}
			});
		}
	
	</script>
 </body>
</html>
