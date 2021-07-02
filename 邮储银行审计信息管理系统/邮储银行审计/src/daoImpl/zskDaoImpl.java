package daoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import dao.ZhishikuDao;
import entity.Zhishiku;


public class zskDaoImpl implements ZhishikuDao{
	SessionFactory sessionFactory;	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	//获取指定页显示的知识库信息列表
	@SuppressWarnings("unchecked")
	@Override
	public List<Zhishiku> getAllZhishiku(int page) {
		Session session=sessionFactory.getCurrentSession();
		Criteria c=session.createCriteria(Zhishiku.class);
		c.setFirstResult(6*(page-1));
		c.setMaxResults(6);
		return c.list();
	}
	//统计所有知识库信息总数
	@Override
	public Integer getCountOfAllZhishiku() {
		Integer count=null;
		try{
		Session session=sessionFactory.getCurrentSession();
		String hql="select count(s) from Zhishiku s";
		Query query=session.createQuery(hql);
		count= Integer.parseInt(query.uniqueResult().toString()) ;
		}catch(Exception e){
			e.printStackTrace();
		}
		return count;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Zhishiku> getZhishikuByCondition(Zhishiku condition, int page) {
		Session session=sessionFactory.getCurrentSession();
		Criteria c=session.createCriteria(Zhishiku.class);
		c.setFirstResult(6*(page-1));
		c.setMaxResults(6);
		return c.list();
	}
	@Override
	public Integer getCountOfZhishiku(Zhishiku condition) {
		Session session=sessionFactory.getCurrentSession();
		Criteria c=session.createCriteria(Zhishiku.class);
		return c.list().size();
	}
	@Override
	public Zhishiku getZhishikuByZhishikuId(int cusId) {
		Session session=sessionFactory.getCurrentSession();
		return (Zhishiku)session.get(Zhishiku.class, cusId);
	}
	//添加知识库信息
	@Override
	public void addZhishiku(Zhishiku zhishiku) {
		Session session=sessionFactory.getCurrentSession();
		session.save(zhishiku);
	}
	//删除知识库信息
	@Override
	public void deleteZhishiku(Zhishiku zhishiku) {
		Session session=sessionFactory.getCurrentSession();
		session.delete(zhishiku);
	}
	//修改知识库信息
	@Override
	public void updateZhishiku(Zhishiku zhishiku) {
		Session session=sessionFactory.getCurrentSession();
		session.update(zhishiku);		
	}
}
