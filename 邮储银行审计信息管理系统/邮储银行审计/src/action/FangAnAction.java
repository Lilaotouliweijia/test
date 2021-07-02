package action;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

import org.apache.commons.io.IOUtils;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.util.ServletContextAware;

import biz.AdminBiz;
import biz.FangAnBiz;
import com.opensymphony.xwork2.ActionSupport;

import entity.Admin;
import entity.Pager;
import entity.FangAn;
public class FangAnAction extends ActionSupport implements RequestAware,SessionAware,ServletContextAware{
	private static final long serialVersionUID = 1L;
	private Pager pager;
	private FangAn arc;
	private FangAnBiz zbi;
	private AdminBiz abiz;
	private Integer arcId;									//编号
	private File img;
	private String imgFileName;//文件名  按照  xxxFileName的格式进行封装   XXX必须与上面的File变量名对应
	private String  imgContentType;//文件类型   xxxContentType的格式封装
	private String imgPath;//  web应用中显示文件的路径    /webapp/xxx文件夹/文件名
	//  web应用中显示文件的路径    /webapp/xxx文件夹/文件名
	private ServletContext context;
	@Override
	public void setServletContext(ServletContext context) {
		this.context = context;
	}

	public String getRealPath(String path){
		return context.getRealPath(path);//   转换成web应用所在文件系统的路径
	}
	
	
	public File getImg() {
		return img;
	}
	public String getImgFileName() {
		return imgFileName;
	}
	public void setImgFileName(String imgFileName) {
		this.imgFileName = imgFileName;
	}
	public String getImgContentType() {
		return imgContentType;
	}
	public void setImgContentType(String imgContentType) {
		this.imgContentType = imgContentType;
	}
	public String getImgPath() {
		return imgPath;
	}
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
	public void setImg(File img) {
		this.img = img;
	}
	public void setAbiz(AdminBiz abiz) {
		this.abiz = abiz;
	}
	public Integer getArcId() {
		return arcId;
	}
	public void setArcId(Integer arcId) {
		this.arcId = arcId;
	}
	public FangAn getArc() {
		return arc;
	}
	public void setArc(FangAn arc) {
		this.arc = arc;
	}
	public void setZbi(FangAnBiz zbi) {
		this.zbi = zbi;
	}
	public Pager getPager() {
		return pager;
	}
	public void setPager(Pager pager) {
		this.pager = pager;
	}

	
	public String FangAnAll(){
		String adminName=(String) session.get("adminName");
		int curPage=1;
		if(pager!=null)
			curPage=pager.getCurPage();
		List<FangAn> arcList=null;		
		//mar为空，表示没有指定查询条件，此时将获取指定页码的反馈信息列表
		if(adminName.equals("admin")){
			arcList=zbi.getAllFangAn(curPage);
		}else{
			Admin admin=abiz.getAdmin(adminName);
			FangAn fan=new FangAn();
			fan.setAdmin(admin);
			arcList=zbi.getAllFangAnA(curPage,fan);
		}
		
		//获取所有反馈信息数量,用来初始化分页类Pager对象，并设置其perPageRows和rowCount属性
		pager=zbi.getPagerOfFangAn();
		//设置Pager对象中的待显示页页码
		pager.setCurPage(curPage);
		//将查询获得的列表存入request范围
		request.put("arcList", arcList);	
		if(arcList.size()!=0){
			if(arcId==null){
				arc=zbi.getFangAnByFangAnId(arcList.get(0).getFangAnId());
			}else{
				arc=zbi.getFangAnByFangAnId(arcId);
			}
		}
		
		request.put("arc", arc);
		return "success";
	}
	//处理删除通知书反馈对象请求，再转到toManageMeal
	public String delFangAn() throws Exception {	
		zbi.deleteFangAn(arcId);
		return "success";
	}
	//增加
	public String addFaa(){
		String imgName = "file_"+System.currentTimeMillis()+
				imgFileName.substring(imgFileName.lastIndexOf("."));//生成文件名   ：  file_xxxx.文件后缀
		//生成web应用中的路径
		String path = "方案夹";//文件夹名
		//    upload_img/文件名                 File.separator  代替"/"  可以消除不同的操作系统下的分隔符差异
		imgPath = path + "/" + imgName; 

		//生成上传文件的  物理硬盘系统路径      xx:\xx\... 
		String realPath = getRealPath(path);
		String realImgPath = realPath + "/" + imgName;//写出文件路径
		//处理文件夹创建的代码
		File file = new File(realPath);
		if(!file.exists()){//如果不用这部分代码，可以手动在WebRoot中创建文件夹
			file.mkdirs();//递归创建本文件夹和父文件夹
		}
		//从缓存中读取文件进行拷贝
		try {
			BufferedInputStream bis = new BufferedInputStream(new FileInputStream(img));
			BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(realImgPath));
			IOUtils.copy(bis, bos);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//imgPath=imgPath.replaceAll("/", "\\");
		arc.setFangUrl("sd");
		
		//Project pro=(Project) session.get("Proarc");
		//arc.setProjectId(pro);
		zbi.addFangAn(arc);
		return "success";
	}
	//修改
	public String modifyFangAn(){
		
		zbi.updateFangAn(arc);
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
