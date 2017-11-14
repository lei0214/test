package cn.jredu.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.jredu.dao.UserDao;
import cn.jredu.entity.User;
import cn.jredu.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao dao;
	@Override
	public boolean saveUser(User user,String bossid) {
		String sql="insert into luserlist values(?,?,?,?,?,?,?,?,?)";
		List<Object> params=new ArrayList<Object>();
		params.add(user.getUserId());
		params.add(user.getUserName());
		params.add(user.getUserPwd());
		params.add(user.getSex());
		params.add(user.getPhone());
		params.add(user.getCheckcode());
		params.add(user.getHeadImg());
		params.add(user.getNickname());
		params.add(bossid);
		int count=0;
		try {
			count=dao.saveUser(sql, params);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count>0;
	}
	@Override
	public User getUser(String userName) {
		String sql="select * from luserlist where username=?";
		List<Object> params=new ArrayList<Object>();
		params.add(userName);
		List<User> list=null;
		User user=new User();
		try {
			list = dao.getUser(sql, params);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(list!=null&&list.size()>0){
			user=list.get(0);
		}
		return user;
	}
	@Override
	public int getUserId() {
		String sql="user_msg";
		
		int count=0;
		
		try {
			count=dao.getUserId(sql);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
	@Override
	public boolean checktUser(String userName, String userPwd) {
		String sql="select * from luserlist where 1=1";
		List<Object> params=new ArrayList<Object>();
		if(userName!=null&!"".equals(userName)){
			sql+="and username=?";
			params.add(userName);
		}
		if(userPwd!=null&!"".equals(userPwd)){
			sql+="and userpwd=?";
			params.add(userPwd);
		}	
		List<User> list=null;
		try {
			list = dao.getUser(sql, params);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int count=list.size();
		return count>0;
	}
	@Override
	public boolean upLoadHeadImg(String userName, String headImg) {
		String sql="update luserlist set headimg=? where userName=?";
		int count=0;
		List<Object> params=new ArrayList<Object>();
		params.add(headImg);
		params.add(userName);
		try {
			count = dao.upLoadHeadImg(sql, params);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count>0;
	}
	@Override
	public boolean changeNickName(String nickname, String userName) {
		String sql="update luserlist set nickname=? where userName=?";
		int count=0;
		List<Object> params=new ArrayList<Object>();
		params.add(nickname);
		params.add(userName);
		try {
			count=dao.changeNickName(sql, params);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count>0;
	}
	@Override
	public List<User> showEmp(Integer start, Integer limit,int userid) {
		int st=0;
		int end=0;
		if(start!=null&&limit!=null){
			st=(start-1)*limit;
			end=start*limit+1;
		}
		String sql="select userid,nickname,phone,sex,bossname from "
				+ " (select rownum r ,u.*,(select nickname from luserlist where u.bossid=userid)"
				+ " bossname from luserlist u where rownum<?) xx where xx.r>? and xx.bossid=?";
		List<Object> params=new ArrayList<Object>();
		params.add(end);
		params.add(st);
		params.add(userid);
		List<User> list = new ArrayList<User>();
		try {
			list=dao.showAllEmp(sql, params);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public int getTotalCountOfUser(int userid) {
		String sql="select * from luserlist where bossid=?";
		List<Object> params=new ArrayList<Object>();
		params.add(userid);
		int count=0;
		try {
			count=dao.getToltalCountOfUser(sql,params);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
	@Override
	public List<User> showEmpSelect(Integer start, Integer limit, String selectValue,int userid) {
		int st=0;
		int end=0;
		if(start!=null&&limit!=null){
			st=(start-1)*limit;
			end=start*limit+1;
		}
		String sql="select userid,nickname,phone,sex,bossname from "
				+ " (select rownum r ,u.*,(select nickname from luserlist where u.bossid=userid)"
				+ " bossname from luserlist u where rownum<?) xx where xx.r>? and xx.bossid=? and xx.nickname like ?";
		List<Object> params=new ArrayList<Object>();
		params.add(end);
		params.add(st);
		params.add(userid);
		params.add("%"+selectValue+"%");
		List<User> list = new ArrayList<User>();
		try {
			list=dao.showAllEmpSelect(sql, params);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public int getTotalCountOfUserSelect(String selectValue,int userid) {
		String sql="select * from luserlist where bossid=? and nickname like ?";
		List<Object> params=new ArrayList<Object>();
		params.add(userid);
		params.add("%"+selectValue+"%");
		int count =0;
		try {
			count=dao.getToltalCountOfUserSelect(sql, params);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
	@Override
	public boolean fireEmp(String idsStr) {
		String[] ids=idsStr.split(",");
		StringBuffer sb=new StringBuffer();
		List<Object> params=new ArrayList<Object>();
		for(String s:ids){
			sb.append("?,");
			params.add(s);
		}
		String finalId=sb.substring(0,sb.length()-1);
		String sql="delete from luserlist where userid in("+finalId+")";
		int count=0;
		try {
			count=dao.fireEmp(sql, params);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count>0;
	}
	@Override
	public List<User> getAllLeader() {
		String sql="select userid,nickname from luserlist where bossid='41'";
		List<User> list=null;
		try {
			list=dao.getAllLeader(sql);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public List<User> getEmpLeft(int userId) {
		String sql="select username,nickname from luserlist where bossid=?";
		List<Object> params=new ArrayList<Object>();
		params.add(userId);
		List<User> list=null;
		try {
			list=dao.getEmpLeft(sql, params);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
}
