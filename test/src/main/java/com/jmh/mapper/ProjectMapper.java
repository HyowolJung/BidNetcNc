package com.jmh.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.jmh.dto.Criteria;
import com.jmh.dto.MemberDto;
import com.jmh.dto.ProjectDto;

@Repository
public interface ProjectMapper {

	List<ProjectDto> getProjectList(Criteria cri);

	int getTotalCnt(Criteria cri);

	List<ProjectDto> searchProjectList(Criteria cri);

	boolean checkId(int project_Id);

	boolean checkName(String project_Name);

	int insertProject(ProjectDto insertDatas);

	List<ProjectDto> getModifyList(int project_Id);

	int projectModify(ProjectDto modifyDatas);

	int deleteProject(int project_Id);

	List<Map<String, Object>> getprojectmemberList(int project_Id);

	List<ProjectDto> getFilterd_pro_List(@Param("cri") Criteria cri, @Param("member_Id") int member_Id);
	
	List<ProjectDto> getFilterd_search_pro_List(@Param("cri") Criteria cri, @Param("member_Id") int member_Id);

	//List<ProjectDto> getProjectListWithId(Criteria cri, int member_Id);

}
