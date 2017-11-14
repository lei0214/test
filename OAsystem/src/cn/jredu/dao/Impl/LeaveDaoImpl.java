package cn.jredu.dao.Impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.jredu.dao.LeaveDao;
import cn.jredu.entity.Leave;
import cn.jredu.util.BaseDao;


@Repository
public class LeaveDaoImpl extends BaseDao implements LeaveDao {

	@Override
	public int getLev_id(String sql) throws Exception {
		
		return getCurrentIndex(sql);
	}

	@Override
	public int applyForLeave(String sql, List<Object> params) throws Exception {
		
		return executeUpdate(sql, params);
	}

	@Override
	public int getTotalCountOfLeave(String sql, List<Object> params) throws Exception {
		List<Leave> list=getModelListByResultSet(sql, params, new Leave());
		int count=0;
		if(list!=null){
			count=list.size();
		}
		return count;
	}

	@Override
	public List<Leave> getLeaveList(String sql, List<Object> params) throws Exception {
		List<Leave> list=getModelListByResultSet(sql, params, new Leave());
		return list;
	}

	@Override
	public int getTotalCountOfLeaveSelect(String sql, List<Object> params) throws Exception {
		List<Leave> list=getModelListByResultSet(sql, params, new Leave());
		int count=0;
		if(list!=null){
			count=list.size();
		}
		return count;
	}

	@Override
	public List<Leave> getLeaveListSelect(String sql, List<Object> params) throws Exception {
		List<Leave> list=getModelListByResultSet(sql, params, new Leave());
		return list;
	}

	@Override
	public int agree(String sql, List<Object> params) throws Exception {
		return executeUpdate(sql, params);
	}

	@Override
	public int disagree(String sql, List<Object> params) throws Exception {
		return executeUpdate(sql, params);
	}

}
