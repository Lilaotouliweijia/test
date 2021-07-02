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
	private Integer arcId;									//���
	private File img;
	private String imgFileName;//�ļ���  ����  xxxFileName�ĸ�ʽ���з�װ   XXX�����������File��������Ӧ
	private String  imgContentType;//�ļ�����   xxxContentType�ĸ�ʽ��װ
	private String imgPath;//  webӦ������ʾ�ļ���·��    /webapp/xxx�ļ���/�ļ���
	//  webӦ������ʾ�ļ���·��    /webapp/xxx�ļ���/�ļ���
	private ServletContext context;
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
		//marΪ�գ���ʾû��ָ����ѯ��������ʱ����ȡָ��ҳ��ķ�����Ϣ�б�
		if(adminName.equals("admin")){
			arcList=zbi.getAllFangAn(curPage);
		}else{
			Admin admin=abiz.getAdmin(adminName);
			FangAn fan=new FangAn();
			fan.setAdmin(admin);
			arcList=zbi.getAllFangAnA(curPage,fan);
		}
		
		//��ȡ���з�����Ϣ����,������ʼ����ҳ��Pager���󣬲�������perPageRows��rowCount����
		pager=zbi.getPagerOfFangAn();
		//����Pager�����еĴ���ʾҳҳ��
		pager.setCurPage(curPage);
		//����ѯ��õ��б����request��Χ
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
	//����ɾ��֪ͨ�鷴������������ת��toManageMeal
	public String delFangAn() throws Exception {	
		zbi.deleteFangAn(arcId);
		return "success";
	}
	//����
	public String addFaa(){
		String imgName = "file_"+System.currentTimeMillis()+
				imgFileName.substring(imgFileName.lastIndexOf("."));//�����ļ���   ��  file_xxxx.�ļ���׺
		//����webӦ���е�·��
		String path = "������";//�ļ�����
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
	//�޸�
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
