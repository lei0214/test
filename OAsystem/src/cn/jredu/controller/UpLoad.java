package cn.jredu.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.jredu.entity.User;
import cn.jredu.service.UserService;
import cn.jredu.service.impl.UserServiceImpl;

/**
 * Servlet implementation class UpLoad
 */
@WebServlet("/UpLoad")
public class UpLoad extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService service;  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpLoad() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//创建磁盘缓冲工厂  设置缓冲区
		DiskFileItemFactory factory=new DiskFileItemFactory();
		
		//限制文件 大小、类型等,并且和磁盘缓冲工厂关联		
		ServletFileUpload serf=new ServletFileUpload(factory);
		
		//约定大小为10M
		serf.setFileSizeMax(1024*1024*10);
		
		//设置请求头编码
		serf.setHeaderEncoding("utf-8");
		
		//解析传递过来的值得类型
		User u=(User) request.getSession().getAttribute("user");
		String userName=u.getUserName();
		try {
			@SuppressWarnings("unchecked")
			List<FileItem> list=serf.parseRequest(request);
			for(FileItem item:list){
				if(item.isFormField()){
					//是普通元素
					//1、获取该表单元素的属性名
					String name=item.getFieldName();
					//2、获取该表单元素的属性值
					String value=item.getString("utf-8");
					service.changeNickName(value,userName);
					u.setNickname(value);
				}else{
					//是文件元素
					//1、获取上传文件的名字
					String filename=item.getName();
					//2、重新定义文件名
					String newfilename=System.currentTimeMillis()+filename;
					//将新的名字存储到数据库
					service.upLoadHeadImg(userName, newfilename);
					//3、将缓存的文件持久化到硬盘
					File file=new File("H://image/"+newfilename);
					
					item.write(file);
					//清除缓冲文件
					item.delete();
					//刷新session里的信息
					u.setHeadImg(newfilename);
					//request.getSession().setAttribute("user", u);
					//跳转到主页面
					response.sendRedirect(request.getContextPath()+"/annouse/show.action");
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		ApplicationContext ctx2=new ClassPathXmlApplicationContext("classpath:applicationContextAnotation.xml");
		service=ctx2.getBean(UserServiceImpl.class);
		super.init(config);
	}

}
