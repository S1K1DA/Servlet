package kr.co.green.board.model.service;

import java.util.ArrayList;

import kr.co.green.board.model.dto.FreeDtoImpl;
import kr.co.green.common.PageInfo;

public interface BoardService {

//  리스트 조회
	public ArrayList<FreeDtoImpl> getList(PageInfo pi);

//  전체 게시글 수
	public int getListCount();

//	글등록
	public int enroll(FreeDtoImpl freeDto);

//	글수정

//	글삭제

}
