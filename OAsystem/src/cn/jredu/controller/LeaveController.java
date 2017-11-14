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

import cn.jredu.entity.Leave;
import cn.jredu.entity.User;
import cn.jredu.service.LeaveService;
import cn.jredu.service.impl.LeaveServiceImpl;

@Controller
@RequestMapping("/leave")
public class LeaveController {

	private static ApplicationContext ctx2=new ClassPathXmlApplicationContext("classpath:applicationContextAnotation.xml");
	private static LeaveService service;
	
	static{
		service=ctx2.getBean(LeaveServiceImpl.class);
	}
	
	
	@RequestMapping("applyforleave")
	public ModelAndView apply(String reason,String startdate,String enddate,HttpSession session){
		int lev_id=service.getLev_id();
		User u=(User) session.getAttribute("user");
		int bossid=u.getBossid();
		String lev_person=u.getNickname();
		Leave l=new Leave(lev_id,lev_person,startdate,enddate,reason);
		boolean isSuccess=service.applyForLeave(l,bossid);
		
		if(isSuccess){
			return new ModelAndView("/jsp/leave/leavelist.jsp");
		}else{
			return new ModelAndView("/jsp/leave/applyforleave.jsp","message","次数已超，无法申请");
		}
		
	}
	@RequestMapping("/showlist")
	@ResponseBody
	public Map<String,Object> showLeave(Integer start, Integer limit,String selectValue,HttpSession session){
		User u=(User) session.getAttribute("user");
		String name=u.getNickname();
		String selectValues=selectValue.trim();
		List<Leave> list=null;
		int count=0;
		if(selectValue!=null&&!selectValue.equals("")){
			list=service.getLeaveListSelect(start, limit, selectValues,name);
			count=service.getTotalCountOfLeaveSelect(selectValues, name);
		}else{
			list=service.getLeaveList(start, limit,name);
			count=service.getTotalCountOfLeave(name);
		}
		if(list!=null){
			for(Leave l:list){
				if(l.getStatus()!=null&&l.getStatus().equals("0")){
					l.setStatus("未审核");
				}else if(l.getStatus()!=null&&l.getStatus().equals("1")){
					l.setStatus("已通过");
				}else{
					l.setStatus("未通过");
				}
			}
		}
		Map<String,Object> map =new HashMap<String,Object>();		
		map.put("code", 0);
		map.put("msg", "");
		map.put("count",count);
		map.put("data", list);
		return map;
	}
	@RequestMapping("/showchecklist")
	@ResponseBody
	public Map<String,Object> checkLeave(Integer start, Integer limit,String selectValue,HttpSession session){
		User u=(User) session.getAttribute("user");
		int userid=u.getUserId();
		String selectValues=selectValue.trim();
		List<Leave> list=null;
		int count=0;
		if(selectValue!=null&&!selectValue.equals("")){
			list=service.getCheckLeaveListSelect(start, limit, selectValues,userid);
			count=service.getCheckTotalCountOfLeaveSelect(selectValues,userid);
		}else{
			list=service.getCheckLeaveList(start, limit,userid);
			count=service.getCheckTotalCountOfLeave(userid);
		}
		if(list!=null){
			for(Leave l:list){
				System.out.println(l.getStatus());
			}
		}
		Map<String,Object> map =new HashMap<String,Object>();		
		map.put("code", 0);
		map.put("msg", "");
		map.put("count",count);
		map.put("data", list);
		return map;
	}
	@RequestMapping("/check")
	public ModelAndView check(Integer lev_id,String isAgree){
		if("agree".equals(isAgree)){
			boolean isSuccess=service.agree(lev_id);
			if(isSuccess){
				return new ModelAndView("/jsp/leave/checkleave.jsp");
			}else{
				return new ModelAndView("/jsp/leave/checkleave.jsp","message","无法通过");
			}
		}else{
			service.disagree(lev_id);
			return new ModelAndView("/jsp/leave/checkleave.jsp");
		}
	}
	
}
