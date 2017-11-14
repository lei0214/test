<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'list.jsp' starting page</title>
    
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

      /*   //分页参数设置 这些全局变量关系到分页的功能
        var startAllAppoint = 0;
        var limitAllAppoint = 8;
        var currentPageAllAppoint = 1;
        var total = 0;
        var dataLength = 0;
        //ajax请求后台数据
        function getShopCustomerManagePageInfo(){
            $.ajax({
                type:"post",
                async:false,
                url:"${pageContext.request.contextPath}/JR/StuList.action",
                data:{start:startAllAppoint, limit:limitAllAppoint,selectValue:$("#selectValue").val()},
                success:function(data,status){
                    getShopCustomesInfo(data.root);
                    startAllAppoint = data.currentPage;//当前页数(后台返回)
                    
                    total = data.total;//总页数(后台返回)
                  
                }
            });

        } */
        function deleteRow(){
	        layui.use('table', function(){
				var table = layui.table;
				var checkStatus = table.checkStatus('idTest'); //test即为基础参数id对应的值
 				var data=checkStatus.data;  //获取选中行的数据
 				var nos="";
 				var array=[];
 				$.each(data,function(index,obj){
 					var no=obj.no;
 					array.push(no);
 				});
 				var str=array.join(",");
 				$.post("${pageContext.request.contextPath}/JR/delete.action",
 				{nos:str},function(data){
 					var isSuccess=data["isSuccess"];
 					if(isSuccess-1){
 						alert("删除失败")
 					}else{
 						getStudentInfo();
 					}
 				});
				  /* alert(checkStatus.data) //获取选中行的数据
			      alert(checkStatus.data.length) //获取选中行数量，可作为是否有选中行的条件
				  alert(checkStatus.isAll ) //表格是否全选 */
			});  
        }
        
        
        function getStudentInfo(){
        	layui.use('table', function(){
			  var table = layui.table;
			  table.render({
        	  page: true,
        	  method:"post",
        	  url:"${pageContext.request.contextPath}/JR/StuList.action",
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
			    ,{field: 'no', title: '学号', width: 120}
			    ,{field: 'name', title: '姓名', width: 120}
			    ,{field: 'sex', title: '性别', width: 80}
			    ,{field: 'birthday', title: '出生日期', width: 120}
			    ,{field: 'school', title: '学校', width: 200}
			    ,{field: 'major', title: '专业', width: 200}
			    ,{field: 'classNo', title: '班级', width: 200}
			    ,{field: 'indate', title: '入学日期', width: 120}
			  ]]
			});
			  
			  
			});
			        	
        	
        	

           /*  var s = "<tr><th>学号</th><th>姓名</th><th>性别</th><th>电话</th><th>邮箱</th><th>操作</th></tr>";
            $.each(data,function(v,o){
                    s+='<tr><td>'+o.no+'</td>';
                    s+='<td>'+o.name+'</td>';
                    s+='<td>'+o.sex+'</td>';
                    s+='<td>'+o.phone+'</td>';
                    s+='<td>'+o.email+'</td>';
                    s+='<td><a href="javascript:deleteRow('+o.no+')">删除</a>&nbsp;&nbsp;<a href="javascript:update('+o.no+')">修改</a></td>';                   
            });
            if(data.length>0){
                $("#t_customerInfo").html(s);
            }else{
                $("#page1").hide();
                $("#t_customerInfo").html("<br/><span style='width:10%;height:30px;display:block;margin:0 auto;'>暂无数据</span>");
            } */


        }
       /*  function toPage(){

            layui.use(['form', 'laypage', 'layedit','layer', 'laydate'], function() {
                var form = layui.form,
                    layer = layui.layer,
                    layedit = layui.layedit,
                    laydate = layui.laydate,
                    laypage = layui.laypage;

                var nums = 10;
                */
                //调用分页
             
               /*  layui.use('laypage', function(){
				  var laypage = layui.laypage;
				  
				  //执行一个laypage实例
				  laypage.render({
				     elem: 't_customerInfo' //注意，这里的 test1 是 ID，不用加 # 号
				    ,count: ${count} //数据总数，从服务端得到
				  });
				}); */
		
    </script>
   
</head>
<body>


    <div class="admin-main">
		<blockquote class="layui-elem-quote">
        	<form class="layui-form" action="" >
        		<div class="layui-form-item">
       				 <div class="layui-input-inline">
            			<input type="text" id="selectValue" lay-verify="required" placeholder="学员姓名" autocomplete="off" class="layui-input">
       				 </div>
       				<button class="layui-btn" type="button" id="selectButton">搜索</button>
        		</div>
        	</form>
        
        </blockquote>
        <fieldset class="layui-elem-field">
            <legend>学员列表</legend>
            <div class="layui-field-box layui-form">
            	<a href="javascript:deleteRow()"><i id="icon1" class="layui-icon">&#xe640;删除</i></a>
            	<a style="position:absolute;right:600px;" href="${pageContext.request.contextPath}/jsp/Student/addStudent.jsp"><i id="icon1" class="layui-icon">&#xe654;添加</i></a>
                <table class="layui-table admin-table"  lay-filter="test" id="t_customerInfo" lay-data="{id: 'idTest'}">
                </table>
            </div>
        </fieldset>
    </div>
    
  </body>
</html>
