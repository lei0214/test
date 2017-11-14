package cn.jredu.dao;

import java.util.List;

import cn.jredu.entity.Annouse;
import cn.jredu.entity.RecentThing;
import cn.jredu.entity.RecentWork;

public interface AnnouseDao {

	/*
	 * 展示通告
	 */
	public List<Annouse> showAnnouse(String sql) throws Exception;
	/*
	 * 展示最近安排
	 */
	public List<RecentThing> showRecentThing(String sql,List<Object> params) throws Exception;
	/*
	 * 展示待办工作
	 */
	public List<RecentWork> showRecentWork(String sql,List<Object> params) throws Exception;
	/*
	 * 获取通告总条数
	 */
	public int getTotalCount(String sql) throws Exception;
	/*
	 * 获取符合条件的通告总条数
	 */
	public int getTotalCountSelect(String sql,List<Object> params) throws Exception;
	/*
	 * 获取所有通告列表
	 */
	public List<Annouse> showAnnouseList(String sql,List<Object> params) throws Exception;
	/*
	 * 获取所有符合条件的通告列表
	 */
	public List<Annouse> showAnnouseListSelect(String sql,List<Object> params) throws Exception;
	/*
	 * 按Id删除通告
	 */
	public int deleteAnnouseById(String sql,List<Object> params) throws Exception;
	/*
	 * 获取Id
	 */
	public int getId(String sql) throws Exception;
	/*
	 * 保存通告
	 */
	public int saveAnnouse(String sql,List<Object> params) throws Exception;
	
}
