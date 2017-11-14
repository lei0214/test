package cn.jredu.service;


import java.util.List;


import cn.jredu.entity.Student;

public interface StudentService {
	
	/*
	 * 获取学员总数
	 */
	public int getTotalCount();
	/*
	 * 展示所有学员
	 */
	public List<Student> show(Integer start, Integer limit);
	/*
	 * 获取符合条件的学员数
	 */
	public int getTotalCountSelect(String selectValue);
	/*
	 * 条件查询
	 */
	public List<Student> showSelect(Integer start, Integer limit,String selectValue);
	/*
	 * 通过NO删除学员
	 */
	public boolean deleteStudentByNo(String nos);
	/*
	 * 保存添加的学员
	 */
	public boolean addStudent(Student stu);
}
