package cn.jredu.service;

import java.util.List;

import cn.jredu.entity.Leave;

public interface LeaveService {
	/*
	 * ��ȡlev_id
	 */
	public int getLev_id();
	/*
	 * �ύ�������
	 */
	public boolean applyForLeave(Leave l,int bossid);
	/*
	 * ��ȡ��������������
	 */
	public int getTotalCountOfLeave(String name);
	/*
	 * ��ȡ��� ������Ϣ
	 */
	public List<Leave> getLeaveList(Integer start, Integer limit,String name);
	/*
	 * ��ȡ���������������������
	 */
	public int getTotalCountOfLeaveSelect(String selectValue,String name);
	/*
	 * ��ȡ�������������������Ϣ�б�
	 */
	public List<Leave> getLeaveListSelect(Integer start, Integer limit,String selectValue,String name);
	/*
	 * ��ȡ��������������
	 */
	public int getCheckTotalCountOfLeave(int bossid);
	/*
	 * ��ȡ��� ������Ϣ
	 */
	public List<Leave> getCheckLeaveList(Integer start, Integer limit,int bossid);
	/*
	 * ��ȡ���������������������
	 */
	public int getCheckTotalCountOfLeaveSelect(String selectValue,int bossid);
	/*
	 * ��ȡ�������������������Ϣ�б�
	 */
	public List<Leave> getCheckLeaveListSelect(Integer start, Integer limit,String selectValue,int bossid);
	/*
	 * ͬ�����
	 */
	public boolean agree(Integer lev_id);
	/*
	 * ��ͬ�����
	 */
	public boolean disagree(Integer lev_id);
}
