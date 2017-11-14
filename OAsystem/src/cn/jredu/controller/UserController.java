package cn.jredu.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.jredu.entity.User;


import cn.jredu.service.UserService;

import cn.jredu.service.impl.UserServiceImpl;

@Controller
@RequestMapping("/User")
public class UserController {

	private static ApplicationContext ctx2=new ClassPathXmlApplicationContext("classpath:applicationContextAnotation.xml");
	private static UserService service;
	
	static{
		service=ctx2.getBean(UserServiceImpl.class);
	}
	
	@RequestMapping("/check")
	@ResponseBody
	public Map<String,String> checkUser(String userName){
		boolean isSuccess=service.checktUser(userName, null);
		Map<String,String> map=new HashMap<String, String>();
		String s="1";
		if(isSuccess){
			s="1";
		}else{
			s="0";
		}
		map.put("check", s);
		return map;
	}
	@RequestMapping("/register")
	public String userRegister(String userName,String password,String phone,String sex,String checkcode,String bossid){
		
		int userId=service.getUserId();
		String headImg="touxiang.jpg";
		String nickname=userName;
		User user=new User(userId,userName,password,phone,sex,checkcode,headImg,nickname);
		boolean isSuccess=service.saveUser(user,bossid);
		if(isSuccess){
			return "/jsp/login.jsp";
		}else{
			return "/jsp/register.jsp";
		}
	}
	@RequestMapping("/login")
	public ModelAndView userLogin(String userName,String password,String rememberuser,HttpSession session){
		if(userName==null||userName.length()==0||password==null||password.length()==0){
			String message="ÕËºÅ»òÃÜÂë´íÎó";
			return new ModelAndView("/jsp/login.jsp","message",message);
		}
		User user=service.getUser(userName);
		boolean isSuccess=service.checktUser(userName, password);
		if(isSuccess){
			session.setAttribute("user", user);
			return new ModelAndView("/annouse/show.action");
		}else{
			String message="ÕËºÅ»òÃÜÂë´íÎó";
			return new ModelAndView("/jsp/login.jsp","message",message);
		}	
	}
	@RequestMapping("/showemp")
	@ResponseBody
	public Map<String,Object> showEmp(Integer start, Integer limit,String selectValue,HttpSession session){
		
		User user=(User) session.getAttribute("user");
		int userid=user.getUserId();
		List<User> list=null;
		int count=0;
		if(selectValue!=null&&!selectValue.equals("")){
			String selectValues=selectValue.trim();
			list=service.showEmpSelect(start, limit, selectValues,userid);
			count=service.getTotalCountOfUserSelect(selectValues,userid);
		}else{
			list=service.showEmp(start, limit,userid);
			count=service.getTotalCountOfUser( userid);
		}
		for(User l:list){
			if("man".equals(l.getSex())){
				l.setSex("ÄÐ");
			}else{
				l.setSex("Å®");
			}
		}
		Map<String,Object> map =new HashMap<String,Object>();
		map.put("code", 0);
		map.put("msg", "");
		map.put("count",count);
		map.put("data", list);
		return map;
	}
	
	@RequestMapping("/fire")
	@ResponseBody
	public Map<String,Object> delete(String ids){		
		Map<String,Object> map =new HashMap<String,Object>();
		boolean isSuccess=service.fireEmp(ids);
		String s=null;
		if(isSuccess){
			s="ÒÑ¿ª³ý";
		}else{
			s="Ëû²»¹éÄú¹Ü";
		}
		map.put("isSuccess", s);
		return map;
		
	}
	@RequestMapping("/showleader")
	@ResponseBody
	public List<User> showLeader(){
		List<User> list=service.getAllLeader();
		return list;
	}
	@RequestMapping("/showempleft")
	@ResponseBody
	public List<User> showEmpLeft(HttpSession session){
		User user=(User) session.getAttribute("user");
		int userId=user.getUserId();
		List<User> list=service.getEmpLeft(userId);
		return list;
	}
}
