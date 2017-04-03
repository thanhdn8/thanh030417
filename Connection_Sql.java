package baitapoop1;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Connection_Sql {
	Connection sqlcon = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	CallableStatement callstmt = null;
	///
	///
	public Connection getConnect() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			sqlcon = DriverManager
					.getConnection("jdbc:sqlserver://ADMINISTRATOR:1433;databaseName=Candidate; username=sa; password=12345678");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sqlcon;
	}
	// print candidate
	public void printEX(int a){
		try {
			stmt = getConnect().createStatement();
			rs = stmt.executeQuery("Select FistName, LastName, BirthDay, Address, Phone, Email, Candidate_type,ExpInYear,ProSkill,Graduation_date,Graduation_rank,Education, Majors,Semester,Universty_name from TCandidate where Candidate_type="+a);
				    
		      while(rs.next()){
		         //Retrieve by column name
		    	  int ExpInYear=0;
		    	  String ProSkill=null;
		    	  String Graduation_date = null,Graduation_rank= null,Education= null,Majors= null,Semester= null,University_name=null;
		    	 String FirstName = rs.getString("FistName");
		    	 String LastName = rs.getString("LastName");
		    	 int BirthDate =rs.getInt("BirthDay");
		    	 String Address=rs.getString("Address");
		    	 String Phone=rs.getString("Phone");
		    	 String Email=rs.getString("Email");
		    	 int Candidate_type = rs.getInt("Candidate_type");
		    	 if(a==0){
		    		 ExpInYear = rs.getInt("ExpInYear");
		    		 ProSkill = rs.getString("ProSkill");
		    		 }
		    	 else if(a==1){
		    		 Graduation_date = rs.getString("Graduation_date");
		    		 Graduation_rank= rs.getString("Graduation_rank");
		    		 Education=rs.getString("Education");
		    		 }
		    	 else if(a==2){
		    		 Majors=rs.getString("Majors");
		    		 Semester=rs.getString("Semester");
		    		 University_name=rs.getString("Universty_name");
		    	 } 
		         
		         //Display values
		    	 System.out.println("**************************");
		    	 System.out.println("    **************");
		    	 System.out.println("FirstName : "+FirstName);
		    	 System.out.println("LastName : "+LastName);
		    	 System.out.println("BirthDate : "+BirthDate);
		    	 System.out.println("Address : "+Address);
		    	 System.out.println("Phone : "+Phone);
		    	 System.out.println("Email : "+Email);
		    	 System.out.println("Candidate_type : "+Candidate_type);
		    	 System.out.println("ExpInYear : "+ExpInYear);
		    	 System.out.println("ProSkill : "+ProSkill);
		    	 System.out.println("Graduation_date : "+Graduation_date);
		    	 System.out.println("Graduation_rank : "+Graduation_rank);
		    	 System.out.println("Education : "+Education);
		    	 System.out.println("Majors : "+Majors);
		    	 System.out.println("Semester : "+Semester);
		    	 System.out.println("University_name : "+University_name);
		    	 
		    	 
		     }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	     
	   }

	
	
public static void main(String[] args) {
	Connection_Sql con= new Connection_Sql();
	System.out.println(con.getConnect().toString());
	con.printEX(0);
	
}
}
