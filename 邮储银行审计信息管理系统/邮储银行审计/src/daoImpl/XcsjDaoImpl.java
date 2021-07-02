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
	//��ȡָ��ҳ��ʾ���ֳ������Ϣ�б�
	@SuppressWarnings("unchecked")
	@Override
	public List<Xcsj> getAllXcsj(int page) {
		Session session=sessionFactory.getCurrentSession();
		Criteria c=session.createCriteria(Xcsj.class);
		c.setFirstResult(6*(page-1));
		c.setMaxResults(6);
		return c.list();
	}
	//ͳ�������ֳ������Ϣ����
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
	//����ֳ������Ϣ
	@Override
	public void addXcsj(Xcsj xcsj) {
		Session session=sessionFactory.getCurrentSession();
		session.save(xcsj);
	}
	//ɾ���ֳ������Ϣ
	@Override
	public void deleteXcsj(Xcsj xcsj) {
		Session session=sessionFactory.getCurrentSession();
		session.delete(xcsj);
	}
	//�޸��ֳ������Ϣ
	@Override
	public void updateXcsj(Xcsj xcsj) {
		Session session=sessionFactory.getCurrentSession();
		session.update(xcsj);		
	}
}
