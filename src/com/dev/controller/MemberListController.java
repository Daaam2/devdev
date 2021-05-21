package com.dev.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dev.VO.MemberVO;
import com.dev.service.MemberService;

public class MemberListController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 전체리스트 > memberListOutput.jsp
		// service > DAO
		MemberService service = MemberService.getInstance();
		List<MemberVO> list = service.memberList();
		
		request.setAttribute("list", list);
		RequestDispatcher rd = request.getRequestDispatcher("result/memberListOutput.jsp"); 
		rd.forward(request, response);
	}

}
