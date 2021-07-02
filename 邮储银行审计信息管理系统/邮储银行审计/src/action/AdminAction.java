package action;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import org.apache.struts2.util.ServletContextAware;
import org.apache.commons.io.IOUtils;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import biz.AdminBiz;
import com.opensymphony.xwork2.ActionSupport;
import entity.Admin;
import entity.Pager;
import entity.Project;

public class AdminAction extends ActionSupport implements RequestAware,SessionAware,ServletContextAware{
	private static final long serialVersionUID = 1L;
	private AdminBiz adminBiz;
	//使用ajax登录注册，这是成功和失败的标志
	private boolean flag;							
	private Admin admin=new Admin();
	private String adminName;
	private String adminPass;
	private File img;//定义文件属性   名必须与提交表单的时候的文本的name属性名对应    struts2的拦截器会自动处理成文件对象
	private String imgFileName;//文件名  按照  xxxFileName的格式进行封装   xxx必须与上面的File变量名对应
	private String  imgContentType;//文件类型   xxxContentType的格式封装
	private String imgPath;//  web应用中显示文件的路径    /webapp/xxx文件夹/文件名
	//  web应用中显示文件的路径    /webapp/xxx文件夹/文件名
	//private String adminPic;
	Map<String, Object> session;
	Map<String, Object> request;
	//获取servlet上下文，本程序用来获取图片真实路劲
	private ServletContext context;
	private int t;
	private Pager pager;
	private Integer aid;


	public Integer getAid() {
		return aid;
	}
	public void setAid(Integer aid) {
		this.aid = aid;
	}
	public Pager getPager() {
		return pager;
	}
	public void setPager(Pager pager) {
		this.pager = pager;
	}
	public int getT() {
		return t;
	}
	public void setT(int t) {
		this.t = t;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getAdminPass() {
		return adminPass;
	}
	public void setAdminPass(String adminPass) {
		this.adminPass = adminPass;
	}
	public void setAdminBiz(AdminBiz adminBiz) {
		this.adminBiz = adminBiz;
	}
	public boolean isFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	@Override
	public void setRequest(Map<String, Object> request) {
		this.request=request;
	}
	@Override
	public void setSession(Map<String, Object> session) {
		this.session=session;
	}
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
	//使用ajax进行登录
	public String login(){
		admin.setAdminName(adminName);
		admin.setAdminPass(adminPass);
		List<Admin> userList=adminBiz.login(admin);
		Admin admin1=adminBiz.getAdmin(adminName);
		String pic=admin1.getAdminPic();
		if(userList.size()==0){
			flag=false;
		}else{
			session.put("adminName", adminName);		//设置request，使得任何一个网页都能调用登录成功的用户名
			session.put("pic", pic);
			flag=true;
		}
		return "success";								//返回值与user.xml中method方法<result name="success" type="json"/>的name对应
	}
	public String checkRegName(){
		List<String> adminNames=adminBiz.getAllAdminName();
		if(adminNames.contains(adminName)){				//先判断用户名是否已被注册
			flag=true;
		}else{
			flag=false;
		}
		return "success";
	}
	//使用ajax进行注册
	public String reg() throws IOException{
		String imgName = "file_"+System.currentTimeMillis()+
				imgFileName.substring(imgFileName.lastIndexOf("."));//生成文件名   ：  file_xxxx.文件后缀
		//生成web应用中的路径
		String path = "upload_img";//文件夹名
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
		admin.setAdminPic(imgPath);
		adminBiz.addAdmin(admin);
		bis.close();
		bos.close();
		return "success";
	}
	//获取所有的用户
	public String adminAll(){
		int curPage=1;
		if(pager!=null)
			curPage=pager.getCurPage();
		List<Admin> al=new LinkedList<Admin>();	
		al=adminBiz.getAllAdmin(curPage);
		//获取所有反馈信息数量,用来初始化分页类Pager对象，并设置其perPageRows和rowCount属性
		pager=adminBiz.getPagerOfAdmin();
		//设置Pager对象中的待显示页页码
		pager.setCurPage(curPage);
		//将查询获得的列表存入request范围
		request.put("adminL", al);
		if(al.size()==0){
			admin=null;
		}else {
			if(aid==null){
				admin=adminBiz.getAdminByAdminId(al.get(0).getAdminId());
			}else{
				admin=adminBiz.getAdminByAdminId(aid);
			}
		}
		Project pro=new Project();
		pro.setProjectAdmin(admin);
		List<Project> proList=adminBiz.getAllProjectA(pro);
		request.put("proList", proList);
		request.put("adm", admin);
		return "success";
	}
	//修改
	public String modifyAdmin(){
		adminBiz.updateAdmin(admin);
		return "success";
	}
}
