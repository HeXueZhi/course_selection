package com.course.selection.action;

import com.course.selection.dao.PageQuery;
import com.course.selection.domain.Student;
import com.course.selection.service.StudentService;
import com.opensymphony.xwork2.ActionSupport;

public class ScanStudentListAction extends ActionSupport {

	private static final long serialVersionUID = -7635577824068366763L;
	/**
	 * ��װ��ҳ���ҵõ��������Լ��������
	 */
	private PageQuery<Student> pageQuery;
	
	/**
	 * ���õ�ҵ���߼����
	 */
	private StudentService studentService;
	
	/**
	 * �Ƿ�Ϊ��ת
	 */
	private boolean isJump;

	/**
	 * ��ת����ָ��ҳ��
	 */
	private int gotoPage;
	
	private String action;

	/**
	 * @return the pageQuery
	 */
	public PageQuery<Student> getPageQuery() {
		return pageQuery;
	}

	/**
	 * @param pageQuery the pageQuery to set
	 */
	public void setPageQuery(PageQuery<Student> pageQuery) {
		this.pageQuery = pageQuery;
	}

	/**
	 * @return the isJump
	 */
	public boolean isJump() {
		return isJump;
	}

	/**
	 * @param isJump the isJump to set
	 */
	public void setJump(boolean isJump) {
		this.isJump = isJump;
	}

	/**
	 * @return the gotoPage
	 */
	public int getGotoPage() {
		return gotoPage;
	}

	/**
	 * @param gotoPage the gotoPage to set
	 */
	public void setGotoPage(int gotoPage) {
		this.gotoPage = gotoPage;
	}

	/**
	 * @return the action
	 */
	public String getAction() {
		return action;
	}

	/**
	 * @param action the action to set
	 */
	public void setAction(String action) {
		this.action = action;
	}


	@Override
	public String execute() throws Exception {
		if(isJump()){
			
			PageQuery<Student> pq = pageQuery.getSpecificPage(getGotoPage());
			
			pageQuery = getStudentService().scanStudent(pq);
			
		}else if(pageQuery == null || pageQuery.isFirst()){
			
			pageQuery = getStudentService().scanStudent();
			
		}else{
			
			pageQuery = getStudentService().scanStudent(pageQuery);
			
		}
		
		return SUCCESS;
	}

	public StudentService getStudentService() {
		return studentService;
	}

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

}
