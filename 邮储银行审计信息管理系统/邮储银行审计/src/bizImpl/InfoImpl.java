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
	public List<Info> getInfoByCondition(Info condition, int page) {		
		return zskDao.getInfoByCondition(condition, page);
	}
	//统计符合查询条件的信息数量,初始化分页类Pager对象，设置perPageRows和rowCount属性
	@Override
	public Pager getPagerOfInfo(Info condition) {
		int count= zskDao.getCountOfInfo(condition);
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
	public Info getInfoByInfoId(int marId) {
		return zskDao.getInfoByInfoId(marId);
	}
	
	//添加信息
	@Override
	public void addInfo(Info info) {
		zskDao.addInfo(info);		
	}
	
	//删除指定编号信息
	@Override
	public void deleteInfo(int marId) {		
		Info arcs=zskDao.getInfoByInfoId(marId);
		zskDao.deleteInfo(arcs);
	}
	//修改信息
	@Override
	public void updateInfo(Info arcs) {
		zskDao.updateInfo(arcs);		
	}

}
