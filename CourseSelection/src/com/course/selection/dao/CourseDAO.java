package com.course.selection.dao;

import java.util.List;

import com.course.selection.domain.ClassRoom;
import com.course.selection.domain.Course;
import com.course.selection.domain.CourseStateType;
import com.course.selection.domain.Student;
import com.course.selection.domain.Teacher;

/**
 * ���ڿγ̵����ݿ���ʽӿ�
 * @author Administrator
 *
 */
public interface CourseDAO {

	/**
	 * �洢Course��ʵ�������ݿ�
	 * @param course ���洢��Courseʵ��
	 * @return �洢��Courseʵ���ı�ʶ����
	 */
	Integer save(Course course);
	/**
	 * �����洢Courseʵ��
	 * @param course
	 */
	void save(List<Course> course);
	
	/**
	 * �����ݿ����Courseʵ��
	 * @param id �����ص�Courseʵ����ʶ����
	 * @return ������ɵ�Courseʵ��
	 */
	Course get(Integer id);
	
	/**
	 * ����Courseʵ��
	 * @param course
	 */
	void update(Course course);
	
	/**
	 * ɾ��Courseʵ��
	 * @param course
	 */
	void delete(Course course);
	
	/**
	 * ͨ��ʵ����ʶ����ɾ��Courseʵ��
	 * @param id
	 */
	void delete(Integer id);
	/**
	 * ͨ��ʵ����ʶ���Դ����ݿ����Ƴ��γ�
	 * @param id
	 */
	void removeFromDatabase(Integer id);
	/**
	 * �����ݿ����Ƴ�courseʵ��
	 * @param course
	 */
	void removeFromDatabase(Course course);
	
	/**
	 * ��ѯȫ���γ�
	 */
	List<Course> findAll();
	
	/**
	 * ͨ����ҳ��ѯ���пγ�
	 * @param pg
	 * @return
	 */
	PageQuery<Course> scanCourseByPage(PageQuery<Course> pg);
	
	/**
	 * ��ѯ���пγ�״̬Ϊtype�Ŀγ�
	 * @param type ָ���Ŀγ�״̬
	 * @return �γ��б� 
	 */
	List<Course> findByType(CourseStateType type);
	
	/**
	 * ��ҳ��ѯ���пγ�״̬Ϊtype�Ŀγ�
	 * @param pg
	 * @param type
	 * @return
	 */
	PageQuery<Course> scanCourseByType(PageQuery<Course> pg,CourseStateType type);

	/**
	 * ��ҳ��ѯ���пγ�״̬��Ϊtype�Ŀγ�
	 * @param pg
	 * @param type
	 * @return
	 */
	PageQuery<Course> scanCourseByNotThatType(PageQuery<Course> pg,CourseStateType type);	
	/**
	 * ��ѯ������teacher���ڵĿγ�
	 * @param teacher ָ���Ľ�ʦ
	 * @return �γ��б�
	 */
	List<Course> findByTeacher(Teacher teacher);
	
	/**
	 * ��ҳ��ѯ����teacher����Ŀγ�
	 * @param pg
	 * @param teacher
	 * @return
	 */
	PageQuery<Course> scanTeacherCourseByPage(PageQuery<Course> pg,Teacher teacher);
	/**
	 * ��ҳ��ѯ����������ʦΪteacherName�Ŀγ�
	 * @param pq
	 * @param teacherName
	 * @return
	 */
	PageQuery<Course> scanCourseByTeacherName(PageQuery<Course> pq,String teacherName);
	
	/**
	 * ��ѯ�����Ͽεص���room�Ŀγ�
	 * @param room
	 * @return
	 */
	List<Course> findByClassRoom(ClassRoom room);
	
	/**
	 * ��ҳ��ѯ�����Ͽεص���room�Ŀγ�
	 * @param pg
	 * @param room
	 * @return
	 */
	PageQuery<Course> scanClassRoomCourseByPage(PageQuery<Course> pg,ClassRoom room);
	
	/**
	 * ��ѯ���пγ̺�ΪcourseNumber�Ŀγ�
	 * @param coursenumber
	 * @return
	 */
	List<Course> findByCourseNumber(String coursenumber);
	/**
	 * ��ѯ�γ̺�ΪcourseNumber�������ΪclassNumber�Ŀγ�
	 * @param courseNumber
	 * @param classNumber
	 * @return
	 */
	Course findByCourseNumberAndClassNumber(String courseNumber,String classNumber);
	
	/**
	 * ��ҳ��ѯ���пγ̺�ΪcourseNumber�Ŀγ�
	 * @param pg
	 * @param CourseNumber
	 * @return
	 */
	PageQuery<Course> scanCourseByCourseNum(PageQuery<Course> pg,String courseNumber);
	
	/**
	 * ��ѯ���пγ���ΪcourseName�Ŀγ�
	 * @param coursename
	 * @return
	 */
	List<Course> findByCourseName(String coursename);
	

	/**
	 * ��ҳ��ѯ���пγ���ΪcourseName�Ŀγ�
	 * @param pg
	 * @param courseName
	 * @return
	 */
	PageQuery<Course> scanCourseByCourseName(PageQuery<Course> pg,String courseName);
	/**
	 * ��ҳ��ѯѧ��student��ѡ�Ŀγ�
	 * @param pq
	 * @param student
	 * @return
	 */
	PageQuery<Course> scanCourseByStudent(PageQuery<Course> pq, Student student);
	
}
