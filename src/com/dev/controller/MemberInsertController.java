package com.dev.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dev.VO.MemberVO;
import com.dev.service.MemberService;

public class MemberInsertController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 신규회원 등록기능 > 결과리턴 (memberInsertOutput.jsp)
		
		// 입력파라메터 읽어옴
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		String mail = request.getParameter("mail");
		// 읽어온 값을 객채로 만듬!
		MemberVO member = new MemberVO();
		member.setId(id);
		member.setPwd(pwd);
		member.setName(name);
		member.setMail(mail);
		
		// 서비스로직 호출
		MemberService service = MemberService.getInstance();
		service.memberInsert(member);
		
		request.setAttribute("member", member);
		
		RequestDispatcher rd = request.getRequestDispatcher("result/memberInsertOutput.jsp");
		rd.forward(request, response);
	}

}
