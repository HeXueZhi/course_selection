/**
 * 
 */
package com.course.selection.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import com.course.selection.dao.ClassRoomDAO;
import com.course.selection.dao.CourseDAO;
import com.course.selection.dao.PageQuery;
import com.course.selection.dao.RoleDAO;
import com.course.selection.dao.StudentDAO;
import com.course.selection.dao.TeacherDAO;
import com.course.selection.dao.UserDAO;
import com.course.selection.domain.Course;
import com.course.selection.domain.CourseStateType;
import com.course.selection.domain.Role;
import com.course.selection.domain.Student;
import com.course.selection.domain.Teacher;
import com.course.selection.service.StudentService;

/**
 * @author JiHan
 *
 */
public class StudentServiceImpl implements StudentService {
	private StudentDAO studentDAO;
	private CourseDAO courseDAO;
	private TeacherDAO teacherDAO;
	private ClassRoomDAO classRoomDAO;
	private UserDAO userDAO;
	private RoleDAO roleDAO;
	/* ���� Javadoc��
	 * @see com.course.selection.service.StudentService#lookCourseAll(com.course.selection.dao.PageQuery)
	 */
	@Override
	public PageQuery<Course> lookCourseAll() {
		return this.courseDAO.scanCourseByPage(null);
	}
	
	@Override
	public PageQuery<Course> lookCourseAll(PageQuery<Course> pq) {
		
		return this.courseDAO.scanCourseByPage(pq);
	}

	/* ���� Javadoc��
	 * @see com.course.selection.service.StudentService#searchCourseByCourseName(java.lang.String)
	 */
	@Override
	public List<Course> searchCourseByCourseName(String coursename) {
		List<Course> result=courseDAO.findByCourseName(coursename);
		return result;
	}

	/* ���� Javadoc��
	 * @see com.course.selection.service.StudentService#searchCourseByCourseNmber(int)
	 */
	@Override
	public List<Course> searchCourseByCourseNmber(String coursenumber) {
		List<Course> result=courseDAO.findByCourseNumber(coursenumber);
		return result;
	}

	/* ���� Javadoc��
	 * @see com.course.selection.service.StudentService#searchCourseByTeacherName(java.lang.String)
	 */
	@Override
	public List<Course> searchCourseByTeacherName(String teachername) {
		List<Teacher> teachers = this.teacherDAO.findAllTeacherByName(teachername);
		List<Course> courses = new ArrayList<>();
		for(Teacher teacher: teachers){
			courses.addAll(this.courseDAO.findByTeacher(teacher));
		}
		return courses;
	}


	/* ���� Javadoc��
	 * @see com.course.selection.service.StudentService#deleteCourse(com.course.selection.domain.Course)
	 */
	@Override
	public void rmCourse(Course course,Student student) {
		student.getCourse().remove(course);
		int num = course.getCourseState().getStudentNumber();
		int capacity = course.getCapacity();
		if(num == capacity){
			course.getCourseState().setStateType(CourseStateType.PICKABLE);
		}
		num = num - 1;
		course.getCourseState().setStudentNumber(num);
		this.courseDAO.update(course);
	}

	/**
	 * @return teacherDAO
	 */
	public TeacherDAO getTeacherDAO() {
		return teacherDAO;
	}

	/**
	 * @param teacherDAO Ҫ���õ� teacherDAO
	 */
	public void setTeacherDAO(TeacherDAO teacherDAO) {
		this.teacherDAO = teacherDAO;
	}

	@Override
	public boolean addCourse(Course course, Student student) {
		if(student != null && course != null && 
				course.getCourseState().getStateType() == CourseStateType.PICKABLE){
			if(student.getCourse() == null){
				student.setCourse(new HashSet<Course>());
			}
			student.getCourse().add(course);
			int num = course.getCourseState().getStudentNumber();
			num = num + 1;
			int capacity = course.getCapacity();
			if(num == capacity){
				course.getCourseState().setStateType(CourseStateType.FULL);
			}
			course.getCourseState().setStudentNumber(num);
			this.courseDAO.update(course);
			return true;
		}
		return false;
	}

	/**
	 * @return studentDAO
	 */
	public StudentDAO getStudentDAO() {
		return studentDAO;
	}

	/**
	 * @param studentDAO Ҫ���õ� studentDAO
	 */
	public void setStudentDAO(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}

	/**
	 * @return classRoomDAO
	 */
	public ClassRoomDAO getClassRoomDAO() {
		return classRoomDAO;
	}

	/**
	 * @param classRoomDAO Ҫ���õ� classRoomDAO
	 */
	public void setClassRoomDAO(ClassRoomDAO classRoomDAO) {
		this.classRoomDAO = classRoomDAO;
	}

	/**
	 * @return userDAO
	 */
	public UserDAO getUserDAO() {
		return userDAO;
	}

	/**
	 * @param userDAO Ҫ���õ� userDAO
	 */
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	/**
	 * @return roleDAO
	 */
	public RoleDAO getRoleDAO() {
		return roleDAO;
	}

	/**
	 * @param roleDAO Ҫ���õ� roleDAO
	 */
	public void setRoleDAO(RoleDAO roleDAO) {
		this.roleDAO = roleDAO;
	}

	/**
	 * @return the courseDAO
	 */
	public CourseDAO getCourseDAO() {
		return courseDAO;
	}

	/**
	 * @param courseDAO the courseDAO to set
	 */
	public void setCourseDAO(CourseDAO courseDAO) {
		this.courseDAO = courseDAO;
	}

	@Override
	public Student getStudentByAccount(String account) {

		return getStudentDAO().findStudentByAccount(account);
	}

	@Override
	public Student getStudentByID(Integer id) {
		return getStudentDAO().get(id);
	}

	@Override
	public PageQuery<Student> scanStudent() {
		return getStudentDAO().scanStudentByPage(null);
	}

	@Override
	public PageQuery<Student> scanStudent(PageQuery<Student> pq) {
		return getStudentDAO().scanStudentByPage(pq);
	}

	@Override
	public Integer createStudent(Student student) {
		Role role = getRoleDAO().findByRoleName("Student");
		if(student != null) student.setRole(role);
		return getStudentDAO().save(student);
	}

	@Override
	public void createStudent(List<Student> students) {
		Role role = getRoleDAO().findByRoleName("Student");
		for(Student student: students){
			student.setRole(role);
		}
		getStudentDAO().save(students);
	}

	@Override
	public void deleteStudent(List<Integer> list) {
		for(Integer id : list){
			getStudentDAO().delete(id);
		}
	}

	@Override
	public void modifyStudent(Student student) {
		
		getStudentDAO().update(student);
		
	}

	@Override
	public PageQuery<Student> scanStudentByCourse(Course course) {
		
		return getStudentDAO().scanCourseStudentByPage(null, course);
	}

	@Override
	public PageQuery<Student> scanStudentByCourse(PageQuery<Student> pq,
			Course course) {
		return getStudentDAO().scanCourseStudentByPage(null, course);
	}

}
