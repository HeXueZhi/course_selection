/**
 * 
 */
package com.course.selection.dao;

import java.util.List;

import com.course.selection.domain.Teacher;

/**
 * ��Teacher�����ݿ���ʲ�
 * @author JiHan
 *
 */
public interface TeacherDAO {
	/**
	 * ���ݱ�ʶ���Լ���Teacherʵ��
	 * @param id:��Ҫ���ص�Teacherʵ���ı�ʶ����ֵ
	 * @return ָ����ʶ���Զ�Ӧ��Teacherʵ��
	 */
	Teacher get(Integer id);
	
	/**
	 * ����ָ����Teacherʵ��
	 * @param ��Ҫ�������Teacherʵ��
	 * @return �������Teacherʵ���ı�ʶ����ֵ
	 */
	Integer save(Teacher teacher);
	/**
	 * ��������Teacherʵ�������ݿ�
	 * @param teachers
	 */
	void save(List<Teacher> teachers);
	
	/**
	 * �޸�ָ����Teacherʵ��
	 * @param ��Ҫ���޸ĵ�Teacherʵ��
	 */
	void updata(Teacher teacher);
	/**
	 * ɾ��ָ����Teacherʵ��
	 * @param teacher ��Ҫ��ɾ����Teacherʵ��
	 */
	void delete(Teacher teacher);
	/**
	 * ���ݱ�ʶ������ɾ��Teacherʵ��
	 * @param id ��Ҫ��ɾ����Teacherʵ���ı�ʶ����ֵ
	 */
	void delete(Integer id);
	/**
	 * ��ѯȫ����Teacherʵ��
	 * @return ���ݿ�������Teacherʵ��
	 */
	List<Teacher> findAll();
	/**
	 * ��ҳ��ѯȫ����Teacherʵ��
	 * @param pq
	 * @return
	 */
	PageQuery<Teacher> scanTeacherByPage(PageQuery<Teacher> pq);
	/**
	 * ���ݽ�ʦ��Ų��ҽ�ʦ
	 * @param account
	 * @return
	 */
	Teacher findTeacherByAccount(String account);
	
	/**
	 * ͨ���������ҽ�ʦ
	 * @param name ָ��������
	 * @return
	 */
	List<Teacher> findAllTeacherByName(String name);
	/**
	 * ���ݽ�ʦ������ҳ���ҽ�ʦ
	 * @param pq
	 * @return
	 */
	PageQuery<Teacher> scanTeacherByNameByPage(PageQuery<Teacher> pq ,String name);
	/**
	 * ����Ժϵ��ҳ���ҽ�ʦ
	 * @param pq
	 * @return
	 */
	PageQuery<Teacher> scanTeacherByDepartmentPage(PageQuery<Teacher> pq,String department);
}
