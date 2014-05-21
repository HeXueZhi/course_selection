package com.course.selection.action;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

import com.course.selection.domain.Course;
import com.course.selection.service.CourseService;
import com.course.selection.util.ImportExcel;
import com.opensymphony.xwork2.ActionSupport;
/**
 * ͨ��Excel�����γ�
 * @author Administrator
 *
 */
public class LoadCourseByExcelAction extends ActionSupport {

	private static final long serialVersionUID = 7273872751774086733L;
		
	private CourseService courseService;

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
		
		List<Course> courses = ImportExcel.importCourseByExcel(excel);
		
		//�������ݿ�
		getCourseService().createCourse(courses);
		
		setMessageKey("admin.load.course.success");
		return SUCCESS;
	}

	public CourseService getCourseService() {
		return courseService;
	}

	public void setCourseService(CourseService courseService) {
		this.courseService = courseService;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) throws UnsupportedEncodingException {
		this.path = URLDecoder.decode(path, "UTF-8");
	}

	public String getErrorKey() {
		return errorKey;
	}

	public void setErrorKey(String errorKey) {
		this.errorKey = errorKey;
	}

	public String getMessageKey() {
		return messageKey;
	}

	public void setMessageKey(String messageKey) {
		this.messageKey = messageKey;
	}
	
	
}
