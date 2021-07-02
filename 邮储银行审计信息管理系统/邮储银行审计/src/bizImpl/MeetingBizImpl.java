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
		//ʹ�÷�ҳ��Pager�������
		Pager pager=new Pager();
		//����pager�����е�perPageRows���ԣ���ʾÿҳ��ʾ�ļ�¼��
		pager.setPerPageRows(6);
		//����pager�����е�rowCount���ԣ���ʾ��¼����
		pager.setRowCount(count);
	    //����pager����
		return pager;
	}
	@Override
	public List<Meeting> getMeetingByCondition(Meeting condition, int page) {		
		return meetingDao.getMeetingByCondition(condition, page);
	}
	//ͳ�Ʒ��ϲ�ѯ��������Ϣ����,��ʼ����ҳ��Pager��������perPageRows��rowCount����
	@Override
	public Pager getPagerOfMeeting(Meeting condition) {
		int count= meetingDao.getCountOfMeeting(condition);
		//ʹ�÷�ҳ��Pager�������
		Pager pager=new Pager();
		//����pager�����е�perPageRows���ԣ���ʾÿҳ��ʾ�ļ�¼��
		pager.setPerPageRows(6);
		//����pager�����е�rowCount���ԣ���ʾ��¼����
		pager.setRowCount(count);
	    //����pager����
		return pager;
	}
	
	@Override
	public Meeting getMeetingByMeetingId(int marId) {
		return meetingDao.getMeetingByMeetingId(marId);
	}
	
	//�����Ϣ
	@Override
	public void addMeeting(Meeting fangAn) {
		meetingDao.addMeeting(fangAn);		
	}
	
	//ɾ��ָ�������Ϣ
	@Override
	public void deleteMeeting(int marId) {		
		Meeting meeting=meetingDao.getMeetingByMeetingId(marId);
		meetingDao.deleteMeeting(meeting);
	}
	//�޸���Ϣ
	@Override
	public void updateMeeting(Meeting meeting) {
		meetingDao.updateMeeting(meeting);		
	}


}
