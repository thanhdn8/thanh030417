package baitapoop1;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Scanner;

public class Experience_candidate extends Candidate {
	Connection sqlcon = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	CallableStatement callstmt = null;
	int expInYear;
	String proSkill;
	public int getExpInYear() {
		return expInYear;
	}
	public void setExpInYear(int expInYear) {
		this.expInYear = expInYear;
	}
	public String getProSkill() {
		return proSkill;
	}
	public void setProSkill(String proSkill) {
		this.proSkill = proSkill;
	}
	//ham dung nhieu doi so
	public Experience_candidate(String firstName, String lastName, String address,String phone, String email, int candidate_type, int birthDate,int expInYear, String proSkill) {
		super(firstName,lastName,address,phone,email,candidate_type,birthDate);
		this.expInYear = expInYear;
		this.proSkill = proSkill;
	}
	//ham dung khong doi so
	public Experience_candidate() {
	}
	//Ham check Exp
	public int checkExp(int a){
		while(a<0|| a>100){
			System.out.print("Vui long nhap lai");
			Scanner sc = new Scanner(System.in);
			a=sc.nextInt();
		}
		return a;
	}
	//ham tao Experence_Candidate
	public Experience_candidate  nhapExp(){
		String firstName,lastName,address,phone,email; 
		int birthDate;
		int expInYear;
		String proSkill;
		firstName = super.input("nhap ten").next();
		lastName= super.input("nhap Ho").next();
		address= super.input("nhap dia chi").next();
		phone=super.checkNumber(super.input("So dien thoai").next());
		email=super.checkMail(super.input("nhap mail").next());
		birthDate= super.checkBirth(super.input("nhap nam sinh").nextInt());
		expInYear=checkExp(super.input("nhap kinh nghiem di lam").nextInt());
		proSkill =super.input("nhap ten truong").next();
		nhapExpSql(firstName,lastName,address,phone,email,2,birthDate,expInYear,proSkill);
		return new Experience_candidate(firstName,lastName,address,phone,email,0,birthDate,expInYear,proSkill);
	}
	//nhap Experience
	public void nhapExpSql(String firstName, String lastName, String address,String phone, String email, int candidate_type, int birthDate,int expInYear, String proSkill) {
		Connection_Sql con=new Connection_Sql();
		//stmt = con.getConnect().createStatement();		
		String sql = "insert into Tcandidate(FistName, LastName, BirthDay, Address, Phone, Email, Candidate_type,ExpInYear,ProSkill) values(?,?, ?, ?,?,?,?,?,?)";				
			try {
					stmt = con.getConnect().createStatement();
					pstmt = con.getConnect().prepareStatement(sql);
					pstmt.setString(1, firstName);
					pstmt.setString(2, lastName);
					pstmt.setInt(3, birthDate);
					pstmt.setString(4, address);
					pstmt.setString(5,phone );
					pstmt.setString(6, email);
					pstmt.setInt(7,0);
					pstmt.setInt(8,expInYear );
					pstmt.setString(9, proSkill);

					pstmt.executeUpdate();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}
	//ham tostring
	public String toString() {
		return "Experience_candidate [expInYear=" + expInYear + ", proSkill="
				+ proSkill + ", FirstName=" + FirstName + ", LastName="
				+ LastName + ", Address=" + Address + ", Phone=" + Phone
				+ ", Email=" + Email + ", Candidate_type=" + Candidate_type
				+ ", BirthDate=" + BirthDate + "]";
	}
	//ham main
	public static void main(String args[]){
		Experience_candidate e = new Experience_candidate();
		//e.checkExp(1000);
		System.out.println(e.nhapExp().toString());
	}
}
