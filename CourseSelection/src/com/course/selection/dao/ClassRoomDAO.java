/**
 * 
 */
package com.course.selection.dao;

import java.util.List;

import com.course.selection.domain.ClassRoom;

/**
 * @author JiHan
 *
 */
public interface ClassRoomDAO {
	/**
	 * ���ݱ�ʶ���Լ���ClassRoomʵ��
	 * @param id:��Ҫ���ص�ClassRoomʵ���ı�ʶ����ֵ
	 * @return ָ����ʶ���Զ�Ӧ��ClassRoomʵ��
	 */
	ClassRoom get(Integer id);
	
	/**
	 * ����ָ����ClassRoomʵ��
	 * @param ��Ҫ�������ClassRoomʵ��
	 * @return �������ClassRoomʵ���ı�ʶ����ֵ
	 */
	Integer save(ClassRoom classRoom);
	/**
	 * ��������ClassRoomʵ��
	 * @param rooms
	 */
	void save(List<ClassRoom> rooms);
	/**
	 * �޸�ָ����ClassRoomʵ��
	 * @param ��Ҫ���޸ĵ�ClassRoomʵ��
	 */
	void updata(ClassRoom classRoom);
	/**
	 * ɾ��ָ����ClassRoomʵ��
	 * @param ClassRoom ��Ҫ��ɾ����ClassRoomʵ��
	 */
	void delete(ClassRoom classRoom);
	/**
	 * ���ݱ�ʶ������ɾ��ClassRoomʵ��
	 * @param id ��Ҫ��ɾ����ClassRoomʵ���ı�ʶ����ֵ
	 */
	void delete(Integer id);
	/**
	 * ���ݱ�ʶ����������ClassRoomʵ��
	 * @param name ��Ҫ�����ҵ�ClassRoomʵ���ı�ʶ����ֵ
	 * @return ָ����ʶ���Զ�Ӧ��ClassRoomʵ��
	 */
	ClassRoom findbyName(String name);
	/**
	 * ��ѯȫ����ClassRoomʵ��
	 * @return ���ݿ�������ClassRoomʵ��
	 */
	List<ClassRoom> findAll();
	/**
	 * ��ѯ���н��ҵ�����
	 * @return
	 */
	List<String> findAllName();
	/**
	 * ��ҳ��ѯ���н���
	 * @param pq
	 * @return
	 */
	PageQuery<ClassRoom> scanClassRoomByPage(PageQuery<ClassRoom> pq);

}
