package com.pres;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.serv.FunctionalException;
import com.serv.PersonService;
import com.serv.ReadWithPagingResult;
import com.serv.bdt.PersonSimpleBDT;

/**
 * Represent a pagined list of persons to display in jsf page.<br>
 * <br>
 * It's available in Spring/JSF Context with bean id : personListBean<br>
 * <br>
 * 
 */
@ManagedBean(name="personListBean")
@SessionScoped
public class PersonListBean implements PageChangeListener{
	/** Logger SL4J */
	private static final Logger LOGGER = LoggerFactory.getLogger( PersonListBean.class );
	
	/**
	 * Custom RichFaces DataModel to manage paged list<br>
	 * This bean is an listener of this data model to reload his data after each page
	 */
	private PagedListDataModel<PersonSimpleBDT> data = new PagedListDataModel<PersonSimpleBDT>(this);
	
	
	/**
	 * Injection by Spring. Do need a setter
	 */
	@ManagedProperty(value="#{personService}")
	private PersonService personService;
	
	/**
	 * To manage reloading in {@link #getData()}
	 */
	private boolean reinit = false;

	public void setPersonService(PersonService personService) {
		this.personService = personService;
	}

	/**
	 * To load {@link #data}<br>
	 * <br>
	 * This method will be called at bean start and at each page
	 */
	@PostConstruct
	public void load(){
		LOGGER.debug( "persons loading..." );
		
		try{
			LOGGER.debug( "beginIndex={}/endIndex={}/currentPage={}/rowByPage={}",new Object[]{
				data.getBeginIndex(),data.getEndIndex(),data.getCurrentPage(),data.getRowsByPage()
			});
			
			ReadWithPagingResult<PersonSimpleBDT> result = personService.readWithPaging( 
				data.getBeginIndex(), data.getEndIndex(), "id", true
			);
			
			data.setWrappedData( result.getList() );
			data.setRowCount( result.getCount() );
			
		}
		catch( FunctionalException e ){
			FacesMessageUtil.addGlobalError( LOGGER, e );
		}
		catch( RuntimeException e ){
			FacesMessageUtil.addGlobalError( LOGGER, e );
		}
	}
	
	/**
	 * @return the data
	 */
	public PagedListDataModel<PersonSimpleBDT> getData(){
		LOGGER.info("Call for getData ...");
		if( reinit ){
			LOGGER.debug( "reinit" );
			reinit = false;
			data.setCurrentPage( 1 );
		}
		return this.data;
	}

	/**
	 * @see PagedListDataModel
	 * @See PagedChangeListener
	 */
	public void pageChanged(){
		LOGGER.info("Call for pageChanged ...");
		load();
	}

	/**
	 * to force data reload for next {@link #getData()} call.<br>
	 * This method is exposed for the actions that update Person's Database
	 * 
	 * @param reinit the init to set
	 */
	public void reinit(){
		LOGGER.info("Call for reinit ...");
		reinit = true;
	}
}