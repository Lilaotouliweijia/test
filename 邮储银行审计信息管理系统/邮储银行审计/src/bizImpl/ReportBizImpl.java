package bizImpl;

import java.util.List;
import biz.ReportBiz;
import dao.ReportDao;
import entity.Pager;
import entity.Report;

public class ReportBizImpl implements ReportBiz{
	private ReportDao zskDao;
	
	public ReportDao getZskDao() {
		return zskDao;
	}

	public void setZskDao(ReportDao zskDao) {
		this.zskDao = zskDao;
	}

	@Override
	public List<Report> getAllReport(int page) {
		return zskDao.getAllReport(page);
	}
	
	@Override
	public Pager getPagerOfReport() {
		int count= zskDao.getCountOfAllReport();
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
	public List<Report> getReportByCondition(Report condition, int page) {		
		return zskDao.getReportByCondition(condition, page);
	}
	//ͳ�Ʒ��ϲ�ѯ��������Ϣ����,��ʼ����ҳ��Pager��������perPageRows��rowCount����
	@Override
	public Pager getPagerOfReport(Report condition) {
		int count= zskDao.getCountOfReport(condition);
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
	public Report getReportByReportId(int marId) {
		return zskDao.getReportByReportId(marId);
	}
	
	//�����Ϣ
	@Override
	public void addReport(Report xcsj) {
		zskDao.addReport(xcsj);		
	}
	
	//ɾ��ָ�������Ϣ
	@Override
	public void deleteReport(int marId) {		
		Report arcs=zskDao.getReportByReportId(marId);
		zskDao.deleteReport(arcs);
	}
	//�޸���Ϣ
	@Override
	public void updateReport(Report arcs) {
		zskDao.updateReport(arcs);		
	}

}
