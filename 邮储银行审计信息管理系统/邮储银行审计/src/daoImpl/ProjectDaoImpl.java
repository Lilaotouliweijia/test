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
	//获取指定页显示的项目信息列表
	@SuppressWarnings("unchecked")
	@Override
	public List<Project> getAllProject(int page) {
		Session session=sessionFactory.getCurrentSession();
		Criteria c=session.createCriteria(Project.class);
		c.setFirstResult(6*(page-1));
		c.setMaxResults(6);
		return c.list();
	}
	//用户获取与自己相关的项目
	@SuppressWarnings("unchecked")
	public List<Project> getAllProjectA(int page,Project condition){
		Session session=sessionFactory.getCurrentSession();
			Criteria c=session.createCriteria(Project.class);
			c.add(Expression.eq("projectAdmin.adminId" , condition.getProjectAdmin().getAdminId())); 
		c.setFirstResult(6*(page-1));
		c.setMaxResults(6);
		return c.list();
	}
	//统计所有项目信息总数
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
	//添加项目信息
	@Override
	public void addProject(Project project) {
		Session session=sessionFactory.getCurrentSession();
		session.save(project);
	}
	//删除项目信息
	@Override
	public void deleteProject(Project project) {
		Session session=sessionFactory.getCurrentSession();
		session.delete(project);
	}
	//修改项目信息
	@Override
	public void updateProject(Project project) {
		Session session=sessionFactory.getCurrentSession();
		session.update(project);		
	}
}
