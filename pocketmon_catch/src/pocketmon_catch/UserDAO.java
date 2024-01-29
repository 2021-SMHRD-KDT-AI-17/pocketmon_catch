package pocketmon_catch;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
	
	private Connection conn = null;
	private PreparedStatement psmt =null;
	private ResultSet rs = null;
	
	public void getConn() {
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@project-db-campus.smhrd.com:1524:xe";
			String user = "campus_23K_AI17_p1_1";  
			String password = "smhrd1"; 
						
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
	}
	
	public UserDTO login(UserDTO dto) {
		
		UserDTO result = null;
		
		try {
			getConn();
			
			String sql = "SELECT * FROM PM_USER WHERE ID=? AND PW=?";
			
			psmt = conn.prepareStatement(sql); 
			psmt.setString(1, dto.getID());
			psmt.setString(2, dto.getPW());
			
			rs = psmt.executeQuery(); 
			
			if(rs.next()) {			       
				result = new UserDTO();
				
				String getId = rs.getString(1); 
				String getPw = rs.getString(2);
				String getNick = rs.getString(3);
				
				result.setID((getId));
				result.setPW((getPw));
				result.setNICK((getNick));
				

				
				System.out.println(getId+"/"+getPw+"/"+getNick);
			}
			
		}  catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return result;
	} 
	
	// ==== 로그인
	
	public int join(UserDTO dto) {
		int cnt = 0;
		try {
			getConn();
			
			String sql = "INSERT INTO PM_USER VALUES(?,?,?)";
			
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getID());
			psmt.setString(2, dto.getPW());
			psmt.setString(3, dto.getNICK());
			
			cnt = psmt.executeUpdate();
			if(cnt>0) {
				System.out.println("회원가입이 완료되었습니다.");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return cnt;
	}
	
	
	// ====== 회원가입
	
	public int Nchange(UserDTO dto) {
		int cnt = 0;
		try {
			getConn();
			String sql = "UPDATE PM_USER SET Nick = ? WHERE ID = ?";
			
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getNICK());
			psmt.setString(2, dto.getID());
			
			cnt = psmt.executeUpdate();
			if(cnt>0) {
				System.out.println("닉네임수정이 완료되었습니다.");
			}
			 
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return cnt;
	}
	
	// ======= 닉네임 수정
	
	public int delete(String deleteId) {
		int cnt = 0;
		try {
			getConn();
			String sql = "DELETE FROM PM_USER WHERE ID = ?";
			
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, deleteId);
			
			cnt = psmt.executeUpdate();
			if(cnt>0) {
				System.out.println("회원정보가 탈퇴되었습니다.");
			}
			 
		} catch (SQLException e) {
			e.printStackTrace();
		}  finally {
			close();
		}
		return cnt;
	}
	// ===== 회원정보삭제
	
	public int Nickcheck(String Nick) {
		try {
			getConn();
			
			String sql = "SELECT * FROM PM_USER WHERE NICK = ?";
			
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, Nick);
			
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				return 1; 
			}
			
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				close();
			}
			return 0; 
	}
	// ======닉네임 중복검사
	
	public int Idcheck(String id) {
		try {
			getConn();
			
			String sql = "SELECT * FROM PM_USER WHERE ID = ?";
			
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				return 1; 
			}
			
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				close();
			}
			return 0; 
	}
	// ======아이디 중복검사
}
