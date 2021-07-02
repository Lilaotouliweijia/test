package action;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletContext;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.util.ServletContextAware;

import biz.AdminBiz;
import biz.MeetingBiz;
import com.opensymphony.xwork2.ActionSupport;

import entity.Admin;
import entity.Pager;
import entity.Meeting;
public class MeetingAction extends ActionSupport implements RequestAware,SessionAware,ServletContextAware{
	private static final long serialVersionUID = 1L;
	private Pager pager;
	private Meeting arc;
	private MeetingBiz zbi;
	private AdminBiz adminBiz;
	private Integer arcId;									//���
	private ServletContext context;
	private String adminName;
	
	

	public AdminBiz getAdminBiz() {
		return adminBiz;
	}

	public void setAdminBiz(AdminBiz adminBiz) {
		this.adminBiz = adminBiz;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	@Override
	public void setServletContext(ServletContext context) {
		this.context = context;
	}

	public String getRealPath(String path){
		return context.getRealPath(path);//   ת����webӦ�������ļ�ϵͳ��·��
	}
	public Integer getArcId() {
		return arcId;
	}
	public void setArcId(Integer arcId) {
		this.arcId = arcId;
	}
	public Meeting getArc() {
		return arc;
	}
	public void setArc(Meeting arc) {
		this.arc = arc;
	}
	public void setZbi(MeetingBiz zbi) {
		this.zbi = zbi;
	}
	public Pager getPager() {
		return pager;
	}
	public void setPager(Pager pager) {
		this.pager = pager;
	}


	public String MeetingAll(){
		int curPage=1;
		if(pager!=null)
			curPage=pager.getCurPage();
		List<Meeting> arcList=null;		
		//marΪ�գ���ʾû��ָ����ѯ��������ʱ����ȡָ��ҳ��ķ�����Ϣ�б�
		arcList=zbi.getAllMeeting(curPage);
		//��ȡ���з�����Ϣ����,������ʼ����ҳ��Pager���󣬲�������perPageRows��rowCount����
		pager=zbi.getPagerOfMeeting();
		//����Pager�����еĴ���ʾҳҳ��
		pager.setCurPage(curPage);
		//����ѯ��õ��б����request��Χ
		request.put("arcList", arcList);
		if(arcList.size()==0){
			arc=null;
		}else if(arcId==null){
			arc=zbi.getMeetingByMeetingId(arcList.get(0).getMeetingId());
		}else{
			arc=zbi.getMeetingByMeetingId(arcId);
		}
		request.put("arc", arc);
		return "success";
	}
	//����ɾ��֪ͨ�鷴������������ת��toManageMeal
	public String delMeeting(){	
		zbi.deleteMeeting(arcId);
		return "success";
	}
	//����
	public String addMeeting(){
		Admin admin=adminBiz.getAdmin(adminName);
		arc.setMeetingAdminId(admin);
		zbi.addMeeting(arc);
		return "success";
	}
	//�޸�
	public String modifyMeeting(){
		zbi.updateMeeting(arc);
		return "success";
	}
	Map<String, Object> session;
	@Override
	public void setSession(Map<String, Object> session) {
		this.session=session;
	}

	Map<String, Object> request;
	@Override
	public void setRequest(Map<String, Object> request) {
		this.request=request;
	}
}
