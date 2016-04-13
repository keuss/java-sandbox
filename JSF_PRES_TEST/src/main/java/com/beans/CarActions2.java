package com.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.models.InventoryItem;

@ManagedBean(name="carsBean2")
@ViewScoped
public class CarActions2 {
	
	/** LOGGER for the class. */
	private static final Logger LOGGER = LoggerFactory.getLogger(CarActions2.class);
	
	private InventoryItem selectedItem  = new InventoryItem();
	
	
	/**
	 * @param selectedItem the selectedItem to set
	 */
	public void setSelectedItem(InventoryItem selectedItem) {
		LOGGER.info("setSelectedItem (InventoryItem) ... [" + selectedItem.getModel() + "]");
		this.selectedItem = selectedItem;
	}

	
	/**
	 * @return the selectedItem
	 */
	public InventoryItem getSelectedItem() {
		return selectedItem;
	}

}
