package dao;

import java.util.List;

import entity.Project;

public interface ProjectDao {
	//获取指定页显示的项目列表
	public List<Project> getAllProject(int page);
	//获取指定页显示的项目信息列表
	public List<Project> getAllProjectA(int page,Project admin);
	//统计所有客户总数
	public Integer getCountOfAllProject();
	//根据查询条件，获取指定页显示的项目列表
	public List<Project> getProjectByCondition(Project condition,int page);
	//统计符合查询条件的项目总数
	public Integer getCountOfProject(Project condition);
	//根据编号加载项目
	public Project getProjectByProjectId(int projectId);
	//添加项目
	public void addProject(Project project);
	//删除项目
	public void deleteProject(Project project);
	//修改项目对象
	public void updateProject(Project project);
}
