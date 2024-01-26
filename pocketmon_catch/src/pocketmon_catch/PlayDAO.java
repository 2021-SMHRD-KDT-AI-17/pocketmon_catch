package pocketmon_catch;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PlayDAO {
	
	private Connection conn = null;
	private PreparedStatement psmt =null;
	private ResultSet rs = null;
	
	public void getConn() {
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@project-db-campus.smhrd.com:1524:xe";
			String user = "campus_23K_AI17_p1_1";  
			String password = "smhrd1"; 
						
			conn = DriverManager.getConnection(url, user, password);
			if(conn!= null) {
				System.out.println("DB연결성공!");
			}else {
				System.out.println("DB연결실패!");
			}
		} catch (Exception e) {
			e.printStackTrace(); 
		}
	}
	
	public void close() {
		
					try {
					if(rs != null) {rs.close(); }
					if(psmt != null) {psmt.close(); }
					if(conn != null) {conn.close(); }
					}catch (SQLException e) {
						e.printStackTrace();
					}
					System.out.println("DB연결종료!");
	}
	
	public int save(PlayDTO dto) {
		int cnt = 0;
		try {
			getConn();
			
			String sql = "INSERT INTO PM_PLAY(NICK,SCORE) VALUES(?,?)";
			
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getNICK());
			psmt.setInt(2, dto.getSCORE());
			
			cnt = psmt.executeUpdate();
			if(cnt>0) {
				System.out.println("저장되었습니다!");
			}	
					
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return cnt;
	}
	// ===== 닉네임과 점수를 저장
	
	public ArrayList<PlayDTO> ranking(){
		ArrayList<PlayDTO> list = new ArrayList<PlayDTO>();
		try {
			getConn();
			
			String sql = "SELECT NICK, SCORE FROM (SELECT NICK, MAX(SCORE) AS score FROM PM_PLAY GROUP BY NICK ORDER BY score DESC) WHERE ROWNUM <=10";
			
			psmt = conn.prepareStatement(sql);
			
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				String id = rs.getString(1);
				int score = rs.getInt(2);
	
				PlayDTO dto = new PlayDTO();
				dto.setNICK(id);
				dto.setSCORE(score);
				
				list.add(dto);
				
				}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}
	
	// ====== 닉네임과 점수를 내림차순으로 10위까지 랭킹등록
}
