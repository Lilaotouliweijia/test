package dao;

import java.util.List;

import entity.Zhishiku;
public interface ZhishikuDao {
	//获取指定页显示的知识库列表
		public List<Zhishiku> getAllZhishiku(int page);
		//统计所有客户总数
		public Integer getCountOfAllZhishiku();
		//根据查询条件，获取指定页显示的知识库列表
		public List<Zhishiku> getZhishikuByCondition(Zhishiku condition,int page);
		//统计符合查询条件的知识库总数
		public Integer getCountOfZhishiku(Zhishiku condition);
		//根据编号加载知识库
		public Zhishiku getZhishikuByZhishikuId(int zhishikuId);
		//添加知识库
		public void addZhishiku(Zhishiku zhishiku);
		//删除知识库
		public void deleteZhishiku(Zhishiku zhishiku);
		//修改知识库对象
		public void updateZhishiku(Zhishiku zhishiku);
}
