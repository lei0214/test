package cn.jredu.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.jredu.dao.RecentThingDao;
import cn.jredu.entity.RecentThing;
import cn.jredu.entity.RecentWork;
import cn.jredu.service.RecentThingService;


@Service
public class RecentThingServiceImpl implements RecentThingService {

	@Autowired
	private RecentThingDao dao;

	@Override
	public List<RecentThing> showListOfRecentThing(Integer start, Integer limit,String username) {
		int st=0;
		int end=0;
		if(start!=null&&limit!=null){
			st=(start-1)*limit;
			end=start*limit+1;
		}
		
		String sql="select id,content,pubdate from (select rownum r ,recentthing.*  "
				+ "from recentthing where rownum<?) xx"+" where xx.r>? and username=?";
		List<Object> params=new ArrayList<Object>();
		params.add(end);
		params.add(st);
		params.add(username);
		List<RecentThing> list =null;
		try {
			list=dao.showListOfRecentThing(sql, params);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int getTotalCountOfRecentThing(String username) {
		String sql="select count(1) from recentthing where username=?";
		List<Object> params=new ArrayList<Object>();
		params.add(username);
		int count=0;
		try {
			count=dao.RecentThingCount(sql, params);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public boolean deleteRecentThingById(String idsStr,String username) {
		String[] ids=idsStr.split(",");
		StringBuffer sb=new StringBuffer();
		List<Object> params=new ArrayList<Object>();
		for(String s:ids){
			sb.append("?,");
			params.add(s);
		}
		String finalId=sb.substring(0,sb.length()-1);
		String sql="delete from recentthing where id in("+finalId+") and username=?";
		params.add(username);
		int count=0;
		try {
			count=dao.deleteRecentThingById(sql, params);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count>0;
	}

	@Override
	public List<RecentWork> showListOfRecentWork(Integer start, Integer limit, String username) {
		int st=0;
		int end=0;
		if(start!=null&&limit!=null){
			st=(start-1)*limit;
			end=start*limit+1;
		}
		
		String sql="select id,forwho,content,pubdate,completedate from (select rownum r ,recentwork.*  "
				+ "from recentwork where rownum<?) xx"+" where xx.r>? and username=?";
		List<Object> params=new ArrayList<Object>();
		params.add(end);
		params.add(st);
		params.add(username);
		List<RecentWork> list =null;
		try {
			list=dao.showListOfRecentWork(sql, params);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int getTotalCountOfRecentWork(String username) {
		String sql="select count(1) from recentwork where username=?";
		List<Object> params=new ArrayList<Object>();
		params.add(username);
		int count=0;
		try {
			count=dao.RecentWorkCount(sql, params);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public boolean deleteRecentWorkById(String idsStr, String username) {
		String[] ids=idsStr.split(",");
		StringBuffer sb=new StringBuffer();
		List<Object> params=new ArrayList<Object>();
		for(String s:ids){
			sb.append("?,");
			params.add(s);
		}
		String finalId=sb.substring(0,sb.length()-1);
		String sql="delete from recentwork where id in("+finalId+") and username=?";
		params.add(username);
		int count=0;
		try {
			count=dao.deleteRecentWorkById(sql, params);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count>0;
	}

	@Override
	public int getRecentThingId() {
		String sql="recent_thing";
		int count=0;
		try {
			count=dao.getRecentThingId(sql);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public boolean addRecentThing(RecentThing rt) {
		String sql="insert into recentthing values(?,?,?,?)";
		List<Object> params=new ArrayList<Object>();
		params.add(rt.getId());
		params.add(rt.getContent());
		params.add(rt.getPubdate());
		params.add(rt.getUsername());
		int count=0;
		try {
			count=dao.addRecentThing(sql, params);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count>0;
	}

	@Override
	public int getRecentWorkId() {
		String sql="recent_work";
		int count=0;
		try {
			count=dao.getRecentThingId(sql);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public boolean addRecentWork(RecentWork rw) {
		String sql="insert into recentwork values(?,?,?,?,?,?)";
		List<Object> params=new ArrayList<Object>();
		params.add(rw.getId());
		params.add(rw.getForwho());
		params.add(rw.getContent());
		params.add(rw.getPubdate());
		params.add(rw.getCompletedate());
		params.add(rw.getUsername());
		int count=0;
		try {
			count=dao.addRecentWork(sql, params);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count>0;
	}
}
