package bizImpl;

import java.util.List;

import biz.AdminBiz;
import dao.AdminDao;
import entity.Admin;
import entity.Pager;
import entity.Project;

public class AdminBizImpl implements AdminBiz{
	AdminDao adminDao;
	
	public void setAdminDao(AdminDao adminDao) {
		this.adminDao = adminDao;
	}
	public List<Admin> login(Admin admin) {
		return adminDao.login(admin);
	}
	//添加用户
	public void addAdmin(Admin admin){
		adminDao.addAdmin(admin);
	}
	@Override
	public List<String> getAllAdminName() {
		// TODO Auto-generated method stub
		return adminDao.getAllAdminName();
	}
	@Override
	public Admin getAdmin(String adminName) {
		// TODO Auto-generated method stub
		return adminDao.getUser(adminName);
	}
	
	@Override
	public List<Admin> getAllAdmin(int page) {
		return adminDao.getAllAdmin(page);
	}
	public List<Admin> getAllAdminA(int page,Admin admin){
		return adminDao.getAllAdminA(page,admin);
	}
	
	@Override
	public Pager getPagerOfAdmin() {
		int count= adminDao.getCountOfAllAdmin();
		//使用分页类Pager定义对象
		Pager pager=new Pager();
		//设置pager对象中的perPageRows属性，表示每页显示的记录数
		pager.setPerPageRows(6);
		//设置pager对象中的rowCount属性，表示记录总数
		pager.setRowCount(count);
	    //返回pager对象
		return pager;
	}
	@Override
	public List<Admin> getAdminByCondition(Admin condition, int page) {		
		return adminDao.getAdminByCondition(condition, page);
	}
	//统计符合查询条件的信息数量,初始化分页类Pager对象，设置perPageRows和rowCount属性
	@Override
	public Pager getPagerOfAdmin(Admin condition) {
		int count= adminDao.getCountOfAdmin(condition);
		//使用分页类Pager定义对象
		Pager pager=new Pager();
		//设置pager对象中的perPageRows属性，表示每页显示的记录数
		pager.setPerPageRows(6);
		//设置pager对象中的rowCount属性，表示记录总数
		pager.setRowCount(count);
	    //返回pager对象
		return pager;
	}
	
	@Override
	public Admin getAdminByAdminId(int marId) {
		return adminDao.getAdminByAdminId(marId);
	}
	
	
	//删除指定编号信息
	@Override
	public void deleteAdmin(int marId) {		
		Admin arcs=adminDao.getAdminByAdminId(marId);
		adminDao.deleteAdmin(arcs);
	}
	//修改信息
	@Override
	public void updateAdmin(Admin arcs) {
		adminDao.updateAdmin(arcs);		
	}
	@Override
	public List<Project> getAllProjectA(Project condition) {
		// TODO Auto-generated method stub
		return adminDao.getAllProjectA(condition);
	}
}
