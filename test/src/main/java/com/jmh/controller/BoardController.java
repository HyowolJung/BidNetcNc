package com.jmh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jmh.service.BoardService;
import com.jmh.vo.BoardVO;

@Controller
@RequestMapping("/board")
public class BoardController {
	//argument & parameter
	
	//����
	//						������ġ		����Ÿ��					Ư¡
	//����(Local)����			�޼��� ��
	//����(Global)����			�޼��� ��
	//�⺻(Primitive)����					Int, String, Boolean	���ͷ�(Literal)�� �����(stack�� �������� �����)
	//������(Reference)����					new						�ּҰ��� �����(heap�� ��������, stack�� �ּҰ��� �����)
	
	
	@Autowired	//�����?
	private BoardService boardService; //��������
	
	//@RequestMapping("/board")
	@GetMapping("/boardList")
	public String BoardList(Model model) {
		System.out.println("����");
		List<BoardVO> boardList = boardService.getBoardList(); //�������� / List, LinkedList, ArrayList 
		model.addAttribute("boardList", boardList);
		
		return "board/boardList";	//�並 ��ȯ�մϴ�.(���� ��ġ)
	}
	
	//�⺻��(primitive) ����
	//int number = 1;
	
	//������(reference) ����
	//BoardVO vo = new BoardVO();
	//vo.setB_NO(1);
	//int bno = vo.getB_NO();
	//System.out.println("bno : " + bno);
	
}