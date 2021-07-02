package biz;

import java.util.List;
import entity.Pager;
import entity.FangAn;

public interface FangAnBiz {
	//��ȡָ��ҳ��ʾ�ķ�����Ϣ�б�
	public List<FangAn> getAllFangAn(int page);
	//��ȡָ��ҳ��ʾ�ķ�����Ϣ�б�
	public List<FangAn> getAllFangAnA(int page,FangAn admin);
	//��ȡ���з�����Ϣ����,������ʼ����ҳ��Pager���󣬲�������perPageRows��rowCount����
	public Pager getPagerOfFangAn();	
	//���ݲ�ѯ��������ȡָ��ҳ��ʾ�ķ�����Ϣ�б�
	public List<FangAn> getFangAnByCondition(FangAn condition,int page);
	//ͳ�Ʒ��ϲ�ѯ�����Ŀͻ���Ϣ����,��ʼ����ҳ��Pager��������perPageRows��rowCount����
	public Pager getPagerOfFangAn(FangAn condition);
	//���ݱ�ż��ط�����Ϣ
	public FangAn getFangAnByFangAnId(int cusId);
	//��ӷ�����Ϣ
	public void addFangAn(FangAn fangAn);
	//ɾ��ָ����ŷ�����Ϣ
	public void deleteFangAn(int arcId);
	//�޸ķ�����Ϣ
	public void updateFangAn(FangAn fangAn);
}
