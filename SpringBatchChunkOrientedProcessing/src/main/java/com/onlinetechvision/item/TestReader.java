package com.onlinetechvision.item;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

import com.onlinetechvision.user.User;

/**
 * TestReader Class is created to read items which will be processed
 * 
 * @author onlinetechvision.com
 * @since 10 Dec 2012
 * @version 1.0.0
 *
 */
public class TestReader implements ItemReader<User> {
	
	private static final Logger logger = LoggerFactory.getLogger(TestReader.class);
	
	private int index;
	private int maxIndex;
	private String namePrefix;
	private String surnamePrefix;
	
	/**
     * Reads items one by one
     *
     * @return User
     * 
     * @throws Exception
     * @throws UnexpectedInputException
     * @throws ParseException
     * @throws NonTransientResourceException
     *
     */
	@Override
	public User read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		User user = new User();
		user.setName(getNamePrefix() + "_" + index);
		user.setSurname(getSurnamePrefix() + "_" + index);
				
		if(index > getMaxIndex()) {
			return null;
		}
		
		incrementIndex();
		logger.info("Read user [{}]", user.toString());
		return user;
	}

	/**
     * Increments index which defines read-count
     *
     * @return int
     * 
     */
	private int incrementIndex() {
		return index++;
	}

	public int getMaxIndex() {
		return maxIndex;
	}

	public void setMaxIndex(int maxIndex) {
		this.maxIndex = maxIndex;
	}

	public String getNamePrefix() {
		return namePrefix;
	}

	public void setNamePrefix(String namePrefix) {
		this.namePrefix = namePrefix;
	}

	public String getSurnamePrefix() {
		return surnamePrefix;
	}

	public void setSurnamePrefix(String surnamePrefix) {
		this.surnamePrefix = surnamePrefix;
	}
	
}
