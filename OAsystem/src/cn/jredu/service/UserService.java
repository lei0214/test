package cn.jredu.service;

import java.util.List;

import cn.jredu.entity.User;

public interface UserService {

	/*
	 * �洢ע����û�
	 */
	public boolean saveUser(User user,String bossid);
	
	/*
	 * Ѱ�ҵ�¼���û��Ƿ����
	 */
	public boolean checktUser(String userName,String userPwd);
	public User getUser(String userName);
	/*
	 * ���userId
	 */
	public int getUserId();
	/*
	 * ����ͷ��
	 */
	public boolean upLoadHeadImg(String userName,String headImg);
	/*
	 * �޸��ǳ�
	 */
	public boolean changeNickName(String nickname,String userName);
	/*
	 * չʾ����Ա��
	 */
	public List<User> showEmp(Integer start, Integer limit,int userid);
	/*
	 * ���Ա������
	 */
	public int getTotalCountOfUser(int userid);
	/*
	 * չʾ����������Ա��
	 */
	public List<User> showEmpSelect(Integer start, Integer limit,String selectValue,int userid);
	/*
	 * ��ȡ����������Ա������
	 */
	public int getTotalCountOfUserSelect(String selectValue,int userid);
	/*
	 * ����Ա��
	 */
	public boolean fireEmp(String ids);
	/*
	 * ���������쵼
	 */
	public List<User> getAllLeader();
	/*
	 * ��ѯ�쵼��Ա��
	 */
	public List<User> getEmpLeft(int userId);
}
