package com.onlinetechvision.exe;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.onlinetechvision.user.User;
import com.onlinetechvision.user.service.IUserService;

public class ApplicationTest {

	private static final Logger logger = LoggerFactory.getLogger(Application.class);

	/**
	 * Starts the application
	 *
	 * @param  String[] args
	 *
	 */
	public static void main(String[] args) {
		logger.info("Strating Application Test ...");
		ApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");

		IUserService userService = (IUserService) appContext.getBean("userService");
		List<User> ul = userService.getUsers();
		for (User user : ul) {
			logger.info("User id {}, name {}",user.getId(), user.getName());
		}
	}

}
