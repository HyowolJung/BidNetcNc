package com.jmh.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jmh.service.BoardService;
import com.jmh.vo.BoardVO;

//ResoponseBody , RequestBody ���� , ��� , �� ��� �ϴ� ��
//RequestParam, param, pathVaraiable
//@RequestMapping(value = "createB" , method=RequestMethod.POST)
//���� ������ �ڵ�����
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
	
	@GetMapping("/deleteB")
	public String deleteB(@RequestParam int checkNum) {
		System.out.println("checkNum �� ����?! = " + checkNum);
		int deleteCnt = boardService.delete(checkNum);
		
		if(deleteCnt > 0) {
			System.out.println("���� ����");
			return "board/boardList";
		}else {
			System.out.println("���� ����");
			return "";
		}
	}
	
	@GetMapping("/createB")
	public String createB1() {
		return "board/boardWrite";
	}
	
	@PostMapping("/createB")
	@ResponseBody
	public String createB(BoardVO datas) {
		System.out.println("�޼��� �������");
		System.out.println("datas : " + datas);
		
		String BType = datas.getBType();
		String BTitle = datas.getBTitle();
		String BContent = datas.getBContent();
		
		System.out.println("BType : " + BType);
		System.out.println("BTitle : " + BTitle);
		System.out.println("BContent : " + BContent);
		
		int insertCnt = boardService.insertB(BType, BTitle, BContent);
		if(insertCnt > 0) {
			System.out.println("���� ����");
			return "board/boardList";
		}else {
			System.out.println("���� ����");
			return "";
		}
	}
	
	@GetMapping("/modifyB")
	//@ResponseBody //���Ͽ� ���� ������ �̵� ��ȿȭ
	public String modifyB(@RequestParam int checkNum, Model model) {
		System.out.println("�޼��� �������");
		System.out.println("checkNum : " + checkNum);
		//int checkNum = 1;
		List<BoardVO> boardList = boardService.getModifyList(checkNum);
		System.out.println("����!");
		model.addAttribute("boardList" , boardList);
		System.out.println("����!2");
		//response.setContentType("text/html");
		
		return "board/boardModify";
	}
	
//	@GetMapping("/modifyB")
//	//@ResponseBody ���Ͽ� ���� ������ �̵� ��ȿȭ
//	public String modifyB(@RequestParam int checkNum,  Model model) {
//		System.out.println("�޼��� �������");
//		System.out.println("checkNum : " + checkNum);
//	
//		List<BoardVO> boardList = boardService.getModifyList(checkNum);
//		model.addAttribute("boardList" , boardList);
//		
//		return "board/boardModify";
//	}
	
	@PostMapping("/modifyB")
	public String modifyB() {
		
		return "board/boardList";
	}
}