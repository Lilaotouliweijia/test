package bizImpl;

import java.util.List;
import biz.XcsjBiz;
import dao.XcsjDao;
import entity.Pager;
import entity.Xcsj;

public class XcsjBizImpl implements XcsjBiz{
	private XcsjDao zskDao;
	
	public XcsjDao getZskDao() {
		return zskDao;
	}

	public void setZskDao(XcsjDao zskDao) {
		this.zskDao = zskDao;
	}

	@Override
	public List<Xcsj> getAllXcsj(int page) {
		return zskDao.getAllXcsj(page);
	}
	
	@Override
	public Pager getPagerOfXcsj() {
		int count= zskDao.getCountOfAllXcsj();
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
	public List<Xcsj> getXcsjByCondition(Xcsj condition, int page) {		
		return zskDao.getXcsjByCondition(condition, page);
	}
	//ͳ�Ʒ��ϲ�ѯ��������Ϣ����,��ʼ����ҳ��Pager��������perPageRows��rowCount����
	@Override
	public Pager getPagerOfXcsj(Xcsj condition) {
		int count= zskDao.getCountOfXcsj(condition);
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
	public Xcsj getXcsjByXcsjId(int marId) {
		return zskDao.getXcsjByXcsjId(marId);
	}
	
	//�����Ϣ
	@Override
	public void addXcsj(Xcsj xcsj) {
		zskDao.addXcsj(xcsj);		
	}
	
	//ɾ��ָ�������Ϣ
	@Override
	public void deleteXcsj(int marId) {		
		Xcsj arcs=zskDao.getXcsjByXcsjId(marId);
		zskDao.deleteXcsj(arcs);
	}
	//�޸���Ϣ
	@Override
	public void updateXcsj(Xcsj arcs) {
		zskDao.updateXcsj(arcs);		
	}

}
