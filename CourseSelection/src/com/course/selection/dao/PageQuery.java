package com.course.selection.dao;

import java.io.Serializable;
import java.util.List;

/**
 * ��ҳ��ѯ����Ϣ��
 * @author Administrator
 *
 * @param <T> ��ҳ��ѯ�����ص�����
 */
public class PageQuery<T> implements Serializable{

	private static final long serialVersionUID = 3933355967786922435L;
	
	/**
	 * ҳ�浱ǰ��ʾ������
	 */
	private int currentIndex;
	/**
	 * �����������ܼ�¼��
	 */
	private long totalNum;
	/**
	 * ҳ������������
	 */
	private int totalIndex;
	/**
	 * ��ǰ���������������
	 */
	private List<T> datas;

	/**
	 * ÿ������ҳ��������������
	 */
	private int pageContentNum = 20;
	
	/**
	 * ��ȡ��ǰҳ�ڲ�ѯ����е�λ��
	 * @return
	 */
	public int getCurrentNum(){
		return (getCurrentIndex()-1) * getPageContentNum();
	}
	
	/**
	 * ��ת����һҳ��������һҳ������
	 */
	public int getNextPage(){
		int res = getCurrentIndex();
		if(getCurrentIndex() < getTotalIndex()){
			res = getCurrentIndex() + 1;
		}
		return res;
	}
	
	/**
	 * ��ת����һҳ��������һҳ������
	 */
	public int getPreviousPage(){
		int res = 1;
		if(getCurrentIndex() > 1){
			res  = getCurrentIndex() - 1;
		}
		return res;
	}
	
	/**
	 * ��ת�����һҳ���������һҳ������
	 */
	public int getLastPage(){
		return getTotalIndex();
	}
	/**
	 * ��ת����һҳ,���ص�һҳ������
	 */
	public int getFirstPage(){
		return 1;
	}	
	
	/**
	 * ��ת��ָ��ҳ
	 * @param page
	 */
	public PageQuery<T> getSpecificPage(int page){
		if(page >= 1 && page <= getTotalIndex()){
			setCurrentIndex(page);
		}
		return this;
	}
	
	public int getCurrentIndex() {
		return currentIndex;
	}

	public void setCurrentIndex(int currnetIndex) {
		this.currentIndex = currnetIndex;
	}

	public int getTotalIndex() {
		return totalIndex;
	}

	public void setTotalIndex(int totalIndex) {
		this.totalIndex = totalIndex;
	}

	public List<T> getDatas() {
		return datas;
	}

	public void setDatas(List<T> datas) {
		this.datas = datas;
	}

	public int getPageContentNum() {
		return pageContentNum;
	}

	public void setPageContentNum(int pageContentNum) {
		this.pageContentNum = pageContentNum;
	}

	public PageQuery(int currnetIndex, int pageContentNum) {
		this.currentIndex = currnetIndex;
		this.pageContentNum = pageContentNum;
	}

	public PageQuery() {
		this.currentIndex = 1;
		this.pageContentNum = 20;
	}

	public long getTotalNum() {
		return totalNum;
	}

	public void setTotalNum(Long total) {
		this.totalNum = total;
		setTotalIndex((int)Math.ceil((double)total / getPageContentNum()));
	}

	public boolean isFirst(){
		if(this.currentIndex == 1){
			return true;
		}
		return false;
	}
}
