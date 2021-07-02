package biz;

import java.util.List;
import entity.Pager;
import entity.Zhishiku;

public interface ZhishikuBiz {
	//��ȡָ��ҳ��ʾ��֪ʶ����Ϣ�б�
	public List<Zhishiku> getAllZhishiku(int page);
	//��ȡ����֪ʶ����Ϣ����,������ʼ����ҳ��Pager���󣬲�������perPageRows��rowCount����
	public Pager getPagerOfZhishiku();	
	//���ݲ�ѯ��������ȡָ��ҳ��ʾ��֪ʶ����Ϣ�б�
	public List<Zhishiku> getZhishikuByCondition(Zhishiku condition,int page);
	//ͳ�Ʒ��ϲ�ѯ�����Ŀͻ���Ϣ����,��ʼ����ҳ��Pager��������perPageRows��rowCount����
	public Pager getPagerOfZhishiku(Zhishiku condition);
	//���ݱ�ż���֪ʶ����Ϣ
	public Zhishiku getZhishikuByZhishikuId(int cusId);
	//���֪ʶ����Ϣ
	public void addZhishiku(Zhishiku zhishiku);
	//ɾ��ָ�����֪ʶ����Ϣ
	public void deleteZhishiku(int arcId);
	//�޸�֪ʶ����Ϣ
	public void updateZhishiku(Zhishiku zhishiku);
}
