package cn.jredu.dao;

import java.util.List;

import cn.jredu.entity.Annouse;
import cn.jredu.entity.RecentThing;
import cn.jredu.entity.RecentWork;

public interface AnnouseDao {

	/*
	 * չʾͨ��
	 */
	public List<Annouse> showAnnouse(String sql) throws Exception;
	/*
	 * չʾ�������
	 */
	public List<RecentThing> showRecentThing(String sql,List<Object> params) throws Exception;
	/*
	 * չʾ���칤��
	 */
	public List<RecentWork> showRecentWork(String sql,List<Object> params) throws Exception;
	/*
	 * ��ȡͨ��������
	 */
	public int getTotalCount(String sql) throws Exception;
	/*
	 * ��ȡ����������ͨ��������
	 */
	public int getTotalCountSelect(String sql,List<Object> params) throws Exception;
	/*
	 * ��ȡ����ͨ���б�
	 */
	public List<Annouse> showAnnouseList(String sql,List<Object> params) throws Exception;
	/*
	 * ��ȡ���з���������ͨ���б�
	 */
	public List<Annouse> showAnnouseListSelect(String sql,List<Object> params) throws Exception;
	/*
	 * ��Idɾ��ͨ��
	 */
	public int deleteAnnouseById(String sql,List<Object> params) throws Exception;
	/*
	 * ��ȡId
	 */
	public int getId(String sql) throws Exception;
	/*
	 * ����ͨ��
	 */
	public int saveAnnouse(String sql,List<Object> params) throws Exception;
	
}
