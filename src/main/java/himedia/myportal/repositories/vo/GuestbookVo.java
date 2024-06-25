package himedia.myportal.repositories.vo;

import java.util.Date;

public class GuestbookVo {

	//	필드
	private Long no;
	private String name;
	private String password;
	private String content;
	private Date date;
	
	//	생성자
	public GuestbookVo() {
		
	}
	
	public GuestbookVo(Long no, String name, String password, String content, Date date) {
		this.no = no;
		this.name = name;
		this.password = password;
		this.content = content;
		this.date = date;
	}
	
	public Long getNo() {
		return no;
	}

	public void setNo(Long no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "GuestbookVo [no=" + no + ", name=" + name + ", password=" + password + ", content=" + content
				+ ", date=" + date + "]";
	}
}
