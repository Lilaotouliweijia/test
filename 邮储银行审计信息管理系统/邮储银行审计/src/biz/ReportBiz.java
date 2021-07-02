package biz;

import java.util.List;
import entity.Pager;
import entity.Report;

public interface ReportBiz {
	//��ȡָ��ҳ��ʾ�ı�����Ϣ�б�
	public List<Report> getAllReport(int page);
	//��ȡ���б�����Ϣ����,������ʼ����ҳ��Pager���󣬲�������perPageRows��rowCount����
	public Pager getPagerOfReport();	
	//���ݲ�ѯ��������ȡָ��ҳ��ʾ�ı�����Ϣ�б�
	public List<Report> getReportByCondition(Report condition,int page);
	//ͳ�Ʒ��ϲ�ѯ�����Ŀͻ���Ϣ����,��ʼ����ҳ��Pager��������perPageRows��rowCount����
	public Pager getPagerOfReport(Report condition);
	//���ݱ�ż��ر�����Ϣ
	public Report getReportByReportId(int cusId);
	//��ӱ�����Ϣ
	public void addReport(Report report);
	//ɾ��ָ����ű�����Ϣ
	public void deleteReport(int arcId);
	//�޸ı�����Ϣ
	public void updateReport(Report report);
}
