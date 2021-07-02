package biz;

import java.util.List;
import entity.Pager;
import entity.Meeting;

public interface MeetingBiz {
	//获取指定页显示的会议信息列表
	public List<Meeting> getAllMeeting(int page);
	//获取所有会议信息数量,用来初始化分页类Pager对象，并设置其perPageRows和rowCount属性
	public Pager getPagerOfMeeting();	
	//根据查询条件，获取指定页显示的会议信息列表
	public List<Meeting> getMeetingByCondition(Meeting condition,int page);
	//统计符合查询条件的客户信息数量,初始化分页类Pager对象，设置perPageRows和rowCount属性
	public Pager getPagerOfMeeting(Meeting condition);
	//根据编号加载会议信息
	public Meeting getMeetingByMeetingId(int cusId);
	//添加会议信息
	public void addMeeting(Meeting meeting);
	//删除指定编号会议信息
	public void deleteMeeting(int arcId);
	//修改会议信息
	public void updateMeeting(Meeting meeting);
}
