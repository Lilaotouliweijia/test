package bizImpl;

import java.util.List;
import biz.InfoBiz;
import dao.InfoDao;
import entity.Pager;
import entity.Info;

public class InfoImpl implements InfoBiz{
	private InfoDao zskDao;
	
	public InfoDao getZskDao() {
		return zskDao;
	}

	public void setZskDao(InfoDao zskDao) {
		this.zskDao = zskDao;
	}

	@Override
	public List<Info> getAllInfo(int page) {
		return zskDao.getAllInfo(page);
	}
	
	@Override
	public Pager getPagerOfInfo() {
		int count= zskDao.getCountOfAllInfo();
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
	public List<Info> getInfoByCondition(Info condition, int page) {		
		return zskDao.getInfoByCondition(condition, page);
	}
	//ͳ�Ʒ��ϲ�ѯ��������Ϣ����,��ʼ����ҳ��Pager��������perPageRows��rowCount����
	@Override
	public Pager getPagerOfInfo(Info condition) {
		int count= zskDao.getCountOfInfo(condition);
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
	public Info getInfoByInfoId(int marId) {
		return zskDao.getInfoByInfoId(marId);
	}
	
	//�����Ϣ
	@Override
	public void addInfo(Info info) {
		zskDao.addInfo(info);		
	}
	
	//ɾ��ָ�������Ϣ
	@Override
	public void deleteInfo(int marId) {		
		Info arcs=zskDao.getInfoByInfoId(marId);
		zskDao.deleteInfo(arcs);
	}
	//�޸���Ϣ
	@Override
	public void updateInfo(Info arcs) {
		zskDao.updateInfo(arcs);		
	}

}
