package com.dev.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dev.VO.MemberVO;
import com.dev.service.MemberService;

public class MemberUpdateController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 입력정보를 받아와서 수정처리 후 memberUpdateOutput.jsp 로 결과 보내줌!
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		String mail = request.getParameter("mail");
		
		MemberVO member = new MemberVO();
		member.setId(id);
		member.setPwd(pwd);
		member.setName(name);
		member.setMail(mail);
		
		MemberService service = MemberService.getInstance();
		service.memberUpdate(member);
		
		request.setAttribute("member", member);
		
		RequestDispatcher rd = request.getRequestDispatcher("result/memberUpdateOutput.jsp");
		rd.forward(request, response);
	}

}
