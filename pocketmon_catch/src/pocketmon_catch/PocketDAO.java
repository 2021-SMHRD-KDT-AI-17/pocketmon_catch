package pocketmon_catch;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PocketDAO {
	
	private Connection conn = null;
	private PreparedStatement psmt = null;
	private ResultSet rs = null;
	
	public void getConn() {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			String url = "jdbc:oracle:thin:@project-db-campus.smhrd.com:1524:xe";
			String user = "campus_23K_AI17_p1_1"; // DB연결 계정
			String password = "smhrd1"; // DB연결 비밀번호

			// 2. 데이터베이스 연결
			conn = DriverManager.getConnection(url, user, password);

		} catch (Exception e) {
			e.printStackTrace(); // 오류출력
		}
	}
	// ======== DB 연결까지
	
	
	
	

	public void close() {

		// 4. 데이터베이스 연결종료(연결된 객체의 역순으로 종료)
		try {
			if (rs != null)
				rs.close();
			if (psmt != null)
				psmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	// ========DB연결 종료
	
	
	
	public void showPocket() {

		PocketDTO[] pock = new PocketDTO[15];

		try {

			getConn();

			String sql = "SELECT * FROM PM_POCKET";

			psmt = conn.prepareStatement(sql);

			rs = psmt.executeQuery();

			for (int i = 0; i < pock.length; i++) {
				if (rs.next()) {
					PocketDTO pdto = new PocketDTO(rs.getString(1), rs.getInt(2));

					pock[i] = pdto;
				}
			}
			
//			메인문에서 사용할 때
//			Random rd = new Random();
//			int num = rd.nextInt(pock.length);
//			이름 : pock[num].getPM_NAME()   HP : pock[num].getPM_HP()
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
	}

}
