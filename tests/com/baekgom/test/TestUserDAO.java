package com.baekgom.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.baekgom.dao.UserDAO;
import com.baekgom.vo.UserVO;
import com.baekgom.vo.UserVO;

public class TestUserDAO {

	UserDAO userDAO;

	@Before
	public void setUp() throws Exception {
		userDAO = new UserDAO();
	}

	@Test
	public void testFindAll() {
		List<UserVO> expectedList = userDAO.findAll();
		Assert.assertNotNull(expectedList);
	}

	@Test
	public void testInsert() {
		UserVO bvo1 = new UserVO("name", "email");
		Assert.assertTrue(userDAO.insert(bvo1));
		List<UserVO> reslutList = userDAO.findAll();

		UserVO expectedVO = new UserVO("name", "email");

		Assert.assertEquals(expectedVO.getName(),
				reslutList.get(reslutList.indexOf(bvo1)).getName());
		Assert.assertEquals(expectedVO.getEmail(),
				reslutList.get(reslutList.indexOf(bvo1)).getEmail());

	}

	@Test
	public void testUpdate() {

		UserVO uvo1 = new UserVO("name", "email");
		userDAO.insert(uvo1);

		List<UserVO> resultList = userDAO.findAll();

		UserVO resultVO = resultList.get(resultList.indexOf(uvo1));
		resultVO.setName("updateName");

		Assert.assertTrue(userDAO.update(resultVO));
	}

	@Test
	public void testDelete() {
		List<UserVO> resultList = userDAO.findAll();

		UserVO initialValue = new UserVO("delete1", "delete1");
		userDAO.insert(initialValue);
		Assert.assertFalse(resultList.isEmpty());

		userDAO.delete(initialValue);
		Assert.assertTrue(resultList.isEmpty());

	}

	@Test
	public void testfindOne() {

		UserVO initialValue1 = new UserVO("findOne", "findOne");
		userDAO.insert(initialValue1);
		Assert.assertEquals(initialValue1, userDAO.findOne(0L));

		UserVO initialValue2 = new UserVO("findOne", "findOne");
		userDAO.insert(initialValue2);
		Assert.assertEquals(initialValue2, userDAO.findOne(1L));

	}

}
