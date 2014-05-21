/**
 * 
 */
package com.course.selection.domain;

import java.io.Serializable;
import java.util.Set;

/**
 * @author JiHan
 *
 */
public class Student extends User implements Serializable {

	private static final long serialVersionUID = -2699784019592963416L;
	/**
	 * ѧ���༶
	 */
	private String clazz;
	private Set<Course> course;
	/**
	 * @return course
	 */
	public Set<Course> getCourse() {
		return course;
	}
	/**
	 * @param course Ҫ���õ� course
	 */
	public void setCourse(Set<Course> course) {
		this.course = course;
	}
	public String getClazz() {
		return clazz;
	}
	public void setClazz(String clazz) {
		this.clazz = clazz;
	}

}
