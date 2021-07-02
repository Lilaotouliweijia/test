package daoImpl;

import java.util.LinkedList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Expression;
import dao.AdminDao;
import entity.Admin;
import entity.Project;

@SuppressWarnings("deprecation")
public class AdminDaoImpl implements AdminDao{
	SessionFactory sessionFactory;	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	//审计员登录验证，返回登录符合条件的所有审计员，但是符合条件的只有一个
	@SuppressWarnings("unchecked")
	@Override
	public List<Admin> login(Admin admin) {
		List<Admin> list=new LinkedList<Admin>();
		//通过sessionFactory获得Session
		Session session=sessionFactory.getCurrentSession();
		String hql="from Admin where adminName='"+admin.getAdminName()+"' and adminPass='"+admin.getAdminPass()+"'";
		Query query=session.createQuery(hql);
		list=query.list();
		return list;
	}
	//添加审计员
	@Override
	public void addAdmin(Admin admin) {
		Session session=sessionFactory.getCurrentSession();
		session.save(admin);
	}
	//获取所有审计员的名字
	@SuppressWarnings("unchecked")
	@Override
	public List<String> getAllAdminName() {		
		List<String> nameList=new LinkedList<String>();
		String sql="select adminName from Admin";
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createSQLQuery(sql);
		nameList=query.list();
		return nameList;
	}
	//通过用户名获取审计员对象
	@Override
	public Admin getUser(String adminName) {
		Admin admin=null;
		String hql="from Admin where adminName='"+adminName+"'";
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery(hql);
		if(query.list().size()!=0){
			admin=(Admin) query.list().get(0);
		}
		return admin;
	}
	//获取指定页显示的管理员信息列表
	@SuppressWarnings("unchecked")
	@Override
	public List<Admin> getAllAdmin(int page) {
		Session session=sessionFactory.getCurrentSession();
		Criteria c=session.createCriteria(Admin.class);
		c.setFirstResult(6*(page-1));
		c.setMaxResults(6);
		return c.list();
	}
	//用户获取与自己相关的管理员
	@SuppressWarnings("unchecked")
	public List<Admin> getAllAdminA(int page,Admin condition){
		Session session=sessionFactory.getCurrentSession();
		Criteria c=session.createCriteria(Admin.class);
		c.add(Expression.eq("adminAdmin.adminId" , condition.getAdminId())); 
		c.setFirstResult(6*(page-1));
		c.setMaxResults(6);
		return c.list();
	}
	//统计所有管理员信息总数
	@Override
	public Integer getCountOfAllAdmin() {
		Integer count=null;
		try{
			Session session=sessionFactory.getCurrentSession();
			String hql="select count(s) from Admin s";
			Query query=session.createQuery(hql);
			count= Integer.parseInt(query.uniqueResult().toString()) ;
		}catch(Exception e){
			e.printStackTrace();
		}
		return count;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Admin> getAdminByCondition(Admin condition, int page) {
		Session session=sessionFactory.getCurrentSession();
		Criteria c=session.createCriteria(Admin.class);
		c.setFirstResult(6*(page-1));
		c.setMaxResults(6);
		return c.list();
	}
	@Override
	public Integer getCountOfAdmin(Admin condition) {
		Session session=sessionFactory.getCurrentSession();
		Criteria c=session.createCriteria(Admin.class);
		return c.list().size();
	}
	@Override
	public Admin getAdminByAdminId(int cusId) {
		Session session=sessionFactory.getCurrentSession();
		return (Admin)session.get(Admin.class, cusId);
	}
	//删除管理员信息
	@Override
	public void deleteAdmin(Admin admin) {
		Session session=sessionFactory.getCurrentSession();
		session.delete(admin);
	}
	//修改管理员信息
	@Override
	public void updateAdmin(Admin admin) {
		Session session=sessionFactory.getCurrentSession();
		session.update(admin);		
	}
	@SuppressWarnings("unchecked")
	public List<Project> getAllProjectA(Project condition){
		Session session=sessionFactory.getCurrentSession();
			Criteria c=session.createCriteria(Project.class);
			c.add(Expression.eq("projectAdmin.adminId" , condition.getProjectAdmin().getAdminId()));
		return c.list();
	}
}
