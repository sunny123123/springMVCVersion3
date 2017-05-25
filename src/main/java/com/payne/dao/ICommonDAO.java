package com.payne.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
@SuppressWarnings("unchecked")
public interface ICommonDAO {
	/**
	 * �������
	 */
	public static final String COUNT = "count";
	/**
	 * ���ּ�ҳ
	 */
	public static final String PAGE_COUNT = "pagecount";
	/**
	 * ÿҳ��ʾ���ټ�¼
	 */
	public static final String PAGE_SIZE = "pagesize";
	/**
	 * ��ǰҳ��
	 */
	public static final String PAGE = "page";
	/**
	 * �����б�
	 */
	public static final String OBJ_LIST = "rows";
	public Object get(Class clazz,Serializable id);
	public Serializable add(Object o);
	public void del(Class clazz,Serializable id);
	public void update(Object o);
	public List list(String hql);
	public List list(String hql,Object[] args);
	public Map<String,Object> queryPage(String hql,int page,int pagesize);
	public Map<String,Object> queryPage(String hql,int page,int pagesize,Object[] args);
}
