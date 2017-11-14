package cn.jredu.dao.Impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.jredu.dao.AnnouseDao;
import cn.jredu.entity.Annouse;
import cn.jredu.entity.RecentThing;
import cn.jredu.entity.RecentWork;
import cn.jredu.util.BaseDao;

@Repository
public class AnnouseDaoImpl extends BaseDao implements AnnouseDao {

	@Override
	public List<Annouse> showAnnouse(String sql) throws Exception {
		List<Annouse> list=getModelListByResultSet(sql, null, new Annouse());
		return list;
	}

	@Override
	public List<RecentThing> showRecentThing(String sql,List<Object> params) throws Exception {
		List<RecentThing> list=getModelListByResultSet(sql, params, new RecentThing());
		return list;
	}

	@Override
	public List<RecentWork> showRecentWork(String sql, List<Object> params) throws Exception {
		List<RecentWork> list=getModelListByResultSet(sql, params, new RecentWork());
		return list;
	}

	@Override
	public int getTotalCount(String sql) throws Exception {
		List<Annouse> list=getModelListByResultSet(sql, null, new Annouse());
		int count =0;
		if(list!=null){
			count=list.size();
		}
		return count;
	}
	@Override
	public int getTotalCountSelect(String sql, List<Object> params) throws Exception {
		List<Annouse> list=getModelListByResultSet(sql, params, new Annouse());
		int count =0;
		if(list!=null){
			count=list.size();
		}
		return count;
	}
	@Override
	public List<Annouse> showAnnouseList(String sql, List<Object> params) throws Exception {
		List<Annouse> list=getModelListByResultSet(sql, params, new Annouse());
		return list;
	}

	@Override
	public List<Annouse> showAnnouseListSelect(String sql, List<Object> params) throws Exception {
		List<Annouse> list=getModelListByResultSet(sql, params, new Annouse());
		return list;
	}

	@Override
	public int deleteAnnouseById(String sql, List<Object> params) throws Exception {
		
		return executeUpdate(sql, params);
	}

	@Override
	public int getId(String sql) throws Exception {
		return getCurrentIndex(sql);
	}

	@Override
	public int saveAnnouse(String sql,List<Object> params) throws Exception {
		return executeUpdate(sql,params);
	}

}
