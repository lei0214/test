package cn.jredu.service;

import java.util.List;

import cn.jredu.entity.Annouse;
import cn.jredu.entity.RecentThing;
import cn.jredu.entity.RecentWork;

public interface AnnouseService {

	
	/*
	 * 展示通告
	 */
	public List<Annouse> showAnnouse();
	/*
	 * 展示最近安排
	 */
	public List<RecentThing> showRecentThing(String username);
	/*
	 * 展示待办工作
	 */
	public List<RecentWork> showRecentWork(String username);
	/*
	 * 获得通告总条数
	 */
	public int getTotalCount();
	/*
	 * 获取符合条件的通告总条数
	 */
	public int getTotalCountSelect(String selectValue);
	/*
	 * 获取所有通告列表
	 */
	public List<Annouse> showAnnouseList(Integer start, Integer limit);
	/*
	 * 获取所有符合条件的通告列表
	 */
	public List<Annouse> showAnnouseListSelect(Integer start, Integer limit,String selectValue);
	/*
	 * 按id删除通告
	 */
	public boolean deleteAnnouseById(String ids);
	/*
	 * 获取Id
	 */
	public int getId();
	/*
	 * 保存通告
	 */
	public boolean saveAnnouse(Annouse ann);
}
