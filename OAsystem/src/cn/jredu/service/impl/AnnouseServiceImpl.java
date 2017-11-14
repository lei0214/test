package cn.jredu.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.jredu.dao.AnnouseDao;
import cn.jredu.entity.Annouse;
import cn.jredu.entity.RecentThing;
import cn.jredu.entity.RecentWork;
import cn.jredu.service.AnnouseService;


@Service
public class AnnouseServiceImpl implements AnnouseService {

	@Autowired
	private AnnouseDao dao;
	
	@Override
	public List<Annouse> showAnnouse() {
		String sql="select * from annouselist";
		List<Annouse> list=null;
		try {
			list=dao.showAnnouse(sql);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public List<RecentThing> showRecentThing(String username) {
		String sql="select * from recentthing where username=?";
		List<Object> params=new ArrayList<Object>();
		params.add(username);
		List<RecentThing> list=null;
		try {
			list=dao.showRecentThing(sql,params);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public List<RecentWork> showRecentWork(String username) {
		String sql="select * from recentwork where username=?";
		List<Object> params=new ArrayList<Object>();
		params.add(username);
		List<RecentWork> list=null;
		try {
			list=dao.showRecentWork(sql,params);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	
	}
	
	@Override
	public int getTotalCount() {
		String sql="select * from annouselist";
		int count =0;
		try {
			count=dao.getTotalCount(sql);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
	@Override
	public int getTotalCountSelect(String selectValue) {
		int total=0;
		String sql="select * from annouselist where author like ?";
		List<Object> params=new ArrayList<Object>();
		String s="%"+selectValue+"%";
		params.add(s);
		try {
			total = dao.getTotalCountSelect(sql,params);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return total;
	}
	
	@Override
	public List<Annouse> showAnnouseList(Integer start, Integer limit) {
		int st=0;
		int end=0;
		if(start!=null&&limit!=null){
			st=(start-1)*limit;
			end=start*limit+1;
		}
		String sql="select id,author,content,pubdate from (select rownum r ,annouselist.*  "
				+ "from annouselist where rownum<?) xx"+" where xx.r>?";
		List<Object> params=new ArrayList<Object>();
		params.add(end);
		params.add(st);
		List<Annouse> list = new ArrayList<Annouse>();
		try {
			list=dao.showAnnouseList(sql, params);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Annouse> showAnnouseListSelect(Integer start, Integer limit,String selectValue) {
		int st=0;
		int end=0;
		if(start!=null&&limit!=null){
			st=(start-1)*limit;
			end=start*limit+1;
		}
		String sql = "select * from (select rownum r ,oo.* from (select * from annouselist where 1=1";
		List<Object> params = new ArrayList<Object>();
		sql += " and author like ?";
		params.add("%" + selectValue + "%");
		sql += ") oo where rownum<?) xx where xx.r>?";
		params.add(end);
		params.add(st);
		List<Annouse> list=null;
		try {
			list=dao.showAnnouseListSelect(sql, params);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public boolean deleteAnnouseById(String idsStr) {
		String[] ids=idsStr.split(",");
		StringBuffer sb=new StringBuffer();
		List<Object> params=new ArrayList<Object>();
		for(String s:ids){
			sb.append("?,");
			params.add(s);
		}
		String finalId=sb.substring(0,sb.length()-1);
		String sql="delete from annouselist where id in("+finalId+")";
		int count=0;
		try {
			count=dao.deleteAnnouseById(sql, params);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count>0;
	}

	@Override
	public int getId() {
		String sql="user_msg";
		int count=0;
		try {
			count=dao.getId(sql);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public boolean saveAnnouse(Annouse ann) {
		String sql="insert into annouselist values (?,?,?,?)";
		List<Object> params=new ArrayList<Object>();
		params.add(ann.getId());
		params.add(ann.getAuthor());
		params.add(ann.getContent());
		params.add(ann.getPubdate());
		int count=0;
		try {
			count=dao.saveAnnouse(sql,params);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count>0;
	}

}
