package action;

import java.util.List;
import java.util.Map;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import biz.ZhishikuBiz;

import com.opensymphony.xwork2.ActionSupport;
import entity.Pager;
import entity.Zhishiku;



public class ZskAction extends ActionSupport implements RequestAware,SessionAware{
	private static final long serialVersionUID = 1L;
	private Pager pager;
	private Zhishiku arc;
	private ZhishikuBiz zbi;
	private Integer arcId;									//���
	
	
	public Integer getArcId() {
		return arcId;
	}
	public void setArcId(Integer arcId) {
		this.arcId = arcId;
	}
	public Zhishiku getArc() {
		return arc;
	}
	public void setArc(Zhishiku arc) {
		this.arc = arc;
	}
	public ZhishikuBiz getZbi() {
		return zbi;
	}
	public void setZbi(ZhishikuBiz zbi) {
		this.zbi = zbi;
	}
	public Pager getPager() {
		return pager;
	}
	public void setPager(Pager pager) {
		this.pager = pager;
	}

	
	public String zskAll(){
		int curPage=1;
		if(pager!=null)
			curPage=pager.getCurPage();
		List<Zhishiku> arcList=null;		
		//marΪ�գ���ʾû��ָ����ѯ��������ʱ����ȡָ��ҳ��ķ�����Ϣ�б�
		arcList=zbi.getAllZhishiku(curPage);
		//��ȡ���з�����Ϣ����,������ʼ����ҳ��Pager���󣬲�������perPageRows��rowCount����
		pager=zbi.getPagerOfZhishiku();
		//����Pager�����еĴ���ʾҳҳ��
		pager.setCurPage(curPage);
		//����ѯ��õ��б����request��Χ
		request.put("arcList", arcList);
		if(arcList.size()!=0){
			if(arcId==null){
				arc=zbi.getZhishikuByZhishikuId(arcList.get(0).getZhiShiId());
			}else{
				arc=zbi.getZhishikuByZhishikuId(arcId);
			}
		}
		request.put("arc", arc);
		return "success";
	}
	//����ɾ��֪ʶ�ⷴ������������ת��toManageMeal
	public String delzsk() throws Exception {	
		zbi.deleteZhishiku(arcId);
		return "success";
	}
	//����
	public String addzsk(){
		Zhishiku arcs=new Zhishiku();
		zbi.addZhishiku(arcs);
		return "success";
	}
	//�޸�
	public String modifyZsk(){
		
		zbi.updateZhishiku(arc);
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
