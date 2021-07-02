package entity;

import java.sql.Date;

/**
 * 方案实体类
 * @author Administrator
 *
 */
public class FangAn {
	private int fangAnId;
	private String danWeiName;
	private Project projectId;
	private String shenJiYiJu;
	private Date startTime;
	private Date  endTime;
	private String fangAnContent;
	private String fangUrl;
	private String res;
	private Admin admin;
	
	
	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	public String getRes() {
		return res;
	}
	public void setRes(String res) {
		this.res = res;
	}
	public int getFangAnId() {
		return fangAnId;
	}
	public void setFangAnId(int fangAnId) {
		this.fangAnId = fangAnId;
	}
	public String getDanWeiName() {
		return danWeiName;
	}
	public void setDanWeiName(String danWeiName) {
		this.danWeiName = danWeiName;
	}
	public Project getProjectId() {
		return projectId;
	}
	public void setProjectId(Project projectId) {
		this.projectId = projectId;
	}
	public String getShenJiYiJu() {
		return shenJiYiJu;
	}
	public void setShenJiYiJu(String shenJiYiJu) {
		this.shenJiYiJu = shenJiYiJu;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public String getFangAnContent() {
		return fangAnContent;
	}
	public void setFangAnContent(String fangAnContent) {
		this.fangAnContent = fangAnContent;
	}
	public String getFangUrl() {
		return fangUrl;
	}
	public void setFangUrl(String fangUrl) {
		this.fangUrl = fangUrl;
	}
	
}
