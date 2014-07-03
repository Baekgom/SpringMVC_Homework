package com.baekgom.vo;

public class BoardVO extends VO {

	private String coment;
	private String writer;

	public BoardVO(String coment, String writer) {
		this.coment = coment;
		this.writer = writer;
	}

	public String getComent() {
		return coment;
	}

	public String getWriter() {
		return writer;
	}

	public void setComent(String coment) {
		this.coment = coment;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	@Override
	public String toString() {
		return "BoardVO [id=" + super.getId() + " coment=" + coment
				+ ", writer=" + writer + "]";
	}

}
