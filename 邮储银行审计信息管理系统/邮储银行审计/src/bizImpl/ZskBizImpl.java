package bizImpl;

import java.util.List;
import biz.ZhishikuBiz;
import dao.ZhishikuDao;
import entity.Pager;
import entity.Zhishiku;

public class ZskBizImpl implements ZhishikuBiz{
	private ZhishikuDao zskDao;
	
	public ZhishikuDao getZskDao() {
		return zskDao;
	}

	public void setZskDao(ZhishikuDao zskDao) {
		this.zskDao = zskDao;
	}

	@Override
	public List<Zhishiku> getAllZhishiku(int page) {
		return zskDao.getAllZhishiku(page);
	}
	
	@Override
	public Pager getPagerOfZhishiku() {
		int count= zskDao.getCountOfAllZhishiku();
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
	public List<Zhishiku> getZhishikuByCondition(Zhishiku condition, int page) {		
		return zskDao.getZhishikuByCondition(condition, page);
	}
	//统计符合查询条件的信息数量,初始化分页类Pager对象，设置perPageRows和rowCount属性
	@Override
	public Pager getPagerOfZhishiku(Zhishiku condition) {
		int count= zskDao.getCountOfZhishiku(condition);
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
	public Zhishiku getZhishikuByZhishikuId(int marId) {
		return zskDao.getZhishikuByZhishikuId(marId);
	}
	
	//添加信息
	@Override
	public void addZhishiku(Zhishiku zhishiku) {
		zskDao.addZhishiku(zhishiku);		
	}
	
	//删除指定编号信息
	@Override
	public void deleteZhishiku(int marId) {		
		Zhishiku arcs=zskDao.getZhishikuByZhishikuId(marId);
		zskDao.deleteZhishiku(arcs);
	}
	//修改信息
	@Override
	public void updateZhishiku(Zhishiku arcs) {
		zskDao.updateZhishiku(arcs);		
	}

}
