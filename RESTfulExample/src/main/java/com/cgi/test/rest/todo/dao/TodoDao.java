package com.cgi.test.rest.todo.dao;

import java.util.HashMap;
import java.util.Map;

import com.cgi.test.rest.todo.model.Todo;

public enum TodoDao {
	instance;

	/**
	 * Singleton which serves as the data provider for the model. We use the implementation based on an enumeration
	 * 
	 */
	
	private Map<String, Todo> contentProvider = new HashMap<String, Todo>();
	

	private TodoDao() {

		System.out.println("TodoDao => initialisation de la \"base\" pour les tests ...");
		Todo todo = new Todo("1", "Learn REST");
		todo.setDescription("Read http://www.vogella.com/articles/REST/article.html");
		contentProvider.put("1", todo);
		todo = new Todo("2", "Do something");
		todo.setDescription("Read complete http://www.vogella.com");
		contentProvider.put("2", todo);

	}

	public Map<String, Todo> getModel(){
		return contentProvider;
	}

} 