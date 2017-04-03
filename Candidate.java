package baitapoop1;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.Date;

public class Candidate {
	String FirstName, LastName, Address, Phone, Email;
	int Candidate_type;
	int BirthDate;
	public Candidate(){
		
	}
	public Candidate(String firstName, String lastName, String address,
			String phone, String email, int candidate_type, int birthDate) {
		FirstName = firstName;
		LastName = lastName;
		Address = address;
		Phone = phone;
		Email = email;
		Candidate_type = candidate_type;
		BirthDate = birthDate;
	}
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getPhone() {
		return Phone;
	}
	public void setPhone(String phone) {
		Phone = phone;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public int getCandidate_type() {
		return Candidate_type;
	}
	public void setCandidate_type(int candidate_type) {
		Candidate_type = candidate_type;
	}
	public int getBirthDate() {
		return BirthDate;
	}
	public void setBirthDate(int birthDate) {
		BirthDate = birthDate;
	}
	//Ham check Birthday
	public int checkBirth(int a){
		Date date = new Date();
		while(a>date.getYear()&& a<1900){
			System.out.print("Vui long nhap lai nam sinh");
			Scanner sc = new Scanner(System.in);
			a=sc.nextInt();
		}
		return a;
	}
	//Ham check so dien thoai
	public String checkNumber(String a){
		String regexStr = "[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]*";
		while(!a.matches(regexStr)){
			System.out.print("Vui long nhap lai so dien thoai");
			Scanner sc = new Scanner(System.in);
			a=sc.next();
		}
		return a;
	}
	//ham check mail
	public String checkMail(String a){
		String regexStr = "[a-z,A-Z,0-9,!,#,$,%,^,&,*,_,.]{2,}@[a-z,A-Z,0-9]{2,}\\.[a-z,A-Z,0-9]{2,}";
		while(!a.matches(regexStr)){
			System.out.print("vui long nhap lai email");
			Scanner sc = new Scanner(System.in);
			a=sc.next();
		}
		return a;
	}
	//ham input
	public Scanner input(String k){
		System.out.print(k);
		Scanner sc=new Scanner(System.in);
		return sc;
	}
	//ham nhap date
	public Date nhapDate(String s){
		SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy");
		try {
			return sd.parse(s);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			System.out.println("nhap lai ngay thang dang dd/MM/yyyy ");
			return nhapDate(input(s).next().toString());
		}
	}
	public static void main(String args[]){
		Candidate c=new Candidate();
		c.checkMail("1");
		/*c.input("s");
		System.out.print("");
		Scanner sc=new Scanner(System.in);*/
	}
}
