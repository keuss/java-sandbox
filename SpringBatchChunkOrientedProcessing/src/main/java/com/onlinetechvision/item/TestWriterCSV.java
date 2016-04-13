package com.onlinetechvision.item;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemWriter;

import com.onlinetechvision.user.UserBIS;
import com.onlinetechvision.user.service.IUserService;

/**
 * TestWriter Class is created to write items to DB, memory etc...
 * 
 * @author onlinetechvision.com
 * @since 10 Dec 2012
 * @version 1.0.0
 *
 */
public class TestWriterCSV implements ItemWriter<UserBIS> {
	
	
	private static final Logger logger = LoggerFactory.getLogger(TestWriterCSV.class);

	private IUserService userService;
	
	/**
	 * {@inheritDoc}
	 */
	public void write(List<? extends UserBIS> userList) throws Exception {
			logger.info("User List : " + userList);
	}

	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

}
