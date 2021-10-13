package dao;

import com.sun.jdi.connect.spi.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
	static {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	public static Connection getConnection() {
		String url = "jdbc:oracle:thin:@EOMTAEWON:1522:xe";
		String user = "c##movie";
		String password = "12345";
		Connection con = null;
		try {
			con = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	
}
