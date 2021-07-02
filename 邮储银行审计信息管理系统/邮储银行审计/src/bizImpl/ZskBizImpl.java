package bizImpl;

import java.util.List;
import biz.ZhishikuBiz;
import dao.ZhishikuDao;
import entity.Pager;
import entity.Zhishiku;

public class ZskBizImpl implements ZhishikuBiz{
	private ZhishikuDao zskDao;
	
	public ZhishikuDao getZskDao() {
		return zskDao;
	}

	public void setZskDao(ZhishikuDao zskDao) {
		this.zskDao = zskDao;
	}

	@Override
	public List<Zhishiku> getAllZhishiku(int page) {
		return zskDao.getAllZhishiku(page);
	}
	
	@Override
	public Pager getPagerOfZhishiku() {
		int count= zskDao.getCountOfAllZhishiku();
		//ʹ�÷�ҳ��Pager�������
		Pager pager=new Pager();
		//����pager�����е�perPageRows���ԣ���ʾÿҳ��ʾ�ļ�¼��
		pager.setPerPageRows(6);
		//����pager�����е�rowCount���ԣ���ʾ��¼����
		pager.setRowCount(count);
	    //����pager����
		return pager;
	}
	@Override
	public List<Zhishiku> getZhishikuByCondition(Zhishiku condition, int page) {		
		return zskDao.getZhishikuByCondition(condition, page);
	}
	//ͳ�Ʒ��ϲ�ѯ��������Ϣ����,��ʼ����ҳ��Pager��������perPageRows��rowCount����
	@Override
	public Pager getPagerOfZhishiku(Zhishiku condition) {
		int count= zskDao.getCountOfZhishiku(condition);
		//ʹ�÷�ҳ��Pager�������
		Pager pager=new Pager();
		//����pager�����е�perPageRows���ԣ���ʾÿҳ��ʾ�ļ�¼��
		pager.setPerPageRows(6);
		//����pager�����е�rowCount���ԣ���ʾ��¼����
		pager.setRowCount(count);
	    //����pager����
		return pager;
	}
	
	@Override
	public Zhishiku getZhishikuByZhishikuId(int marId) {
		return zskDao.getZhishikuByZhishikuId(marId);
	}
	
	//�����Ϣ
	@Override
	public void addZhishiku(Zhishiku zhishiku) {
		zskDao.addZhishiku(zhishiku);		
	}
	
	//ɾ��ָ�������Ϣ
	@Override
	public void deleteZhishiku(int marId) {		
		Zhishiku arcs=zskDao.getZhishikuByZhishikuId(marId);
		zskDao.deleteZhishiku(arcs);
	}
	//�޸���Ϣ
	@Override
	public void updateZhishiku(Zhishiku arcs) {
		zskDao.updateZhishiku(arcs);		
	}

}
