package action;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

import org.apache.commons.io.IOUtils;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.util.ServletContextAware;

import biz.AdminBiz;
import biz.ProjectBiz;
import com.opensymphony.xwork2.ActionSupport;

import entity.Admin;
import entity.Info;
import entity.Pager;
import entity.Project;
public class ProjectAction extends ActionSupport implements RequestAware,SessionAware,ServletContextAware{
	private static final long serialVersionUID = 1L;
	private Pager pager;
	private Project arc=new Project();
	private ProjectBiz zbi;
	private AdminBiz abiz;
	private Integer arcId;									//编号
	private File img;
	private String imgFileName;//文件名  按照  xxxFileName的格式进行封装   xxx必须与上面的File变量名对应
	private String  imgContentType;//文件类型   xxxContentType的格式封装
	private String imgPath;//  web应用中显示文件的路径    /webapp/xxx文件夹/文件名
	//  web应用中显示文件的路径    /webapp/xxx文件夹/文件名
	private File proFile2;
	private String proFile2FileName;
	private String  proFile2ContentType;
	private String proFile2Path;
	private File proFile1;
	private String proFile1FileName;
	private String  proFile1ContentType;
	private String proFile1Path;
	private ServletContext context;
	public String getProFile2FileName() {
		return proFile2FileName;
	}
	public void setProFile2FileName(String proFile2FileName) {
		this.proFile2FileName = proFile2FileName;
	}
	public String getProFile2ContentType() {
		return proFile2ContentType;
	}
	public void setProFile2ContentType(String proFile2ContentType) {
		this.proFile2ContentType = proFile2ContentType;
	}
	public String getProFile2Path() {
		return proFile2Path;
	}
	public void setProFile2Path(String proFile2Path) {
		this.proFile2Path = proFile2Path;
	}
	public String getProFile1FileName() {
		return proFile1FileName;
	}
	public void setProFile1FileName(String proFile1FileName) {
		this.proFile1FileName = proFile1FileName;
	}
	public String getProFile1ContentType() {
		return proFile1ContentType;
	}
	public void setProFile1ContentType(String proFile1ContentType) {
		this.proFile1ContentType = proFile1ContentType;
	}
	public String getProFile1Path() {
		return proFile1Path;
	}
	public void setProFile1Path(String proFile1Path) {
		this.proFile1Path = proFile1Path;
	}
	@Override
	public void setServletContext(ServletContext context) {
		this.context = context;
	}
	public File getProFile2() {
		return proFile2;
	}
	public void setProFile2(File proFile2) {
		this.proFile2 = proFile2;
	}
	public File getProFile1() {
		return proFile1;
	}
	public void setProFile1(File proFile1) {
		this.proFile1 = proFile1;
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
	public AdminBiz getAbiz() {
		return abiz;
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
	public Project getArc() {
		return arc;
	}
	public void setArc(Project arc) {
		this.arc = arc;
	}
	public ProjectBiz getZbi() {
		return zbi;
	}
	public void setZbi(ProjectBiz zbi) {
		this.zbi = zbi;
	}
	public Pager getPager() {
		return pager;
	}
	public void setPager(Pager pager) {
		this.pager = pager;
	}
	public String ProjectAll(){
		String adminName=(String) session.get("adminName");
		int curPage=1;
		if(pager!=null)
			curPage=pager.getCurPage();
		List<Project> arcList=null;		
		//mar为空，表示没有指定查询条件，此时将获取指定页码的反馈信息列表
		if(adminName.equals("admin")){
			arcList=zbi.getAllProject(curPage);
		}else{
			Admin admin=abiz.getAdmin(adminName);
			Project fan=new Project();
			fan.setProjectAdmin(admin);
			arcList=zbi.getAllProjectA(curPage,fan);
		}
		
		//获取所有反馈信息数量,用来初始化分页类Pager对象，并设置其perPageRows和rowCount属性
		pager=zbi.getPagerOfProject();
		//设置Pager对象中的待显示页页码
		pager.setCurPage(curPage);
		//将查询获得的列表存入request范围
		request.put("arcList", arcList);
		if(arcList.size()!=0){
			if(arcId==null){
				arc=zbi.getProjectByProjectId(arcList.get(0).getProjectId());
			}else{
				arc=zbi.getProjectByProjectId(arcId);
			}
		}
		request.put("arc", arc);
		return "success";
	}
	//处理删除通知书反馈对象请求，再转到toManageMeal
	public String delProject() throws Exception {	
		zbi.deleteProject(arcId);
		return "success";
	}
	//增加
	public String addPro() throws Exception{
		String imgName = "file_"+System.currentTimeMillis()+
				imgFileName.substring(imgFileName.lastIndexOf("."));//生成文件名   ：  file_xxxx.文件后缀
		//生成web应用中的路径
		String path = "申报书";//文件夹名
		//    upload_img/文件名                 File.separator  代替"/"  可以消除不同的操作系统下的分隔符差异
		imgPath = path + "/" + imgName; 

		//生成上传文件的  物理硬盘系统路径      xx:\xx\... 
		String realPath = getRealPath(path);
		String realImgPath = realPath + "\\" + imgName;//写出文件路径
		//处理文件夹创建的代码
		File file = new File(realPath);
		if(!file.exists()){//如果不用这部分代码，可以手动在WebRoot中创建文件夹
			file.mkdirs();//递归创建本文件夹和父文件夹
		}
		//从缓存中读取文件进行拷贝
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(img));
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(realImgPath));
		IOUtils.copy(bis, bos);
		//imgPath=imgPath.replaceAll("/", "\\");
		
		String imgName1 = "file_"+System.currentTimeMillis()+
				proFile1FileName.substring(proFile1FileName.lastIndexOf("."));//生成文件名   ：  file_xxxx.文件后缀
		//生成web应用中的路径
		String path1 = "申报书1";//文件夹名
		//    upload_img/文件名                 File.separator  代替"/"  可以消除不同的操作系统下的分隔符差异
		proFile1Path = path1 + "/" + imgName1; 

		//生成上传文件的  物理硬盘系统路径      xx:\xx\... 
		String realPath1 = getRealPath(path1);
		String realImgPath1 = realPath1 + "/" + imgName1;//写出文件路径
		//处理文件夹创建的代码
		File file1 = new File(realPath1);
		if(!file1.exists()){//如果不用这部分代码，可以手动在WebRoot中创建文件夹
			file1.mkdirs();//递归创建本文件夹和父文件夹
		}
		//从缓存中读取文件进行拷贝
		BufferedInputStream bis1 = new BufferedInputStream(new FileInputStream(proFile1));
		BufferedOutputStream bos1 = new BufferedOutputStream(new FileOutputStream(realImgPath1));
		IOUtils.copy(bis1, bos1);
		
		String imgName2 = "file_"+System.currentTimeMillis()+
				proFile2FileName.substring(proFile2FileName.lastIndexOf("."));//生成文件名   ：  file_xxxx.文件后缀
		//生成web应用中的路径
		String path2 = "申报书2";//文件夹名
		//    upload_img/文件名                 File.separator  代替"/"  可以消除不同的操作系统下的分隔符差异
		proFile2Path = path2 + "/" + imgName2; 

		//生成上传文件的  物理硬盘系统路径      xx:\xx\... 
		String realPath2 = getRealPath(path2);
		String realImgPath2= realPath2 + "/" + imgName2;//写出文件路径
		//处理文件夹创建的代码
		File file2 = new File(realPath2);
		if(!file2.exists()){//如果不用这部分代码，可以手动在WebRoot中创建文件夹
			file2.mkdirs();//递归创建本文件夹和父文件夹
		}
		//从缓存中读取文件进行拷贝
		BufferedInputStream bis2 = new BufferedInputStream(new FileInputStream(proFile2));
		BufferedOutputStream bos2 = new BufferedOutputStream(new FileOutputStream(realImgPath2));
		IOUtils.copy(bis2, bos2);
		
		arc.setBaseUrl(realPath1);
		arc.setProUrl(realPath2);
		arc.setShenQingUrl(imgPath);
		String adminName=(String) session.get("adminName");
		Admin admin=abiz.getAdmin(adminName);
		Info i=new Info();
		i.setState("未通过");
		arc.setIfopr("未审");
		arc.setProjectState("未开启");
		arc.setProjectInfo(i);
		arc.setProjectAdmin(admin);
		Date date=new Date();
		@SuppressWarnings("deprecation")
		java.sql.Date dat=new java.sql.Date(date.getYear(), date.getMonth(), date.getDay());
		arc.setStartDate(dat);
		i.setProject(arc);
		session.put("Proarc", arc);
		zbi.addProject(arc);
		return "success";
	}
	//修改
	public String modifyProject(){
		Date date=new Date();
		@SuppressWarnings("deprecation")
		java.sql.Date dat=new java.sql.Date(date.getYear(), date.getMonth(), date.getDay());
		String adminName=(String) session.get("adminName");
		Admin admin=abiz.getAdmin(adminName);
		arc.setProjectAdmin(admin);
		arc.setEndDate(null);
		arc.setStartDate(dat);
		arc.setProjectState("进行中");
		session.put("Proarc", arc);
		zbi.updateProject(arc);
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
