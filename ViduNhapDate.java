package baitapoop1;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ViduNhapDate {
	// /////////////////////
	Connection sqlcon = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	CallableStatement callstmt = null;

	// ///////////////////////////////
	// tao connet
	public Connection getConnect() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			sqlcon = DriverManager
					.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Candidate; username=sa; password=12345678");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sqlcon;
	}

	public String Ngay(Date d) {
		SimpleDateFormat ft = new SimpleDateFormat("dd.MM.yyyy");
		return ft.format(d);
	}

	public void addNewEmp() {
		/*
		 * String sql=
		 * "insert into Employees values('"+emp.getEmpName()+"','"+emp
		 * .getPhone()+"',"+emp.getTuoi()+")"; try { stmt =
		 * getConnect().createStatement(); stmt.executeUpdate(sql); } catch
		 * (SQLException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 */
		Date d = new Date();
		String sql = "insert into day(day) values (convert(date," + Ngay(d)
				+ ",103))";
		try {
			stmt = getConnect().createStatement();
			stmt.execute(sql);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		ViduNhapDate v = new ViduNhapDate();
		v.addNewEmp();
	}
}
