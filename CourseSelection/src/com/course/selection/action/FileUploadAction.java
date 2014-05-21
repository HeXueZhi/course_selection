package com.course.selection.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class FileUploadAction extends ActionSupport {

	private static final long serialVersionUID = 1240724054350602732L;
	
	/**
	 * ��װ�ϴ��ļ��������
	 */
	private File upload;
	/**
	 * ��װ�ϴ��ļ����͵�����
	 */
	private String uploadContentType;
	/**
	 * ��װ�ϴ��ļ���������
	 */
	private String uploadFileName;

	/**
	 * ֱ����struts.xml�ļ������õ�����
	 */
	private String savePath;
	/**
	 * ����·��
	 */
	private String realPath;
	
	/**
	 * ��һ��Action
	 */
	private String nextAction;
	/**
	 * @return the upload
	 */
	public File getUpload() {
		return upload;
	}

	/**
	 * @param upload the upload to set
	 */
	public void setUpload(File upload) {
		this.upload = upload;
	}

	/**
	 * @return the uploadContentType
	 */
	public String getUploadContentType() {
		return uploadContentType;
	}

	/**
	 * @param uploadContentType the uploadContentType to set
	 */
	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	/**
	 * @return the uploadFileName
	 */
	public String getUploadFileName() {
		return uploadFileName;
	}

	/**
	 * @param uploadFileName the uploadFileName to set
	 */
	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	/**
	 * ���ؾ���·��
	 * @return the savePath
	 */
	public String getSavePath() {
		return ServletActionContext.getServletContext().getRealPath(savePath);
	}

	/**
	 * @param savePath the savePath to set
	 */
	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}
	/**
	 * ��ȡ�ϴ��ļ��ľ���·��
	 * @return
	 */
	public String getRealPath(){
		return this.realPath;
	}

	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	@Override
	public String execute() throws Exception {
		
		if(getUpload() == null){
			addActionError(getText("upload.file.is.null"));
			return ERROR;
		}

		File dirPath = new File(getSavePath());
		if(!dirPath.exists()){
			dirPath.mkdirs();
		}
		
		File filePath = new File(dirPath, getUploadFileName());
		FileOutputStream fos = new FileOutputStream(filePath);
		
		FileInputStream fis = new FileInputStream(getUpload());
		
		byte[] buffer = new byte[1024];
		int len = 0;
		while((len = fis.read(buffer)) > 0){
			fos.write(buffer, 0, len);
		}
		
		fos.close();
		fis.close();
		this.setRealPath(filePath.getAbsolutePath());
		return SUCCESS;
	}

	public String getNextAction() {
		return nextAction;
	}

	public void setNextAction(String nextAction) {
		this.nextAction = nextAction;
	}

	public void setRealPath(String realPath) throws UnsupportedEncodingException {
	
		this.realPath = URLEncoder.encode(realPath,"UTF-8");
	}

}
