package org.camelcode.itf;

import org.camelcode.MyException;

public interface BookService {
	
	public void printBook(String book) throws MyException;
	
	public String getBook(String book) throws MyException ;

}
