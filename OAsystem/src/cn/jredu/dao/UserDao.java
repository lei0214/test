package cn.jredu.dao;

import java.util.List;

import cn.jredu.entity.User;

public interface UserDao {

	/*
	 * 将注册成功的用户加入数据库
	 */
	public int saveUser(String sql,List<Object> params) throws Exception;
	/*
	 * 获取userId
	 */
	public int getUserId(String sql) throws Exception;
	/*
	 * 获取正在登录的用户
	 */
	public List<User> getUser(String sql,List<Object> params)throws Exception;
	
	/*
	 * 获取所有用户
	 */
	public List<User> getAllUser(String sql) throws Exception ;
	/*
	 * 修改头像
	 */
	public int upLoadHeadImg(String sql,List<Object> params) throws Exception;
	/*
	 * 修改昵称
	 */
	public int changeNickName(String sql,List<Object> params) throws Exception;
	/*
	 * 展示所有员工
	 */
	public List<User> showAllEmp(String sql,List<Object> params) throws Exception;
	/*
	 * 获得员工总数
	 */
	public int getToltalCountOfUser(String sql,List<Object> params) throws Exception ;
	/*
	 * 展示所有符合条件员工
	 */
	public List<User> showAllEmpSelect(String sql,List<Object> params) throws Exception;
	/*
	 * 获得符合条件员工总数
	 */
	public int getToltalCountOfUserSelect(String sql,List<Object> params) throws Exception ;
	/*
	 * 开除员工
	 */
	public int fireEmp(String sql,List<Object> params) throws Exception ;
	/*
	 * 获取所有领导
	 */
	public List<User> getAllLeader(String sql) throws Exception ;
	/*
	 * 获取领导的员工
	 */
	public List<User> getEmpLeft(String sql,List<Object> params) throws Exception ;
}
