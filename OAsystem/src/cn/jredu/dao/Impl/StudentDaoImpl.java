package cn.jredu.dao.Impl;


import java.util.List;

import org.springframework.stereotype.Repository;

import cn.jredu.dao.StudentDao;
import cn.jredu.entity.Student;
import cn.jredu.util.BaseDao;

@Repository
public class StudentDaoImpl extends BaseDao implements StudentDao {

	@Override
	public int getTotalCount(String sql) throws Exception {
		List<Student> list=getModelListByResultSet(sql, null, new Student());
		int count=0;
		if(list!=null){
			count=list.size();
		}
		return count;
	}

	@Override
	public List<Student> showAllStudentInfo(String sql,List<Object> params) throws Exception {
		List<Student> list=getModelListByResultSet(sql, params, new Student());
		return list;
	}

	@Override
	public int deleteStudentByNo(String sql, List<Object> params) throws Exception {
		
		return executeUpdate(sql, params);
	}

	@Override
	public int addStudent(String sql, List<Object> params) throws Exception {
		
		return executeUpdate(sql, params);
	}

	@Override
	public int getTotalCountSelect(String sql, List<Object> params) throws Exception {
		List<Student> list=getModelListByResultSet(sql, params, new Student());
		int count=0;
		if(list!=null){
			count=list.size();
		}
		return count;
	}

}
