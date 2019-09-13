package testinggggggg.com.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity

@Table(name = "MicroStudent")
public class Student {

	@Id

	@GeneratedValue(strategy = GenerationType.AUTO)

	@Column(name = "sid")
	private int sid;

	@Column(name = "sname")
	private String sname;

	@Column(name = "city")
	private String city;

	@Column(name = "rollNo")
	private int rollNo;

	public int getSid() {
		return sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getRollNo() {
		return rollNo;
	}

	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}

	public Student(int sid, String sname, String city, int rollNo) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.city = city;
		this.rollNo = rollNo;
	}

	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", city=" + city + ", rollNo=" + rollNo + "]";
	}

	public Student() {
		super();
	}

}
