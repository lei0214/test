package cn.jredu.service;

import java.util.List;

import cn.jredu.entity.Annouse;
import cn.jredu.entity.RecentThing;
import cn.jredu.entity.RecentWork;

public interface AnnouseService {

	
	/*
	 * չʾͨ��
	 */
	public List<Annouse> showAnnouse();
	/*
	 * չʾ�������
	 */
	public List<RecentThing> showRecentThing(String username);
	/*
	 * չʾ���칤��
	 */
	public List<RecentWork> showRecentWork(String username);
	/*
	 * ���ͨ��������
	 */
	public int getTotalCount();
	/*
	 * ��ȡ����������ͨ��������
	 */
	public int getTotalCountSelect(String selectValue);
	/*
	 * ��ȡ����ͨ���б�
	 */
	public List<Annouse> showAnnouseList(Integer start, Integer limit);
	/*
	 * ��ȡ���з���������ͨ���б�
	 */
	public List<Annouse> showAnnouseListSelect(Integer start, Integer limit,String selectValue);
	/*
	 * ��idɾ��ͨ��
	 */
	public boolean deleteAnnouseById(String ids);
	/*
	 * ��ȡId
	 */
	public int getId();
	/*
	 * ����ͨ��
	 */
	public boolean saveAnnouse(Annouse ann);
}
