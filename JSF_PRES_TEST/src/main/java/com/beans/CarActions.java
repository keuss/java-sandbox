package com.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.models.InventoryItem;


/**
 * @author galloisg
 *
 */
@ManagedBean(name="carActions")
@ViewScoped
public class CarActions {

	/** LOGGER for the class. */
	private static final Logger LOGGER = LoggerFactory.getLogger(CarActions.class);
	
//	private InventoryItem selectedItem  = new InventoryItem();
	
	public void toggleItemSelectedActionListener() {
		 // LOGGER.debug("toggleItemSelectedActionListener() - click : [" + selectedItem.getModel() + "]");
	}

//	/**
//	 * @return the selectedItem
//	 */
//	public InventoryItem getSelectedItem() {
//		return selectedItem;
//	}

//	/**
//	 * @param selectedItem the selectedItem to set
//	 */
//	public void setSelectedItem(InventoryItem selectedItem) {
//		LOGGER.info("setSelectedItem (InventoryItem) ... [" + selectedItem.getModel() + "]");
//		this.selectedItem = selectedItem;
//	}
	
	
	

}
