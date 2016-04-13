package com.serv;

import com.serv.bdt.PersonSimpleBDT;


/**
 * Interface of Service Layer for Person.<br>
 * <br>
 * Spring Bean id exposed : personservice
 * 
 */
public interface PersonService {
	
	/**
	 * @param person
	 * person to create
	 * 
	 * @return
	 * person created. <b>id</b> will be updated with the inserted person id.
	 * 
	 * @throws RuntimeException
	 * Throwed if error while requesting/processing data
	 */
	PersonSimpleBDT create( PersonSimpleBDT person );
	
	
	/**
	 * @param person
	 * person to update
	 * 
	 * @throws RuntimeException
	 * Throwed if error while requesting/processing data
	 */
	void update( PersonSimpleBDT person );
	
	
	/**
	 * @param id
	 * person's id to delete
	 * 
	 * @throws FunctionalException
	 * Throwed if <b>id</b> is null
	 * 
	 * @throws RuntimeException
	 * Throwed if error while requesting/processing data
	 */
	void delete( Long id ) throws FunctionalException;
	
	
	/**
	 * @param start
	 * start index
	 * 
	 * @param end
	 * end index. Must be greater or equals to <b>start</b>
	 * 
	 * @param propertyOrder
	 * PersonSimpleBDT property
	 * 
	 * @param ascending
	 * true : ascending order<br>
	 * false : descending order
	 * 
	 * @return
	 * Persons requested with number total of persons
	 * 
	 * @throws FunctionalException
	 * Throwed if <b>start</b> > <b>end</b> 
	 * 
	 * @throws RuntimeException
	 * Throwed if error while requesting/processing data
	 */
	ReadWithPagingResult<PersonSimpleBDT> readWithPaging( int start, int end ,String propertyOrder, boolean ascending  ) 
		throws FunctionalException;

}
