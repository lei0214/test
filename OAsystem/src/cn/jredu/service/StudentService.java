package cn.jredu.service;


import java.util.List;


import cn.jredu.entity.Student;

public interface StudentService {
	
	/*
	 * ��ȡѧԱ����
	 */
	public int getTotalCount();
	/*
	 * չʾ����ѧԱ
	 */
	public List<Student> show(Integer start, Integer limit);
	/*
	 * ��ȡ����������ѧԱ��
	 */
	public int getTotalCountSelect(String selectValue);
	/*
	 * ������ѯ
	 */
	public List<Student> showSelect(Integer start, Integer limit,String selectValue);
	/*
	 * ͨ��NOɾ��ѧԱ
	 */
	public boolean deleteStudentByNo(String nos);
	/*
	 * ������ӵ�ѧԱ
	 */
	public boolean addStudent(Student stu);
}
