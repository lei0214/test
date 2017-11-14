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

import cn.jredu.entity.Annouse;
import cn.jredu.entity.RecentThing;
import cn.jredu.entity.RecentWork;
import cn.jredu.entity.User;
import cn.jredu.service.AnnouseService;
import cn.jredu.service.impl.AnnouseServiceImpl;


@Controller
@RequestMapping("/annouse")
public class AnnouseController {
	
	private static ApplicationContext ctx2=new ClassPathXmlApplicationContext("classpath:applicationContextAnotation.xml");
	private static AnnouseService service;
	
	static{
		service=ctx2.getBean(AnnouseServiceImpl.class);
	}
	
	@RequestMapping("/show")
	public ModelAndView showAnnouse(HttpSession session){
		User user=(User) session.getAttribute("user");
		String username=user.getUserName();
		int id=user.getUserId();
		int bossid=user.getBossid();
		List<Annouse> list1=service.showAnnouse();
		List<RecentThing> list2=service.showRecentThing(username);
		List<RecentWork> list3=service.showRecentWork(username);
		Map<String,Object> map =new HashMap<String, Object>();
		map.put("annouse", list1);
		map.put("recentthing", list2);
		map.put("recentwork", list3);
		if(id==bossid||bossid==41){
			return new ModelAndView("/jsp/leader/content.jsp",map);
		}
		return new ModelAndView("/jsp/content.jsp",map);
	}
	@RequestMapping("/showlist")
	@ResponseBody
	public Map<String,Object> showList(Integer start, Integer limit,String selectValue){
		String selectValues=selectValue.trim();
		List<Annouse> list=null;
		int count=0;
		if(selectValue!=null&&!selectValue.equals("")){
			list=service.showAnnouseListSelect(start, limit, selectValues);
			count=service.getTotalCountSelect(selectValues);
		}else{
			list=service.showAnnouseList(start, limit);
			count=service.getTotalCount();
		}
		Map<String,Object> map =new HashMap<String,Object>();
		map.put("code", 0);
		map.put("msg", "");
		map.put("count",count);
		map.put("data", list);
		return map;
		
	}
	@RequestMapping("/delete")
	@ResponseBody
	public Map<String,Object> delete(String ids){
		Map<String,Object> map =new HashMap<String,Object>();
		boolean isSuccess=service.deleteAnnouseById(ids);
		String s=null;
		if(isSuccess){
			s="1";
		}else{
			s="0";
		}
		map.put("isSuccess", s);
		return map;
		
	}
	@RequestMapping("/save")
	public ModelAndView saveAnnouse(String author,String content){
		int id=service.getId();
		Date date=new Date();
		SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd");
		String pubdate=sf.format(date);
		Annouse ann=new Annouse(id,author,content,pubdate);
		boolean isSuccess=service.saveAnnouse(ann);
		if(isSuccess){
			String message="添加成功";
			return new ModelAndView("/jsp/multiple/annouse.jsp","message",message);
		}else{
			String message="添加失败";
			return new ModelAndView("/jsp/multiple/annouse.jsp","message",message);
		}
	}
}
