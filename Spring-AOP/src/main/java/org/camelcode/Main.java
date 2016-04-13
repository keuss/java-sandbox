package org.camelcode;

import org.camelcode.itf.BookService;
import org.camelcode.itf.PageService;
import org.camelcode.otherstuff.OtherServiceITF;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String...args){
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");

		BookService bookService = (BookService)context.getBean("bookService");
		PageService pageService = (PageService)context.getBean("pageService");
		
		try {
			System.out.println("##############################");
			bookService.printBook("camelcode.org BOOK");
			System.out.println("##############################");
			String book = bookService.getBook("camelcode.org BOOK");
			System.out.println("book => [" + book + "]");
			System.out.println("##############################");
			pageService.printPage("camelcode.org PAGE");
			System.out.println("##############################");
			
			// Other test spring and non-spring bean
			// POUR faire de l'aop => gestion par spring + itf !!!!
			OtherServiceITF os = (OtherServiceITF)context.getBean("otherService");
			//OtherServiceITF os = new OtherService();
			os.callOtherStuff();
			System.out.println("##############################");

		} catch (MyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}