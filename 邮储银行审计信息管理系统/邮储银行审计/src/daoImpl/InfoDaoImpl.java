package daoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import dao.InfoDao;
import entity.Info;


public class InfoDaoImpl implements InfoDao{
	SessionFactory sessionFactory;	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	//��ȡָ��ҳ��ʾ��֪ͨ����Ϣ�б�
	@SuppressWarnings("unchecked")
	@Override
	public List<Info> getAllInfo(int page) {
		Session session=sessionFactory.getCurrentSession();
		Criteria c=session.createCriteria(Info.class);
		c.setFirstResult(6*(page-1));
		c.setMaxResults(6);
		return c.list();
	}
	//ͳ������֪ͨ����Ϣ����
	@Override
	public Integer getCountOfAllInfo() {
		Integer count=null;
		try{
		Session session=sessionFactory.getCurrentSession();
		String hql="select count(s) from Info s";
		Query query=session.createQuery(hql);
		count= Integer.parseInt(query.uniqueResult().toString()) ;
		}catch(Exception e){
			e.printStackTrace();
		}
		return count;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Info> getInfoByCondition(Info condition, int page) {
		Session session=sessionFactory.getCurrentSession();
		Criteria c=session.createCriteria(Info.class);
		c.setFirstResult(6*(page-1));
		c.setMaxResults(6);
		return c.list();
	}
	@Override
	public Integer getCountOfInfo(Info condition) {
		Session session=sessionFactory.getCurrentSession();
		Criteria c=session.createCriteria(Info.class);
		return c.list().size();
	}
	@Override
	public Info getInfoByInfoId(int cusId) {
		Session session=sessionFactory.getCurrentSession();
		return (Info)session.get(Info.class, cusId);
	}
	//���֪ͨ����Ϣ
	@Override
	public void addInfo(Info info) {
		Session session=sessionFactory.getCurrentSession();
		session.save(info);
	}
	//ɾ��֪ͨ����Ϣ
	@Override
	public void deleteInfo(Info info) {
		Session session=sessionFactory.getCurrentSession();
		session.delete(info);
	}
	//�޸�֪ͨ����Ϣ
	@Override
	public void updateInfo(Info info) {
		Session session=sessionFactory.getCurrentSession();
		session.update(info);		
	}
}
