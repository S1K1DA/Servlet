package kr.co.green.contact.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.co.green.common.DatabaseConnection;
import kr.co.green.common.PageInfo;
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
			con.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public ArrayList<ContactDto> getList(PageInfo pi) {
		ArrayList<ContactDto> result = new ArrayList<>(); // 반환할 객체 생성
		String query = "SELECT * FROM CONTACT c"
				+ "     ORDER BY c_indate DESC"
				+ "     OFFSET ? ROW FETCH FIRST ? ROW ONLY";
	
		
			try {
				pstmt = con.prepareStatement(query);
				pstmt.setInt(1, pi.getOffset());
				pstmt.setInt(2, pi.getBoardLimit());
				
				ResultSet rs = pstmt.executeQuery();
				
				while (rs.next()) {
					int no = rs.getInt("C_NO");
					String name = rs.getString("C_NAME");
					String massage = rs.getString("C_MESSAGE");
					String email = rs.getString("C_EMAIL");
					String indate = rs.getString("C_INDATE");
					String answer = rs.getString("C_ANSWER_STATUS");
					int memberno = rs.getInt("M_NO");
					
					ContactDto contactDto = new ContactDto();
					contactDto.setNo(no);
					contactDto.setName(name);
					contactDto.setMessage(massage);
					contactDto.setEmail(email);
					contactDto.setIndate(indate);
					contactDto.setAnswerStatus(answer);
					contactDto.setMemberNo(memberno);
					
					result.add(contactDto);
				}
				
				pstmt.close();
				con.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return result;
	}
	
	public int getListCount() {
		String query = "SELECT count(*) AS CNT FROM CONTACT";
		
		try {
			pstmt = con.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				int result = rs.getInt("CNT");
				return result;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
				
	}
	
	public ContactDto getDetail(int no) {
		String query = "SELECT * FROM CONTACT"
				+ "     WHERE C_NO = ?";
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, no);		
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int cNo = rs.getInt("C_NO");
				String cName = rs.getString("C_NAME");
				String cMessage = rs.getString("C_MESSAGE");
				String cEmail = rs.getString("C_EMAIL");
				String cIndate = rs.getString("C_INDATE");
				int mNo = rs.getInt("M_NO");
				
				ContactDto contactDto = new ContactDto();
				contactDto.setNo(cNo);
				contactDto.setName(cName);
				contactDto.setMessage(cMessage);
				contactDto.setEmail(cEmail);
				contactDto.setIndate(cIndate);
				contactDto.setMemberNo(mNo);
				
				return contactDto;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public int setAnswer(ContactDto contactDto) {
		System.out.println(contactDto.getNo());
		System.out.println(contactDto.getMemberNo());
		String query = "INSERT INTO contact_answer VALUES(contact_answer_seq.nextval, ?, default, ?, ?)";
		int result = 0;
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, contactDto.getAnswerContent());
			pstmt.setInt(2, contactDto.getMemberNo());
			pstmt.setInt(3, contactDto.getNo());
			
			result = pstmt.executeUpdate();
			return result;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
	}

	
	public int setAnswerUpdate(int no) {
		String query = "UPDATE contact set c_answer_status = 'Y' WHERE c_no = ?";
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, no);
			int result = pstmt.executeUpdate();
			return result;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public int Delete(int no) {
		String query = "DELETE FROM contact_answer WHERE c_no = ?";
		int result = 0;
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, no);
			
			result = pstmt.executeUpdate();
			return result;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public int contactDelete(int no) {
		String query = "DELETE FROM contact WHERE c_no = ?";
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, no);
			int result = pstmt.executeUpdate();
			return result;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	
	
	
	
	
	
	
	
}
