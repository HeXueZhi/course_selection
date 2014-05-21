package com.course.selection.dao;

import java.io.Serializable;
import java.util.List;

import com.course.selection.domain.Role;

/**
 * ��ɫ�������ݿ�ķ��ʲ�ӿ�
 * @author Administrator
 *
 */
public interface RoleDAO {
	/**
	 * ͨ����ʶ���Բ���Roleʵ��
	 * @param id
	 * @return
	 */
	Role get(Serializable id);
	
	/**
	 * �洢Role��ʵ�������ݿ�
	 * @param role
	 * @return
	 */
	Integer save(Role role);

	/**
	 * ��Roleʵ�������ݿ���ɾ��
	 * @param role
	 */
	void delete(Role role);
	
	/**
	 * �޸����ݿ��е�Roleʵ��
	 * @param role
	 */
	void modify(Role role);
	
	/**
	 * ��ѯ���н�ɫ����
	 * @return
	 */
	List<Role> findAll();
	/**
	 * ͨ����ɫ���Ʋ��ҽ�ɫ����
	 * @param name
	 * @return
	 */
	Role findByRoleName(String name);
}
