package dao;

import java.util.List;

import entity.Report;
public interface ReportDao {
	//��ȡָ��ҳ��ʾ�ı����б�
		public List<Report> getAllReport(int page);
		//ͳ�����пͻ�����
		public Integer getCountOfAllReport();
		//���ݲ�ѯ��������ȡָ��ҳ��ʾ�ı����б�
		public List<Report> getReportByCondition(Report condition,int page);
		//ͳ�Ʒ��ϲ�ѯ�����ı�������
		public Integer getCountOfReport(Report condition);
		//���ݱ�ż��ر���
		public Report getReportByReportId(int reportId);
		//��ӱ���
		public void addReport(Report report);
		//ɾ������
		public void deleteReport(Report report);
		//�޸ı������
		public void updateReport(Report report);
}
