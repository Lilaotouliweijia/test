package dao;

import java.util.List;

import entity.Admin;
import entity.Project;
/**
 * �������Ա��Ľӿ���
 * @author Administrator
 *
 */
public interface AdminDao {
	//�û���¼��֤,���������������û����Ƿ��Ѿ�ע�ᣬ�������أ���ϵͳ�û��������ظ�
	public List<Admin> login(Admin admin);
	//���Աע��
	public void addAdmin(Admin admin);
	//�������е��û�������������
	public List<String> getAllAdminName();
	//ͨ�����ֲ����û�
	public Admin getUser(String adminName);
	//��ȡָ��ҳ��ʾ�Ĺ���Ա�б�
	public List<Admin> getAllAdmin(int page);
	//��ȡָ��ҳ��ʾ�Ĺ���Ա��Ϣ�б�
	public List<Admin> getAllAdminA(int page,Admin admin);
	//ͳ�����й���Ա����
	public Integer getCountOfAllAdmin();
	//���ݲ�ѯ��������ȡָ��ҳ��ʾ�Ĺ���Ա�б�
	public List<Admin> getAdminByCondition(Admin condition,int page);
	//ͳ�Ʒ��ϲ�ѯ�����Ĺ���Ա����
	public Integer getCountOfAdmin(Admin condition);
	//���ݱ�ż��ع���Ա
	public Admin getAdminByAdminId(int adminId);
	//ɾ������Ա
	public void deleteAdmin(Admin admin);
	//�޸Ĺ���Ա����
	public void updateAdmin(Admin admin);
	//�û����û���������Ŀ
	public List<Project> getAllProjectA(Project condition);
}
