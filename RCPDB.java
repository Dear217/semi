package RCP;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RCPDB {

	
	static {
		//1. 드라이버 로딩
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 로딩 성공!");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패!");
			e.printStackTrace();
		}
	}
	
	
	//2. db 연결
	public static Connection getConnection(String url, String user, String upwd) throws SQLException {
		Connection con = DriverManager.getConnection(url, user, upwd);
		System.out.println("db연결 , con : " + con);
		return con;
	}
	
	public static Connection getConnection(String user, String upwd) throws SQLException {
		String url = "jdbc:oracle:thin:@180.69.42.150:1521:xe";
		Connection con = DriverManager.getConnection(url,user, upwd);
		return con;
	}
	
	public static Connection getConnection() throws SQLException {
		String url = "jdbc:oracle:thin:@180.69.42.150:1521:xe";
		String user = "sajo", upwd = "sajo123";
		Connection con = DriverManager.getConnection(url,user,upwd);
		return con;
	}
	
	public static void dbClose(ResultSet rs, PreparedStatement ps, Connection con) throws SQLException {
		if(rs != null) rs.close();
		if(ps != null) ps.close();
		if(con != null) con.close();
		
	}
	
	public static void dbClose(PreparedStatement ps, Connection con) throws SQLException {
		if(ps != null) ps.close();
		if(con != null) con.close();
		
		
	}
	
	
}
