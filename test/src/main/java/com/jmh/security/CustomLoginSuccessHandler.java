package com.jmh.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

public class CustomLoginSuccessHandler implements AuthenticationSuccessHandler{

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		System.err.println("CustomLoginSuccessHandler 도착 1");
		List<String> roleNames = new ArrayList<String>();
		
		authentication.getAuthorities().forEach(authrity -> {
			roleNames.add(authrity.getAuthority());
			
		});
		
		CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
        String member_Id = userDetails.getUsername(); // 또는 getMember_Id()
        
        HttpSession session = request.getSession();
        session.setAttribute("member_Id", member_Id);
		
//        if(member_Id != null) {
//        	System.err.println("이미 로그인이 되어있습니다.");
//        	response.sendRedirect("/main");
//        	return;
//        }
        
        if (authentication.isAuthenticated()) {
            // Redirect to a different page
        	System.err.println("이미 로그인이 되어있습니다.");
            response.sendRedirect("/main");
            return;
        }
		
        response.sendRedirect("/login");
	}
}
