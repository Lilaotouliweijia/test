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
	private Integer arcId;									//���
	private File img;
	private String imgFileName;//�ļ���  ����  xxxFileName�ĸ�ʽ���з�װ   xxx�����������File��������Ӧ
	private String  imgContentType;//�ļ�����   xxxContentType�ĸ�ʽ��װ
	private String imgPath;//  webӦ������ʾ�ļ���·��    /webapp/xxx�ļ���/�ļ���
	//  webӦ������ʾ�ļ���·��    /webapp/xxx�ļ���/�ļ���
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
		return context.getRealPath(path);//   ת����webӦ�������ļ�ϵͳ��·��
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
		//marΪ�գ���ʾû��ָ����ѯ��������ʱ����ȡָ��ҳ��ķ�����Ϣ�б�
		if(adminName.equals("admin")){
			arcList=zbi.getAllProject(curPage);
		}else{
			Admin admin=abiz.getAdmin(adminName);
			Project fan=new Project();
			fan.setProjectAdmin(admin);
			arcList=zbi.getAllProjectA(curPage,fan);
		}
		
		//��ȡ���з�����Ϣ����,������ʼ����ҳ��Pager���󣬲�������perPageRows��rowCount����
		pager=zbi.getPagerOfProject();
		//����Pager�����еĴ���ʾҳҳ��
		pager.setCurPage(curPage);
		//����ѯ��õ��б����request��Χ
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
	//����ɾ��֪ͨ�鷴������������ת��toManageMeal
	public String delProject() throws Exception {	
		zbi.deleteProject(arcId);
		return "success";
	}
	//����
	public String addPro() throws Exception{
		String imgName = "file_"+System.currentTimeMillis()+
				imgFileName.substring(imgFileName.lastIndexOf("."));//�����ļ���   ��  file_xxxx.�ļ���׺
		//����webӦ���е�·��
		String path = "�걨��";//�ļ�����
		//    upload_img/�ļ���                 File.separator  ����"/"  ����������ͬ�Ĳ���ϵͳ�µķָ�������
		imgPath = path + "/" + imgName; 

		//�����ϴ��ļ���  ����Ӳ��ϵͳ·��      xx:\xx\... 
		String realPath = getRealPath(path);
		String realImgPath = realPath + "\\" + imgName;//д���ļ�·��
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
		
		String imgName1 = "file_"+System.currentTimeMillis()+
				proFile1FileName.substring(proFile1FileName.lastIndexOf("."));//�����ļ���   ��  file_xxxx.�ļ���׺
		//����webӦ���е�·��
		String path1 = "�걨��1";//�ļ�����
		//    upload_img/�ļ���                 File.separator  ����"/"  ����������ͬ�Ĳ���ϵͳ�µķָ�������
		proFile1Path = path1 + "/" + imgName1; 

		//�����ϴ��ļ���  ����Ӳ��ϵͳ·��      xx:\xx\... 
		String realPath1 = getRealPath(path1);
		String realImgPath1 = realPath1 + "/" + imgName1;//д���ļ�·��
		//�����ļ��д����Ĵ���
		File file1 = new File(realPath1);
		if(!file1.exists()){//��������ⲿ�ִ��룬�����ֶ���WebRoot�д����ļ���
			file1.mkdirs();//�ݹ鴴�����ļ��к͸��ļ���
		}
		//�ӻ����ж�ȡ�ļ����п���
		BufferedInputStream bis1 = new BufferedInputStream(new FileInputStream(proFile1));
		BufferedOutputStream bos1 = new BufferedOutputStream(new FileOutputStream(realImgPath1));
		IOUtils.copy(bis1, bos1);
		
		String imgName2 = "file_"+System.currentTimeMillis()+
				proFile2FileName.substring(proFile2FileName.lastIndexOf("."));//�����ļ���   ��  file_xxxx.�ļ���׺
		//����webӦ���е�·��
		String path2 = "�걨��2";//�ļ�����
		//    upload_img/�ļ���                 File.separator  ����"/"  ����������ͬ�Ĳ���ϵͳ�µķָ�������
		proFile2Path = path2 + "/" + imgName2; 

		//�����ϴ��ļ���  ����Ӳ��ϵͳ·��      xx:\xx\... 
		String realPath2 = getRealPath(path2);
		String realImgPath2= realPath2 + "/" + imgName2;//д���ļ�·��
		//�����ļ��д����Ĵ���
		File file2 = new File(realPath2);
		if(!file2.exists()){//��������ⲿ�ִ��룬�����ֶ���WebRoot�д����ļ���
			file2.mkdirs();//�ݹ鴴�����ļ��к͸��ļ���
		}
		//�ӻ����ж�ȡ�ļ����п���
		BufferedInputStream bis2 = new BufferedInputStream(new FileInputStream(proFile2));
		BufferedOutputStream bos2 = new BufferedOutputStream(new FileOutputStream(realImgPath2));
		IOUtils.copy(bis2, bos2);
		
		arc.setBaseUrl(realPath1);
		arc.setProUrl(realPath2);
		arc.setShenQingUrl(imgPath);
		String adminName=(String) session.get("adminName");
		Admin admin=abiz.getAdmin(adminName);
		Info i=new Info();
		i.setState("δͨ��");
		arc.setIfopr("δ��");
		arc.setProjectState("δ����");
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
	//�޸�
	public String modifyProject(){
		Date date=new Date();
		@SuppressWarnings("deprecation")
		java.sql.Date dat=new java.sql.Date(date.getYear(), date.getMonth(), date.getDay());
		String adminName=(String) session.get("adminName");
		Admin admin=abiz.getAdmin(adminName);
		arc.setProjectAdmin(admin);
		arc.setEndDate(null);
		arc.setStartDate(dat);
		arc.setProjectState("������");
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
