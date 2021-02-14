package com.board.domain;

public class Page {
	
	// 현재 페이지 번호
	private int num;

	// 게시물 총 갯수
	private int count;

	// 한 페이지에 출력할 게시물 갯수
	private int postNum = 10;

	// 하단 페이징 번호 ([ 게시물 총 갯수 ÷ 한 페이지에 출력할 갯수 ]의 올림)
	private int pageNum;

	// 출력할 게시물
	private int displayPost;

	// 한번에 표시할 페이징 번호의 갯수
	private int pageNumCnt = 10;

	// 표시되는 페이지 번호 중 마지막 번호
	private int endPageNum;

	// 표시되는 페이지 번호 중 첫번째 번호
	private int startPageNum;

	// 다음/이전 표시 여부
	private boolean prev;
	private boolean next;

	public void setNum(int num) {
		 this.num = num;
		 dataCalc();
	}

	public void setCount(int count) {
		 this.count = count;
		 dataCalc();
	}

	public int getCount() {
			return count;
	}

	public int getPostNum() {
		return postNum;
	}

	public int getPageNum() {
		return pageNum;
	}

	public int getDisplayPost() {
		return displayPost;
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
		
		// 총 페이지 수
		pageNum = (int)Math.ceil((double)count/postNum);
		
		// 출력할 페이지
		displayPost = (num - 1) * postNum; 
		
		// 표시되는 마지막 페이지 번호
		endPageNum = (int)(Math.ceil((double)num/(double)pageNumCnt) * pageNumCnt);
		
		// 표시되는 첫 페이지 번호
		startPageNum = endPageNum - (pageNumCnt - 1);
		
		// 마지막 페이지 번호 재계산
		int endPageNum_tmp = (int)(Math.ceil((double)count/(double)postNum));
		
		if(endPageNum > endPageNum_tmp) {
			endPageNum = endPageNum_tmp;
		}
		
		prev = startPageNum == 1 ? false : true;
		next = endPageNum == endPageNum_tmp ? false : true;
		
	}
	
	// 검색 타입과 검색어	
	private String searchType;
	private String keyword;
	

	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
	public String getSearchType() {
		return searchType;
	}
	
	public String getKeyword() {
		return keyword;
	}

	public String getSearchTypeKeyword() {
		
		if(searchType.equals("") || keyword.equals("")) {
			return "";
		}else {
			return "&searchType=" + searchType + "&keyword=" + keyword;
		}
		
	}
}
