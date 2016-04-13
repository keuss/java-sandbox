package com.onlinetechvision.item;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

import com.onlinetechvision.user.User;
import com.onlinetechvision.user.service.IUserService;


/**
 * @author galloisg
 *
 */
public class TestReaderBDD implements ItemReader<User> {

	private static final Logger logger = LoggerFactory.getLogger(TestReaderBDD.class);

	private IUserService userService;
	
	private int nbCalled = 0;
	//private int nbLines = 3;

	/**
	 * {@inheritDoc}
	 */
	public User read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		
		logger.info("nbCalled : [{}]", nbCalled);
		
		// no need, c'est le service qui retour null ... et qui arrête le JOB
//		if(nbCalled > nbLines) {
//			return null;
//		}
		
		User user = userService.getToMigrateUser(nbCalled);
		if(user != null) {
			logger.info("Read user [{}]", user.toString());
		}
		this.updateIndex();
		return user;
	}

	private void updateIndex() {
		nbCalled++;
	}
	
	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
}
