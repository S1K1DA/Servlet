package kr.co.green.board.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.co.green.board.model.dto.FreeDtoImpl;
import kr.co.green.common.DatabaseConnection;
import kr.co.green.common.PageInfo;

public class FreeDao {
	private Connection con;
	private DatabaseConnection dc;
	private PreparedStatement pstmt;

	public FreeDao() {
		dc = new DatabaseConnection();
		con = dc.connDB();
	}

	public ArrayList<FreeDtoImpl> getList(PageInfo pi) {
		ArrayList<FreeDtoImpl> result = new ArrayList<>(); // 반환할 객체 생성
		String query = "SELECT * FROM FREE_BOARD fb" + "     JOIN MEMBER m ON m.M_NO = fb.M_NO"
				+ "     ORDER BY fb_indate DESC" + "     OFFSET ? ROW FETCH FIRST ? ROW ONLY";

		try {
			// 1. 쿼리 사용할 준비
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, pi.getOffset());
			pstmt.setInt(2, pi.getBoardLimit());

			// 2. 쿼리 실행
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				int no = rs.getInt("FB_NO");
				String title = rs.getString("FB_TITLE");
				String content = rs.getString("FB_CONTENT");
				int views = rs.getInt("FB_VIEWS");
				String indate = rs.getString("FB_INDATE");
				int memberNo = rs.getInt("M_NO");
				String memberName = rs.getString("M_NAME");

				FreeDtoImpl freeDto = new FreeDtoImpl();
				freeDto.setBoardNo(no);
				freeDto.setBoardTitle(title);
				freeDto.setBoardContent(content);
				freeDto.setBoardViews(views);
				freeDto.setBoardIndate(indate);
				freeDto.setMemberNo(memberNo);
				freeDto.setMemberName(memberName);

				result.add(freeDto);
			}

			pstmt.close();
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	public int getListCount() {
		String query = "SELECT count(*) AS cnt FROM free_board";

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
	
	public int enroll(FreeDtoImpl freeDto) {
		String query = "INSERT INTO free_board VALUES(free_board_seq.nextval,?,?,default,default,NULL,NULL,default,?)";
		int result = 0;
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, freeDto.getBoardTitle());
			pstmt.setString(2, freeDto.getBoardContent());
			pstmt.setInt(3, freeDto.getMemberNo());
			
			result = pstmt.executeUpdate();
			pstmt.close();
			con.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
}

// 1. 쿼리 작성
//MySQL offset 페이징
//String query = "SELECT fb_idx,"
//   + "            fb_title,"
//   + "            fb_in_date,"
//   + "            fb_views,"
//   + "            fb_writer"
//   + "      FROM free_board"
//   + "      LIMIT ? OFFSET ?";

//MySQL cursor 페이징
//String query = "SELECT fb_idx,"
//   + "            fb_title,"
//   + "            fb_in_date,"
//   + "            fb_views,"
//   + "            fb_writer"
//   + "      FROM free_board"
//   + "      WHERE fb_idx > ? LIMIT ?";
