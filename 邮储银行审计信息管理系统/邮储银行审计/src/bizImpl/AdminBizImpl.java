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
	//����û�
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
		//ʹ�÷�ҳ��Pager�������
		Pager pager=new Pager();
		//����pager�����е�perPageRows���ԣ���ʾÿҳ��ʾ�ļ�¼��
		pager.setPerPageRows(6);
		//����pager�����е�rowCount���ԣ���ʾ��¼����
		pager.setRowCount(count);
	    //����pager����
		return pager;
	}
	@Override
	public List<Admin> getAdminByCondition(Admin condition, int page) {		
		return adminDao.getAdminByCondition(condition, page);
	}
	//ͳ�Ʒ��ϲ�ѯ��������Ϣ����,��ʼ����ҳ��Pager��������perPageRows��rowCount����
	@Override
	public Pager getPagerOfAdmin(Admin condition) {
		int count= adminDao.getCountOfAdmin(condition);
		//ʹ�÷�ҳ��Pager�������
		Pager pager=new Pager();
		//����pager�����е�perPageRows���ԣ���ʾÿҳ��ʾ�ļ�¼��
		pager.setPerPageRows(6);
		//����pager�����е�rowCount���ԣ���ʾ��¼����
		pager.setRowCount(count);
	    //����pager����
		return pager;
	}
	
	@Override
	public Admin getAdminByAdminId(int marId) {
		return adminDao.getAdminByAdminId(marId);
	}
	
	
	//ɾ��ָ�������Ϣ
	@Override
	public void deleteAdmin(int marId) {		
		Admin arcs=adminDao.getAdminByAdminId(marId);
		adminDao.deleteAdmin(arcs);
	}
	//�޸���Ϣ
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
