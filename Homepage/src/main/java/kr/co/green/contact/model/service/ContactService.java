package kr.co.green.contact.model.service;

import java.util.ArrayList;

import kr.co.green.board.model.dto.FreeDtoImpl;
import kr.co.green.common.PageInfo;
import kr.co.green.contact.model.dto.ContactDto;

public interface ContactService {
	
	// 등록
	public int enroll(ContactDto contactDto);
	
	public ArrayList<ContactDto> getList(PageInfo pi);
	
	public int getListCount();
	
	public ContactDto getDetail(int no);

}
