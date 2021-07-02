package action;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

import org.apache.commons.io.IOUtils;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.util.ServletContextAware;

import biz.ReportBiz;

import com.opensymphony.xwork2.ActionSupport;
import entity.Pager;
import entity.Report;



public class ReportAction extends ActionSupport implements RequestAware,SessionAware,ServletContextAware{
	private static final long serialVersionUID = 1L;
	private Pager pager;
	private Report arc;
	private ReportBiz zbi;
	private Integer arcId;									//编号
	private File img;//定义文件属性   名必须与提交表单的时候的文本的name属性名对应    struts2的拦截器会自动处理成文件对象
	private String imgFileName;//文件名  按照  xxxFileName的格式进行封装   xxx必须与上面的File变量名对应
	private String  imgContentType;//文件类型   xxxContentType的格式封装
	private String imgPath;//  web应用中显示文件的路径    /webapp/xxx文件夹/文件名
	//  web应用中显示文件的路径    /webapp/xxx文件夹/文件名
	private File img1;//定义文件属性   名必须与提交表单的时候的文本的name属性名对应    struts2的拦截器会自动处理成文件对象
	private String img1FileName;//文件名  按照  xxxFileName的格式进行封装   xxx必须与上面的File变量名对应
	private String  img1ContentType;//文件类型   xxxContentType的格式封装
	private String img1Path;//  web应用中显示文件的路径    /webapp/xxx文件夹/文件名
	//  web应用中显示文件的路径    /webapp/xxx文件夹/文件名
	private ServletContext context;
	
	public String getRealPath(String path){
		return context.getRealPath(path);//   转换成web应用所在文件系统的路径
	}
	public File getImg() {
		return img;
	}
	public void setImg(File img) {
		this.img = img;
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
	public File getImg1() {
		return img1;
	}
	public void setImg1(File img1) {
		this.img1 = img1;
	}
	public String getImg1FileName() {
		return img1FileName;
	}
	public void setImg1FileName(String img1FileName) {
		this.img1FileName = img1FileName;
	}
	public String getImg1ContentType() {
		return img1ContentType;
	}
	public void setImg1ContentType(String img1ContentType) {
		this.img1ContentType = img1ContentType;
	}
	public String getImg1Path() {
		return img1Path;
	}
	public void setImg1Path(String img1Path) {
		this.img1Path = img1Path;
	}
	public void setContext(ServletContext context) {
		this.context = context;
	}
	public Integer getArcId() {
		return arcId;
	}
	public void setArcId(Integer arcId) {
		this.arcId = arcId;
	}
	public Report getArc() {
		return arc;
	}
	public void setArc(Report arc) {
		this.arc = arc;
	}
	public ReportBiz getZbi() {
		return zbi;
	}
	public void setZbi(ReportBiz zbi) {
		this.zbi = zbi;
	}
	public Pager getPager() {
		return pager;
	}
	public void setPager(Pager pager) {
		this.pager = pager;
	}

	
	public String bgAll(){
		int curPage=1;
		if(pager!=null)
			curPage=pager.getCurPage();
		List<Report> arcList=null;		
		//mar为空，表示没有指定查询条件，此时将获取指定页码的反馈信息列表
		arcList=zbi.getAllReport(curPage);
		//获取所有反馈信息数量,用来初始化分页类Pager对象，并设置其perPageRows和rowCount属性
		pager=zbi.getPagerOfReport();
		//设置Pager对象中的待显示页页码
		pager.setCurPage(curPage);
		//将查询获得的列表存入request范围
		request.put("arcList", arcList);	
		if(arcList.size()!=0){
			if(arcId==null){
				arc=zbi.getReportByReportId(arcList.get(0).getReportId());
			}else{
				arc=zbi.getReportByReportId(arcId);
			}
		}
		request.put("arc", arc);
		return "success";
	}
	//处理删除知识库反馈对象请求，再转到toManageMeal
	public String delbg() throws Exception {	
		zbi.deleteReport(arcId);
		return "success";
	}
	//增加
	public String addbg() throws Exception{
		String imgName = "file_"+System.currentTimeMillis()+
				imgFileName.substring(imgFileName.lastIndexOf("."));//生成文件名   ：  file_xxxx.文件后缀
		//生成web应用中的路径
		String path = "审计意见书";//文件夹名
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
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(img));
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(realImgPath));
		IOUtils.copy(bis, bos);
		//imgPath=imgPath.replaceAll("/", "\\");
		
		String imgName1 = "file_"+System.currentTimeMillis()+
				img1FileName.substring(img1FileName.lastIndexOf("."));//生成文件名   ：  file_xxxx.文件后缀
		//生成web应用中的路径
		String path1 = "台账报表";//文件夹名
		//    upload_img/文件名                 File.separator  代替"/"  可以消除不同的操作系统下的分隔符差异
		img1Path = path1 + "/" + imgName1; 

		//生成上传文件的  物理硬盘系统路径      xx:\xx\... 
		String realPath1 = getRealPath(path1);
		String realImgPath1 = realPath1 + "/" + imgName1;//写出文件路径
		//处理文件夹创建的代码
		File file1 = new File(realPath1);
		if(!file1.exists()){//如果不用这部分代码，可以手动在WebRoot中创建文件夹
			file1.mkdirs();//递归创建本文件夹和父文件夹
		}
		//从缓存中读取文件进行拷贝
		BufferedInputStream bis1 = new BufferedInputStream(new FileInputStream(img1));
		BufferedOutputStream bos1 = new BufferedOutputStream(new FileOutputStream(realImgPath1));
		IOUtils.copy(bis1, bos1);
		//imgPath=imgPath.replaceAll("/", "\\");
		arc.setSugUrl(imgPath);
		arc.setTzUrl(img1Path);
		zbi.addReport(arc);
		return "success";
	}
	//修改
	public String modifybg(){
		
		zbi.updateReport(arc);
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
	@Override
	public void setServletContext(ServletContext context) {
		this.context = context;
	}
}
