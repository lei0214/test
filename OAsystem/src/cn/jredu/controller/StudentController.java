package cn.jredu.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.jredu.entity.Student;
import cn.jredu.service.StudentService;
import cn.jredu.service.impl.StudentServiceImpl;


@Controller
@RequestMapping("/JR")
public class StudentController {
	private static ApplicationContext ctx2=new ClassPathXmlApplicationContext("classpath:applicationContextAnotation.xml");
	private static StudentService service;
	
	static{
		service=ctx2.getBean(StudentServiceImpl.class);
	}
	
	@RequestMapping("/StuList")
	@ResponseBody
	public Map<String,Object> show(Integer start, Integer limit,String selectValue){
		String selectValues=selectValue.trim();
		List<Student> list=null;
		int count=0;
		if(selectValue!=null&&!selectValue.equals("")){
			list=service.showSelect(start, limit,selectValues);
			count=service.getTotalCountSelect(selectValues);
		}else{
			list=service.show(start, limit);
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
	public Map<String,Object> delete(String nos){
		Map<String,Object> map =new HashMap<String,Object>();
		
		boolean isSuccess=service.deleteStudentByNo(nos);
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
	public ModelAndView saveStudent(String no,String name,String sex,String birthday,String school,String major,String classNo,String indate){
				
		
		
		Student stu=new Student(Integer.parseInt(no),name,sex,birthday,school,major,classNo,indate);
		boolean isSuccess=service.addStudent(stu);
		if(isSuccess){
			String message="添加成功";
			return new ModelAndView("/jsp/Student/list.jsp","message",message);
		}else{
			String message="学号已存在";
			return new ModelAndView("/jsp/Student/addStudent.jsp","message",message);
		}
		
	}
	
	
}
