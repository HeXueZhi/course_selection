/**
 * 
 */
package com.course.selection.domain;

import java.io.Serializable;

/**
 * @author JiHan
 *
 */
public class Course implements Serializable {
	private static final long serialVersionUID = -9149654796329357137L;
	/**
	 * ����Id��������
����		courseName���γ���
����		courseNumber���γ̺ţ��Ϳγ�����һһ��Ӧ��ϵ
����		classNumber������ţ��γ̺���ͬ�Ŀγ��Կ��������
		attribute: �γ����ԣ����޻�ѡ��
		department���γ�Ժϵ
����		Capacity��������
����		Credit���ÿγ̵�ѧ��
����		classRoom��classRoom�࣬course����classRoom���Ƕ��һ��������ϵ��һ��course			  
 				       ӵ��һ��classRoom��һ��classroomӵ�ж��course
����		Timepoint��timepoint�࣬��course����һ��һ�ľۺϹ�ϵ
		Teacher��user�࣬course����user���Ƕ��һ����ϵ��ϵ
	 */
	private int ID;
	private String CourseName;
	private String CourseNumber;
	private String ClassNumber;
	private String attribute;
	private String department;
	private int Capacity;
	private double Credit;
	private Teacher teacher;
	private ClassRoom classroom;
	private TimePoint timepoint;
	private CourseState courseState;
	public void setID(int ID){
		this.ID=ID;
	}
	public int getID(){
		return ID;
	}
	/**
	 * @return courseName
	 */
	public String getCourseName() {
		return CourseName;
	}
	/**
	 * @param courseName Ҫ���õ� courseName
	 */
	public void setCourseName(String courseName) {
		CourseName = courseName;
	}

	/**
	 * @return capacity
	 */
	public int getCapacity() {
		return Capacity;
	}
	/**
	 * @param capacity Ҫ���õ� capacity
	 */
	public void setCapacity(int capacity) {
		Capacity = capacity;
	}
	/**
	 * @return credit
	 */
	public double getCredit() {
		return Credit;
	}
	/**
	 * @param credit Ҫ���õ� credit
	 */
	public void setCredit(double credit) {
		Credit = credit;
	}
	/**
	 * @return teacher
	 */
	
	/**
	 * @return classroom
	 */
	public ClassRoom getClassroom() {
		return classroom;
	}
	/**
	 * @param classroom Ҫ���õ� classroom
	 */
	public void setClassroom(ClassRoom classroom) {
		this.classroom = classroom;
	}
	/**
	 * @return timepoint
	 */
	public TimePoint getTimepoint() {
		return timepoint;
	}
	/**
	 * @param timepoint Ҫ���õ� timepoint
	 */
	public void setTimepoint(TimePoint timepoint) {
		this.timepoint = timepoint;
	}
	/**
	 * @return teacher
	 */
	public Teacher getTeacher() {
		return teacher;
	}
	/**
	 * @param teacher Ҫ���õ� teacher
	 */
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	
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
		Course other = (Course) obj;
		if (ID != other.ID)
			return false;
		return true;
	}
	public CourseState getCourseState() {
		return courseState;
	}
	public void setCourseState(CourseState courseState) {
		this.courseState = courseState;
	}
	public String getCourseNumber() {
		return CourseNumber;
	}
	public void setCourseNumber(String courseNumber) {
		CourseNumber = courseNumber;
	}
	public String getClassNumber() {
		return ClassNumber;
	}
	public void setClassNumber(String classNumber) {
		ClassNumber = classNumber;
	}
	public String getAttribute() {
		return attribute;
	}
	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	@Override
	public String toString() {
		return this.getCourseName() + " " + getTimepoint().getWeeksDescription() 
				+" " + getClassroom().getRoomName() + " ��" + getCourseNumber() + "-" + getClassNumber() + "��";
	}
}
