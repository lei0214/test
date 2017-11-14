package cn.jredu.dao;

import java.util.List;

import cn.jredu.entity.Leave;

public interface LeaveDao {

	/*
	 * ��ȡlev_id
	 */
	public int getLev_id(String sql) throws Exception;
	/*
	 * �ύ�������
	 */
	public int applyForLeave(String sql,List<Object> params) throws Exception;
	/*
	 * ��ȡ��������������
	 */
	public int getTotalCountOfLeave(String sql,List<Object> params) throws Exception;
	/*
	 * չʾ��������б�
	 */
	public List<Leave> getLeaveList(String sql,List<Object> params) throws Exception;
	/*
	 * ��ȡ����������������������
	 */
	public int getTotalCountOfLeaveSelect(String sql,List<Object> params) throws Exception;
	/*
	 * ��ȡ������������������Ϣ�б�
	 */
	public List<Leave> getLeaveListSelect(String sql,List<Object> params) throws Exception;
	/*
	 * ͬ�����
	 */
	public int agree(String sql,List<Object> params) throws Exception;
	/*
	 * ��ͬ�����
	 */
	public int disagree(String sql,List<Object> params) throws Exception;
}
