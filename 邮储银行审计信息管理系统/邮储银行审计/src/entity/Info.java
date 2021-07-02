package entity;

import java.sql.Timestamp;

public class Info {
	private int infoId;
	private String infoTitle;
	private Timestamp  infoTime;
	private String forBook;
	private String forBookUrl;
	private String state;
	private Project project;
	
	
	public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getInfoId() {
		return infoId;
	}
	public void setInfoId(int infoId) {
		this.infoId = infoId;
	}
	public String getInfoTitle() {
		return infoTitle;
	}
	public void setInfoTitle(String infoTitle) {
		this.infoTitle = infoTitle;
	}
	public Timestamp getInfoTime() {
		return infoTime;
	}
	public void setInfoTime(Timestamp infoTime) {
		this.infoTime = infoTime;
	}
	public String getForBook() {
		return forBook;
	}
	public void setForBook(String forBook) {
		this.forBook = forBook;
	}
	public String getForBookUrl() {
		return forBookUrl;
	}
	public void setForBookUrl(String forBookUrl) {
		this.forBookUrl = forBookUrl;
	}
	
}
