package com.course.selection.dao;

import java.util.List;

import com.course.selection.domain.User;

/**
 * ����User�����ݿ���ʲ�
 * @author Administrator
 *
 */
public interface UserDAO {

	/**
	 * ���ݱ�ʶ���Լ���Userʵ��
	 * @param id ��Ҫ���ص�Userʵ���ı�ʶ����ֵ
	 * @return ָ����ʶ���Զ�Ӧ��Userʵ��
	 */
	User get(Integer id);
	
	/**
	 * �־û�ָ����Userʵ��
	 * @param user ��Ҫ���־û���Userʵ��
	 * @return Userʵ�����־û���ı�ʶ����ֵ
	 */
	Integer save(User user);
	
	/**
	 * �޸�ָ����Userʵ��
	 * @param user ��Ҫ���޸ĵ�Userʵ��
	 */
	void update(User user);
	
	/**
	 * ɾ��ָ����Userʵ��
	 * @param user ��Ҫ��ɾ����Userʵ��
	 */
	void delete(User user);
	
	/**
	 * ͨ��ʵ����ʶ����idɾ��Userʵ��
	 * @param id
	 */
	void delete(Integer id);
	/**
	 * �����û������������User�б�
	 * @param name �û���
	 * @param passwd ����
	 * @return ����������User�б�
	 */
	List<User> findByNameAndPasswd(String name,String passwd);
	
	/**
	 * ���������û�
	 * @return
	 */
	List<User> findAllUser();
	/**
	 * �鿴�����û���ͨ����ҳ�ķ�ʽ
	 * @param pq
	 * @return
	 */
	PageQuery<User> scanUserByPage(PageQuery<User> pq);
}
