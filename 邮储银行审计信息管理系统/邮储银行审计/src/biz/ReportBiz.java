package biz;

import java.util.List;
import entity.Pager;
import entity.Report;

public interface ReportBiz {
	//获取指定页显示的报告信息列表
	public List<Report> getAllReport(int page);
	//获取所有报告信息数量,用来初始化分页类Pager对象，并设置其perPageRows和rowCount属性
	public Pager getPagerOfReport();	
	//根据查询条件，获取指定页显示的报告信息列表
	public List<Report> getReportByCondition(Report condition,int page);
	//统计符合查询条件的客户信息数量,初始化分页类Pager对象，设置perPageRows和rowCount属性
	public Pager getPagerOfReport(Report condition);
	//根据编号加载报告信息
	public Report getReportByReportId(int cusId);
	//添加报告信息
	public void addReport(Report report);
	//删除指定编号报告信息
	public void deleteReport(int arcId);
	//修改报告信息
	public void updateReport(Report report);
}
