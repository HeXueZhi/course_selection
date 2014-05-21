package com.course.selection.action.interceptor;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class AccessControlInterceptor extends AbstractInterceptor {

	private static final long serialVersionUID = -9028430725547743361L;
	
	private String role;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		
		String temp = (String) invocation.getInvocationContext().getSession().get("role");
		String result = null;
		//System.out.println("role = " + role + " now = " + temp);
		if(temp == null){ 							//�û�δ��¼
			invocation.getInvocationContext().put("message", "����δ��¼��");
			result = Action.ERROR;
		}else{
			if(role == null || temp.equals(role.trim())){	//�û����ִ��Ȩ��
				result = invocation.invoke();
			}else{									//�û�Ȩ�޲���
				invocation.getInvocationContext().put("message", "��û�н��д˲�����Ȩ�ޣ�");				
				result = Action.ERROR;
			}
		}
		
		return result;

	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
