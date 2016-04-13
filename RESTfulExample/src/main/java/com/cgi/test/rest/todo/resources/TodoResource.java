package com.cgi.test.rest.todo.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.xml.bind.JAXBElement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cgi.test.rest.todo.dao.TodoDao;
import com.cgi.test.rest.todo.model.Todo;

public class TodoResource {
	
	private final static Logger logger = LoggerFactory.getLogger(TodoResource.class);
	
	@Context
	UriInfo uriInfo;
	@Context
	Request request;
	String id;
	public TodoResource(UriInfo uriInfo, Request request, String id) {
		this.uriInfo = uriInfo;
		this.request = request;
		this.id = id;
		logger.debug("new TodoResource with id:{}", id);
	}

	//Application integration 
	//@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Todo getTodo() {
		
		//comment cette methode est appelee ?
		logger.debug("Call for TodoResource.getTodo() ...");
		
		Todo todo = TodoDao.instance.getModel().get(id);
		if(todo==null)
			throw new RuntimeException("Get: Todo with " + id +  " not found");
		return todo;
	}

	// For the browser
	@GET
	@Produces(MediaType.TEXT_XML)
	public Todo getTodoHTML() {
		
		logger.debug("Call for TodoResource.getTodoHTML() ...");
		
		Todo todo = TodoDao.instance.getModel().get(id);
		if(todo==null)
			throw new RuntimeException("Get: Todo with " + id +  " not found");
		return todo;
	}

	@PUT
	@Consumes(MediaType.APPLICATION_XML)
	public Response putTodo(JAXBElement<Todo> todo) {
		
		logger.debug("Call for TodoResource.putTodo() ...");
		
		Todo c = todo.getValue();
		return putAndGetResponse(c);
	}

	@DELETE
	public void deleteTodo() {
		
		logger.debug("Call for TodoResource.deleteTodo() ...");
		
		Todo c = TodoDao.instance.getModel().remove(id);
		if(c==null)
			throw new RuntimeException("Delete: Todo with " + id +  " not found");
	}

	/**
	 * @param todo
	 * @return
	 */
	private Response putAndGetResponse(Todo todo) {
		
		logger.debug("Call for TodoResource.putAndGetResponse() ...");
		
		Response res;
		if(TodoDao.instance.getModel().containsKey(todo.getId())) {
			res = Response.noContent().build();
		} else {
			res = Response.created(uriInfo.getAbsolutePath()).build();
		}
		TodoDao.instance.getModel().put(todo.getId(), todo);
		return res;
	}



} 