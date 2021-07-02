package daoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import dao.XcsjDao;
import entity.Xcsj;


public class XcsjDaoImpl implements XcsjDao{
	SessionFactory sessionFactory;	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	//获取指定页显示的现场审计信息列表
	@SuppressWarnings("unchecked")
	@Override
	public List<Xcsj> getAllXcsj(int page) {
		Session session=sessionFactory.getCurrentSession();
		Criteria c=session.createCriteria(Xcsj.class);
		c.setFirstResult(6*(page-1));
		c.setMaxResults(6);
		return c.list();
	}
	//统计所有现场审计信息总数
	@Override
	public Integer getCountOfAllXcsj() {
		Integer count=null;
		try{
		Session session=sessionFactory.getCurrentSession();
		String hql="select count(s) from Xcsj s";
		Query query=session.createQuery(hql);
		count= Integer.parseInt(query.uniqueResult().toString()) ;
		}catch(Exception e){
			e.printStackTrace();
		}
		return count;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Xcsj> getXcsjByCondition(Xcsj condition, int page) {
		Session session=sessionFactory.getCurrentSession();
		Criteria c=session.createCriteria(Xcsj.class);
		c.setFirstResult(6*(page-1));
		c.setMaxResults(6);
		return c.list();
	}
	@Override
	public Integer getCountOfXcsj(Xcsj condition) {
		Session session=sessionFactory.getCurrentSession();
		Criteria c=session.createCriteria(Xcsj.class);
		return c.list().size();
	}
	@Override
	public Xcsj getXcsjByXcsjId(int cusId) {
		Session session=sessionFactory.getCurrentSession();
		return (Xcsj)session.get(Xcsj.class, cusId);
	}
	//添加现场审计信息
	@Override
	public void addXcsj(Xcsj xcsj) {
		Session session=sessionFactory.getCurrentSession();
		session.save(xcsj);
	}
	//删除现场审计信息
	@Override
	public void deleteXcsj(Xcsj xcsj) {
		Session session=sessionFactory.getCurrentSession();
		session.delete(xcsj);
	}
	//修改现场审计信息
	@Override
	public void updateXcsj(Xcsj xcsj) {
		Session session=sessionFactory.getCurrentSession();
		session.update(xcsj);		
	}
}
