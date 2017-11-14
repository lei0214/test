package cn.jredu.dao;

import java.util.List;

import cn.jredu.entity.RecentThing;
import cn.jredu.entity.RecentWork;

public interface RecentThingDao {
	/*
	 * 展示所有最近安排
	 */
	public List<RecentThing> showListOfRecentThing(String sql,List<Object> params) throws Exception;
	/*
	 * 显示最近安排的总数
	 */
	public int RecentThingCount(String sql,List<Object> params) throws Exception;
	/*
	 * 通过Id删除最近安排
	 */
	public int deleteRecentThingById(String sql,List<Object> params) throws Exception;
	/*
	 * 展示所有待办事项
	 */
	public List<RecentWork> showListOfRecentWork(String sql,List<Object> params) throws Exception;
	/*
	 * 显示最近安排的总数
	 */
	public int RecentWorkCount(String sql,List<Object> params) throws Exception;
	/*
	 * 通过Id删除最近安排
	 */
	public int deleteRecentWorkById(String sql,List<Object> params) throws Exception;
	/*
	 * 获取最近安排的ID
	 */
	public int getRecentThingId(String sql) throws Exception;
	/*
	 * 添加最近安排
	 */
	public int addRecentThing(String sql,List<Object> params) throws Exception;
	/*
	 * 获得待办事项id
	 */
	public int getRecentWorkId(String sql) throws Exception;
	/*
	 * 发布任务
	 */
	public int addRecentWork(String sql,List<Object> params) throws Exception;

}
