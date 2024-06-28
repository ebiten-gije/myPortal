package himedia.myportal.exceptions;

import himedia.myportal.repositories.vo.PhonebookVo;

public class PhonebookDaoException extends RuntimeException {

	private PhonebookVo phonebookVo = null;

	public PhonebookDaoException() {

	}
	
	public PhonebookDaoException(String message) {
		super(message);
	}
	
	public PhonebookDaoException(String message, PhonebookVo vo) {
		super(message);
		this.phonebookVo = vo;
	}

	public void setPhonebookVo(PhonebookVo phonebookVo) {
		this.phonebookVo = phonebookVo;
	}
	

}
