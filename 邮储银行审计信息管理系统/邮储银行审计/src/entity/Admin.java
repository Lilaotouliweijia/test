package entity;


/**
 * 管理员实体类
 * @author Administrator
 *
 */
public class Admin {
	private int adminId;
	private String adminName;
	private String adminPass;
	private String adminType;
	private String adminPic;
	private Project project;
	
	public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
	}
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getAdminPass() {
		return adminPass;
	}
	public void setAdminPass(String adminPass) {
		this.adminPass = adminPass;
	}
	public String getAdminType() {
		return adminType;
	}
	public void setAdminType(String adminType) {
		this.adminType = adminType;
	}
	public String getAdminPic() {
		return adminPic;
	}
	public void setAdminPic(String adminPic) {
		this.adminPic = adminPic;
	}
	
}
