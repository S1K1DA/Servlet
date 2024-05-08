package kr.co.green.member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import kr.co.green.common.DatabaseConnection;
import kr.co.green.member.model.dto.Member;

public class MemberDAO {
	private Connection con;
	private DatabaseConnection dc;
	private PreparedStatement pstmt;
	
	public MemberDAO() {
		dc = new DatabaseConnection();
		con = dc.connDB();
	}
	
	public int register(Member member) {
		String query = "INSERT INTO member VALUES(member_seq.nextval,?,?,?,default)";
		int result = 0;
		
		try {    // 예외처리 필수
			pstmt = con.prepareStatement(query); 
			pstmt.setString(1, member.getUserName());
			pstmt.setString(2, member.getUserId());
			pstmt.setString(3, member.getUserPwd());
			
			result = pstmt.executeUpdate();
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public Member login(Member member) {
		String query = "SELECT M_NO, M_NAME FROM MEMBER"
				+ "     WHERE M_ID = ?"
				+ "     AND M_PWD = ?";
		Member result = new Member();
				
		try {    // 예외처리 필수
			pstmt = con.prepareStatement(query); 
			pstmt.setString(1, member.getUserId());
			pstmt.setString(2, member.getUserPwd());

			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int userNo = rs.getInt("M_NO");
				String userName =  rs.getString("M_NAME");
				
				result.setUserNo(userNo);
				result.setUserName(userName);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
		
		
	}
	
	
	
	
}
