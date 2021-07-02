package biz;

import java.util.List;
import entity.Pager;
import entity.FangAn;

public interface FangAnBiz {
	//获取指定页显示的方案信息列表
	public List<FangAn> getAllFangAn(int page);
	//获取指定页显示的方案信息列表
	public List<FangAn> getAllFangAnA(int page,FangAn admin);
	//获取所有方案信息数量,用来初始化分页类Pager对象，并设置其perPageRows和rowCount属性
	public Pager getPagerOfFangAn();	
	//根据查询条件，获取指定页显示的方案信息列表
	public List<FangAn> getFangAnByCondition(FangAn condition,int page);
	//统计符合查询条件的客户信息数量,初始化分页类Pager对象，设置perPageRows和rowCount属性
	public Pager getPagerOfFangAn(FangAn condition);
	//根据编号加载方案信息
	public FangAn getFangAnByFangAnId(int cusId);
	//添加方案信息
	public void addFangAn(FangAn fangAn);
	//删除指定编号方案信息
	public void deleteFangAn(int arcId);
	//修改方案信息
	public void updateFangAn(FangAn fangAn);
}
