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
	public List<Xcsj> getXcsjByCondition(Xcsj condition, int page) {		
		return zskDao.getXcsjByCondition(condition, page);
	}
	//统计符合查询条件的信息数量,初始化分页类Pager对象，设置perPageRows和rowCount属性
	@Override
	public Pager getPagerOfXcsj(Xcsj condition) {
		int count= zskDao.getCountOfXcsj(condition);
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
	public Xcsj getXcsjByXcsjId(int marId) {
		return zskDao.getXcsjByXcsjId(marId);
	}
	
	//添加信息
	@Override
	public void addXcsj(Xcsj xcsj) {
		zskDao.addXcsj(xcsj);		
	}
	
	//删除指定编号信息
	@Override
	public void deleteXcsj(int marId) {		
		Xcsj arcs=zskDao.getXcsjByXcsjId(marId);
		zskDao.deleteXcsj(arcs);
	}
	//修改信息
	@Override
	public void updateXcsj(Xcsj arcs) {
		zskDao.updateXcsj(arcs);		
	}

}
