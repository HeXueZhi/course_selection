package com.course.selection.action;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

import com.course.selection.domain.ClassRoom;
import com.course.selection.service.ClassRoomService;
import com.course.selection.util.ImportExcel;
import com.opensymphony.xwork2.ActionSupport;
/**
 * ͨ��Excel�����γ�
 * @author Administrator
 *
 */
public class LoadClassRoomByExcelAction extends ActionSupport {
	
	private static final long serialVersionUID = 2675732819333406920L;
	
	private ClassRoomService classRoomService;
	
	private String path;
	
	private String errorKey;
	
	private String messageKey;

	@Override
	public String execute() throws Exception {
				
		if(path == null || !new File(path).exists()){
			setErrorKey("admin.not.exist.uploadfile");
			return ERROR;
		}
		
		//���ϴ����ļ����д���
		File excel = new File(path);
		List<ClassRoom> classRooms = ImportExcel.importClassRoomByExcel(excel);
		//�������ݿ�
		getClassRoomService().createClassRooms(classRooms);
		setMessageKey("admin.load.classroom.success");
		return SUCCESS;
	}

	public ClassRoomService getClassRoomService() {
		return classRoomService;
	}

	public void setClassRoomService(ClassRoomService classRoomService) {
		this.classRoomService = classRoomService;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) throws UnsupportedEncodingException {
		this.path = URLDecoder.decode(path, "UTF-8");
	}

	public String getMessageKey() {
		return messageKey;
	}

	public void setMessageKey(String messageKey) {
		this.messageKey = messageKey;
	}

	public String getErrorKey() {
		return errorKey;
	}

	public void setErrorKey(String errorKey) {
		this.errorKey = errorKey;
	}
	
}
