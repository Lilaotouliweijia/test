package dao;

import java.util.List;

import entity.Report;
public interface ReportDao {
	//获取指定页显示的报告列表
		public List<Report> getAllReport(int page);
		//统计所有客户总数
		public Integer getCountOfAllReport();
		//根据查询条件，获取指定页显示的报告列表
		public List<Report> getReportByCondition(Report condition,int page);
		//统计符合查询条件的报告总数
		public Integer getCountOfReport(Report condition);
		//根据编号加载报告
		public Report getReportByReportId(int reportId);
		//添加报告
		public void addReport(Report report);
		//删除报告
		public void deleteReport(Report report);
		//修改报告对象
		public void updateReport(Report report);
}
