package kr.co.test.member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import kr.co.test.common.DatabaseConnection;
import kr.co.test.member.model.dto.MemberDTO;

public class MemberDAO {
	private Connection con;
	private DatabaseConnection dc;
	private PreparedStatement pstmt;
	
	public MemberDAO() {
		dc = new DatabaseConnection();
		con = dc.connDB();
	}
	
	public int register(MemberDTO memberDTO) {
		String query = "INSERT INTO Users VALUES(member_seq.nextval,?,?,?,?,?)";
		int result = 0;
		
		try {    // 예외처리 필수
			pstmt = con.prepareStatement(query); 
			pstmt.setString(1, memberDTO.getName());
			pstmt.setString(2, memberDTO.getEmail());
			pstmt.setString(3, memberDTO.getPassword());
			pstmt.setString(4, memberDTO.getBirthdate());
			pstmt.setString(5, memberDTO.getAddress());
			
			result = pstmt.executeUpdate();
			pstmt.close();
			con.close();
			return result;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
	}
	
}


