package com.jmh.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jmh.dto.Criteria;
import com.jmh.dto.MemberDto;
import com.jmh.dto.ProjectDetailDto;
import com.jmh.dto.ProjectDto;
import com.jmh.mapper.ProjectMapper;

@Service
public class ProjectServiceImpl implements ProjectService{

	@Autowired
	ProjectMapper projectMapper;
	
	@Override
	public List<ProjectDto> getProjectList(Criteria cri) {
		// TODO Auto-generated method stub
		return projectMapper.getProjectList(cri);
	}

	@Override
	public int getTotalCntPop(@Param("cri") Criteria cri, @Param("member_Id") int member_Id) {
		// TODO Auto-generated method stub
		return projectMapper.getTotalCntPop(cri, member_Id);
	}

	@Override
	public int getTotalCnt(Criteria cri) {
		// TODO Auto-generated method stub
		return projectMapper.getTotalCnt(cri);
	}
	
	@Override
	public List<ProjectDto> searchProjectList(Criteria cri) {
		// TODO Auto-generated method stub
		return projectMapper.searchProjectList(cri);
	}

	@Override
	public boolean checkId(int project_Id) {
		// TODO Auto-generated method stub
		return projectMapper.checkId(project_Id);
	}

	@Override
	public boolean checkName(String project_Name) {
		// TODO Auto-generated method stub
		return projectMapper.checkName(project_Name);
	}

	@Override
	public int insertProject(ProjectDto insertDatas) {
		// TODO Auto-generated method stub
		return projectMapper.insertProject(insertDatas);
	}

	@Override
	public List<ProjectDto> getModifyList(int project_Id) {
		// TODO Auto-generated method stub
		return projectMapper.getModifyList(project_Id);
	}

	@Override
	public int projectModify(ProjectDto modifyDatas) {
		// TODO Auto-generated method stub
		return projectMapper.projectModify(modifyDatas);
	}

//	@Override
//	public int deleteProject(int project_Id) {
//		// TODO Auto-generated method stub
//		return projectMapper.deleteProject(project_Id);
//	}

	@Override
	public List<MemberDto> getprojectmemberList(int project_Id) {
		// TODO Auto-generated method stub
		return projectMapper.getprojectmemberList(project_Id);
	}

	@Override
	public List<ProjectDto> getFilterd_pro_List(Criteria cri, int member_Id) {
		// TODO Auto-generated method stub
		return projectMapper.getFilterd_pro_List(cri, member_Id);
	}

	@Override
	public List<ProjectDto> getFilterd_search_pro_List(Criteria cri, int member_Id) {
		// TODO Auto-generated method stub
		return projectMapper.getFilterd_search_pro_List(cri, member_Id);
	}

	@Override
	public int projectModify2(Map<String, Object> resultMap) {
		// TODO Auto-generated method stub
		return projectMapper.projectModify2(resultMap);
	}

	@Override
	public int projectDelete2(Map<String, Object> resultMap) {
		// TODO Auto-generated method stub
		return projectMapper.projectDelete2(resultMap);
	}

	@Override
	public int deleteProject(List<String> checkList) {
		// TODO Auto-generated method stub
		return projectMapper.deleteProject(checkList);
	}

	@Override
	public ArrayList<String> deleteProjectCheck(List<String> checkList) {
		// TODO Auto-generated method stub
		return projectMapper.deleteProjectCheck(checkList);
	}

	@Override
	public int insertTest1(String data1) {
		// TODO Auto-generated method stub
		return projectMapper.insertTest1(data1);
	}

	@Override
	public int insertTest2(String data2) {
		// TODO Auto-generated method stub
		return projectMapper.insertTest2(data2);
	}

	

//	@Override
//	public List<ProjectDto> getProjectListWithId(Criteria cri, int member_Id) {
//		// TODO Auto-generated method stub
//		return projectMapper.getProjectListWithId(cri, member_Id);
//	}

}
