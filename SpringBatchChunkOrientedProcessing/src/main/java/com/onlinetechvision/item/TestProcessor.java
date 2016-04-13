package com.onlinetechvision.item;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

import com.onlinetechvision.user.User;
import com.onlinetechvision.user.UserBIS;

/**
 * TestProcessor Class is created to process items.
 * 
 * @author onlinetechvision.com
 * @since 10 Dec 2012
 * @version 1.0.0
 *
 */
public class TestProcessor implements ItemProcessor<User, UserBIS>  {
	
	private static final Logger logger = LoggerFactory.getLogger(TestProcessor.class);

	/**
	 * {@inheritDoc}
	 */
	public UserBIS process(User user) throws Exception {
		user.setName(user.getName().toUpperCase(Locale.ENGLISH));
		user.setSurname(user.getSurname().toUpperCase(Locale.ENGLISH));
		logger.info("Process user [{}]", user.toString());
		
		return new UserBIS(user.getId(), user.getName(), "otherData"+user.getId());
	}

}
