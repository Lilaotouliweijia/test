package dao;

import java.util.List;

import entity.Info;
public interface InfoDao {
	//��ȡָ��ҳ��ʾ��֪ͨ���б�
		public List<Info> getAllInfo(int page);
		//ͳ�����пͻ�����
		public Integer getCountOfAllInfo();
		//���ݲ�ѯ��������ȡָ��ҳ��ʾ��֪ͨ���б�
		public List<Info> getInfoByCondition(Info condition,int page);
		//ͳ�Ʒ��ϲ�ѯ������֪ͨ������
		public Integer getCountOfInfo(Info condition);
		//���ݱ�ż���֪ͨ��
		public Info getInfoByInfoId(int infoId);
		//���֪ͨ��
		public void addInfo(Info info);
		//ɾ��֪ͨ��
		public void deleteInfo(Info info);
		//�޸�֪ͨ�����
		public void updateInfo(Info info);
}
