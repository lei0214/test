package cn.jredu.dao.Impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.jredu.dao.UserDao;
import cn.jredu.entity.User;
import cn.jredu.util.BaseDao;

@Repository
public class UserDaoImpl extends BaseDao implements UserDao{

	@Override
	public int saveUser(String sql, List<Object> params) throws Exception {
		
		return executeUpdate(sql, params);
	}
	@Override
	public int getUserId(String sql) throws Exception {
		
		return getCurrentIndex(sql);
	}

	@Override
	public List<User> getUser(String sql, List<Object> params) throws Exception {
		List<User> list = getModelListByResultSet(sql,params,new User());
		return list;
	}

	@Override
	public List<User> getAllUser(String sql) throws Exception {
		List<User> list = getModelListByResultSet(sql,null,new User());
		return list;
	}
	@Override
	public int upLoadHeadImg(String sql, List<Object> params) throws Exception {
		return executeUpdate(sql, params);
	}
	@Override
	public int changeNickName(String sql, List<Object> params) throws Exception {
		return executeUpdate(sql, params);
	}
	@Override
	public List<User> showAllEmp(String sql, List<Object> params) throws Exception {
		List<User> list = getModelListByResultSet(sql,params,new User());
		return list;
	}
	@Override
	public int getToltalCountOfUser(String sql,List<Object> params) throws Exception {
		List<User> list = getModelListByResultSet(sql,params,new User());
		int count=0;
		if(list!=null){
			count=list.size();
		}
		return count;
	}
	@Override
	public List<User> showAllEmpSelect(String sql, List<Object> params) throws Exception {
		List<User> list = getModelListByResultSet(sql,params,new User());
		return list;
	}
	@Override
	public int getToltalCountOfUserSelect(String sql, List<Object> params) throws Exception {
		List<User> list = getModelListByResultSet(sql,params,new User());
		int count=0;
		if(list!=null){
			count=list.size();
		}
		return count;
	}
	@Override
	public int fireEmp(String sql, List<Object> params) throws Exception {
		return executeUpdate(sql, params);
	}
	@Override
	public List<User> getAllLeader(String sql) throws Exception {
		List<User> list = getModelListByResultSet(sql,null,new User());
		return list;

	}
	@Override
	public List<User> getEmpLeft(String sql, List<Object> params) throws Exception {
		List<User> list = getModelListByResultSet(sql,params,new User());
		return list;
	}	

}
