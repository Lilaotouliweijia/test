package dao;

import java.util.List;

import entity.Project;

public interface ProjectDao {
	//��ȡָ��ҳ��ʾ����Ŀ�б�
	public List<Project> getAllProject(int page);
	//��ȡָ��ҳ��ʾ����Ŀ��Ϣ�б�
	public List<Project> getAllProjectA(int page,Project admin);
	//ͳ�����пͻ�����
	public Integer getCountOfAllProject();
	//���ݲ�ѯ��������ȡָ��ҳ��ʾ����Ŀ�б�
	public List<Project> getProjectByCondition(Project condition,int page);
	//ͳ�Ʒ��ϲ�ѯ��������Ŀ����
	public Integer getCountOfProject(Project condition);
	//���ݱ�ż�����Ŀ
	public Project getProjectByProjectId(int projectId);
	//�����Ŀ
	public void addProject(Project project);
	//ɾ����Ŀ
	public void deleteProject(Project project);
	//�޸���Ŀ����
	public void updateProject(Project project);
}
