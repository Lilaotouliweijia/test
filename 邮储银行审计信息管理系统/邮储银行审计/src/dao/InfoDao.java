package dao;

import java.util.List;

import entity.Info;
public interface InfoDao {
	//获取指定页显示的通知书列表
		public List<Info> getAllInfo(int page);
		//统计所有客户总数
		public Integer getCountOfAllInfo();
		//根据查询条件，获取指定页显示的通知书列表
		public List<Info> getInfoByCondition(Info condition,int page);
		//统计符合查询条件的通知书总数
		public Integer getCountOfInfo(Info condition);
		//根据编号加载通知书
		public Info getInfoByInfoId(int infoId);
		//添加通知书
		public void addInfo(Info info);
		//删除通知书
		public void deleteInfo(Info info);
		//修改通知书对象
		public void updateInfo(Info info);
}
