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
	//���Ա��¼��֤�����ص�¼�����������������Ա�����Ƿ���������ֻ��һ��
	@SuppressWarnings("unchecked")
	@Override
	public List<Admin> login(Admin admin) {
		List<Admin> list=new LinkedList<Admin>();
		//ͨ��sessionFactory���Session
		Session session=sessionFactory.getCurrentSession();
		String hql="from Admin where adminName='"+admin.getAdminName()+"' and adminPass='"+admin.getAdminPass()+"'";
		Query query=session.createQuery(hql);
		list=query.list();
		return list;
	}
	//������Ա
	@Override
	public void addAdmin(Admin admin) {
		Session session=sessionFactory.getCurrentSession();
		session.save(admin);
	}
	//��ȡ�������Ա������
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
	//ͨ���û�����ȡ���Ա����
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
	//��ȡָ��ҳ��ʾ�Ĺ���Ա��Ϣ�б�
	@SuppressWarnings("unchecked")
	@Override
	public List<Admin> getAllAdmin(int page) {
		Session session=sessionFactory.getCurrentSession();
		Criteria c=session.createCriteria(Admin.class);
		c.setFirstResult(6*(page-1));
		c.setMaxResults(6);
		return c.list();
	}
	//�û���ȡ���Լ���صĹ���Ա
	@SuppressWarnings("unchecked")
	public List<Admin> getAllAdminA(int page,Admin condition){
		Session session=sessionFactory.getCurrentSession();
		Criteria c=session.createCriteria(Admin.class);
		c.add(Expression.eq("adminAdmin.adminId" , condition.getAdminId())); 
		c.setFirstResult(6*(page-1));
		c.setMaxResults(6);
		return c.list();
	}
	//ͳ�����й���Ա��Ϣ����
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
	//ɾ������Ա��Ϣ
	@Override
	public void deleteAdmin(Admin admin) {
		Session session=sessionFactory.getCurrentSession();
		session.delete(admin);
	}
	//�޸Ĺ���Ա��Ϣ
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
