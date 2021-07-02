package bizImpl;

import java.util.List;
import biz.FangAnBiz;
import dao.FangAnDao;
import entity.Pager;
import entity.FangAn;

public class FangAnBizImpl implements FangAnBiz{
	private FangAnDao faDao;
	
	

	public FangAnDao getFaDao() {
		return faDao;
	}

	public void setFaDao(FangAnDao faDao) {
		this.faDao = faDao;
	}

	@Override
	public List<FangAn> getAllFangAn(int page) {
		return faDao.getAllFangAn(page);
	}
	public List<FangAn> getAllFangAnA(int page,FangAn admin){
		return faDao.getAllFangAnA(page,admin);
	}
	
	@Override
	public Pager getPagerOfFangAn() {
		int count= faDao.getCountOfAllFangAn();
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
	public List<FangAn> getFangAnByCondition(FangAn condition, int page) {		
		return faDao.getFangAnByCondition(condition, page);
	}
	//ͳ�Ʒ��ϲ�ѯ��������Ϣ����,��ʼ����ҳ��Pager��������perPageRows��rowCount����
	@Override
	public Pager getPagerOfFangAn(FangAn condition) {
		int count= faDao.getCountOfFangAn(condition);
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
	public FangAn getFangAnByFangAnId(int marId) {
		return faDao.getFangAnByFangAnId(marId);
	}
	
	//�����Ϣ
	@Override
	public void addFangAn(FangAn fangAn) {
		faDao.addFangAn(fangAn);		
	}
	
	//ɾ��ָ�������Ϣ
	@Override
	public void deleteFangAn(int marId) {		
		FangAn arcs=faDao.getFangAnByFangAnId(marId);
		faDao.deleteFangAn(arcs);
	}
	//�޸���Ϣ
	@Override
	public void updateFangAn(FangAn arcs) {
		faDao.updateFangAn(arcs);		
	}

}
