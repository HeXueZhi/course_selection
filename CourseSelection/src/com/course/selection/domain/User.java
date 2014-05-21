/**
 * 
 */
package com.course.selection.domain;

import java.io.Serializable;
//import java.util.Set;

/**
 * @author JiHan
 *
 */
public class User implements Serializable {

	private static final long serialVersionUID = 5415776578485276952L;

	/**
	 * ����Id��������
����		Account���˺�
����		Password������
����		Role��role��
		Profile��profile��
	 */
	private int ID;
	private String Account;
	private String Password;
	private Role role;
	private Profile profile;
	//private Set<Course> course;
	/**
	 * ��������������
	 * @param ID
	 */
	public void setID(int ID){
		this.ID=ID;
	}
	public int getID(){
		return ID;
	}
	public void setAccount(String Account){
		this.Account=Account;
	}
	public String getAccount(){
		return Account;
	}
	public void setPassword(String Password){
		this.Password=Password;
	}
	public String getPassword(){
		return Password;
	}
	public void setRole(Role role){
		this.role=role;
	}
	public Role getRole(){
		return role;
	}
	public void setProfile(Profile profile){
		this.profile=profile;
	}
	public Profile getProfile(){
		return profile;
	}
	
	/*public Set<Course> getCourse() {
		return course;
	}
	public void setCourse(Set<Course> course) {
		this.course = course;
	}*/
	
	
	/* ���� Javadoc��
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ID;
		return result;
	}
	/* ���� Javadoc��
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (ID != other.ID)
			return false;
		return true;
	}

}
