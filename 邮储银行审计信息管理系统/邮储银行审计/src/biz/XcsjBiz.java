package biz;

import java.util.List;
import entity.Pager;
import entity.Xcsj;

public interface XcsjBiz {
	//获取指定页显示的现场审计信息列表
	public List<Xcsj> getAllXcsj(int page);
	//获取所有现场审计信息数量,用来初始化分页类Pager对象，并设置其perPageRows和rowCount属性
	public Pager getPagerOfXcsj();	
	//根据查询条件，获取指定页显示的现场审计信息列表
	public List<Xcsj> getXcsjByCondition(Xcsj condition,int page);
	//统计符合查询条件的客户信息数量,初始化分页类Pager对象，设置perPageRows和rowCount属性
	public Pager getPagerOfXcsj(Xcsj condition);
	//根据编号加载现场审计信息
	public Xcsj getXcsjByXcsjId(int cusId);
	//添加现场审计信息
	public void addXcsj(Xcsj xcsj);
	//删除指定编号现场审计信息
	public void deleteXcsj(int arcId);
	//修改现场审计信息
	public void updateXcsj(Xcsj xcsj);
}
