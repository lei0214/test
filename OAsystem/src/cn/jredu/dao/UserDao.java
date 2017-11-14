package cn.jredu.dao;

import java.util.List;

import cn.jredu.entity.User;

public interface UserDao {

	/*
	 * ��ע��ɹ����û��������ݿ�
	 */
	public int saveUser(String sql,List<Object> params) throws Exception;
	/*
	 * ��ȡuserId
	 */
	public int getUserId(String sql) throws Exception;
	/*
	 * ��ȡ���ڵ�¼���û�
	 */
	public List<User> getUser(String sql,List<Object> params)throws Exception;
	
	/*
	 * ��ȡ�����û�
	 */
	public List<User> getAllUser(String sql) throws Exception ;
	/*
	 * �޸�ͷ��
	 */
	public int upLoadHeadImg(String sql,List<Object> params) throws Exception;
	/*
	 * �޸��ǳ�
	 */
	public int changeNickName(String sql,List<Object> params) throws Exception;
	/*
	 * չʾ����Ա��
	 */
	public List<User> showAllEmp(String sql,List<Object> params) throws Exception;
	/*
	 * ���Ա������
	 */
	public int getToltalCountOfUser(String sql,List<Object> params) throws Exception ;
	/*
	 * չʾ���з�������Ա��
	 */
	public List<User> showAllEmpSelect(String sql,List<Object> params) throws Exception;
	/*
	 * ��÷�������Ա������
	 */
	public int getToltalCountOfUserSelect(String sql,List<Object> params) throws Exception ;
	/*
	 * ����Ա��
	 */
	public int fireEmp(String sql,List<Object> params) throws Exception ;
	/*
	 * ��ȡ�����쵼
	 */
	public List<User> getAllLeader(String sql) throws Exception ;
	/*
	 * ��ȡ�쵼��Ա��
	 */
	public List<User> getEmpLeft(String sql,List<Object> params) throws Exception ;
}
