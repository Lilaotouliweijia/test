package biz;

import java.util.List;
import entity.Admin;
import entity.Pager;
import entity.Project;

public interface AdminBiz {
	//�û���¼��֤
	public List<Admin> login(Admin admin);
	//����û�
	public void addAdmin(Admin admin);
	//�������е��û�������������
	public List<String> getAllAdminName();
	//ͨ�����ֲ����û�
	public Admin getAdmin(String adminName);
	//��ȡָ��ҳ��ʾ�Ĺ���Ա��Ϣ�б�
	public List<Admin> getAllAdmin(int page);
	//��ȡָ��ҳ��ʾ�Ĺ���Ա��Ϣ�б�
	public List<Admin> getAllAdminA(int page,Admin admin);
	//��ȡ���й���Ա��Ϣ����,������ʼ����ҳ��Pager���󣬲�������perPageRows��rowCount����
	public Pager getPagerOfAdmin();	
	//���ݲ�ѯ��������ȡָ��ҳ��ʾ�Ĺ���Ա��Ϣ�б�
	public List<Admin> getAdminByCondition(Admin condition,int page);
	//ͳ�Ʒ��ϲ�ѯ�����Ĺ���Ա��Ϣ����,��ʼ����ҳ��Pager��������perPageRows��rowCount����
	public Pager getPagerOfAdmin(Admin condition);
	//���ݱ�ż��ع���Ա��Ϣ
	public Admin getAdminByAdminId(int cusId);
	//ɾ��ָ����Ź���Ա��Ϣ
	public void deleteAdmin(int arcId);
	//�޸Ĺ���Ա��Ϣ
	public void updateAdmin(Admin admin);
	//�û����û���������Ŀ
	public List<Project> getAllProjectA(Project condition);
}
