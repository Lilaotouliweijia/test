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
	private Integer arcId;									//编号
	
	
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
		//mar为空，表示没有指定查询条件，此时将获取指定页码的反馈信息列表
		arcList=zbi.getAllInfo(curPage);
		//获取所有反馈信息数量,用来初始化分页类Pager对象，并设置其perPageRows和rowCount属性
		pager=zbi.getPagerOfInfo();
		//设置Pager对象中的待显示页页码
		pager.setCurPage(curPage);
		//将查询获得的列表存入request范围
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
	//处理删除通知书反馈对象请求，再转到toManageMeal
	public String delInfo() throws Exception {	
		zbi.deleteInfo(arcId);
		return "success";
	}
	//增加
	public String addInfo(){
		Info arcs=new Info();
		zbi.addInfo(arcs);
		return "success";
	}
	//修改
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
