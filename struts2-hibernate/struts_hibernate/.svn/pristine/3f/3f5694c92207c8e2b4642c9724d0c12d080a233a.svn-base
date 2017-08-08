package com.oracle.model;

import java.util.List;

import com.oracle.util.PageUtil;

public class PageBean {

	private Integer currentPage=1;
	private Integer pageSize=10;
	private Integer maxSize=0;
	private Integer maxPage=0;
	
	private List<?> list;
	
	public PageBean(){}
	
	public PageBean(int currentPage){
		this.currentPage=currentPage;
	}
	
	public PageBean(String currentPage){
		int page=1;
		try{
			page=Integer.parseInt(currentPage);
		}catch(Exception e){
			System.out.println("参数错误");
		}
		//因为刚刚创建PageBean对象,暂时不知道共有多少页数据,所以只能对页码小于1进行判断
		//暂时不能判断页码大于最大页码
		if(page<1)page=1;
		
		//if(page>maxPage)page=maxPage;
		
		this.currentPage=page;
	}
	
	

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getMaxSize() {
		return maxSize;
	}

	//设置总数量时,就可以计算总页数了
	public void setMaxSize(Integer maxSize) {
		this.maxSize = maxSize;
		//上行代码已经获取到了总数量,下行代码直接计算出总页数
		this.maxPage=PageUtil.getMaxPage(maxSize, pageSize);
		
		//这里设置了总消息数量之后,就可以计算出总页数,就可以对当前页的后限进行判断处理
		if(this.currentPage>this.maxPage)this.currentPage=this.maxPage;
	}

	public Integer getMaxPage() {
		return maxPage;
	}

	public void setMaxPage(Integer maxPage) {
		this.maxPage = maxPage;
	}

	public List<?> getList() {
		return list;
	}

	public void setList(List<?> list) {
		this.list = list;
	}
	
	
	//用于sql查询时的起点坐标和长度,都封装到PageBean中
	public int getBegin(){
		int begin=(currentPage-1)*pageSize;
		return begin;
	}
	public int getLength(){
		return pageSize;
	}
}
