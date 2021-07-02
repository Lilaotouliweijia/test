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
	//ʹ��ajax��¼ע�ᣬ���ǳɹ���ʧ�ܵı�־
	private boolean flag;							
	private Admin admin=new Admin();
	private String adminName;
	private String adminPass;
	private File img;//�����ļ�����   ���������ύ����ʱ����ı���name��������Ӧ    struts2�����������Զ�������ļ�����
	private String imgFileName;//�ļ���  ����  xxxFileName�ĸ�ʽ���з�װ   xxx�����������File��������Ӧ
	private String  imgContentType;//�ļ�����   xxxContentType�ĸ�ʽ��װ
	private String imgPath;//  webӦ������ʾ�ļ���·��    /webapp/xxx�ļ���/�ļ���
	//  webӦ������ʾ�ļ���·��    /webapp/xxx�ļ���/�ļ���
	//private String adminPic;
	Map<String, Object> session;
	Map<String, Object> request;
	//��ȡservlet�����ģ�������������ȡͼƬ��ʵ·��
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
		return context.getRealPath(path);//   ת����webӦ�������ļ�ϵͳ��·��
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
	//ʹ��ajax���е�¼
	public String login(){
		admin.setAdminName(adminName);
		admin.setAdminPass(adminPass);
		List<Admin> userList=adminBiz.login(admin);
		Admin admin1=adminBiz.getAdmin(adminName);
		String pic=admin1.getAdminPic();
		if(userList.size()==0){
			flag=false;
		}else{
			session.put("adminName", adminName);		//����request��ʹ���κ�һ����ҳ���ܵ��õ�¼�ɹ����û���
			session.put("pic", pic);
			flag=true;
		}
		return "success";								//����ֵ��user.xml��method����<result name="success" type="json"/>��name��Ӧ
	}
	public String checkRegName(){
		List<String> adminNames=adminBiz.getAllAdminName();
		if(adminNames.contains(adminName)){				//���ж��û����Ƿ��ѱ�ע��
			flag=true;
		}else{
			flag=false;
		}
		return "success";
	}
	//ʹ��ajax����ע��
	public String reg() throws IOException{
		String imgName = "file_"+System.currentTimeMillis()+
				imgFileName.substring(imgFileName.lastIndexOf("."));//�����ļ���   ��  file_xxxx.�ļ���׺
		//����webӦ���е�·��
		String path = "upload_img";//�ļ�����
		//    upload_img/�ļ���                 File.separator  ����"/"  ����������ͬ�Ĳ���ϵͳ�µķָ�������
		imgPath = path + "/" + imgName; 

		//�����ϴ��ļ���  ����Ӳ��ϵͳ·��      xx:\xx\... 
		String realPath = getRealPath(path);
		String realImgPath = realPath + "/" + imgName;//д���ļ�·��
		//�����ļ��д����Ĵ���
		File file = new File(realPath);
		if(!file.exists()){//��������ⲿ�ִ��룬�����ֶ���WebRoot�д����ļ���
			file.mkdirs();//�ݹ鴴�����ļ��к͸��ļ���
		}
		//�ӻ����ж�ȡ�ļ����п���
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
	//��ȡ���е��û�
	public String adminAll(){
		int curPage=1;
		if(pager!=null)
			curPage=pager.getCurPage();
		List<Admin> al=new LinkedList<Admin>();	
		al=adminBiz.getAllAdmin(curPage);
		//��ȡ���з�����Ϣ����,������ʼ����ҳ��Pager���󣬲�������perPageRows��rowCount����
		pager=adminBiz.getPagerOfAdmin();
		//����Pager�����еĴ���ʾҳҳ��
		pager.setCurPage(curPage);
		//����ѯ��õ��б����request��Χ
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
	//�޸�
	public String modifyAdmin(){
		adminBiz.updateAdmin(admin);
		return "success";
	}
}
