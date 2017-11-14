package cn.jredu.dao;

import java.util.List;

import cn.jredu.entity.RecentThing;
import cn.jredu.entity.RecentWork;

public interface RecentThingDao {
	/*
	 * չʾ�����������
	 */
	public List<RecentThing> showListOfRecentThing(String sql,List<Object> params) throws Exception;
	/*
	 * ��ʾ������ŵ�����
	 */
	public int RecentThingCount(String sql,List<Object> params) throws Exception;
	/*
	 * ͨ��Idɾ���������
	 */
	public int deleteRecentThingById(String sql,List<Object> params) throws Exception;
	/*
	 * չʾ���д�������
	 */
	public List<RecentWork> showListOfRecentWork(String sql,List<Object> params) throws Exception;
	/*
	 * ��ʾ������ŵ�����
	 */
	public int RecentWorkCount(String sql,List<Object> params) throws Exception;
	/*
	 * ͨ��Idɾ���������
	 */
	public int deleteRecentWorkById(String sql,List<Object> params) throws Exception;
	/*
	 * ��ȡ������ŵ�ID
	 */
	public int getRecentThingId(String sql) throws Exception;
	/*
	 * ����������
	 */
	public int addRecentThing(String sql,List<Object> params) throws Exception;
	/*
	 * ��ô�������id
	 */
	public int getRecentWorkId(String sql) throws Exception;
	/*
	 * ��������
	 */
	public int addRecentWork(String sql,List<Object> params) throws Exception;

}
