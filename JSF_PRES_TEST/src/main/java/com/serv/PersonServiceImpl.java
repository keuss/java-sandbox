package com.serv;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.serv.bdt.PersonSimpleBDT;

/**
 * Implementation of Service Layer for Person.<br>
 * 
 */
@Service("personService")
public class PersonServiceImpl implements PersonService {

	/** Logger SL4J */
	private static final Logger LOGGER = LoggerFactory
			.getLogger(PersonServiceImpl.class);

	/** the data for test */
	private Map<Long, PersonSimpleBDT> lPersonSimpleBDT = new HashMap<Long, PersonSimpleBDT>();

	public PersonServiceImpl() {
		LOGGER.info("new PersonServiceImpl ...");
	}

	/**
	 * To load data for test (no dao)
	 */
	@PostConstruct
	public void init() {
		long i = 0;

		for (i = 0; i < 100; i++) {
			PersonSimpleBDT personSimpleBDT = new PersonSimpleBDT();
			personSimpleBDT.setId(i);
			personSimpleBDT.setAddress("address" + i);
			personSimpleBDT.setLastName("lastName" + i);
			personSimpleBDT.setFirstName("firstName" + i);
			personSimpleBDT.setTown("town" + i);
			personSimpleBDT.setCountry("country" + i);
			lPersonSimpleBDT.put(i, personSimpleBDT);
		}

		LOGGER.info("init OK");
	}

	@Override
	public PersonSimpleBDT create(PersonSimpleBDT person) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(PersonSimpleBDT person) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Long id) throws FunctionalException {
		// TODO Auto-generated method stub

	}

	@Override
	public ReadWithPagingResult<PersonSimpleBDT> readWithPaging(int start,
			int end, String propertyOrder, boolean ascending)
			throws FunctionalException {
		
		LOGGER.info("ReadWithPagingResult page de {} a {}", start, end);

		ReadWithPagingResult<PersonSimpleBDT> result = new ReadWithPagingResult<PersonSimpleBDT>();
		List<PersonSimpleBDT> page = new ArrayList<PersonSimpleBDT>();

		for (int i = start; i<=end; i++) {
			page.add(lPersonSimpleBDT.get(new Long(i)));
		}

		result.setList(page);
		result.setCount(lPersonSimpleBDT.size());

		return result;
	}

}
