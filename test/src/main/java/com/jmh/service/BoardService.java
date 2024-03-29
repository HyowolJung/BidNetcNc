package com.jmh.service;

import java.util.List;

import com.jmh.dto.BoardDto;

public interface BoardService {
	
	//1. 자유게시글 목록 불러오기
	List<BoardDto> getFreeBoardList();
	
	//2. 게시글 등록
	int insertBoard(BoardDto boardForm);

	//3. 특정 자유게시글 목록 가져오기
	List<BoardDto> selectFreeBoardList(String board_Title);

	

}
