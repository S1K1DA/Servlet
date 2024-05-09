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
		String query = "INSERT INTO example_member VALUES(example_member_seq.nextval,?,?,?,?,default)";
		int result = 0;
		
		try {    // 예외처리 필수
			pstmt = con.prepareStatement(query); 
			pstmt.setString(1, member.getUserfirstName());
			pstmt.setString(2, member.getUserlastName());
			pstmt.setString(3, member.getUserEmail());
			pstmt.setString(4, member.getUserPwd());
			
			result = pstmt.executeUpdate();
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public Member login(Member member) {
		String query = "SELECT E_NO, M_FIRST_NAME, E_LAST_NAME FROM EXAMPLE_MEMBER"
				+ "     WHERE E_EMAIL = ?"
				+ "     AND E_PWD = ?";
		Member result = new Member();
				
		try {    // 예외처리 필수
			pstmt = con.prepareStatement(query); 
			pstmt.setString(1, member.getUserEmail());
			pstmt.setString(2, member.getUserPwd());

			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int userNo = rs.getInt("E_NO");
				String userfirstName =  rs.getString("M_FIRST_NAME");
				String userlastName =  rs.getString("E_LAST_NAME");
				
				result.setUserNo(userNo);
				result.setUserfirstName(userfirstName);
				result.setUserlastName(userlastName);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
		
		
	}
	
	
	
	
	
}