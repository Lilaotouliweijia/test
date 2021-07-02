package dao;

import java.util.List;

import entity.FangAn;
public interface FangAnDao {
	//��ȡָ��ҳ��ʾ�ķ����б�
		public List<FangAn> getAllFangAn(int page);
		//��ȡָ��ҳ��ʾ�ķ�����Ϣ�б�
		public List<FangAn> getAllFangAnA(int page,FangAn admin);
		//ͳ�����пͻ�����
		public Integer getCountOfAllFangAn();
		//���ݲ�ѯ��������ȡָ��ҳ��ʾ�ķ����б�
		public List<FangAn> getFangAnByCondition(FangAn condition,int page);
		//ͳ�Ʒ��ϲ�ѯ�����ķ�������
		public Integer getCountOfFangAn(FangAn condition);
		//���ݱ�ż��ط���
		public FangAn getFangAnByFangAnId(int fangAnId);
		//��ӷ���
		public void addFangAn(FangAn fangAn);
		//ɾ������
		public void deleteFangAn(FangAn fangAn);
		//�޸ķ�������
		public void updateFangAn(FangAn fangAn);
}
