package cn.jredu.service;

import java.util.List;

import cn.jredu.entity.User;

public interface UserService {

	/*
	 * 存储注册的用户
	 */
	public boolean saveUser(User user,String bossid);
	
	/*
	 * 寻找登录的用户是否存在
	 */
	public boolean checktUser(String userName,String userPwd);
	public User getUser(String userName);
	/*
	 * 获得userId
	 */
	public int getUserId();
	/*
	 * 保存头像
	 */
	public boolean upLoadHeadImg(String userName,String headImg);
	/*
	 * 修改昵称
	 */
	public boolean changeNickName(String nickname,String userName);
	/*
	 * 展示所有员工
	 */
	public List<User> showEmp(Integer start, Integer limit,int userid);
	/*
	 * 获得员工总数
	 */
	public int getTotalCountOfUser(int userid);
	/*
	 * 展示符合条件的员工
	 */
	public List<User> showEmpSelect(Integer start, Integer limit,String selectValue,int userid);
	/*
	 * 获取符合条件的员工总数
	 */
	public int getTotalCountOfUserSelect(String selectValue,int userid);
	/*
	 * 开除员工
	 */
	public boolean fireEmp(String ids);
	/*
	 * 查找所有领导
	 */
	public List<User> getAllLeader();
	/*
	 * 查询领导的员工
	 */
	public List<User> getEmpLeft(int userId);
}
