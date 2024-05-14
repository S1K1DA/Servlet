package kr.co.green.contact.model.dto;

public class ContactDto {
	private int no;  
	private String message;  
	private String name;   
	private String email;
	private String indate;
	private String answerStatus;
	
	private int answerNo;
	private String answerContent;
	private String answerWriter;
	private String answerIndate;
	
	private int memberNo; // 회원 번호
	
	// 생성자 만들기
	public ContactDto() {
		super();
	}
	
	// 매개변수 있는 생성자
	public ContactDto(String name, String email, String message, int memberNo) {
		super();
		this.name = name;
		this.email = email;
		this.message = message;
		this.memberNo = memberNo;
	}

	
	
	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

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

	public String getIndate() {
		return indate;
	}

	public void setIndate(String indate) {
		this.indate = indate;
	}

	public String getAnswerStatus() {
		return answerStatus;
	}

	public void setAnswerStatus(String answerStatus) {
		this.answerStatus = answerStatus;
	}

	public int getAnswerNo() {
		return answerNo;
	}

	public void setAnswerNo(int answerNo) {
		this.answerNo = answerNo;
	}

	public String getAnswerContent() {
		return answerContent;
	}

	public void setAnswerContent(String answerContent) {
		this.answerContent = answerContent;
	}

	public String getAnswerWriter() {
		return answerWriter;
	}

	public void setAnswerWriter(String answerWriter) {
		this.answerWriter = answerWriter;
	}

	public String getAnswerIndate() {
		return answerIndate;
	}

	public void setAnswerIndate(String answerIndate) {
		this.answerIndate = answerIndate;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	
	
	

	
	
}
