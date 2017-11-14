package cn.jredu.dao;

import java.util.List;

import cn.jredu.entity.Student;

public interface StudentDao {
	/*
	 * 获取学员总数
	 */
	public int getTotalCount(String sql)throws Exception;
	/*
	 * 获取符合条件的学员数
	 */
	public int getTotalCountSelect(String sql,List<Object> params)throws Exception;
	/*
	 * 获取所有学员信息
	 */
	public List<Student> showAllStudentInfo(String sql,List<Object> params)throws Exception;
	/*
	 * 通过NO删除学员
	 */
	public int deleteStudentByNo(String sql,List<Object> params)throws Exception;
	/*
	 * 添加学员
	 */
	public int addStudent(String sql,List<Object> params)throws Exception;
}
