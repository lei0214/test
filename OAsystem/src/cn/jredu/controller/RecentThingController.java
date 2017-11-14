package cn.jredu.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
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

import cn.jredu.entity.RecentThing;
import cn.jredu.entity.RecentWork;
import cn.jredu.entity.User;
import cn.jredu.service.RecentThingService;
import cn.jredu.service.impl.RecentThingServiceImpl;

@Controller
@RequestMapping("/recent")
public class RecentThingController {
	
	private static ApplicationContext ctx2=new ClassPathXmlApplicationContext("classpath:applicationContextAnotation.xml");
	private static RecentThingService service;

	static{
		service=ctx2.getBean(RecentThingServiceImpl.class);
		
	}
	
	@RequestMapping("/recentthing")
	@ResponseBody
	public Map<String,Object> showRecentThing(Integer start, Integer limit,HttpSession session){
		User user=(User) session.getAttribute("user");
		String username=user.getUserName();
		List<RecentThing> list=null;
		int count=0;	
		list=service.showListOfRecentThing(start, limit, username);
		count=service.getTotalCountOfRecentThing(username);
		Map<String,Object> map =new HashMap<String,Object>();
		map.put("code", 0);
		map.put("msg", "");
		map.put("count",count);
		map.put("data", list);
		return map;
		
	}
	@RequestMapping("/recentwork")
	@ResponseBody
	public Map<String,Object> showRecentWork(Integer start, Integer limit,HttpSession session){
		User user=(User) session.getAttribute("user");
		String username=user.getUserName();
		List<RecentWork> list=null;
		int count=0;	
		list=service.showListOfRecentWork(start, limit, username);
		count=service.getTotalCountOfRecentWork(username);
		Map<String,Object> map =new HashMap<String,Object>();
		map.put("code", 0);
		map.put("msg", "");
		map.put("count",count);
		map.put("data", list);
		return map;
		
	}
	@RequestMapping("/savething")
	public ModelAndView saveRecentThing(String content,HttpSession session){

		User user=(User) session.getAttribute("user");
		String username=user.getUserName();
		int id=service.getRecentThingId();
		Date date=new Date();
		SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd");
		String pubdate=sf.format(date);
		RecentThing rt=new RecentThing(id,content,pubdate,username);
		boolean isSuccess=service.addRecentThing(rt);
		String s=null;
		if(isSuccess){
			s="添加成功";
		}else{
			s="添加失败";
		}

		return new ModelAndView("/jsp/multiple/recentthing.jsp","message",s);
	}
	@RequestMapping("/deletething")
	@ResponseBody
	public Map<String,Object> delete(String ids,HttpSession session){
		User user=(User) session.getAttribute("user");
		String username=user.getUserName();
		Map<String,Object> map =new HashMap<String,Object>();
		boolean isSuccess=service.deleteRecentThingById(ids,username);
		String s=null;
		if(isSuccess){
			s="1";
		}else{
			s="0";
		}
		map.put("isSuccess", s);
		return map;
		
	}
	@RequestMapping("/savework")
	public ModelAndView saveRecentWork(String empname,String completedate,String content,HttpSession session){

		User user=(User) session.getAttribute("user");
		int id=service.getRecentWorkId();
		Date date=new Date();
		SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd");
		String pubdate=sf.format(date);
		RecentWork rw=new RecentWork(id,user.getNickname(),content,pubdate,completedate,empname);
		boolean isSuccess=service.addRecentWork(rw);
		String s=null;
		if(isSuccess){
			s="添加成功";
		}else{
			s="添加失败";
		}
		return new ModelAndView("/jsp/leader/addwork.jsp","message",s);
	}
	
	
}
