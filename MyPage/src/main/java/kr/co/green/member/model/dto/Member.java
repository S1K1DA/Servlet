package kr.co.green.member.model.dto;


public class Member {
	private int userNo;
	private String userfirstName;
	private String userlastName;
	private String userEmail;
	private String userPwd;
	private String confirmpwd;
	
	
	public int getUserNo() {
		return userNo;
	}
	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}
	public String getUserfirstName() {
		return userfirstName;
	}
	public void setUserfirstName(String userfirstName) {
		this.userfirstName = userfirstName;
	}
	public String getUserlastName() {
		return userlastName;
	}
	public void setUserlastName(String userlastName) {
		this.userlastName = userlastName;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public String getConfirmpwd() {
		return confirmpwd;
	}
	public void setConfirmpwd(String confirmpwd) {
		this.confirmpwd = confirmpwd;
	}

}