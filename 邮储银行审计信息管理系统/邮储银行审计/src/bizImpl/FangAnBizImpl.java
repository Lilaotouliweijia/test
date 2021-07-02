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
	public List<FangAn> getFangAnByCondition(FangAn condition, int page) {		
		return faDao.getFangAnByCondition(condition, page);
	}
	//统计符合查询条件的信息数量,初始化分页类Pager对象，设置perPageRows和rowCount属性
	@Override
	public Pager getPagerOfFangAn(FangAn condition) {
		int count= faDao.getCountOfFangAn(condition);
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
	public FangAn getFangAnByFangAnId(int marId) {
		return faDao.getFangAnByFangAnId(marId);
	}
	
	//添加信息
	@Override
	public void addFangAn(FangAn fangAn) {
		faDao.addFangAn(fangAn);		
	}
	
	//删除指定编号信息
	@Override
	public void deleteFangAn(int marId) {		
		FangAn arcs=faDao.getFangAnByFangAnId(marId);
		faDao.deleteFangAn(arcs);
	}
	//修改信息
	@Override
	public void updateFangAn(FangAn arcs) {
		faDao.updateFangAn(arcs);		
	}

}
