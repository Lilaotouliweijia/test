package dao;

import java.util.List;

import entity.Xcsj;
public interface XcsjDao {
	//获取指定页显示的知识库列表
		public List<Xcsj> getAllXcsj(int page);
		//统计所有客户总数
		public Integer getCountOfAllXcsj();
		//根据查询条件，获取指定页显示的知识库列表
		public List<Xcsj> getXcsjByCondition(Xcsj condition,int page);
		//统计符合查询条件的知识库总数
		public Integer getCountOfXcsj(Xcsj condition);
		//根据编号加载知识库
		public Xcsj getXcsjByXcsjId(int xcsjId);
		//添加知识库
		public void addXcsj(Xcsj xcsj);
		//删除知识库
		public void deleteXcsj(Xcsj xcsj);
		//修改知识库对象
		public void updateXcsj(Xcsj xcsj);
}
