package baitapoop1;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Fresher_candidate extends Candidate{
	Date Graduation_date;
	String Graduation_rank;
	String Education;
	public Date getGraduation_date() {
		return Graduation_date;
	}
	public void setGraduation_date(Date graduation_date) {
		Graduation_date = graduation_date;
	}
	public String getGraduation_rank() {
		return Graduation_rank;
	}
	public void setGraduation_rank(String graduation_rank) {
		Graduation_rank = graduation_rank;
	}
	public String getEducation() {
		return Education;
	}
	public void setEducation(String education) {
		Education = education;
	}
	//ham dung nhieu doi so
	public Fresher_candidate(String firstName, String lastName, String address,String phone, String email, int candidate_type, int birthDate,Date graduation_date, String graduation_rank,
			String education) {
		super(firstName,lastName,address,phone,email,candidate_type,birthDate);
		Graduation_date = graduation_date;
		Graduation_rank = graduation_rank;
		Education = education;
	}
	//ham dung khong doi so
	public Fresher_candidate() {
		// TODO Auto-generated constructor stub
	}
	//ham check graduation_rank
	public String checkGra(String a){
			while(!(a.equals("Excellence")||a.equals("Good")||a.equals("Fair")||a.equals("Poor"))){
			System.out.print("vui long nhap lai Excellence, Good, Fair, Poor");
			Scanner sc = new Scanner(System.in);
			a=sc.next();
		}
		return a;
	}
	////Ham tao fresher
	public Fresher_candidate  nhapFresher(){
		String firstName,lastName,address,phone,email; 
		int birthDate;
		Date Graduation_date;
		String Graduation_rank;
		String Education;
		firstName = super.input("nhap ten").next();
		lastName= super.input("nhap Ho").next();
		address= super.input("nhap dia chi").next();
		phone=super.checkNumber(super.input("So dien thoai").next());
		email=super.checkMail(super.input("nhap mail").next());
		birthDate= super.checkBirth(super.input("nhap nam sinh").nextInt());
		Graduation_date = super.nhapDate(super.input("Nhap ngay thang co dang dd/mm/yy").next());
		Graduation_rank = this.checkGra(super.input("xep loai").next());
		Education=super.input("nhap ten truong").next();
		return new Fresher_candidate(firstName,lastName,address,phone,email,1,birthDate,Graduation_date,Graduation_rank,Education);
	}
	//ham toString
	public String toString() {
		return "Fresher_candidate [Graduation_date=" + Graduation_date
				+ ", Graduation_rank=" + Graduation_rank + ", Education="
				+ Education + ", FirstName=" + FirstName + ", LastName="
				+ LastName + ", Address=" + Address + ", Phone=" + Phone
				+ ", Email=" + Email + ", Candidate_type=" + Candidate_type
				+ ", BirthDate=" + BirthDate + "]";
	}
		public static void main(String args[]){
		Fresher_candidate f=new Fresher_candidate();
		//f.checkGra("a");
		System.out.print(f.nhapFresher());
	}
}
