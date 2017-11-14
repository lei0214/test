package cn.jredu.service;

import java.util.List;

import cn.jredu.entity.Leave;

public interface LeaveService {
	/*
	 * 获取lev_id
	 */
	public int getLev_id();
	/*
	 * 提交请假申请
	 */
	public boolean applyForLeave(Leave l,int bossid);
	/*
	 * 获取请假申请的总条数
	 */
	public int getTotalCountOfLeave(String name);
	/*
	 * 获取请假 申请信息
	 */
	public List<Leave> getLeaveList(Integer start, Integer limit,String name);
	/*
	 * 获取符合条件的请假申请条数
	 */
	public int getTotalCountOfLeaveSelect(String selectValue,String name);
	/*
	 * 获取符合条件的请假申请信息列表
	 */
	public List<Leave> getLeaveListSelect(Integer start, Integer limit,String selectValue,String name);
	/*
	 * 获取请假申请的总条数
	 */
	public int getCheckTotalCountOfLeave(int bossid);
	/*
	 * 获取请假 申请信息
	 */
	public List<Leave> getCheckLeaveList(Integer start, Integer limit,int bossid);
	/*
	 * 获取符合条件的请假申请条数
	 */
	public int getCheckTotalCountOfLeaveSelect(String selectValue,int bossid);
	/*
	 * 获取符合条件的请假申请信息列表
	 */
	public List<Leave> getCheckLeaveListSelect(Integer start, Integer limit,String selectValue,int bossid);
	/*
	 * 同意请假
	 */
	public boolean agree(Integer lev_id);
	/*
	 * 不同意请假
	 */
	public boolean disagree(Integer lev_id);
}
