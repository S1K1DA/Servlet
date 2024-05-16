package kr.co.green.contact.model.service;

import java.util.ArrayList;

import kr.co.green.common.PageInfo;
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
	
	@Override
	public ArrayList<ContactDto> getList(PageInfo pi) {
		return contactDao.getList(pi);
	}
	
	@Override
	public int getListCount() {
		return contactDao.getListCount();
	}
	
	@Override
	public ContactDto getDetail(int no) {
		
		return contactDao.getDetail(no);
	}
	
	@Override
	public ContactDto getAnswerForm(int no) {
		ContactDto result = contactDao.getDetail(no);
		
		return result;
	}
	
	@Override
	public int setAnswer(ContactDto contactDto) {
//		return contactDao.setAnswer(contactDto); 
		
		if(contactDao.setAnswer(contactDto) == 1) {
			return contactDao.setAnswerUpdate(contactDto.getNo());
			}
		
		return 0;
	}
	
	@Override
	public int Delete(int no) {
		
		if(contactDao.Delete(no) == 1) {
			return contactDao.contactDelete(no);
		}
		return 0;
	}
	

}
