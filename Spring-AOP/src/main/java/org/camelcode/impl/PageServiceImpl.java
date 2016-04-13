package org.camelcode.impl;

import org.camelcode.MyException;
import org.camelcode.itf.PageService;
import org.springframework.stereotype.Service;

@Service("pageService")
public class PageServiceImpl implements PageService {

	@Override
	public void printPage(String page) throws MyException {

		boolean isException = false;

		if(isException) {
			throw new MyException("PageServiceImpl.printBook MyException !!!");
		}
		System.out.println(page);
		
	}

}
