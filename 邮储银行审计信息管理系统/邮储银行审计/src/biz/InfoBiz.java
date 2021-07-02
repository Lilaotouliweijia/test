package biz;

import java.util.List;
import entity.Pager;
import entity.Info;

public interface InfoBiz {
	//获取指定页显示的通知书信息列表
	public List<Info> getAllInfo(int page);
	//获取所有通知书信息数量,用来初始化分页类Pager对象，并设置其perPageRows和rowCount属性
	public Pager getPagerOfInfo();	
	//根据查询条件，获取指定页显示的通知书信息列表
	public List<Info> getInfoByCondition(Info condition,int page);
	//统计符合查询条件的客户信息数量,初始化分页类Pager对象，设置perPageRows和rowCount属性
	public Pager getPagerOfInfo(Info condition);
	//根据编号加载通知书信息
	public Info getInfoByInfoId(int cusId);
	//添加通知书信息
	public void addInfo(Info info);
	//删除指定编号通知书信息
	public void deleteInfo(int arcId);
	//修改通知书信息
	public void updateInfo(Info info);
}
