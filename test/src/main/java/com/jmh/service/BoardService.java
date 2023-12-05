package com.jmh.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.jmh.vo.BoardVO;
import com.jmh.vo.Criteria;

@Service
public interface BoardService {

	//1. ��ȸ
	public List<BoardVO> getBoardList(@Param("cri") Criteria cri, @Param("numberSearch") int numberSearch);
	//public List<BoardVO> getBoardList(Criteria cri);
	
	//2. ����
	public int delete(int checkNum);

	//3. ����
	public int insertB(@Param("BType") String BType, @Param("BTitle") String BTitle, @Param("BContent") String BContent);

	//4. ��
	public List<BoardVO> getModifyList(int bno);
	
	//5. ����
	public int modifyB(@Param("BNO") int BNO, @Param("BType") String BType, @Param("BTitle") String BTitle, @Param("BContent") String BContent);

	public int getTotalCnt(Criteria cri);

}
