package entity;


public class Report {
	private int reportId;
	private String suggest;
	private String content;
	private String guiDang;
	private String sugUrl;
	private String tzUrl;
	
	public String getSugUrl() {
		return sugUrl;
	}
	public void setSugUrl(String sugUrl) {
		this.sugUrl = sugUrl;
	}
	public String getTzUrl() {
		return tzUrl;
	}
	public void setTzUrl(String tzUrl) {
		this.tzUrl = tzUrl;
	}
	public int getReportId() {
		return reportId;
	}
	public void setReportId(int reportId) {
		this.reportId = reportId;
	}
	public String getSuggest() {
		return suggest;
	}
	public void setSuggest(String suggest) {
		this.suggest = suggest;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getGuiDang() {
		return guiDang;
	}
	public void setGuiDang(String guiDang) {
		this.guiDang = guiDang;
	}
	
	
}
