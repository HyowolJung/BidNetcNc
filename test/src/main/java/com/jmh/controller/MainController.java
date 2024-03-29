package com.jmh.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jmh.dto.MemberDto;
import com.jmh.service.MemberService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MainController {
	
	@Autowired
	MemberService memberService;
	
	@GetMapping("/header")
	public String header(HttpSession session, Model model) {
		model.addAttribute("memberId" , session.getAttribute("memberId"));
		return "/common/header";
	}
	
	@GetMapping("/myPage")
	public String myPage() {
		return "/myPage";
	}
	
	@GetMapping("/main")
	public String main(HttpSession session, Model model, String memberId) {
		model.addAttribute("memberDept" , session.getAttribute("memberDept"));
		model.addAttribute("memberId", session.getAttribute("memberId"));
		//model.addAttribute("member_Department" , "인사부");
		return "/main";
	}
	
	@PostMapping("/main")
	public String main2(HttpSession session, Model model, String memberId) {
		model.addAttribute("memberDept" , session.getAttribute("memberDept"));
		model.addAttribute("memberId", session.getAttribute("memberId"));
		//model.addAttribute("member_Department" , "인사부");
		return "/main";
	}
	
	@GetMapping("/success")
	public String success() {
		return "/success";	
	}
	
	@GetMapping("/error")
	public void error() {}
	
	@PostMapping("/error")
	public void error2() {}
	
	@GetMapping("/login")
	public void login() {}
	
	@PostMapping("/logout")
	public void logout() {}
	
	
//	@GetMapping("/login")
//	public String login(Model model , CsrfToken csrfToken) {
//		model.addAttribute("_csrf", csrfToken);
//		return "/login";	
//	}
//	
//	@PostMapping("/login")
//	@ResponseBody
//	public List<MemberDto> memberLogin(int member_Id, String member_Pw, HttpSession session, MemberDto dto, Model model) {
//		session.setAttribute("member_Id", dto.getMember_Id());
//		
//		//List<MemberDto> loginCk = memberService.loginCk(member_Id, member_Pw);
//		//return loginCk;
//		boolean isValid = false;
//		List<MemberDto> loginCk = null;
//		
//		String member_Pw_ck = memberService.getmember_Pw(member_Id);
//		System.err.println("member_Pw : " + member_Pw);
//		System.err.println("member_Pw_ck : " + member_Pw_ck);
//		if(member_Pw_ck != null) {
//			System.err.println("member_Pw_ck : " + member_Pw_ck);
//			isValid = BCrypt.checkpw(member_Pw, member_Pw_ck);
//			System.err.println("isValid : " + isValid);
//			
//			if(isValid == true) {
//				System.err.println("isValid TRUE 진입");
//				ModelAndView mav = new ModelAndView();
//				mav.setViewName("/common/header");
//				mav.addObject("member_Id", session.getAttribute("member_Id"));
//				
//				loginCk = memberService.loginCk(member_Id, member_Pw_ck);
//				MemberDto loginCk_member_Department = loginCk.get(0);
//				String member_Department = loginCk_member_Department.getMember_Department();
//				session.setAttribute("member_Department" , member_Department);
//				
//				System.err.println("loginCk 일치합니다. : " + loginCk);
//				return loginCk; 
//			}
//			
//			if(isValid == false) {
//				System.out.println("loginCk 비밀번호 불일치 : " + loginCk);
//				return loginCk;
//			}
//			
//		}
//		return null;
//	}
}	
//	@GetMapping("/logout")
//	public String memberLogout(HttpServletRequest request) {
//		HttpSession session = request.getSession();
//		session.invalidate();
//		System.out.println("logout)session : " + session);
//		return "redirect:/login";
//	}
//}

//List<MemberDto> loginCk = memberService.loginCk(member_Id, member_Pw);
//if(loginCk != null) {
//	session.setAttribute("member_Id", dto.getMember_Id());
//	mav.setViewName("/common/header");
//	mav.addObject("member_Id", session.getAttribute("member_Id"));
//	model.addAttribute("loginCk" , loginCk);
//	//System.out.println("loginCk : " + loginCk);
//	//return "redirect:/main";
//	return "redirect:/main";
//}
//return "/login";
