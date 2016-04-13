package com.cgi.test.rest.jaxbtest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.cgi.test.rest.model.Todo;

@Path("/todo")
public class TodoResource {


	// This can be used to test the integration with the browser
	@GET
	@Produces({ MediaType.TEXT_XML })
	public Todo getHTML() {
		Todo todo = new Todo();
		todo.setSummary("This is my first todo TEXT_XML");
		todo.setDescription("This is my first todo TEXT_XML");
		return todo;
	}

	// This method is called if XMLis request
	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Todo getXML() {
		Todo todo = new Todo();
		todo.setSummary("This is my first todo APPLICATION_XML / APPLICATION_JSON");
		todo.setDescription("This is my first todo APPLICATION_XML / APPLICATION_JSON");
		return todo;
	}


} 