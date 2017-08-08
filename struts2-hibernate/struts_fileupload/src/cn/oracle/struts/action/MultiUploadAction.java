package cn.oracle.struts.action;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class MultiUploadAction extends ActionSupport {
	private File[] imgs;
	private String[] imgsFileName;
	private List<String> fileList;

	public String multi() {
		// 从application中获取当前项目的根目录，将文件上传路径设置在项目的根目录下的upload
		String realPath = ServletActionContext.getServletContext().getRealPath("/");
		File path = new File(realPath + "\\upload");
		if (!path.exists()) {
			path.mkdirs();
		}
		fileList = new ArrayList<String>();
		int i = 0;
		for (File src : imgs) {
			File destination = new File(path.getPath() + "\\" + imgsFileName[i]);
			try {
				FileUtils.copyFile(src, destination);
				fileList.add("upload/" + destination.getName());
			} catch (IOException e) {
				e.printStackTrace();
			}
			i++;
		}
		return SUCCESS;
	}

	public void setImgs(File[] imgs) {
		this.imgs = imgs;
	}

	public void setImgsFileName(String[] imgsFileName) {
		this.imgsFileName = imgsFileName;
	}

	public List<String> getFileList() {
		return fileList;
	}

}
