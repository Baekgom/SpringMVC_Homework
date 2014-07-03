package com.baekgom.dao;

import java.util.Iterator;

import com.baekgom.repository.UserRepository;
import com.baekgom.vo.UserVO;

public class UserDAO extends BaseDAO<UserVO> {

	public UserDAO() {
		super(UserRepository.getInstance());
	}

	@Override
	public UserVO findOne(Long id) {

		UserVO tempVO;

		Iterator<UserVO> iterator = baseRepository.repository.iterator();
		while (iterator.hasNext()) {
			tempVO = iterator.next();
			if (id.equals(tempVO.getId())) {
				return tempVO;
			}

		}

		return null;
	}

}
