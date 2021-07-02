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

import biz.XcsjBiz;

import com.opensymphony.xwork2.ActionSupport;
import entity.Pager;
import entity.Xcsj;



public class XcsjAction extends ActionSupport implements RequestAware,SessionAware,ServletContextAware{
	private static final long serialVersionUID = 1L;
	private Pager pager;
	private Xcsj arc=new Xcsj();
	private XcsjBiz zbi;
	private Integer arcId;									//���
	private File img;//�����ļ�����   ���������ύ����ʱ����ı���name��������Ӧ    struts2�����������Զ�������ļ�����
	private String imgFileName;//�ļ���  ����  xxxFileName�ĸ�ʽ���з�װ   xxx�����������File��������Ӧ
	private String  imgContentType;//�ļ�����   xxxContentType�ĸ�ʽ��װ
	private String imgPath;//  webӦ������ʾ�ļ���·��    /webapp/xxx�ļ���/�ļ���
	//  webӦ������ʾ�ļ���·��    /webapp/xxx�ļ���/�ļ���
	private ServletContext context;
	
	public ServletContext getContext() {
		return context;
	}

	public void setContext(ServletContext context) {
		this.context = context;
	}

	@Override
	public void setServletContext(ServletContext context) {
		this.context = context;
	}

	public String getRealPath(String path){
		return context.getRealPath(path);//   ת����webӦ�������ļ�ϵͳ��·��
	}
	public Integer getArcId() {
		return arcId;
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
	public void setArcId(Integer arcId) {
		this.arcId = arcId;
	}
	public Xcsj getArc() {
		return arc;
	}
	public void setArc(Xcsj arc) {
		this.arc = arc;
	}
	public XcsjBiz getZbi() {
		return zbi;
	}
	public void setZbi(XcsjBiz zbi) {
		this.zbi = zbi;
	}
	public Pager getPager() {
		return pager;
	}
	public void setPager(Pager pager) {
		this.pager = pager;
	}

	
	public String xcAll(){
		int curPage=1;
		if(pager!=null)
			curPage=pager.getCurPage();
		List<Xcsj> arcList=null;		
		//marΪ�գ���ʾû��ָ����ѯ��������ʱ����ȡָ��ҳ��ķ�����Ϣ�б�
		arcList=zbi.getAllXcsj(curPage);
		//��ȡ���з�����Ϣ����,������ʼ����ҳ��Pager���󣬲�������perPageRows��rowCount����
		pager=zbi.getPagerOfXcsj();
		//����Pager�����еĴ���ʾҳҳ��
		pager.setCurPage(curPage);
		//����ѯ��õ��б����request��Χ
		request.put("arcList", arcList);
		if(arcList.size()!=0){
			if(arcId==null){
				arc=zbi.getXcsjByXcsjId(arcList.get(0).getXcSheJ());
			}else{
				arc=zbi.getXcsjByXcsjId(arcId);
			}
		}
		request.put("arc", arc);
		return "success";
	}
	//����ɾ��֪ʶ�ⷴ������������ת��toManageMeal
	public String delxc() throws Exception {	
		zbi.deleteXcsj(arcId);
		return "success";
	}
	//����
	public String addxc() throws Exception{
		String imgName = "file_"+System.currentTimeMillis()+
				imgFileName.substring(imgFileName.lastIndexOf("."));//�����ļ���   ��  file_xxxx.�ļ���׺
		//����webӦ���е�·��
		String path = "�ֳ����㱨��";//�ļ�����
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
		arc.setUrl(imgPath);
		zbi.addXcsj(arc);
		return "success";
	}
	//�޸�
	public String modifyxc(){
		zbi.updateXcsj(arc);
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
