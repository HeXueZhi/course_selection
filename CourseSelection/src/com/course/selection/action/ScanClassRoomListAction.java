package com.course.selection.action;

import com.course.selection.dao.PageQuery;
import com.course.selection.domain.ClassRoom;
import com.course.selection.service.ClassRoomService;
import com.opensymphony.xwork2.ActionSupport;
/**
 * 
 * @author Administrator
 *
 */
public class ScanClassRoomListAction extends ActionSupport {

	private static final long serialVersionUID = 7022976876095320500L;
	
	/**
	 * ��װ��ҳ���ҵõ��������Լ��������
	 */
	private PageQuery<ClassRoom> pageQuery;
	
	/**
	 * ���õ�ҵ���߼����
	 */

	private ClassRoomService classRoomService;
	
	/**
	 * �Ƿ�Ϊ��ת
	 */
	private boolean isJump;
	
	/**
	 * ��ת����ָ��ҳ��
	 */
	private int gotoPage;
	
	private String action;

	public PageQuery<ClassRoom> getPageQuery() {
		return pageQuery;
	}

	public void setPageQuery(PageQuery<ClassRoom> pageQuery) {
		this.pageQuery = pageQuery;
	}

	@Override
	public String execute() throws Exception {
		
		if(isJump()){
			
			PageQuery<ClassRoom> pq = pageQuery.getSpecificPage(getGotoPage());
			
			pageQuery = getClassRoomService().lookClassRoomByPage(pq);
			
		}else if(pageQuery == null || pageQuery.isFirst()){
			
			pageQuery = getClassRoomService().lookClassRoomByPage();
			
		}else{
			
			pageQuery = getClassRoomService().lookClassRoomByPage(pageQuery);
			
		}
		
		return SUCCESS;
	}

	public int getGotoPage() {
		return gotoPage;
	}

	public void setGotoPage(int gotoPage) {
		this.gotoPage = gotoPage;
	}

	public boolean isJump() {
		return isJump;
	}

	public void setJump(boolean isJump) {
		this.isJump = isJump;
	}

	public ClassRoomService getClassRoomService() {
		return classRoomService;
	}

	public void setClassRoomService(ClassRoomService classRoomService) {
		this.classRoomService = classRoomService;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}
}
