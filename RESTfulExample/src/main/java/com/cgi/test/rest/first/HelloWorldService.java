package com.cgi.test.rest.first;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/hello")
public class HelloWorldService {

	// http://localhost:8088/RESTfulExample/rest/hello/xxxx
	@GET
	@Path("/{param}")
	@Produces(MediaType.TEXT_PLAIN)
	public Response getMsg(@PathParam("param") String msg) {

		String output = "Jersey say : " + msg;

		return Response.status(200).entity(output).build();

	}

	// This method is called if HTML is request
	// http://localhost:8088/RESTfulExample/rest/hello/
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String sayHtmlHello() {
		return "<html> " + "<title>" + "Hello Jersey" + "</title>"
				+ "<body><h1>" + "Hello Jersey HTML" + "</body></h1>" + "</html> ";
	}

}
