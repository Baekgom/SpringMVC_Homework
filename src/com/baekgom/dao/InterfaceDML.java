package com.baekgom.dao;

import java.util.List;

import com.baekgom.vo.VO;

public interface InterfaceDML {

	public List findAll();

	public boolean insert(VO vo);

	public boolean update(VO vo);

	public boolean delete(VO vo);

}
