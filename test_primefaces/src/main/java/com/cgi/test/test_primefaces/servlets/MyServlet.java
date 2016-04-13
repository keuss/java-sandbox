package com.cgi.test.test_primefaces.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.cgi.test.test_primefaces.model.User;
import com.cgi.test.test_primefaces.service.IUserService;

public class MyServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4533015297389037632L;
	
	/** LOGGER for the class. */
	private static final Logger LOGGER = LoggerFactory.getLogger(MyServlet.class);
	
	/**
	 * {@inheritDoc}
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LOGGER.debug("MyServlet.doPost ...");
		//TEST GGA 20130409 get spring bean
		WebApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(request.getSession().getServletContext());
		//Get the bean service ...
		IUserService userService = (IUserService) ctx.getBean("UserService");
		List<User> userList = new ArrayList<User>();
		userList.addAll(userService.getUsers());
		
		for (User user : userList) {
			LOGGER.debug("user:["+user.getId()+"]");
		}
	}

	/**
	 * {@inheritDoc}
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LOGGER.debug("MyServlet.doGet ...");
		doPost(request, response);
	}
}
