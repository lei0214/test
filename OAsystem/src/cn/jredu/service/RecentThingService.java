package cn.jredu.service;

import java.util.List;

import cn.jredu.entity.RecentThing;
import cn.jredu.entity.RecentWork;

public interface RecentThingService {

	/*
	 * 展示所有最近安排
	 */
	public List<RecentThing> showListOfRecentThing(Integer start, Integer limit,String username);
	/*
	 * 获取最近安排的总数
	 */
	public int getTotalCountOfRecentThing(String username);
	/*
	 * 通过id删除最近安排
	 */
	public boolean deleteRecentThingById(String ids,String username);
	/*
	 * 只是所有待办事项
	 */
	public List<RecentWork> showListOfRecentWork(Integer start, Integer limit,String username);
	/*
	 * 获取待办事项的总数
	 */
	public int getTotalCountOfRecentWork(String username);
	/*
	 * 通过id删除待办事项
	 */
	public boolean deleteRecentWorkById(String ids,String username);
	/*
	 * 获取最近安排的id
	 */
	public int getRecentThingId();
	/*
	 * 添加最近安排
	 */
	public boolean addRecentThing(RecentThing rt);
	/*
	 * 获取待办事项id
	 */
	public int getRecentWorkId();
	/*
	 * 发布任务
	 *
	 */
	public boolean addRecentWork(RecentWork rw);
}
