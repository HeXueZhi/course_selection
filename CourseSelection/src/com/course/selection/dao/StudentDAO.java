/**
 * 
 */
package com.course.selection.dao;

import java.util.List;

import com.course.selection.domain.Course;
import com.course.selection.domain.Student;

/**
 * ��Student�����ݿ���ʲ�
 * @author JiHan
 *
 */
public interface StudentDAO {
	/**
	 * ���ݱ�ʶ���Լ���Studentʵ��
	 * @param id:��Ҫ���ص�Studentʵ���ı�ʶ����ֵ
	 * @return ָ����ʶ���Զ�Ӧ��Studentʵ��
	 */
	Student get(Integer id);
	
	/**
	 * ����ָ����Studentʵ��
	 * @param ��Ҫ�������Studentʵ��
	 * @return �������Studentʵ���ı�ʶ����ֵ
	 */
	Integer save(Student student);
	/**
	 * ��������Studentʵ�������ݿ�
	 * @param students
	 */
	void save(List<Student> students);
	
	/**
	 * �޸�ָ����Studentʵ��
	 * @param ��Ҫ���޸ĵ�Studentʵ��
	 */
	void update(Student student);
	/**
	 * ɾ��ָ����Studentʵ��
	 * @param Student ��Ҫ��ɾ����Studentʵ��
	 */
	void delete(Student student);
	/**
	 * ���ݱ�ʶ������ɾ��Studentʵ��
	 * @param id ��Ҫ��ɾ����Studentʵ���ı�ʶ����ֵ
	 */
	void delete(Integer id);

	/**
	 * ���ݿγ�������ѧ������
	 * @param course �γ�
	 * @return ѡ��ָ���γ̵�����ѧ������
	 */
	List<Student> findByCourse(Course course);
	/**
	 * ��ѯȫ����Studentʵ��
	 * @return ���ݿ�������Studentʵ��
	 */
	List<Student> findAll();
	/**
	 * ��ҳ��ѯ����Studentʵ��
	 * @param pq
	 * @return
	 */
	PageQuery<Student> scanStudentByPage(PageQuery<Student> pq);
	/**
	 * ��ҳ��ѯ����ѡ��Course��Student
	 * @param pq
	 * @return
	 */
	PageQuery<Student> scanCourseStudentByPage(PageQuery<Student> pq,Course course);
	
	/**
	 * ����ѧ�Ų���ѧ��
	 * @param Account
	 * @return
	 */
	Student findStudentByAccount(String Account);
	/**
	 * ����������ҳ����
	 * @param pq
	 * @return
	 */
	PageQuery<Student> scanStudentByNameByPage(PageQuery<Student> pq,String name);
	/**
	 * ���ݰ༶����ѧ��
	 * @param pq
	 * @return
	 */
	PageQuery<Student> scanStudentByClassByPage(PageQuery<Student> pq,String clazz);
	/**
	 * ����Ժϵ����ѧ��
	 * @param pq
	 * @param department
	 * @return
	 */
	PageQuery<Student> scanStudentByDepartmentByPage(PageQuery<Student> pq,String department);
}
