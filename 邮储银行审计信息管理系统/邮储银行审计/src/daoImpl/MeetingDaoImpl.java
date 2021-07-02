package daoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Expression;

import dao.MeetingDao;
import entity.Meeting;

@SuppressWarnings({ "deprecation", "unused" })
public class MeetingDaoImpl implements MeetingDao{
	SessionFactory sessionFactory;	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	//获取指定页显示的会议信息列表
	@SuppressWarnings("unchecked")
	@Override
	public List<Meeting> getAllMeeting(int page) {
		Session session=sessionFactory.getCurrentSession();
		Criteria c=session.createCriteria(Meeting.class);
		c.setFirstResult(6*(page-1));
		c.setMaxResults(6);
		return c.list();
	}
	//统计所有会议信息总数
	@Override
	public Integer getCountOfAllMeeting() {
		Integer count=null;
		try{
			Session session=sessionFactory.getCurrentSession();
			String hql="select count(s) from Meeting s";
			Query query=session.createQuery(hql);
			count= Integer.parseInt(query.uniqueResult().toString()) ;
		}catch(Exception e){
			e.printStackTrace();
		}
		return count;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Meeting> getMeetingByCondition(Meeting condition, int page) {
		Session session=sessionFactory.getCurrentSession();
		Criteria c=session.createCriteria(Meeting.class);
		c.setFirstResult(6*(page-1));
		c.setMaxResults(6);
		return c.list();
	}
	@Override
	public Integer getCountOfMeeting(Meeting condition) {
		Session session=sessionFactory.getCurrentSession();
		Criteria c=session.createCriteria(Meeting.class);
		return c.list().size();
	}
	@Override
	public Meeting getMeetingByMeetingId(int cusId) {
		Session session=sessionFactory.getCurrentSession();
		return (Meeting)session.get(Meeting.class, cusId);
	}
	//添加会议信息
	@Override
	public void addMeeting(Meeting meeting) {
		Session session=sessionFactory.getCurrentSession();
		session.save(meeting);
	}
	//删除会议信息
	@Override
	public void deleteMeeting(Meeting meeting) {
		Session session=sessionFactory.getCurrentSession();
		session.delete(meeting);
	}
	//修改会议信息
	@Override
	public void updateMeeting(Meeting meeting) {
		Session session=sessionFactory.getCurrentSession();
		session.update(meeting);		
	}
}
