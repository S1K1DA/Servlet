package kr.co.green.contact.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import kr.co.green.common.DatabaseConnection;
import kr.co.green.contact.model.dto.ContactDto;

public class ContactDao {
	private Connection con;
	private DatabaseConnection dc;
	private PreparedStatement pstmt;
	
	public ContactDao() {
		dc = new DatabaseConnection();
		con = dc.connDB();
	}
	
	
	public int enroll(ContactDto contactDto) {
		String query = "INSERT INTO contact VALUES(contact_seq.nextval, ?, ?, ?, default, default, ?)";
		int result = 0;
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, contactDto.getName());
			pstmt.setString(2, contactDto.getMessage());
			pstmt.setString(3, contactDto.getEmail());
			pstmt.setInt(4, contactDto.getMemberNo());
			
			result = pstmt.executeUpdate();
			pstmt.close();
			pstmt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
		
	}

}
