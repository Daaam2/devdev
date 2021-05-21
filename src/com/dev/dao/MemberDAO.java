package com.dev.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.dev.VO.MemberVO;

public class MemberDAO {
	Connection conn;
	PreparedStatement psmt;
	ResultSet rs;
	
	private static MemberDAO dao = new MemberDAO();
	private MemberDAO() {
	}
	public static MemberDAO getInstance() {
		return dao;
	}
	
	// 연결처리 Connection 객체
	private void connect() {
		try {
			InitialContext ic = new InitialContext();
			DataSource ds = (DataSource) ic.lookup("java:comp/env/jdbc/myoracle");
			conn = ds.getConnection();			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// resource 반환
	private void close() {
		if(rs!=null)
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		if(psmt!=null)
			try {
				psmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		if(conn!=null)
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	
	// 한건 조회 
	public MemberVO ShearchMember(String id) {
		connect();
		String sql = "SELECT * FROM MEMBER_B WHERE ID=?";
		MemberVO member = null;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			if(rs.next()) {
				member = new MemberVO();
				member.setId(rs.getString("id"));
				member.setPwd(rs.getString("pwd"));
				member.setName(rs.getString("name"));
				member.setMail(rs.getString("mail"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return member;
	}
	
	
	// Insert DB 처리기능
	public void insertMember(MemberVO member) {
		connect();
		String sql = "INSERT INTO MEMBER_B(ID, PWD, NAME, MAIL) VALUES(?,?,?,?)";
		try {  // 쿼리실행, 받아보기객체 
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, member.getId());
			psmt.setString(2, member.getPwd());
			psmt.setString(3, member.getName());
			psmt.setString(4, member.getMail());
			int r = psmt.executeUpdate();
			System.out.println(r + "건 입력성공!");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}
	
	// 수정
	public void UpdateMember(MemberVO member) {
		connect();
		String sql = "update member_b set pwd=?, name=?, mail=? where id=? ";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, member.getPwd());
			psmt.setString(2, member.getName());
			psmt.setString(3, member.getMail());
			psmt.setString(4, member.getId());
			int r = psmt.executeUpdate();
			System.out.println(r +"건 입력완료");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}	
	
	// 삭제
	public void daleteMember(String id) {
		
		System.out.println(id);
		connect();
		String sql = "delete from member_b where id=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			int r = psmt.executeUpdate();
			System.out.println(r + "건 삭제");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}
	
	// 전체목록
	public List<MemberVO> listMember () {
		connect();
		String sql = "select * from member_b order by 1";
		List<MemberVO> memberList = new ArrayList<>();
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				MemberVO member = new MemberVO();
				member.setId(rs.getString("id"));
				member.setPwd(rs.getString("pwd"));
				member.setName(rs.getString("name"));
				member.setMail(rs.getString("mail"));
				memberList.add(member);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return memberList;
	}
	
}
