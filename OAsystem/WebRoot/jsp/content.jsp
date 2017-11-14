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
    
    <title>My JSP 'content.jsp' starting page</title>
    
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
	
	<style type="text/css">
		#caldenar{
			text-align:center;
		}
		.scroll{
			overflow:hidden;
			position:relative;
		}
		.scroll li{
			height:60px;
			position:absolute;
			font-size:16px;
			width:500px;
			border-bottom:2px solid #F2F2F2;
			
		}
		.scroll li:hover{
			font-size:20px;
			font-weight:bold;
			background-color:rgba(95,184,120,0.5);
			padding-left:20px;
		}
		#worktab{
			width:100%;	
		}
		.final{
			border-bottom:5px solid #5FB878;
		}
		#worktext{
			resize:none;
			width:100%;
			height:auto;
			
		}
		.overflow{
			overflow-y:auto;
		}
	</style>
	
  </head>
  
  <body>
  <div style="height:60px;position: relative;top: 0;width:100%;z-index: 100;background: #393D49;">  
            <div style="display: inline;font-size: 40px;margin-left:20px;">  
                <a><img src="${pageContext.request.contextPath}/image/title100.png" style="width: 400px;height: 50px;"></a>  
            </div>  
            <ul class="layui-nav" style="border-radius: 0;display: inline;float: right;">  
                <li class="layui-nav-item"> 
                	
                    <a href="${pageContext.request.contextPath}/jsp/info.jsp">
	                    <img src="/img/${user.headImg}" class="layui-nav-img"> 
	                    ${user.nickname}
                    </a>  
                </li>  
                <li class="layui-nav-item">  
                    <a href="${pageContext.request.contextPath}/jsp/setting.jsp">设置</a>  
                </li>  
                <li class="layui-nav-item">  
                    <a href="${pageContext.request.contextPath}/jsp/login.jsp">退出</a>  
                </li>  
            </ul>  
        </div>  
        <div style="top:60px;position: fixed;overflow-x: hidden;">  
            <ul class="layui-nav layui-nav-tree layui-nav-side" style="margin-top: 60px;border-radius: 0;">  
                <li class="layui-nav-item layui-nav-itemed">  
                    <a>学员管理</a>  
                    <dl class="layui-nav-child">  
                        <dd>  
                            <a name='a' title="${pageContext.request.contextPath}/jsp/Student/list.jsp">在读学员信息管理</a>  
                        </dd>  
                        <dd>  
                            <a name='a' title="${pageContext.request.contextPath}/jsp/Student/graduatelist.jsp">已毕业学员信息管理</a>  
                        </dd>  
                        <dd>  
                            <a name='a' title="../../address.html">休学学员信息管理</a>  
                        </dd>
                        <dd>  
                            <a name='a' title="../../address.html">导入学员信息数据</a>  
                        </dd> 
                        <dd>  
                            <a name='a' title="${pageContext.request.contextPath}/jsp/Student/addStudent.jsp">添加学员信息</a>  
                        </dd>
                         <dd>  
                            <a name='a' title="../../address.html">班级管理</a>  
                        </dd>
                         <dd>  
                            <a name='a' title="../../address.html">贷款缴费明细管理</a>  
                        </dd>   
                    </dl>  
                </li>  
                <li class="layui-nav-item layui-nav-itemed">  
                    <a>请假管理</a>  
                    <dl class="layui-nav-child">  
                        <dd>  
                            <a name='a' title="${pageContext.request.contextPath}/jsp/leave/leavelist.jsp">请假申请</a>  
                        </dd>  
                        <dd>  
                            <a name='a' title="${pageContext.request.contextPath}/jsp/leave/checkleave.jsp">请假审批</a>  
                        </dd>  
                    </dl>  
                </li>  
                  
                <li class="layui-nav-item layui-nav-itemed">  
                    <a>综合管理</a>  
                    <dl class="layui-nav-child">  
                        <dd>  
                            <a name='a' title="${pageContext.request.contextPath}/jsp/multiple/annouse.jsp">通告管理</a>  
                        </dd>  
                        <dd>  
                            <a name='a' title="${pageContext.request.contextPath}/jsp/multiple/recentwork.jsp">待办事项管理</a>  
                        </dd>
                        <dd>  
                            <a name='a' title="${pageContext.request.contextPath}/jsp/multiple/recentthing.jsp">最近安排管理</a>  
                        </dd>   
                    </dl>  
                </li>  
            </ul>  
        </div>  
        <div style="left: 200px;right:0;position: absolute;overflow-y: auto;">  
            <div class="layui-tab" lay-filter="demo">  
                <ul id="tabTitle" class="layui-tab-title">
                	<li class="layui-this">首页</li>
                </ul>  
                <div id="tabContainers" class="layui-tab-content">
                	  <div class="layui-tab-item layui-show">
                	  <div class="layui-container">
						  <div class="layui-row layui-col-space20">
						    <div class="layui-col-md6">
						       <div class="layui-collapse">
								  <div class="layui-colla-item">
								    <h2 class="layui-colla-title">最新通告</h2>
								    <div class="layui-colla-content layui-show scroll" style="height:240px;">
								    	<ul>
								    	<c:forEach items="${annouse}" var="ann" varStatus="idx">
								    		<li style="top:${idx.index*60}px">
								    			<dl>
								    				<dt>${ann.author}</dt>
								    				<dd>${ann.content}</dd>
								    				<dd style="position:absolute;right:10px;">${ann.pubdate}</dd>
								    			</dl>
								    		</li>
								    	</c:forEach>								    	
								    	</ul>
								    </div>
								  </div>
								  <div class="layui-colla-item">
								    <h2 class="layui-colla-title">我的最近安排</h2>
								    <div class="layui-colla-content layui-show overflow" style="height:240px;">
								    	<ul>
								    	<c:forEach items="${recentthing}" var="recent" varStatus="idx">
								    		<li style="top:${idx.index*60}px;border-bottom:2px solid #F2F2F2;padding-bottom:20px;">
								    			<dl>
								    				<dd style="padding-left:20px">${recent.content}</dd>
								    				<dd style="position:absolute;right:30px;">${recent.pubdate}</dd>
								    			</dl>
								    		</li>
								    	</c:forEach>								    	
								    	</ul>
								    </div>
								  </div>						 
								</div>    
						    </div>
						    <div class="layui-col-md6">
						     	 <div class="layui-collapse">
									  <div class="layui-colla-item">
									    <h2 class="layui-colla-title">办公系统待办</h2>
									    <div class="layui-colla-content layui-show overflow" style="height:200px;">
									    	<table id="worktab">
									    		<c:forEach items="${recentwork}" var="work" varStatus="idx">
									    		
									    		<tr>
									    			<td style="color:red">工作${idx.index+1}</td>
									    			<td align="right">发布工作者:<span style="color:#FF5722;font-size:18px;font-weight:bold;">${work.forwho}</span></td>
									    		</tr>
									    		<tr>
									    			<td colspan="2">
									    				<textarea readonly id="worktext">${work.content}</textarea>
									    			</td>
									    		</tr>
									    		<tr class="final">
									    			<td>发布日期:${work.pubdate}</td>
									    			<td align="right">需完成日期:${work.completedate}</td>
									    		</tr>
									    		</c:forEach>								    	
								    		</table>
									    </div>
									  </div>
									  <div class="layui-colla-item">
									    <div id="caldenar" class="layui-colla-content layui-show">
									   		 
									    </div>
									  </div>						 
									</div>    
						    </div>
						  </div>
					  </div>
                	  </div>
                </div>  
            </div> 
        </div>
        <!-- 最新通告 无缝隙滚动 -->
        <script type="text/javascript">
        	$(function(){
        		var lis=$(".scroll li");
        		gun=setInterval(function() {
        			$.each(lis,function(index,li){
        			var list=$(li);
        			var height=parseFloat(list.height());
        			var top=parseFloat(list.css("top"));
        			list.css("top",top-1);
        			if(top<-height){
        				var bottom=(lis.length-1)*height;
        				list.css("top",bottom)
        			}
        		});
        		}, 50)
        		//停止滚动
        		var div=$(".scroll ul");
        		div.hover(function(){
        			clearInterval(gun)
        		},function(){
        			gun=setInterval(function() {
        			$.each(lis,function(index,li){
        			var list=$(li);
        			var height=parseFloat(list.height());
        			var top=parseFloat(list.css("top"));
        			list.css("top",top-1);
        			if(top<-height){
        				var bottom=(lis.length-1)*height;
        				list.css("top",bottom)
        			}
        		});
        		}, 50)
        		});
        	});
        </script>
        
        
        
        
         <script>
			layui.use('laydate', function(){
			  var laydate = layui.laydate;
			  
			  //执行一个laydate实例
			  laydate.render({
			    elem: '#caldenar' //指定元素
			    ,show: true
			    ,btns: ['now']
			    ,position: 'static'
			    ,change: function(value, date){ //监听日期被切换
			    	lay('#testView').html(value);
			    }
			    ,theme: '#FF5722'
			    ,calendar: true
			    ,mark: {
				    '0-2-14': '生日'
				    ,'0-12-31': '跨年' //每年12月31日
				    ,'0-0-10': '工资' //每个月10号
				    ,'2017-8-15': '' //具体日期
				    ,'2017-8-20': '预发' //如果为空字符，则默认显示数字+徽章
				    ,'2017-8-21': '发布'
				  }				 
			  });
			  
			});
		</script>
		
		
		
        <script type="text/javascript">  
            //调整iframe高度  
            function reinitIframe() {  
                var iframes = document.getElementsByName("iframe");  
                try {  
                    for(var i = 0; i < iframes.length; i++)  
                        //iframes[i].height = iframes[i].contentWindow.document.documentElement.scrollHeight;  
                        iframes[i].height = window.screen.height -280;  
                } catch(ex) {}  
            }  
            window.setInterval("reinitIframe()", 200);  
  
            layui.use(['layer', 'laypage', 'element'], function() {  
                var $ = layui.jquery,  
                    element = layui.element; //Tab的切换功能，切换事件监听等，需要依赖element模块  
  				//添加点击事件
  				var ssm=$("a[name='a']");
                   ssm.on("click", function() {  
                   var title = $(this).text();  
                   var tabs = $(".layui-tab-title").children();  
                   
                   //判断是否已打开，若已打开则直接切换
                   for(var i = 0; i < tabs.length; i++) {  
                       if($(tabs[i]).html().substr(0,$(tabs[i]).html().indexOf("i")-1) == title) {
						element.tabChange('demo', $(tabs[i]).attr("lay-id"));  
                           return; 
                       }                        
                   }
                   //添加tab 
                   element.tabAdd('demo', {  
                      title: $(this).text() + "<i class='layui-icon layui-unselect layui-tab-close'>ဆ</i>",  
                      content: '<iframe name="iframe" src="' + this.title + '" frameborder="0" style="width: 100%;"></iframe>',
                      id: new Date().getTime()
                   });
                   //添加删除功能
                   var r = $("#tabTitle").find("li");    
                        r.eq(r.length - 1).children("i").on("click", function () {
                    	element.tabDelete("demo", $(this).parent("li").attr('lay-id'));
                    }), element.tabChange("demo",$(this).parent("li").attr('lay-id'));
                    element.init();
               });
           });
            
        </script>
        
        <!-- 日历 -->
        <script>
			//注意：折叠面板 依赖 element 模块，否则无法进行功能性操作
			layui.use('element', function(){
			  var element = layui.element;
			});
		</script>  
  </body>
</html>
