package cn.jredu.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.jredu.dao.LeaveDao;
import cn.jredu.entity.Leave;
import cn.jredu.service.LeaveService;


@Service
public class LeaveServiceImpl implements LeaveService {
	
	@Autowired
	private LeaveDao dao;

	@Override
	public int getLev_id() {
		String sql="leave_list";
		int count=0;
		try {
			count=dao.getLev_id(sql);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public boolean applyForLeave(Leave l,int bossid) {
		String sql="insert into leavelist values(?,?,?,?,?,?,?)";
		List<Object> params=new ArrayList<Object>();
		params.add(l.getLev_id());
		params.add(l.getLev_person());
		params.add(l.getLev_startdate());
		params.add(l.getLev_enddate());
		params.add(l.getLev_reason());
		params.add(bossid);
		params.add(0);
		int count=0;
		try {
			count=dao.applyForLeave(sql, params);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count>0;
		
	}

	@Override
	public int getTotalCountOfLeave(String name) {
		String sql="select * from leavelist where lev_person=?";
		List<Object> params=new ArrayList<Object>();
		params.add(name);
		int count=0;
		try {
			count=dao.getTotalCountOfLeave(sql, params);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public List<Leave> getLeaveList(Integer start, Integer limit,String name) {
		int st=0;
		int end=0;
		if(start!=null&&limit!=null){
			st=(start-1)*limit;
			end=start*limit+1;
		}
		String sql="select lev_id,lev_person,lev_startdate,lev_enddate,lev_reason,status from (select rownum r ,leavelist.*  "
				+ "from leavelist where lev_person=? and rownum<?) xx"+" where xx.r>?";
		List<Object> params=new ArrayList<Object>();
		params.add(name);
		params.add(end);
		params.add(st);
		
		List<Leave> list=null;
		try {
			list=dao.getLeaveList(sql, params);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int getTotalCountOfLeaveSelect(String selectValue, String name) {
		String sql="select * from leavelist where lev_person=? and lev_startdate=?";
		List<Object> params=new ArrayList<Object>();
		params.add(name);
		params.add(selectValue);
		int count=0;
		try {
			count=dao.getTotalCountOfLeaveSelect(sql, params);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public List<Leave> getLeaveListSelect(Integer start, Integer limit, String selectValue,String name) {
		int st=0;
		int end=0;
		if(start!=null&&limit!=null){
			st=(start-1)*limit;
			end=start*limit+1;
		}
		String sql="select lev_id,lev_person,lev_startdate,lev_enddate,lev_reason,status from (select rownum r ,leavelist.*  "
				+ "from leavelist where lev_person=? and rownum<?) xx"+" where xx.r>? and xx.startdate=?";
		List<Object> params=new ArrayList<Object>();
		params.add(name);
		params.add(end);
		params.add(st);
		params.add(selectValue);
		List<Leave> list=null;
		try {
			list=dao.getLeaveListSelect(sql, params);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int getCheckTotalCountOfLeave(int bossid) {
		String sql="select * from leavelist where bossid=?";
		List<Object> params=new ArrayList<Object>();
		params.add(bossid);
		int count=0;
		try {
			count=dao.getTotalCountOfLeave(sql, params);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public List<Leave> getCheckLeaveList(Integer start, Integer limit, int bossid) {
		int st=0;
		int end=0;
		if(start!=null&&limit!=null){
			st=(start-1)*limit;
			end=start*limit+1;
		}
		String sql="select lev_id,lev_person,lev_startdate,lev_enddate,lev_reason,status from (select rownum r ,leavelist.*  "
				+ "from leavelist where bossid=? and rownum<?) xx"+" where xx.r>?";
		List<Object> params=new ArrayList<Object>();
		params.add(bossid);
		params.add(end);
		params.add(st);
		
		List<Leave> list=null;
		try {
			list=dao.getLeaveList(sql, params);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int getCheckTotalCountOfLeaveSelect(String selectValue, int bossid) {
		String sql="select * from leavelist where bossid=? and lev_startdate=?";
		List<Object> params=new ArrayList<Object>();
		params.add(bossid);
		params.add(selectValue);
		int count=0;
		try {
			count=dao.getTotalCountOfLeaveSelect(sql, params);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public List<Leave> getCheckLeaveListSelect(Integer start, Integer limit, String selectValue,int bossid) {
		int st=0;
		int end=0;
		if(start!=null&&limit!=null){
			st=(start-1)*limit;
			end=start*limit+1;
		}
		String sql="select lev_id,lev_person,lev_startdate,lev_enddate,lev_reason,status from (select rownum r ,leavelist.*  "
				+ "from leavelist where bossid=? and rownum<?) xx"+" where xx.r>? and xx.startdate=?";
		List<Object> params=new ArrayList<Object>();
		params.add(bossid);
		params.add(end);
		params.add(st);
		params.add(selectValue);
		List<Leave> list=null;
		try {
			list=dao.getLeaveListSelect(sql, params);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public boolean agree(Integer lev_id) {
		String sql="update leavelist set status='通过' where lev_id=?";
		List<Object> params=new ArrayList<Object>();
		params.add(lev_id);
		int count=0;
		try {
			count=dao.agree(sql, params);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count>0;
	}

	@Override
	public boolean disagree(Integer lev_id) {
		String sql="update leavelist set status='未通过' where lev_id=?";
		List<Object> params=new ArrayList<Object>();
		params.add(lev_id);
		int count=0;
		try {
			count=dao.disagree(sql, params);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count>0;
	}
}
