package com.course.selection.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * �˳���¼�Ŀ�����
 * @author Administrator
 *
 */
public class LogoutAction extends ActionSupport {

	private static final long serialVersionUID = 7606796119677630083L;

	public LogoutAction() {
		
	}
	/**
	 * ʵ��ע���߼��ķ���
	 */
	@Override
	public String execute() throws Exception {
		
		ActionContext ctx = ActionContext.getContext();
		ctx.getSession().remove("userID");
		ctx.getSession().remove("role");
		ctx.getSession().remove("username");
		
		return SUCCESS;
	}

}
