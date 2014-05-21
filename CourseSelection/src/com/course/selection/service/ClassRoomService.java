package com.course.selection.service;

import java.util.List;

import com.course.selection.dao.PageQuery;
import com.course.selection.domain.ClassRoom;
import com.course.selection.domain.Course;

public interface ClassRoomService {
	
	/**
	 * ɾ������
	 * @param id
	 */
	boolean deleteClassRoom(Integer id);
	/**
	 * ����ɾ������
	 * @param ids
	 */
	boolean deleteClassRoom(List<Integer> ids);
	/**
	 * ����½���
	 * @param room
	 * @return
	 */
	Integer addNewClassRoom(ClassRoom room);
	/**
	 * �������Ƿ����
	 * @param name
	 * @return
	 */
	boolean isClassRoomNameExist(String name);
	/**
	 * �޸Ľ���
	 * @param room
	 */
	void modifyClassRoom(ClassRoom room);
	
	/**
	 * �鿴�����Ƿ�Ϊ��
	 * @param classRoom
	 * @return
	 */
	boolean isClassRoomEmpty(ClassRoom classRoom);
	/**
	 * ͨ����������ý���
	 * @param name
	 * @return
	 */
	ClassRoom getClassRoomByName(String name);

	/**
	 * ͨ����ʶ���Բ��ҽ���
	 * @param id
	 * @return
	 */
	ClassRoom getClassRoomByID(Integer id);
	/**
	 * �鿴ָ�����ҵĿγ��б�
	 * @param classroom
	 * @return
	 */
	List<Course> lookClassRoomCourses(ClassRoom classroom);
	
	/**
	 * �鿴���н���
	 * @return
	 */
	List<ClassRoom> lookClassRoom();
	/**
	 * ��ҳ�鿴���н��ң���һҳ
	 */
	PageQuery<ClassRoom> lookClassRoomByPage();
	/**
	 * ��ҳ�鿴���н��ң�����ҳ
	 */
	PageQuery<ClassRoom> lookClassRoomByPage(PageQuery<ClassRoom> pq);
	/**
	 * ����һ������
	 * @param room
	 * @return
	 */
	Integer createClassRoom(ClassRoom room);
	/**
	 * ������������
	 * @param rooms
	 */
	void createClassRooms(List<ClassRoom> rooms);

	/**
	 * ��ȡroom���ҵĿ���ʱ���
	 * @param room
	 * @return �ɿ���ʱ�����ɵ��ַ���
	 */
	List<String> getEmptyPeriod(ClassRoom room);
	/**
	 * ��ȡ���н��ҵĽ�����
	 * @return
	 */
	List<String> getClassRoomNames();
}
