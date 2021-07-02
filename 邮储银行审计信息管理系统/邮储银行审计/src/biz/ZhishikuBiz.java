package biz;

import java.util.List;
import entity.Pager;
import entity.Zhishiku;

public interface ZhishikuBiz {
	//获取指定页显示的知识库信息列表
	public List<Zhishiku> getAllZhishiku(int page);
	//获取所有知识库信息数量,用来初始化分页类Pager对象，并设置其perPageRows和rowCount属性
	public Pager getPagerOfZhishiku();	
	//根据查询条件，获取指定页显示的知识库信息列表
	public List<Zhishiku> getZhishikuByCondition(Zhishiku condition,int page);
	//统计符合查询条件的客户信息数量,初始化分页类Pager对象，设置perPageRows和rowCount属性
	public Pager getPagerOfZhishiku(Zhishiku condition);
	//根据编号加载知识库信息
	public Zhishiku getZhishikuByZhishikuId(int cusId);
	//添加知识库信息
	public void addZhishiku(Zhishiku zhishiku);
	//删除指定编号知识库信息
	public void deleteZhishiku(int arcId);
	//修改知识库信息
	public void updateZhishiku(Zhishiku zhishiku);
}
