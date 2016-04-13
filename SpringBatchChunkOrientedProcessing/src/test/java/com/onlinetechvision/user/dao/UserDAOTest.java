package com.onlinetechvision.user.dao;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.onlinetechvision.user.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContextTest.xml")
@TransactionConfiguration(defaultRollback = false)
public class UserDAOTest {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserDAOTest.class);

	@Autowired
	private IUserDAO userDAO;

	@Test
	public void testDAOInjection_OK() {
		LOGGER.info("Test testDAOInjection_OK ...");
		assertNotNull(userDAO);
	}

	@Test
	public void testReadUsersByName() {

		// Besoin d'ajouter @Transactional(readOnly = true) à getUsers dans le DAO
		// => getCurrentSession() only makes sense inside a scope of transaction.
		// http://stackoverflow.com/questions/10459922/org-hibernate-hibernateexception-no-session-found-for-current-thread

		LOGGER.info("Test testReadUsersByName ...");
		List<User> ul = userDAO.getUsersByName("firstname_1");
		assertNotNull(ul);
		for (User user : ul) {
			LOGGER.info("User id {}, name {}", user.getId(), user.getName());
		}
	}
}
