package biz;

import java.util.List;
import entity.Pager;
import entity.Meeting;

public interface MeetingBiz {
	//��ȡָ��ҳ��ʾ�Ļ�����Ϣ�б�
	public List<Meeting> getAllMeeting(int page);
	//��ȡ���л�����Ϣ����,������ʼ����ҳ��Pager���󣬲�������perPageRows��rowCount����
	public Pager getPagerOfMeeting();	
	//���ݲ�ѯ��������ȡָ��ҳ��ʾ�Ļ�����Ϣ�б�
	public List<Meeting> getMeetingByCondition(Meeting condition,int page);
	//ͳ�Ʒ��ϲ�ѯ�����Ŀͻ���Ϣ����,��ʼ����ҳ��Pager��������perPageRows��rowCount����
	public Pager getPagerOfMeeting(Meeting condition);
	//���ݱ�ż��ػ�����Ϣ
	public Meeting getMeetingByMeetingId(int cusId);
	//��ӻ�����Ϣ
	public void addMeeting(Meeting meeting);
	//ɾ��ָ����Ż�����Ϣ
	public void deleteMeeting(int arcId);
	//�޸Ļ�����Ϣ
	public void updateMeeting(Meeting meeting);
}
