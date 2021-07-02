package biz;

import java.util.List;
import entity.Pager;
import entity.Project;

public interface ProjectBiz {
	//获取指定页显示的项目信息列表
	public List<Project> getAllProject(int page);
	//获取指定页显示的项目信息列表
	public List<Project> getAllProjectA(int page,Project admin);
	//获取所有项目信息数量,用来初始化分页类Pager对象，并设置其perPageRows和rowCount属性
	public Pager getPagerOfProject();	
	//根据查询条件，获取指定页显示的项目信息列表
	public List<Project> getProjectByCondition(Project condition,int page);
	//统计符合查询条件的客户信息数量,初始化分页类Pager对象，设置perPageRows和rowCount属性
	public Pager getPagerOfProject(Project condition);
	//根据编号加载项目信息
	public Project getProjectByProjectId(int cusId);
	//添加项目信息
	public void addProject(Project project);
	//删除指定编号项目信息
	public void deleteProject(int arcId);
	//修改项目信息
	public void updateProject(Project project);
}
