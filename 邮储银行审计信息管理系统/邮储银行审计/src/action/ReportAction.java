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
	private Integer arcId;									//���
	private File img;//�����ļ�����   ���������ύ����ʱ����ı���name��������Ӧ    struts2�����������Զ�������ļ�����
	private String imgFileName;//�ļ���  ����  xxxFileName�ĸ�ʽ���з�װ   xxx�����������File��������Ӧ
	private String  imgContentType;//�ļ�����   xxxContentType�ĸ�ʽ��װ
	private String imgPath;//  webӦ������ʾ�ļ���·��    /webapp/xxx�ļ���/�ļ���
	//  webӦ������ʾ�ļ���·��    /webapp/xxx�ļ���/�ļ���
	private File img1;//�����ļ�����   ���������ύ����ʱ����ı���name��������Ӧ    struts2�����������Զ�������ļ�����
	private String img1FileName;//�ļ���  ����  xxxFileName�ĸ�ʽ���з�װ   xxx�����������File��������Ӧ
	private String  img1ContentType;//�ļ�����   xxxContentType�ĸ�ʽ��װ
	private String img1Path;//  webӦ������ʾ�ļ���·��    /webapp/xxx�ļ���/�ļ���
	//  webӦ������ʾ�ļ���·��    /webapp/xxx�ļ���/�ļ���
	private ServletContext context;
	
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
		//marΪ�գ���ʾû��ָ����ѯ��������ʱ����ȡָ��ҳ��ķ�����Ϣ�б�
		arcList=zbi.getAllReport(curPage);
		//��ȡ���з�����Ϣ����,������ʼ����ҳ��Pager���󣬲�������perPageRows��rowCount����
		pager=zbi.getPagerOfReport();
		//����Pager�����еĴ���ʾҳҳ��
		pager.setCurPage(curPage);
		//����ѯ��õ��б����request��Χ
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
	//����ɾ��֪ʶ�ⷴ������������ת��toManageMeal
	public String delbg() throws Exception {	
		zbi.deleteReport(arcId);
		return "success";
	}
	//����
	public String addbg() throws Exception{
		String imgName = "file_"+System.currentTimeMillis()+
				imgFileName.substring(imgFileName.lastIndexOf("."));//�����ļ���   ��  file_xxxx.�ļ���׺
		//����webӦ���е�·��
		String path = "��������";//�ļ�����
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
		
		String imgName1 = "file_"+System.currentTimeMillis()+
				img1FileName.substring(img1FileName.lastIndexOf("."));//�����ļ���   ��  file_xxxx.�ļ���׺
		//����webӦ���е�·��
		String path1 = "̨�˱���";//�ļ�����
		//    upload_img/�ļ���                 File.separator  ����"/"  ����������ͬ�Ĳ���ϵͳ�µķָ�������
		img1Path = path1 + "/" + imgName1; 

		//�����ϴ��ļ���  ����Ӳ��ϵͳ·��      xx:\xx\... 
		String realPath1 = getRealPath(path1);
		String realImgPath1 = realPath1 + "/" + imgName1;//д���ļ�·��
		//�����ļ��д����Ĵ���
		File file1 = new File(realPath1);
		if(!file1.exists()){//��������ⲿ�ִ��룬�����ֶ���WebRoot�д����ļ���
			file1.mkdirs();//�ݹ鴴�����ļ��к͸��ļ���
		}
		//�ӻ����ж�ȡ�ļ����п���
		BufferedInputStream bis1 = new BufferedInputStream(new FileInputStream(img1));
		BufferedOutputStream bos1 = new BufferedOutputStream(new FileOutputStream(realImgPath1));
		IOUtils.copy(bis1, bos1);
		//imgPath=imgPath.replaceAll("/", "\\");
		arc.setSugUrl(imgPath);
		arc.setTzUrl(img1Path);
		zbi.addReport(arc);
		return "success";
	}
	//�޸�
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
