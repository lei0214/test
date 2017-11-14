package cn.jredu.dao.Impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.jredu.dao.RecentThingDao;
import cn.jredu.entity.RecentThing;
import cn.jredu.entity.RecentWork;
import cn.jredu.util.BaseDao;

@Repository
public class RecentThingDaoImpl extends BaseDao implements RecentThingDao {

	@Override
	public List<RecentThing> showListOfRecentThing(String sql, List<Object> params) throws Exception {
		List<RecentThing> list=getModelListByResultSet(sql, params, new RecentThing());
		return list;
	}

	@Override
	public int RecentThingCount(String sql, List<Object> params) throws Exception {
		List<RecentThing> list=getModelListByResultSet(sql, params, new RecentThing());
		int count =0;
		if(list!=null){
			count=list.size();
		}
		return count;
	}

	@Override
	public int deleteRecentThingById(String sql, List<Object> params) throws Exception {
		
		return executeUpdate(sql, params);
	}

	@Override
	public List<RecentWork> showListOfRecentWork(String sql, List<Object> params) throws Exception {
		List<RecentWork> list=getModelListByResultSet(sql, params, new RecentWork());
		return list;
	}

	@Override
	public int RecentWorkCount(String sql, List<Object> params) throws Exception {
		List<RecentWork> list=getModelListByResultSet(sql, params, new RecentWork());
		int count =0;
		if(list!=null){
			count=list.size();
		}
		return count;
	}

	@Override
	public int deleteRecentWorkById(String sql, List<Object> params) throws Exception {
		return executeUpdate(sql, params);
	}

	@Override
	public int getRecentThingId(String sql) throws Exception {
		return getCurrentIndex(sql);
	}

	@Override
	public int addRecentThing(String sql, List<Object> params) throws Exception {
		return executeUpdate(sql, params);
	}

	@Override
	public int getRecentWorkId(String sql) throws Exception {
		return getCurrentIndex(sql);
	}

	@Override
	public int addRecentWork(String sql, List<Object> params) throws Exception {
		return executeUpdate(sql, params);
	}

}
