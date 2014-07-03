package com.baekgom.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.baekgom.dao.BoardDAO;
import com.baekgom.vo.BoardVO;

public class TestBoardDAO {

	BoardDAO boardDAO;

	@Before
	public void setUp() throws Exception {
		boardDAO = new BoardDAO();
	}

	@Test
	public void testFindAll() {
		List<BoardVO> expectedList = boardDAO.findAll();
		Assert.assertNotNull(expectedList);
	}

	@Test
	public void testInsert() {
		BoardVO bvo1 = new BoardVO("coment1", "writer1");
		Assert.assertTrue(boardDAO.insert(bvo1));
		List<BoardVO> reslutList = boardDAO.findAll();

		BoardVO expectedVO = new BoardVO("coment1", "writer1");

		Assert.assertEquals(expectedVO.getComent(),
				reslutList.get(reslutList.indexOf(bvo1)).getComent());
		Assert.assertEquals(expectedVO.getWriter(),
				reslutList.get(reslutList.indexOf(bvo1)).getWriter());

	}

	@Test
	public void testUpdate() {

		BoardVO bvo1 = new BoardVO("coment1", "witer1");
		boardDAO.insert(bvo1);

		List<BoardVO> resultList = boardDAO.findAll();

		BoardVO resultVO = resultList.get(resultList.indexOf(bvo1));
		resultVO.setComent("updateComent");

		Assert.assertTrue(boardDAO.update(resultVO));

	}

	@Test
	public void testDelete() {
		List<BoardVO> resultList = boardDAO.findAll();

		BoardVO initialValue = new BoardVO("delete1", "delete1");
		boardDAO.insert(initialValue);
		Assert.assertFalse(resultList.isEmpty());

		boardDAO.delete(initialValue);
		Assert.assertTrue(resultList.isEmpty());

	}

	@Test
	public void testfindOne() {

		BoardVO initialValue1 = new BoardVO("findOne", "findOne");
		boardDAO.insert(initialValue1);
		Assert.assertEquals(initialValue1, boardDAO.findOne(0L));

		BoardVO initialValue2 = new BoardVO("findOne", "findOne");
		boardDAO.insert(initialValue2);
		Assert.assertEquals(initialValue2, boardDAO.findOne(1L));

	}

}
