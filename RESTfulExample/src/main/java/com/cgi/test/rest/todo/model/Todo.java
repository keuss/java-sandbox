package com.cgi.test.rest.todo.model;

import javax.xml.bind.annotation.XmlRootElement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@XmlRootElement
//JAX-RS supports an automatic mapping from JAXB annotated class to XML and JSON
//Isn't that cool?
// pour test com.cgi.test.rest.todo.resources
public class Todo {
	
	
	private final static Logger logger = LoggerFactory.getLogger(Todo.class);
	
	private String id;
	private String summary;
	private String description;

	public Todo(){
		logger.debug("new Todo ...");
	}
	public Todo (String id, String summary){
		this.id = id;
		this.summary = summary;
		logger.debug("new Todo with id:{}, summary:{}", id, summary);
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}