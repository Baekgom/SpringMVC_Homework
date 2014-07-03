package com.baekgom.repository;

import java.util.ArrayList;

import com.baekgom.vo.UserVO;

public class UserRepository extends BaseRepository<UserVO> {

	private volatile static UserRepository userRepository;

	private UserRepository() {
		repository = new ArrayList<UserVO>();
	}

	public static UserRepository getInstance() {

		if (userRepository == null) {
			synchronized (BoardRepository.class) {
				if (userRepository == null) {
					userRepository = new UserRepository();
				}
			}
		}
		return userRepository;

	}

}
