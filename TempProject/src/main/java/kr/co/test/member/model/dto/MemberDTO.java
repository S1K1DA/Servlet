package kr.co.test.member.model.dto;

public class MemberDTO {
	private String name;
	private String email;
	private String password;
	private String confirmpwd;
	private String birthdate;
	private String address;
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmpwd() {
		return confirmpwd;
	}
	public void setConfirmpwd(String confirmpwd) {
		this.confirmpwd = confirmpwd;
	}
	public String getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "MemberDTO [name=" + name + ", email=" + email + ", password=" + password + ", confirmpwd=" + confirmpwd
				+ ", birthdate=" + birthdate + ", address=" + address + "]";
	}
	
	
	
	
	
	
	

}
