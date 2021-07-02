package daoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import dao.ReportDao;
import entity.Report;


public class ReportDaoImpl implements ReportDao{
	SessionFactory sessionFactory;	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	//��ȡָ��ҳ��ʾ�ı�����Ϣ�б�
	@SuppressWarnings("unchecked")
	@Override
	public List<Report> getAllReport(int page) {
		Session session=sessionFactory.getCurrentSession();
		Criteria c=session.createCriteria(Report.class);
		c.setFirstResult(6*(page-1));
		c.setMaxResults(6);
		return c.list();
	}
	//ͳ�����б�����Ϣ����
	@Override
	public Integer getCountOfAllReport() {
		Integer count=null;
		try{
		Session session=sessionFactory.getCurrentSession();
		String hql="select count(s) from Report s";
		Query query=session.createQuery(hql);
		count= Integer.parseInt(query.uniqueResult().toString()) ;
		}catch(Exception e){
			e.printStackTrace();
		}
		return count;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Report> getReportByCondition(Report condition, int page) {
		Session session=sessionFactory.getCurrentSession();
		Criteria c=session.createCriteria(Report.class);
		c.setFirstResult(6*(page-1));
		c.setMaxResults(6);
		return c.list();
	}
	@Override
	public Integer getCountOfReport(Report condition) {
		Session session=sessionFactory.getCurrentSession();
		Criteria c=session.createCriteria(Report.class);
		return c.list().size();
	}
	@Override
	public Report getReportByReportId(int cusId) {
		Session session=sessionFactory.getCurrentSession();
		return (Report)session.get(Report.class, cusId);
	}
	//��ӱ�����Ϣ
	@Override
	public void addReport(Report report) {
		Session session=sessionFactory.getCurrentSession();
		session.save(report);
	}
	//ɾ��������Ϣ
	@Override
	public void deleteReport(Report report) {
		Session session=sessionFactory.getCurrentSession();
		session.delete(report);
	}
	//�޸ı�����Ϣ
	@Override
	public void updateReport(Report report) {
		Session session=sessionFactory.getCurrentSession();
		session.update(report);		
	}
}
