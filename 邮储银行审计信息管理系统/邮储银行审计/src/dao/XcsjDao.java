package dao;

import java.util.List;

import entity.Xcsj;
public interface XcsjDao {
	//��ȡָ��ҳ��ʾ��֪ʶ���б�
		public List<Xcsj> getAllXcsj(int page);
		//ͳ�����пͻ�����
		public Integer getCountOfAllXcsj();
		//���ݲ�ѯ��������ȡָ��ҳ��ʾ��֪ʶ���б�
		public List<Xcsj> getXcsjByCondition(Xcsj condition,int page);
		//ͳ�Ʒ��ϲ�ѯ������֪ʶ������
		public Integer getCountOfXcsj(Xcsj condition);
		//���ݱ�ż���֪ʶ��
		public Xcsj getXcsjByXcsjId(int xcsjId);
		//���֪ʶ��
		public void addXcsj(Xcsj xcsj);
		//ɾ��֪ʶ��
		public void deleteXcsj(Xcsj xcsj);
		//�޸�֪ʶ�����
		public void updateXcsj(Xcsj xcsj);
}
