package com.oracle.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.oracle.entity.Room;
import com.oracle.model.PageBean;

@Namespace("/room")
@Results({
	@Result(name="listPage",location="list.jsp"),
	@Result(name="updatePage",location="list.jsp"),
	@Result(name="addPage",location="list.jsp"),
	@Result(name="redirect2list",location="list.action",type="redirect")
})
public class RoomAction extends BaseAction{
	
	private PageBean pb;
	private int currentPage;
	private List<Room> list;
	private Room room;
	private Integer id;
	
	@Action("list")
	public String list(){
		pb=roomService.findPageBean(currentPage,10,room);
		return "listPage";
	}
	
	@Action("updatePage")
	public String updatePage(){
		return null;
	}



	public PageBean getPb() {
		return pb;
	}
	public void setPb(PageBean pb) {
		this.pb = pb;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public List<Room> getList() {
		return list;
	}
	public void setList(List<Room> list) {
		this.list = list;
	}
	public Room getRoom() {
		return room;
	}
	public void setRoom(Room room) {
		this.room = room;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
}
