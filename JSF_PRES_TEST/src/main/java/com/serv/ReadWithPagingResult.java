package com.serv;

import java.io.Serializable;
import java.util.List;

/**
 * Class to return paged result from Service Layer.
 *
 * @param <T>
 */
public class ReadWithPagingResult<T> implements Serializable{
	
	/** @see Serializable **/
	private static final long serialVersionUID = -8621121839419207071L;
	
	/**
	 * Number total of results
	 */
	private int count;
	
	/**
	 * Pagined results requested
	 */
	private List<T> list;
	
	/**
	 * @return
	 * {@link #count}
	 */
	public int getCount(){
		return this.count;
	}
	
	/**
	 * @param count
	 * {@link #count}
	 */
	public void setCount( int count ){
		this.count = count;
	}
	
	/**
	 * @return
	 * {@link #list}
	 */
	public List<T> getList(){
		return this.list;
	}
	
	/**
	 * @param list
	 * {@link #list}
	 */
	public void setList( List<T> list ){
		this.list = list;
	}
}
