package com.course.selection.domain;

public enum CourseStateType {
	CREATE("�Ѵ���"),INDATABASE("�Ѵ洢"),MODIFIED("���޸�"),PICKABLE("��ѡ"),FULL("����"),DELETED("��ɾ��");
	
	private String value;
	
	private CourseStateType(String value){
		this.value = value;
	}
	
	public String getValue(){
		return value;
	}
}
