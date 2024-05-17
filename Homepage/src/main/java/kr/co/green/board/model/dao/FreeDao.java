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

	public ArrayList<FreeDtoImpl> getList(PageInfo pi, String category, String searchText) {
		ArrayList<FreeDtoImpl> result = new ArrayList<>(); // 반환할 객체 생성
		String query = "SELECT * FROM FREE_BOARD fb" 
				+ "     JOIN MEMBER m ON m.M_NO = fb.M_NO"
				+ "     WHERE FB_DELETE_STATUS = 'N'"
				+ "     AND " + category + " LIKE '%'||?||'%'"
				+ "     ORDER BY fb_indate DESC" 
				+ "     OFFSET ? ROW FETCH FIRST ? ROW ONLY";

		try {
			// 1. 쿼리 사용할 준비
			pstmt = con.prepareStatement(query);
//			pstmt.setString(1, category);
			pstmt.setString(1, searchText);
			pstmt.setInt(2, pi.getOffset());
			pstmt.setInt(3, pi.getBoardLimit());

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

	public int getListCount(String category, String searchText) {
		String query = "SELECT count(*) AS cnt FROM free_board fb"
				+ "     JOIN member m ON fb.m_no = m.m_no"
				+ "     WHERE FB_DELETE_STATUS = 'N'"
				+ "     AND " + category + " LIKE '%'||?||'%'";

		try {
			pstmt = con.prepareStatement(query);
//			pstmt.setString(1, category);
			
			pstmt.setString(1, searchText);
			
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
	
	public FreeDtoImpl getDetail(int boardNo) {
		// 1. 쿼리 작성(String 변수에)
		String query = "SELECT * FROM free_board"
				+ "     WHERE FB_NO = ?";
		
		// 2. pstmt에 쿼리를 사용할 준비
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, boardNo);
			// 3. 쿼리 실행(반환값은 ResultSet)
			//    * 반환값이 int -> insert, delete, update
			//      반환값이 ResultSet -> select
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				// 4. 튜플에 있는 컬럼의 값을 꺼내기
				// 게시글 번호, 제목, 내용, 작성일, 조회수
				int fbNO = rs.getInt("FB_NO");
				String fbTitle = rs.getString("FB_TITLE");
				String fbContent = rs.getString("FB_CONTENT");
				String fbIndate = rs.getString("FB_INDATE");
				int fbViews = rs.getInt("FB_VIEWS");
				int mNo = rs.getInt("M_NO");
				
				FreeDtoImpl freeDto = new FreeDtoImpl();
				freeDto.setBoardNo(fbNO);
				freeDto.setBoardTitle(fbTitle);
				freeDto.setBoardContent(fbContent);
				freeDto.setBoardIndate(fbIndate);
				freeDto.setBoardViews(fbViews);
				freeDto.setMemberNo(mNo);
				return freeDto;
				
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void getWriter(FreeDtoImpl freeDto) {
		String query = "SELECT m_name FROM member"
				+ "     WHERE m_no = ?";
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, freeDto.getMemberNo());
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String mName = rs.getString("M_NAME");
				
				freeDto.setMemberName(mName);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public int setViews(int boardNo) {
		String query = "UPDATE free_board SET fb_views = fb_views + 1"
				+ "     WHERE fb_no = ?";
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, boardNo);
			return pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
	}
	
	public int setEdit(FreeDtoImpl freeDto) {
		// 1. String query 작성
		// title, content, update = sysdate
		String query = "UPDATE free_board "
				+ "		SET FB_TITLE = ?,"
				+ "     	FB_CONTENT = ?,"
				+ "     	FB_UPDATE = SYSDATE"
				+ "     WHERE FB_NO = ?";
		try {
			// 2. 쿼리 사용할 준비
			pstmt = con.prepareStatement(query);
			// 3. 물음표 채워넣고
			pstmt.setString(1, freeDto.getBoardTitle());
			pstmt.setString(2, freeDto.getBoardContent());
			pstmt.setInt(3, freeDto.getBoardNo());
			
			// 4. 쿼리 실행
			int result = pstmt.executeUpdate();
			pstmt.close();
			con.close();
			
			return result;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
	}
	
	public int setDelete(int boardNo) {
		String query = "UPDATE free_board"
				+ "     SET FB_DELETE = SYSDATE,"
				+ "         FB_DELETE_STATUS = 'Y'"
				+ "     WHERE FB_NO = ?";
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, boardNo);
			
			int result = pstmt.executeUpdate();
			pstmt.close();
			con.close();
			
			return result;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
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
