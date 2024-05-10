package kr.co.green.board.model.service;

import java.util.ArrayList;

import kr.co.green.board.model.dao.FreeDao;
import kr.co.green.board.model.dto.FreeDtoImpl;
import kr.co.green.common.PageInfo;

public class FreeServiceImpl implements BoardService{
	FreeDao freeDao;
	
	public FreeServiceImpl() {
		freeDao = new FreeDao();
	}
	
	
	@Override
	public ArrayList<FreeDtoImpl> getList(PageInfo pi) {
		return freeDao.getList(pi);
	}


	@Override
	public int getListCount() {
		return freeDao.getListCount();
	}
	
	@Override
	public int enroll(FreeDtoImpl freeDto) {
		return freeDao.enroll(freeDto);
	}


}
