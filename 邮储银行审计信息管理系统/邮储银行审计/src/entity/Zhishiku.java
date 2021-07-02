package entity;

import java.sql.Timestamp;

public class Zhishiku {
	private int zhiShiId;
	private String shiShiTitle;
	private String zhishiContent;
	private Timestamp publishTime;
	private String author;
	public int getZhiShiId() {
		return zhiShiId;
	}
	public void setZhiShiId(int zhiShiId) {
		this.zhiShiId = zhiShiId;
	}
	public String getShiShiTitle() {
		return shiShiTitle;
	}
	public void setShiShiTitle(String shiShiTitle) {
		this.shiShiTitle = shiShiTitle;
	}
	public String getZhishiContent() {
		return zhishiContent;
	}
	public void setZhishiContent(String zhishiContent) {
		this.zhishiContent = zhishiContent;
	}
	public Timestamp getPublishTime() {
		return publishTime;
	}
	public void setPublishTime(Timestamp publishTime) {
		this.publishTime = publishTime;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
}
