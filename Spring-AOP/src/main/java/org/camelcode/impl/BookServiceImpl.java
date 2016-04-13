package org.camelcode.impl;

import org.camelcode.MyException;
import org.camelcode.itf.BookService;
import org.springframework.stereotype.Service;

@Service("bookService")
public class BookServiceImpl implements BookService {

	@Override
	public void printBook(String book) throws MyException {
		boolean isException = false;

		if(isException) {
			throw new MyException("BookServiceImpl.printBook MyException !!!");
		}
		System.out.println(book);
	}

	@Override
	public String getBook(String book) throws MyException {
		boolean isException = false;

		if(isException) {
			throw new MyException("BookServiceImpl.getBook MyException !!!");
		}		
		return "returned : " + book;
	}
}