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
		//使用分页类Pager定义对象
		Pager pager=new Pager();
		//设置pager对象中的perPageRows属性，表示每页显示的记录数
		pager.setPerPageRows(6);
		//设置pager对象中的rowCount属性，表示记录总数
		pager.setRowCount(count);
	    //返回pager对象
		return pager;
	}
	@Override
	public List<Report> getReportByCondition(Report condition, int page) {		
		return zskDao.getReportByCondition(condition, page);
	}
	//统计符合查询条件的信息数量,初始化分页类Pager对象，设置perPageRows和rowCount属性
	@Override
	public Pager getPagerOfReport(Report condition) {
		int count= zskDao.getCountOfReport(condition);
		//使用分页类Pager定义对象
		Pager pager=new Pager();
		//设置pager对象中的perPageRows属性，表示每页显示的记录数
		pager.setPerPageRows(6);
		//设置pager对象中的rowCount属性，表示记录总数
		pager.setRowCount(count);
	    //返回pager对象
		return pager;
	}
	
	@Override
	public Report getReportByReportId(int marId) {
		return zskDao.getReportByReportId(marId);
	}
	
	//添加信息
	@Override
	public void addReport(Report xcsj) {
		zskDao.addReport(xcsj);		
	}
	
	//删除指定编号信息
	@Override
	public void deleteReport(int marId) {		
		Report arcs=zskDao.getReportByReportId(marId);
		zskDao.deleteReport(arcs);
	}
	//修改信息
	@Override
	public void updateReport(Report arcs) {
		zskDao.updateReport(arcs);		
	}

}
