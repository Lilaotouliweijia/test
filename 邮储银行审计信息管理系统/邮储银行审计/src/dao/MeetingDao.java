package dao;

import java.util.List;

import entity.Meeting;
public interface MeetingDao {
	//��ȡָ��ҳ��ʾ�Ļ����б�
	public List<Meeting> getAllMeeting(int page);
	//ͳ�����пͻ�����
	public Integer getCountOfAllMeeting();
	//���ݲ�ѯ��������ȡָ��ҳ��ʾ�Ļ����б�
	public List<Meeting> getMeetingByCondition(Meeting condition,int page);
	//ͳ�Ʒ��ϲ�ѯ�����Ļ�������
	public Integer getCountOfMeeting(Meeting condition);
	//���ݱ�ż��ػ���
	public Meeting getMeetingByMeetingId(int meetingId);
	//��ӻ���
	public void addMeeting(Meeting meeting);
	//ɾ������
	public void deleteMeeting(Meeting meeting);
	//�޸Ļ������
	public void updateMeeting(Meeting meeting);
}
