package com.cgi.test.rest.client.first;

import java.net.URI;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

public class ClienTestLast {


	private final static Logger logger = LoggerFactory.getLogger(ClienTestLast.class); 
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// test http://localhost:8088/RESTfulExample/rest/todos
		// via com.cgi.test.rest.todo.resources (cf. web.xml)
		
		ClientConfig config = new DefaultClientConfig();
		Client client = Client.create(config);
		WebResource service = client.resource(getBaseURI());
		
		// si pas le bon mode (doit être le même que celui du serveur)
		/*Exception in thread "main" com.sun.jersey.api.client.UniformInterfaceException: GET http://localhost:8088/RESTfulExample/rest/todos returned a response status of 406 Not Acceptable
			at com.sun.jersey.api.client.WebResource.handle(WebResource.java:676)
			at com.sun.jersey.api.client.WebResource.access$200(WebResource.java:74)
			at com.sun.jersey.api.client.WebResource$Builder.get(WebResource.java:503)
			at com.cgi.test.rest.client.first.ClienTestLast.main(ClienTestLast.java:32)
			*/


		
		// Get XML
		String jsonString = service.path("rest").path("todos").accept(MediaType.APPLICATION_JSON).get(String.class);
		logger.info("jsonString => {}", jsonString);
		
		// Test JSON convertion ...
		try {
			// org.codehaus.jettison.json.JSONObject from jersey-json dependence
			JSONObject jsonObject = new JSONObject(jsonString);
			logger.info("jsonObject => {}", jsonObject.toString());
			logger.info("getJSONArray => {}", jsonObject.getJSONArray("todo").get(0));
			JSONObject jsonObject2 = new JSONObject(jsonObject.getJSONArray("todo").get(0).toString());
			logger.info("jsonObject2 => {}", jsonObject2.toString());
			logger.info("jsonObject2 get 'id' key => {}", jsonObject2.getString("id"));
			logger.info("jsonObject2 get 'description' key => {}", jsonObject2.getString("description"));
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * @return
	 */
	private static URI getBaseURI() {
		return UriBuilder.fromUri("http://localhost:8088/RESTfulExample").build();
	}

}
