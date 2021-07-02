package biz;

import java.util.List;
import entity.Pager;
import entity.Info;

public interface InfoBiz {
	//��ȡָ��ҳ��ʾ��֪ͨ����Ϣ�б�
	public List<Info> getAllInfo(int page);
	//��ȡ����֪ͨ����Ϣ����,������ʼ����ҳ��Pager���󣬲�������perPageRows��rowCount����
	public Pager getPagerOfInfo();	
	//���ݲ�ѯ��������ȡָ��ҳ��ʾ��֪ͨ����Ϣ�б�
	public List<Info> getInfoByCondition(Info condition,int page);
	//ͳ�Ʒ��ϲ�ѯ�����Ŀͻ���Ϣ����,��ʼ����ҳ��Pager��������perPageRows��rowCount����
	public Pager getPagerOfInfo(Info condition);
	//���ݱ�ż���֪ͨ����Ϣ
	public Info getInfoByInfoId(int cusId);
	//���֪ͨ����Ϣ
	public void addInfo(Info info);
	//ɾ��ָ�����֪ͨ����Ϣ
	public void deleteInfo(int arcId);
	//�޸�֪ͨ����Ϣ
	public void updateInfo(Info info);
}
