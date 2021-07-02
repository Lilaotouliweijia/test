package daoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Expression;

import dao.FangAnDao;
import entity.FangAn;

@SuppressWarnings("deprecation")
public class FangAnDaoImpl implements FangAnDao{
	SessionFactory sessionFactory;	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	//��ȡָ��ҳ��ʾ�ķ�����Ϣ�б�
	@SuppressWarnings("unchecked")
	@Override
	public List<FangAn> getAllFangAn(int page) {
		Session session=sessionFactory.getCurrentSession();
		Criteria c=session.createCriteria(FangAn.class);
		c.setFirstResult(6*(page-1));
		c.setMaxResults(6);
		return c.list();
	}
	//�û���ȡ���Լ���صķ���
	@SuppressWarnings("unchecked")
	public List<FangAn> getAllFangAnA(int page,FangAn condition){
		Session session=sessionFactory.getCurrentSession();
			Criteria c=session.createCriteria(FangAn.class);
			c.add(Expression.eq("admin.adminId" , condition.getAdmin().getAdminId())); 
		c.setFirstResult(6*(page-1));
		c.setMaxResults(6);
		return c.list();
	}
	//ͳ�����з�����Ϣ����
	@Override
	public Integer getCountOfAllFangAn() {
		Integer count=null;
		try{
			Session session=sessionFactory.getCurrentSession();
			String hql="select count(s) from FangAn s";
			Query query=session.createQuery(hql);
			count= Integer.parseInt(query.uniqueResult().toString()) ;
		}catch(Exception e){
			e.printStackTrace();
		}
		return count;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<FangAn> getFangAnByCondition(FangAn condition, int page) {
		Session session=sessionFactory.getCurrentSession();
		Criteria c=session.createCriteria(FangAn.class);
		c.setFirstResult(6*(page-1));
		c.setMaxResults(6);
		return c.list();
	}
	@Override
	public Integer getCountOfFangAn(FangAn condition) {
		Session session=sessionFactory.getCurrentSession();
		Criteria c=session.createCriteria(FangAn.class);
		return c.list().size();
	}
	@Override
	public FangAn getFangAnByFangAnId(int cusId) {
		Session session=sessionFactory.getCurrentSession();
		return (FangAn)session.get(FangAn.class, cusId);
	}
	//��ӷ�����Ϣ
	@Override
	public void addFangAn(FangAn fangAn) {
		Session session=sessionFactory.getCurrentSession();
		session.save(fangAn);
	}
	//ɾ��������Ϣ
	@Override
	public void deleteFangAn(FangAn fangAn) {
		Session session=sessionFactory.getCurrentSession();
		session.delete(fangAn);
	}
	//�޸ķ�����Ϣ
	@Override
	public void updateFangAn(FangAn fangAn) {
		Session session=sessionFactory.getCurrentSession();
		session.update(fangAn);		
	}
}
