package com.board.domain;

public class Page {
	// 현재 페이지 번호
	private int num;
	
	// 게시물 총 개수
	private int count;
	
	// 한 페이지에 출력할 게시물 갯수
	private int postNum = 10;
	
	// 하단 페이징 번호
	private int pageNum;
	
	// 출력할 게시물(sql: limit displayPost, postNum)
	// sql 게시물 검색용도
	private int displayPost;
	
	// 한 번에 표시할 페이징 번호의 갯수
	private int pageNumCnt = 10;
	
	// 표시되는 페이지 번호 중 마지막, 첫번째
	private int endPageNum;
	private int startPageNum;
	
	// 이전, 다음 버튼
	private boolean prev;
	private boolean next;
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
		dataCalc();
	}
	public int getPostNum() {
		return postNum;
	}
	public int getDisplayPost() {
		return displayPost;
	}
	public int getPageNum() {
		return pageNum;
	}
	public int getPageNumCnt() {
		return pageNumCnt;
	}
	public int getEndPageNum() {
		return endPageNum;
	}
	public int getStartPageNum() {
		return startPageNum;
	}
	public boolean getPrev() {
		return prev;
	}
	public boolean getNext() {
		return next;
	}
	
	private void dataCalc() {
		endPageNum = (int)(Math.ceil((double)num / (double)pageNumCnt) * pageNumCnt);
		startPageNum = endPageNum - (pageNumCnt -1);
		int endPageNum_tmp = (int)(Math.ceil((double)count / (double)pageNumCnt));
		if(endPageNum > endPageNum_tmp) {
			endPageNum = endPageNum_tmp;
		}
		prev = startPageNum == 1 ? false : true;
		next = endPageNum * pageNumCnt >= count ? false : true;
		displayPost = (num - 1) * postNum;
	}
	
	private String searchType;
	private String keyword;
	
	public String getSearchType() {
		return searchType;
	}
	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

//	private String searchTypeKeyword;
//	
//	public void setSearchTypeKeyword(String searchType, String keyword) {
//		
//		if(searchType.equals("") || keyword.equals("")) {
//			searchTypeKeyword = "";
//		} else {
//			searchTypeKeyword = "&searchType=" + searchType + "&keyword=" + keyword;
//		}
//	}
	public String getSearchTypeKeyword() {
		if(searchType.equals("") || keyword.equals("")) {
			return "";
		} else {
			return "&searchType=" + searchType + "&keyword=" + keyword;
		}
			
	}
}
