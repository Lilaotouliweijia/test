package dao;

import java.util.List;

import entity.FangAn;
public interface FangAnDao {
	//获取指定页显示的方案列表
		public List<FangAn> getAllFangAn(int page);
		//获取指定页显示的方案信息列表
		public List<FangAn> getAllFangAnA(int page,FangAn admin);
		//统计所有客户总数
		public Integer getCountOfAllFangAn();
		//根据查询条件，获取指定页显示的方案列表
		public List<FangAn> getFangAnByCondition(FangAn condition,int page);
		//统计符合查询条件的方案总数
		public Integer getCountOfFangAn(FangAn condition);
		//根据编号加载方案
		public FangAn getFangAnByFangAnId(int fangAnId);
		//添加方案
		public void addFangAn(FangAn fangAn);
		//删除方案
		public void deleteFangAn(FangAn fangAn);
		//修改方案对象
		public void updateFangAn(FangAn fangAn);
}
