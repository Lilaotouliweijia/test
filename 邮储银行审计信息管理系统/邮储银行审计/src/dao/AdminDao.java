package dao;

import java.util.List;

import entity.Admin;
import entity.Project;
/**
 * 操作审计员表的接口类
 * @author Administrator
 *
 */
public interface AdminDao {
	//用户登录验证,并且能用来查找用户名是否已经注册，方便排重，此系统用户名不能重复
	public List<Admin> login(Admin admin);
	//审计员注册
	public void addAdmin(Admin admin);
	//查找所有的用户名，用来排重
	public List<String> getAllAdminName();
	//通过名字查找用户
	public Admin getUser(String adminName);
	//获取指定页显示的管理员列表
	public List<Admin> getAllAdmin(int page);
	//获取指定页显示的管理员信息列表
	public List<Admin> getAllAdminA(int page,Admin admin);
	//统计所有管理员总数
	public Integer getCountOfAllAdmin();
	//根据查询条件，获取指定页显示的管理员列表
	public List<Admin> getAdminByCondition(Admin condition,int page);
	//统计符合查询条件的管理员总数
	public Integer getCountOfAdmin(Admin condition);
	//根据编号加载管理员
	public Admin getAdminByAdminId(int adminId);
	//删除管理员
	public void deleteAdmin(Admin admin);
	//修改管理员对象
	public void updateAdmin(Admin admin);
	//用户该用户的所有项目
	public List<Project> getAllProjectA(Project condition);
}
