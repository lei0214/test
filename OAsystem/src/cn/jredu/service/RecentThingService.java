package cn.jredu.service;

import java.util.List;

import cn.jredu.entity.RecentThing;
import cn.jredu.entity.RecentWork;

public interface RecentThingService {

	/*
	 * չʾ�����������
	 */
	public List<RecentThing> showListOfRecentThing(Integer start, Integer limit,String username);
	/*
	 * ��ȡ������ŵ�����
	 */
	public int getTotalCountOfRecentThing(String username);
	/*
	 * ͨ��idɾ���������
	 */
	public boolean deleteRecentThingById(String ids,String username);
	/*
	 * ֻ�����д�������
	 */
	public List<RecentWork> showListOfRecentWork(Integer start, Integer limit,String username);
	/*
	 * ��ȡ�������������
	 */
	public int getTotalCountOfRecentWork(String username);
	/*
	 * ͨ��idɾ����������
	 */
	public boolean deleteRecentWorkById(String ids,String username);
	/*
	 * ��ȡ������ŵ�id
	 */
	public int getRecentThingId();
	/*
	 * ����������
	 */
	public boolean addRecentThing(RecentThing rt);
	/*
	 * ��ȡ��������id
	 */
	public int getRecentWorkId();
	/*
	 * ��������
	 *
	 */
	public boolean addRecentWork(RecentWork rw);
}
