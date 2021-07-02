package daoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Expression;

import dao.ProjectDao;
import entity.Project;

@SuppressWarnings("deprecation")
public class ProjectDaoImpl implements ProjectDao{
	SessionFactory sessionFactory;	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	//��ȡָ��ҳ��ʾ����Ŀ��Ϣ�б�
	@SuppressWarnings("unchecked")
	@Override
	public List<Project> getAllProject(int page) {
		Session session=sessionFactory.getCurrentSession();
		Criteria c=session.createCriteria(Project.class);
		c.setFirstResult(6*(page-1));
		c.setMaxResults(6);
		return c.list();
	}
	//�û���ȡ���Լ���ص���Ŀ
	@SuppressWarnings("unchecked")
	public List<Project> getAllProjectA(int page,Project condition){
		Session session=sessionFactory.getCurrentSession();
			Criteria c=session.createCriteria(Project.class);
			c.add(Expression.eq("projectAdmin.adminId" , condition.getProjectAdmin().getAdminId())); 
		c.setFirstResult(6*(page-1));
		c.setMaxResults(6);
		return c.list();
	}
	//ͳ��������Ŀ��Ϣ����
	@Override
	public Integer getCountOfAllProject() {
		Integer count=null;
		try{
			Session session=sessionFactory.getCurrentSession();
			String hql="select count(s) from Project s";
			Query query=session.createQuery(hql);
			count= Integer.parseInt(query.uniqueResult().toString()) ;
		}catch(Exception e){
			e.printStackTrace();
		}
		return count;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Project> getProjectByCondition(Project condition, int page) {
		Session session=sessionFactory.getCurrentSession();
		Criteria c=session.createCriteria(Project.class);
		c.setFirstResult(6*(page-1));
		c.setMaxResults(6);
		return c.list();
	}
	@Override
	public Integer getCountOfProject(Project condition) {
		Session session=sessionFactory.getCurrentSession();
		Criteria c=session.createCriteria(Project.class);
		return c.list().size();
	}
	@Override
	public Project getProjectByProjectId(int cusId) {
		Session session=sessionFactory.getCurrentSession();
		return (Project)session.get(Project.class, cusId);
	}
	//�����Ŀ��Ϣ
	@Override
	public void addProject(Project project) {
		Session session=sessionFactory.getCurrentSession();
		session.save(project);
	}
	//ɾ����Ŀ��Ϣ
	@Override
	public void deleteProject(Project project) {
		Session session=sessionFactory.getCurrentSession();
		session.delete(project);
	}
	//�޸���Ŀ��Ϣ
	@Override
	public void updateProject(Project project) {
		Session session=sessionFactory.getCurrentSession();
		session.update(project);		
	}
}
