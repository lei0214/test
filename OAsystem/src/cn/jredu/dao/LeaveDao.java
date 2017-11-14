package cn.jredu.dao;

import java.util.List;

import cn.jredu.entity.Leave;

public interface LeaveDao {

	/*
	 * 获取lev_id
	 */
	public int getLev_id(String sql) throws Exception;
	/*
	 * 提交请假申请
	 */
	public int applyForLeave(String sql,List<Object> params) throws Exception;
	/*
	 * 获取请假申请的总条数
	 */
	public int getTotalCountOfLeave(String sql,List<Object> params) throws Exception;
	/*
	 * 展示请假申请列表
	 */
	public List<Leave> getLeaveList(String sql,List<Object> params) throws Exception;
	/*
	 * 获取符合条件请假申请的总条数
	 */
	public int getTotalCountOfLeaveSelect(String sql,List<Object> params) throws Exception;
	/*
	 * 获取符合条件请假申请的信息列表
	 */
	public List<Leave> getLeaveListSelect(String sql,List<Object> params) throws Exception;
	/*
	 * 同意请假
	 */
	public int agree(String sql,List<Object> params) throws Exception;
	/*
	 * 不同意请假
	 */
	public int disagree(String sql,List<Object> params) throws Exception;
}
