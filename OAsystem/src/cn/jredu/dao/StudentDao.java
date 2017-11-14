package cn.jredu.dao;

import java.util.List;

import cn.jredu.entity.Student;

public interface StudentDao {
	/*
	 * ��ȡѧԱ����
	 */
	public int getTotalCount(String sql)throws Exception;
	/*
	 * ��ȡ����������ѧԱ��
	 */
	public int getTotalCountSelect(String sql,List<Object> params)throws Exception;
	/*
	 * ��ȡ����ѧԱ��Ϣ
	 */
	public List<Student> showAllStudentInfo(String sql,List<Object> params)throws Exception;
	/*
	 * ͨ��NOɾ��ѧԱ
	 */
	public int deleteStudentByNo(String sql,List<Object> params)throws Exception;
	/*
	 * ���ѧԱ
	 */
	public int addStudent(String sql,List<Object> params)throws Exception;
}
