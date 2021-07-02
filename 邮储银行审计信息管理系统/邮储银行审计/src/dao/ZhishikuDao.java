package dao;

import java.util.List;

import entity.Zhishiku;
public interface ZhishikuDao {
	//��ȡָ��ҳ��ʾ��֪ʶ���б�
		public List<Zhishiku> getAllZhishiku(int page);
		//ͳ�����пͻ�����
		public Integer getCountOfAllZhishiku();
		//���ݲ�ѯ��������ȡָ��ҳ��ʾ��֪ʶ���б�
		public List<Zhishiku> getZhishikuByCondition(Zhishiku condition,int page);
		//ͳ�Ʒ��ϲ�ѯ������֪ʶ������
		public Integer getCountOfZhishiku(Zhishiku condition);
		//���ݱ�ż���֪ʶ��
		public Zhishiku getZhishikuByZhishikuId(int zhishikuId);
		//���֪ʶ��
		public void addZhishiku(Zhishiku zhishiku);
		//ɾ��֪ʶ��
		public void deleteZhishiku(Zhishiku zhishiku);
		//�޸�֪ʶ�����
		public void updateZhishiku(Zhishiku zhishiku);
}
