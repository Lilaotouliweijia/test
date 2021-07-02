package bizImpl;

import java.util.List;
import biz.ProjectBiz;
import dao.ProjectDao;
import entity.Pager;
import entity.Project;

public class ProjectBizImpl implements ProjectBiz{
	private ProjectDao faDao;
	
	public ProjectDao getFaDao() {
		return faDao;
	}
	
	public void setFaDao(ProjectDao faDao) {
		this.faDao = faDao;
	}

	@Override
	public List<Project> getAllProject(int page) {
		return faDao.getAllProject(page);
	}
	public List<Project> getAllProjectA(int page,Project admin){
		return faDao.getAllProjectA(page,admin);
	}
	
	@Override
	public Pager getPagerOfProject() {
		int count= faDao.getCountOfAllProject();
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
	public List<Project> getProjectByCondition(Project condition, int page) {		
		return faDao.getProjectByCondition(condition, page);
	}
	//ͳ�Ʒ��ϲ�ѯ��������Ϣ����,��ʼ����ҳ��Pager��������perPageRows��rowCount����
	@Override
	public Pager getPagerOfProject(Project condition) {
		int count= faDao.getCountOfProject(condition);
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
	public Project getProjectByProjectId(int marId) {
		return faDao.getProjectByProjectId(marId);
	}
	
	//�����Ϣ
	@Override
	public void addProject(Project project) {
		faDao.addProject(project);		
	}
	
	//ɾ��ָ�������Ϣ
	@Override
	public void deleteProject(int marId) {		
		Project arcs=faDao.getProjectByProjectId(marId);
		faDao.deleteProject(arcs);
	}
	//�޸���Ϣ
	@Override
	public void updateProject(Project arcs) {
		faDao.updateProject(arcs);		
	}

}
