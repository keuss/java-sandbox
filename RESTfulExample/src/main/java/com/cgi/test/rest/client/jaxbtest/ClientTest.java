package com.cgi.test.rest.client.jaxbtest;

import java.net.URI;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

public class ClientTest {

	private final static Logger logger = LoggerFactory.getLogger(ClientTest.class);
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// TEST browser : http://localhost:8088/RESTfulExample/rest/todo/  => return the application/XML/JSON
		
		ClientConfig config = new DefaultClientConfig();
		Client client = Client.create(config);
		WebResource service = client.resource(getBaseURI());

		// Get XML
		logger.info(service.path("rest").path("todo").accept(MediaType.TEXT_XML).get(String.class));
		// Get XML for application
		logger.info(service.path("rest").path("todo").accept(MediaType.APPLICATION_JSON).get(String.class));
		// Get JSON for application
		logger.info(service.path("rest").path("todo").accept(MediaType.APPLICATION_XML).get(String.class));
	}

	private static URI getBaseURI() {
		return UriBuilder.fromUri("http://localhost:8088/RESTfulExample").build();
	}

}

