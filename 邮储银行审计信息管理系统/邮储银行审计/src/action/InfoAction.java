package action;
import java.util.List;
import java.util.Map;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import biz.InfoBiz;
import com.opensymphony.xwork2.ActionSupport;
import entity.Pager;
import entity.Info;
public class InfoAction extends ActionSupport implements RequestAware,SessionAware{
	private static final long serialVersionUID = 1L;
	private Pager pager;
	private Info arc;
	private InfoBiz zbi;
	private Integer arcId;									//���
	
	
	public Integer getArcId() {
		return arcId;
	}
	public void setArcId(Integer arcId) {
		this.arcId = arcId;
	}
	public Info getArc() {
		return arc;
	}
	public void setArc(Info arc) {
		this.arc = arc;
	}
	public InfoBiz getZbi() {
		return zbi;
	}
	public void setZbi(InfoBiz zbi) {
		this.zbi = zbi;
	}
	public Pager getPager() {
		return pager;
	}
	public void setPager(Pager pager) {
		this.pager = pager;
	}

	
	public String InfoAll(){
		int curPage=1;
		if(pager!=null)
			curPage=pager.getCurPage();
		List<Info> arcList=null;		
		//marΪ�գ���ʾû��ָ����ѯ��������ʱ����ȡָ��ҳ��ķ�����Ϣ�б�
		arcList=zbi.getAllInfo(curPage);
		//��ȡ���з�����Ϣ����,������ʼ����ҳ��Pager���󣬲�������perPageRows��rowCount����
		pager=zbi.getPagerOfInfo();
		//����Pager�����еĴ���ʾҳҳ��
		pager.setCurPage(curPage);
		//����ѯ��õ��б����request��Χ
		request.put("arcList", arcList);
		if(arcList.size()!=0){
			if(arcId==null){
				arc=zbi.getInfoByInfoId(arcList.get(0).getInfoId());
			}else{
				arc=zbi.getInfoByInfoId(arcId);
			}
		}
		request.put("arc", arc);
		return "success";
	}
	//����ɾ��֪ͨ�鷴������������ת��toManageMeal
	public String delInfo() throws Exception {	
		zbi.deleteInfo(arcId);
		return "success";
	}
	//����
	public String addInfo(){
		Info arcs=new Info();
		zbi.addInfo(arcs);
		return "success";
	}
	//�޸�
	public String modifyInfo(){
		
		zbi.updateInfo(arc);
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
