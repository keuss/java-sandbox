package com.test;

public class MathTest {


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int nbPage = (int) Math.round(Math.ceil(5 / 10));
		System.out.println(nbPage);
		
		for (int i = 1; i <= nbPage; nbPage++) {
			System.out.println(i);
		}
		

		//Pagination
//		int nbPage = (int) Math.round(Math.ceil(nbElementAdded / nbElementByPage));
//		for (int i = 1; i <= nbPage; nbPage++) {
//			model.getPagesToScroll().add(new SelectItem(i));
//		}
		
	}

}
