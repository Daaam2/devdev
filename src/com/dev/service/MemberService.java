package com.dev.service;

import java.util.List;

import com.dev.VO.MemberVO;
import com.dev.dao.MemberDAO;

public class MemberService {
	// 입력, 수정, 삭제, 조회, 리스트
	
	private static MemberService service = new MemberService();
	MemberDAO dao = MemberDAO.getInstance();
	private MemberService() {
	}
	public static MemberService getInstance() {
		return service;
	}

	
	// 입력
	public void memberInsert(MemberVO member) {
		dao.insertMember(member);
	}
	
	// 한건조회
	public MemberVO memberSearch(String id) {
		return dao.ShearchMember(id);
	}
	
	// 수정
	public void memberUpdate(MemberVO member) {
		dao.UpdateMember(member);
	}
	
	//삭제
	public void memberDelete(String id) {
		dao.daleteMember(id);
	}
	
	//리스트
	public List<MemberVO> memberList() {
		return dao.listMember();
	}
	
}
