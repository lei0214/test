<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'checkleave.jsp' starting page</title>
    
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
        function getStudentInfo(){
        	layui.use('table', function(){
			  var table = layui.table;
				  table.render({
		        	  page: true,
		        	  method:"post",
		        	  url:"${pageContext.request.contextPath}/leave/showchecklist.action",
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
					    ,{field: 'lev_id', title: '编号', width: 80}
					    ,{field: 'lev_person', title: '申请人', width: 120}
					    ,{field: 'lev_startdate', title: '起始时间', width: 300}
					    ,{field: 'lev_enddate', title: '结束时间', width: 120} 
					    ,{field: 'lev_reason', title: '原因', width: 120}
					    ,{field: 'status', title: '状态', width: 120}
					    ,{fixed: 'right', width:150, align:'center', toolbar: '#barDemo'}
					  ]]
				  });
				  table.on('tool(test)', function(obj){ //注：tool是工具条事件名，test是table原始容器的属性 lay-filter="对应的值"
  					var data = obj.data; //获得当前行数据
 					var layEvent = obj.event; //获得 lay-event 对应的值
  					var id=data.lev_id;
  					$.post("${pageContext.request.contextPath}/leave/check.action",
 					{lev_id:id,isAgree:layEvent},function(data){
	 					var isSuccess=data["isSuccess"];
	 					if(isSuccess-1){
	 						alert("审批失败")
	 					}else{
	 						getStudentInfo();
	 					}
 					});
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
            			<input type="text" id="selectValue" lay-verify="required" placeholder="请假人姓名" autocomplete="off" class="layui-input">
       				 </div>
       				<button class="layui-btn" type="button" id="selectButton">搜索</button>
        		</div>
        	</form>
        
        </blockquote>
        <fieldset class="layui-elem-field">
            <legend>申请列表</legend>
            <div class="layui-field-box layui-form">
                <table class="layui-table admin-table" lay-filter="test" id="t_customerInfo" lay-data="{id: 'idTest'}">
                </table>
            </div>
        </fieldset>
    </div>
    <script type="text/html" id="barDemo">
       <a class="layui-btn layui-btn-mini" lay-event="agree"><i class="layui-icon">&#xe618;</i>通过</a>
       <a class="layui-btn layui-btn-mini layui-bg-red" lay-event="disagree"><i class="layui-icon">&#x1006;</i>不通过</a>
  
</script>
  </body>
</html>
