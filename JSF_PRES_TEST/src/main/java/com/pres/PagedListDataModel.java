package com.pres;

import java.util.List;

import javax.faces.model.DataModel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * RichFaces's DataModel to manage Pagined Table
 * 
 * @param <T>
 * Bean to display
 */
public class PagedListDataModel<T> extends DataModel{
	
	/** Logger SL4J */
	private static final Logger LOGGER = LoggerFactory.getLogger( PagedListDataModel.class );
	/**
	 * 
	 */
	private int rowIndex = -1;
	
	/**
	 * current page
	 */
	protected int currentPage = 1;
	
	/**
	 * rows by page
	 */
	protected int rowsByPage = 10;
	
	/**
	 * data to display for current page
	 */
	protected List<T> data;
	
	/**
	 * number total of row. Used to display number of pages.
	 */
	protected int rowCount;
	
	/**
	 * page change's listener to manage data loading.
	 */
	private final PageChangeListener pageChangeListener;

	/**
	 * @param pageChangeListener Listener of this model
	 */
	public PagedListDataModel( final PageChangeListener pageChangeListener ){
		LOGGER.trace("Call new PagedListDataModel ...");
		this.pageChangeListener = pageChangeListener;
	}
	
	/**
	 * @return {@link #currentPage}
	 */
	public int getCurrentPage(){
		LOGGER.trace("Call PagedListDataModel.getCurrentPage ...");
		return this.currentPage;
	}

	/**
	 * @param currentPage
	 * {@link #currentPage}
	 * 
	 * {@link PageChangeListener#pageChanged()} is called at this moment
	 */
	public void setCurrentPage( int currentPage ){
		LOGGER.trace("Call PagedListDataModel.setCurrentPage with currentpage = "+currentPage);
		this.currentPage = currentPage;
		pageChangeListener.pageChanged();
	}

	/**
	 * @return {@link #rowsByPage}
	 */
	public int getRowsByPage(){
		LOGGER.trace("Call PagedListDataModel.getRowsByPage ...");
		return this.rowsByPage;
	}

	/**
	 * @param rowsByPage {@link #rowsByPage}
	 */
	public void setRowsByPage( int rowsByPage ){
		LOGGER.trace("Call PagedListDataModel.setRowsByPage ...");
		this.rowsByPage = rowsByPage;
	}
	
	/**
	 * @return calculate start index in table
	 */
	public int getBeginIndex(){
		LOGGER.trace("Call PagedListDataModel.getBeginIndex ...");
		return (currentPage - 1) * rowsByPage;
	}

	/**
	 * @return calculate end index in table
	 */
	public int getEndIndex(){
		LOGGER.trace("Call PagedListDataModel.getEndIndex ...");
		return currentPage * rowsByPage - 1;
	}

	/**
	 * @see DataModel#isRowAvailable()
	 */
	public boolean isRowAvailable(){
		LOGGER.trace("Call PagedListDataModel.isRowAvailable ...");
		if( data == null ){
			return false;
		}

		int rowIndex = getRowIndex();
		if( rowIndex >= 0 && rowIndex < data.size() ){
			return true;
		}
		else{
			return false;
		}
	}

	/**
	 * {@link #rowCount}
	 */
	public int getRowCount(){
		LOGGER.trace("Call PagedListDataModel.getRowCount ...");
		return rowCount;
	}
	
	/**
	 * @param rowCount the rowCount to set
	 */
	public void setRowCount( int rowCount ){
		LOGGER.trace("Call PagedListDataModel.setRowCount ...");
		this.rowCount = rowCount;
	}

	/**
	 * @see DataModel#getRowData()
	 */
	public Object getRowData(){
		LOGGER.trace("Call PagedListDataModel.getRowData ...");
		if( data == null ){
			return null;
		}
		else if( !isRowAvailable() ){
			throw new IllegalArgumentException();
		}
		else{
			int dataIndex = getRowIndex();
			return data.get( dataIndex );
		}
	}

	/**
	 * @see DataModel#getRowIndex()
	 */
	public int getRowIndex(){
		LOGGER.trace("Call PagedListDataModel.getRowIndex ...");
		return( rowIndex % rowsByPage );
	}

	/**
	 * @see DataModel#setRowIndex(int)
	 */
	public void setRowIndex( int rowIndex ){
		LOGGER.trace("Call PagedListDataModel.setRowIndex ...");
		this.rowIndex = rowIndex;
	}

	/**
	 * @see DataModel#getWrappedData()
	 */
	public Object getWrappedData(){
		LOGGER.trace("Call PagedListDataModel.getWrappedData ...");
		return data;
	}

	/**
	 * @see DataModel#setWrappedData(Object) 
	 */
	@SuppressWarnings( "unchecked" )
	public void setWrappedData( Object data2Display ){
		LOGGER.trace("Call PagedListDataModel.setWrappedData ...");
		this.data = (List<T>)data2Display;
	}
}
