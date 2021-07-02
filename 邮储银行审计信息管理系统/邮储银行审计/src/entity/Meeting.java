package entity;

import java.sql.Date;

public class Meeting {
	private int meetingId;
	private Date meetingTime;
	private Admin meetingAdminId;
	private String meetingAdress;
	public int getMeetingId() {
		return meetingId;
	}
	public void setMeetingId(int meetingId) {
		this.meetingId = meetingId;
	}
	
	public Date getMeetingTime() {
		return meetingTime;
	}
	public void setMeetingTime(Date meetingTime) {
		this.meetingTime = meetingTime;
	}
	public Admin getMeetingAdminId() {
		return meetingAdminId;
	}
	public void setMeetingAdminId(Admin meetingAdminId) {
		this.meetingAdminId = meetingAdminId;
	}
	public String getMeetingAdress() {
		return meetingAdress;
	}
	public void setMeetingAdress(String meetingAdress) {
		this.meetingAdress = meetingAdress;
	}
	
}
