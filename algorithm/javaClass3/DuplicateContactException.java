package com.ssafy.ddu;

public class DuplicateContactException extends Exception {
	public DuplicateContactException() {
		super("중복된 전화번호");
	}
}
