package com.baekgom.repository;

import java.util.ArrayList;

import com.baekgom.vo.BoardVO;

public class BoardRepository extends BaseRepository<BoardVO> {

	private volatile static BoardRepository boardRepository;

	public BoardRepository() {
		repository = new ArrayList<BoardVO>();
	}
 
	public static BoardRepository getInstance() {
		
		if (boardRepository == null) {
			synchronized (BoardRepository.class) {
				if (boardRepository == null) {
					boardRepository = new BoardRepository();
				}
			}
		}
		return boardRepository;
	}

}
