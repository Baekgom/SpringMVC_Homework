package com.baekgom.dao;

import java.util.Iterator;

import com.baekgom.repository.BoardRepository;
import com.baekgom.vo.BoardVO;

public class BoardDAO extends BaseDAO<BoardVO> {

	public BoardDAO() {
		super(BoardRepository.getInstance());
	}

	@Override
	public BoardVO findOne(Long id) {

		BoardVO tempVO;

		Iterator<BoardVO> iterator = baseRepository.repository.iterator();
		while (iterator.hasNext()) {
			tempVO = iterator.next();
			if (id.equals(tempVO.getId())) {
				return tempVO;
			}

		}

		return null;
	}

}
