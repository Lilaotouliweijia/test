package biz;

import java.util.List;
import entity.Pager;
import entity.Xcsj;

public interface XcsjBiz {
	//��ȡָ��ҳ��ʾ���ֳ������Ϣ�б�
	public List<Xcsj> getAllXcsj(int page);
	//��ȡ�����ֳ������Ϣ����,������ʼ����ҳ��Pager���󣬲�������perPageRows��rowCount����
	public Pager getPagerOfXcsj();	
	//���ݲ�ѯ��������ȡָ��ҳ��ʾ���ֳ������Ϣ�б�
	public List<Xcsj> getXcsjByCondition(Xcsj condition,int page);
	//ͳ�Ʒ��ϲ�ѯ�����Ŀͻ���Ϣ����,��ʼ����ҳ��Pager��������perPageRows��rowCount����
	public Pager getPagerOfXcsj(Xcsj condition);
	//���ݱ�ż����ֳ������Ϣ
	public Xcsj getXcsjByXcsjId(int cusId);
	//����ֳ������Ϣ
	public void addXcsj(Xcsj xcsj);
	//ɾ��ָ������ֳ������Ϣ
	public void deleteXcsj(int arcId);
	//�޸��ֳ������Ϣ
	public void updateXcsj(Xcsj xcsj);
}
