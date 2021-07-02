package dao;

import java.util.List;

import entity.Meeting;
public interface MeetingDao {
	//获取指定页显示的会议列表
	public List<Meeting> getAllMeeting(int page);
	//统计所有客户总数
	public Integer getCountOfAllMeeting();
	//根据查询条件，获取指定页显示的会议列表
	public List<Meeting> getMeetingByCondition(Meeting condition,int page);
	//统计符合查询条件的会议总数
	public Integer getCountOfMeeting(Meeting condition);
	//根据编号加载会议
	public Meeting getMeetingByMeetingId(int meetingId);
	//添加会议
	public void addMeeting(Meeting meeting);
	//删除会议
	public void deleteMeeting(Meeting meeting);
	//修改会议对象
	public void updateMeeting(Meeting meeting);
}
