package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="staffs")
public class Staff {	
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int id;
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
	private String email;	
	@Column(name = "phone_number")
	private String phone;
	private int active;
	
	@ManyToOne
	@JoinColumn(name="manager_id")
	private Staff manager;
	
	public Staff() {
	}

	public Staff(String firstName, String lastName, String email, String phone, int active) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.active = active;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public Staff getManager() {
		return manager;
	}

	public void setManager(Staff manager) {
		this.manager = manager;
	}

	@Override
	public String toString() {
		return "Staff [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", phone=" + phone + ", active=" + active + ", manager=" + manager + "]";
	}
	
	
}
