package com.board.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.board.dao.BoardDAO;
import com.board.domain.BoardVO;

@Service
public class BoardServiceImpl implements BoardService {

	@Inject
	private BoardDAO dao;
	
	// 게시물 목록
	@Override
	public List<BoardVO> list() throws Exception {
		return dao.list();
	}

	// 게시물 작성
	@Override
	public void write(BoardVO vo) throws Exception {
		dao.write(vo);
	}
	
	// 게시물 조회
	@Override
	public BoardVO view(int bno) throws Exception{
		return dao.view(bno);
	}

	// 게시물 수정
	@Override
	public void modify(BoardVO vo) throws Exception {
		dao.modify(vo);
		
	}

	// 게시물 삭제
	@Override
	public void delete(int bno) throws Exception {
		dao.delete(bno);
		
	}

	// Pagination
	@Override
	public int count(String searchType, String keyword) throws Exception {
		return dao.count(searchType, keyword);
	}

	@Override
	public List<BoardVO> listPage(int displayPost, int postNum) throws Exception {
		return dao.listPage(displayPost, postNum);
	}

	@Override
	public List<BoardVO> listPageSearch(int displayPost, int postNum, String searchType, String keyword)
			throws Exception {
		return dao.listPageSearch(displayPost, postNum, searchType, keyword);
	}

}