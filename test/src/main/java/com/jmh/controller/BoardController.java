package com.jmh.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jmh.mapper.BoardMapper;
import com.jmh.service.BoardService;
import com.jmh.vo.BoardVO;
import com.jmh.vo.Criteria;
import com.jmh.vo.PageDto;

//ResoponseBody , RequestBody ���� , ��� , �� ��� �ϴ� ��
//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
//RequestParam, param, pathVaraiable
//@RequestMapping(value = "createB" , method=RequestMethod.POST)
//���� ����
//����ȿ�� �˻� ������ ���ߡ�
//1. sql ������ �� ���� + �빮�ڷ�
//2. �پ��ϰ�
//3. Ÿ����?
// ���ѹ�ȣ(������, ���)�� ���� ������� �ϴ� ���̵�ٿ� �ִ� �޴�(�ٵ�)�� �ٸ���, 
// 1. ���ǿ� �����ؼ� ��������(���Ѿ��̵�=#{01})�� �̿��ϰų�, 
// 2. jsp �������� jstl(c:if when)�� �̿��������� 
// �ٸ� ����� ã�� �����غ�����.
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
//	@GetMapping("/boardList")
//	public String BoardList(Model model) {
//		System.out.println("����");
//		List<BoardVO> boardList = boardService.getBoardList(); //�������� / List, LinkedList, ArrayList 
//		model.addAttribute("boardList", boardList);
//		
//		return "board/boardList";	//�並 ��ȯ�մϴ�.(���� ��ġ)
//	}
	
	@GetMapping("/boardList")
	public String BoardList(Model model, Criteria cri, int numberSearch) {
//		if(numberSearch = null) {
//			
//			
//		}
//		if (numberSearch != null) {
//			
//		}
		numberSearch = 1;
		System.out.println("����");
		System.out.println("numberSearch : " + numberSearch);
		List<BoardVO> boardList = boardService.getBoardList(cri, numberSearch); //�������� / List, LinkedList, ArrayList 
		//List<BoardVO> boardList = boardService.getBoardList(cri); 
		
		int totalCnt = boardService.getTotalCnt(cri);
		PageDto pageDto = new PageDto(cri, totalCnt);
		
		model.addAttribute("pageDto", pageDto);
		model.addAttribute("totalCnt", totalCnt);
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
	//@ResponseBody
	public String insertB(BoardVO datas) {
		System.out.println("�޼��� �������");
		System.out.println("datas : " + datas);
		
		String BType = datas.getBType();
		String BTitle = datas.getBTitle();
		String BContent = datas.getBContent();
		
		//System.out.println("BType : " + BType);
		//System.out.println("BTitle : " + BTitle);
		//System.out.println("BContent : " + BContent);
		
		int insertCnt = boardService.insertB(BType, BTitle, BContent);
		if(insertCnt > 0) {
			System.out.println("���� ����");
			return "board/boardList";
		}else {
			System.out.println("���� ����");
			return "";
		}
	}
	
//	@PostMapping("/modifyB")
//	//@ResponseBody //���Ͽ� ���� ������ �̵� ��ȿȭ
//	public String modifyB(@RequestBody int checkNum, Model model) {
//		System.out.println("�޼��� �������");
//		System.out.println("checkNum : " + checkNum);
//		//int checkNum = 1;
//		List<BoardVO> boardList = boardService.getModifyList(checkNum);
//		System.out.println("����!");
//		model.addAttribute("boardList" , boardList);
//		System.out.println("����!2");
//		//response.setContentType("text/html");
//		
//		return "board/boardModify";
//	}
	
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
	
	@GetMapping("/modifyB")
	public String modifyB(@RequestParam("bno") int bno, Model model) { /*@RequestParam int bno*/
		System.out.println("���� + ���� : " + bno);
		//List<BoardVO> boardList = boardService.getModifyList(bno);
		//System.out.println("boardList + " + boardList);
		//model.addAttribute("boardList" , boardList);
		model.addAttribute("boardList" ,boardService.getModifyList(bno));
		System.out.println("boardList + " + boardService.getModifyList(bno));
		System.out.println("����  + ���� : " + bno );
		return "board/boardModify";
	}
	
	@PostMapping("/modifyB")
	public String modifyB(BoardVO datas) {
		System.out.println("�޼��� �������");
		System.out.println("datas : " + datas);
		
		int BNO = datas.getBNO();
		String BType = datas.getBType();
		String BTitle = datas.getBTitle();
		String BContent = datas.getBContent();
		
		int modifyCnt = boardService.modifyB(BNO, BType, BTitle, BContent);
		if(modifyCnt > 0) {
			System.out.println("���� ����");
			return "board/boardList";
		}else {
			System.out.println("���� ����");
			return "";
		}
	}
}