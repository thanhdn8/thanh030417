package baitapoop1;

public class Intern_candidate extends Candidate{
	String majors, semester, Universty_name;

	public String getMajors() {
		return majors;
	}

	public void setMajors(String majors) {
		this.majors = majors;
	}

	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}

	public String getUniversty_name() {
		return Universty_name;
	}

	public void setUniversty_name(String universty_name) {
		Universty_name = universty_name;
	}
	//ham dung nhieu doi so
	public Intern_candidate(String firstName, String lastName, String address,String phone, String email, int candidate_type, int birthDate,String majors, String semester,String universty_name) {
		super(firstName,lastName,address,phone,email,candidate_type,birthDate);
		this.majors = majors;
		this.semester = semester;
		Universty_name = universty_name;
		System.out.print("da duoc tao");
	}
	//ham dung khong doi so
	public Intern_candidate() {
		// TODO Auto-generated constructor stub
	}

	//Nhap Inter_candidate
	public Intern_candidate  nhapInter(){
		String firstName,lastName,address,phone,email; 
		int birthDate;
		String majors;
		String semester;
		String universty_name;
		firstName = super.input("nhap ten").next();
		lastName= super.input("nhap Ho").next();
		address= super.input("nhap dia chi").next();
		phone=super.checkNumber(super.input("So dien thoai").next());
		email=super.checkMail(super.input("nhap mail").next());
		birthDate= super.checkBirth(super.input("nhap nam sinh").nextInt());
		majors = super.input("Nhap chuyen nganh").next();
		semester = super.input("Nhap hoc ky").next();
		universty_name=super.input("nhap ten truong").next();
		return new Intern_candidate(firstName,lastName,address,phone,email,0,birthDate,majors,semester,universty_name);
	}
	//ham to String
	public String toString() {
		return "Intern_candidate [majors=" + majors + ", semester=" + semester
				+ ", Universty_name=" + Universty_name + ", FirstName="
				+ FirstName + ", LastName=" + LastName + ", Address=" + Address
				+ ", Phone=" + Phone + ", Email=" + Email + ", Candidate_type="
				+ Candidate_type + ", BirthDate=" + BirthDate + "]";
	}
	public static void main(String arg[]){
		Intern_candidate sc=new Intern_candidate();
		Intern_candidate a = null;
		a=sc.nhapInter();
		System.out.print(a);
		
	}
}
