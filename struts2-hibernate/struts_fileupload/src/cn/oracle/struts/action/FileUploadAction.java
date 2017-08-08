package cn.oracle.struts.action;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import com.opensymphony.xwork2.ActionSupport;

public class FileUploadAction extends ActionSupport {
	private File file;
	private String fileFileName;

	
	public String upload() {
		File destination = new File("E:\\" + fileFileName);
		try {
			FileUtils.copyFile(file, destination);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "success";
	}


	public File getFile() {
		return file;
	}


	public void setFile(File file) {
		this.file = file;
	}


	public String getFileFileName() {
		return fileFileName;
	}


	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}
	
}
