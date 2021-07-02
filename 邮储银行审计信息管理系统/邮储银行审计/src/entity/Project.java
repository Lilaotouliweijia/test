package entity;

import java.sql.Date;
public class Project {
	private int projectId;
	private String  projectName;
	private String  projectContent;
	private Info projectInfo;
	private Admin projectAdmin;
	private String  projectState; 
	private Date startDate;
	private Date endDate;
	private FangAn fangAn;
	private String shenQingUrl;
	private String ifopr;
	private String baseEn;
	private String baseInfo;
	private String baseFz;
	private String baseWay;
	private String ProEn;
	private String ProInfo;
	private String ProFz;
	private String ProWay;
	private String baseUrl;
	private String ProUrl;
	
	public String getBaseUrl() {
		return baseUrl;
	}
	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}
	public String getProUrl() {
		return ProUrl;
	}
	public void setProUrl(String proUrl) {
		ProUrl = proUrl;
	}
	public String getBaseEn() {
		return baseEn;
	}
	public void setBaseEn(String baseEn) {
		this.baseEn = baseEn;
	}
	public String getBaseInfo() {
		return baseInfo;
	}
	public void setBaseInfo(String baseInfo) {
		this.baseInfo = baseInfo;
	}
	public String getBaseFz() {
		return baseFz;
	}
	public void setBaseFz(String baseFz) {
		this.baseFz = baseFz;
	}
	public String getBaseWay() {
		return baseWay;
	}
	public void setBaseWay(String baseWay) {
		this.baseWay = baseWay;
	}
	public String getProEn() {
		return ProEn;
	}
	public void setProEn(String proEn) {
		ProEn = proEn;
	}
	public String getProInfo() {
		return ProInfo;
	}
	public void setProInfo(String proInfo) {
		ProInfo = proInfo;
	}
	public String getProFz() {
		return ProFz;
	}
	public void setProFz(String proFz) {
		ProFz = proFz;
	}
	public String getProWay() {
		return ProWay;
	}
	public void setProWay(String proWay) {
		ProWay = proWay;
	}
	public String getIfopr() {
		return ifopr;
	}
	public void setIfopr(String ifopr) {
		this.ifopr = ifopr;
	}
	public String getShenQingUrl() {
		return shenQingUrl;
	}
	public void setShenQingUrl(String shenQingUrl) {
		this.shenQingUrl = shenQingUrl;
	}
	public FangAn getFangAn() {
		return fangAn;
	}
	public void setFangAn(FangAn fangAn) {
		this.fangAn = fangAn;
	}
	public int getProjectId() {
		return projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getProjectContent() {
		return projectContent;
	}
	public void setProjectContent(String projectContent) {
		this.projectContent = projectContent;
	}
	public Info getProjectInfo() {
		return projectInfo;
	}
	public void setProjectInfo(Info projectInfo) {
		this.projectInfo = projectInfo;
	}
	public Admin getProjectAdmin() {
		return projectAdmin;
	}
	public void setProjectAdmin(Admin projectAdmin) {
		this.projectAdmin = projectAdmin;
	}
	public String getProjectState() {
		return projectState;
	}
	public void setProjectState(String projectState) {
		this.projectState = projectState;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
}
