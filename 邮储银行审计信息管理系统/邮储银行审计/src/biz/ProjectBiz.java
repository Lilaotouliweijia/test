package biz;

import java.util.List;
import entity.Pager;
import entity.Project;

public interface ProjectBiz {
	//��ȡָ��ҳ��ʾ����Ŀ��Ϣ�б�
	public List<Project> getAllProject(int page);
	//��ȡָ��ҳ��ʾ����Ŀ��Ϣ�б�
	public List<Project> getAllProjectA(int page,Project admin);
	//��ȡ������Ŀ��Ϣ����,������ʼ����ҳ��Pager���󣬲�������perPageRows��rowCount����
	public Pager getPagerOfProject();	
	//���ݲ�ѯ��������ȡָ��ҳ��ʾ����Ŀ��Ϣ�б�
	public List<Project> getProjectByCondition(Project condition,int page);
	//ͳ�Ʒ��ϲ�ѯ�����Ŀͻ���Ϣ����,��ʼ����ҳ��Pager��������perPageRows��rowCount����
	public Pager getPagerOfProject(Project condition);
	//���ݱ�ż�����Ŀ��Ϣ
	public Project getProjectByProjectId(int cusId);
	//�����Ŀ��Ϣ
	public void addProject(Project project);
	//ɾ��ָ�������Ŀ��Ϣ
	public void deleteProject(int arcId);
	//�޸���Ŀ��Ϣ
	public void updateProject(Project project);
}
