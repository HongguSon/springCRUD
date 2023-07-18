package com.board.dao;

import java.util.List;

import com.board.domain.BoardVO;

public interface BoardDAO {
 
  // 게시물 목록
  public List<BoardVO> list() throws Exception;
  // 게시물 작성
  public void write(BoardVO vo) throws Exception;
  // 게시물 조회
  public BoardVO view(int bno) throws Exception;
  // 게시물 수정
  public void modify(BoardVO vo) throws Exception;
  // 게시물 삭제
  public void delete(int bno) throws Exception;
  // 총 게시물 개수 + Search
  public int count(String searchType, String keyword) throws Exception;
  // Pagination
  public List<BoardVO> listPage(int displayPost, int postNum) throws Exception;
  // Pagination + Search
  public List<BoardVO> listPageSearch(int displayPost, int postNum, String searchType, String keyword) throws Exception;
}