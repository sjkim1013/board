package com.board.service;

import java.util.List;

import com.board.domain.BoardVO;

public interface BoardService {

	// 게시글 목록
	public List<BoardVO> list() throws Exception;

	// 게시글 목록 + 페이지
	public List<BoardVO> listPage(int displayPost, int postNum) throws Exception;
	
	// 게시글 총 갯수
	public int count() throws Exception;
	
	// 게시글 작성
	public void write(BoardVO vo) throws Exception;
	
	// 게시글 조회
	public BoardVO view(int bno) throws Exception;
	
	// 게시글 수정
	public void modify(BoardVO vo) throws Exception;
	
	// 게시글 삭제
	public void delete(int bno) throws Exception;
}
