package bizImpl;

import java.util.List;
import biz.MeetingBiz;
import dao.MeetingDao;
import entity.Pager;
import entity.Meeting;

public class MeetingBizImpl implements MeetingBiz{
	private MeetingDao meetingDao;
	
	

	

	public MeetingDao getMeetingDao() {
		return meetingDao;
	}

	public void setMeetingDao(MeetingDao meetingDao) {
		this.meetingDao = meetingDao;
	}

	@Override
	public List<Meeting> getAllMeeting(int page) {
		return meetingDao.getAllMeeting(page);
	}
	
	@Override
	public Pager getPagerOfMeeting() {
		int count= meetingDao.getCountOfAllMeeting();
		//使用分页类Pager定义对象
		Pager pager=new Pager();
		//设置pager对象中的perPageRows属性，表示每页显示的记录数
		pager.setPerPageRows(6);
		//设置pager对象中的rowCount属性，表示记录总数
		pager.setRowCount(count);
	    //返回pager对象
		return pager;
	}
	@Override
	public List<Meeting> getMeetingByCondition(Meeting condition, int page) {		
		return meetingDao.getMeetingByCondition(condition, page);
	}
	//统计符合查询条件的信息数量,初始化分页类Pager对象，设置perPageRows和rowCount属性
	@Override
	public Pager getPagerOfMeeting(Meeting condition) {
		int count= meetingDao.getCountOfMeeting(condition);
		//使用分页类Pager定义对象
		Pager pager=new Pager();
		//设置pager对象中的perPageRows属性，表示每页显示的记录数
		pager.setPerPageRows(6);
		//设置pager对象中的rowCount属性，表示记录总数
		pager.setRowCount(count);
	    //返回pager对象
		return pager;
	}
	
	@Override
	public Meeting getMeetingByMeetingId(int marId) {
		return meetingDao.getMeetingByMeetingId(marId);
	}
	
	//添加信息
	@Override
	public void addMeeting(Meeting fangAn) {
		meetingDao.addMeeting(fangAn);		
	}
	
	//删除指定编号信息
	@Override
	public void deleteMeeting(int marId) {		
		Meeting meeting=meetingDao.getMeetingByMeetingId(marId);
		meetingDao.deleteMeeting(meeting);
	}
	//修改信息
	@Override
	public void updateMeeting(Meeting meeting) {
		meetingDao.updateMeeting(meeting);		
	}


}
