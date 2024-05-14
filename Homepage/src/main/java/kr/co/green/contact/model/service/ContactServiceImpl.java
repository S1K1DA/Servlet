package kr.co.green.contact.model.service;

import kr.co.green.contact.model.dao.ContactDao;
import kr.co.green.contact.model.dto.ContactDto;

public class ContactServiceImpl implements ContactService {
	ContactDao contactDao;
	
	public ContactServiceImpl() {
		contactDao = new ContactDao();
	}
	
	@Override
	public int enroll(ContactDto contactDto) {
		return contactDao.enroll(contactDto);
	}

}
