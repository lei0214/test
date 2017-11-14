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
		
		//�������̻��幤��  ���û�����
		DiskFileItemFactory factory=new DiskFileItemFactory();
		
		//�����ļ� ��С�����͵�,���Һʹ��̻��幤������		
		ServletFileUpload serf=new ServletFileUpload(factory);
		
		//Լ����СΪ10M
		serf.setFileSizeMax(1024*1024*10);
		
		//��������ͷ����
		serf.setHeaderEncoding("utf-8");
		
		//�������ݹ�����ֵ������
		User u=(User) request.getSession().getAttribute("user");
		String userName=u.getUserName();
		try {
			@SuppressWarnings("unchecked")
			List<FileItem> list=serf.parseRequest(request);
			for(FileItem item:list){
				if(item.isFormField()){
					//����ͨԪ��
					//1����ȡ�ñ�Ԫ�ص�������
					String name=item.getFieldName();
					//2����ȡ�ñ�Ԫ�ص�����ֵ
					String value=item.getString("utf-8");
					service.changeNickName(value,userName);
					u.setNickname(value);
				}else{
					//���ļ�Ԫ��
					//1����ȡ�ϴ��ļ�������
					String filename=item.getName();
					//2�����¶����ļ���
					String newfilename=System.currentTimeMillis()+filename;
					//���µ����ִ洢�����ݿ�
					service.upLoadHeadImg(userName, newfilename);
					//3����������ļ��־û���Ӳ��
					File file=new File("H://image/"+newfilename);
					
					item.write(file);
					//��������ļ�
					item.delete();
					//ˢ��session�����Ϣ
					u.setHeadImg(newfilename);
					//request.getSession().setAttribute("user", u);
					//��ת����ҳ��
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
