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
	public List<Project> getProjectByCondition(Project condition, int page) {		
		return faDao.getProjectByCondition(condition, page);
	}
	//统计符合查询条件的信息数量,初始化分页类Pager对象，设置perPageRows和rowCount属性
	@Override
	public Pager getPagerOfProject(Project condition) {
		int count= faDao.getCountOfProject(condition);
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
	public Project getProjectByProjectId(int marId) {
		return faDao.getProjectByProjectId(marId);
	}
	
	//添加信息
	@Override
	public void addProject(Project project) {
		faDao.addProject(project);		
	}
	
	//删除指定编号信息
	@Override
	public void deleteProject(int marId) {		
		Project arcs=faDao.getProjectByProjectId(marId);
		faDao.deleteProject(arcs);
	}
	//修改信息
	@Override
	public void updateProject(Project arcs) {
		faDao.updateProject(arcs);		
	}

}
