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
	private Integer arcId;									//编号
	
	
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
		//mar为空，表示没有指定查询条件，此时将获取指定页码的反馈信息列表
		arcList=zbi.getAllZhishiku(curPage);
		//获取所有反馈信息数量,用来初始化分页类Pager对象，并设置其perPageRows和rowCount属性
		pager=zbi.getPagerOfZhishiku();
		//设置Pager对象中的待显示页页码
		pager.setCurPage(curPage);
		//将查询获得的列表存入request范围
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
	//处理删除知识库反馈对象请求，再转到toManageMeal
	public String delzsk() throws Exception {	
		zbi.deleteZhishiku(arcId);
		return "success";
	}
	//增加
	public String addzsk(){
		Zhishiku arcs=new Zhishiku();
		zbi.addZhishiku(arcs);
		return "success";
	}
	//修改
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
