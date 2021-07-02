package biz;

import java.util.List;
import entity.Admin;
import entity.Pager;
import entity.Project;

public interface AdminBiz {
	//用户登录验证
	public List<Admin> login(Admin admin);
	//添加用户
	public void addAdmin(Admin admin);
	//查找所有的用户名，用来排重
	public List<String> getAllAdminName();
	//通过名字查找用户
	public Admin getAdmin(String adminName);
	//获取指定页显示的管理员信息列表
	public List<Admin> getAllAdmin(int page);
	//获取指定页显示的管理员信息列表
	public List<Admin> getAllAdminA(int page,Admin admin);
	//获取所有管理员信息数量,用来初始化分页类Pager对象，并设置其perPageRows和rowCount属性
	public Pager getPagerOfAdmin();	
	//根据查询条件，获取指定页显示的管理员信息列表
	public List<Admin> getAdminByCondition(Admin condition,int page);
	//统计符合查询条件的管理员信息数量,初始化分页类Pager对象，设置perPageRows和rowCount属性
	public Pager getPagerOfAdmin(Admin condition);
	//根据编号加载管理员信息
	public Admin getAdminByAdminId(int cusId);
	//删除指定编号管理员信息
	public void deleteAdmin(int arcId);
	//修改管理员信息
	public void updateAdmin(Admin admin);
	//用户该用户的所有项目
	public List<Project> getAllProjectA(Project condition);
}
