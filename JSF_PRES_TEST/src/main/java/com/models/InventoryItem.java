package com.models;

import java.util.Date;

/**
 * @author galloisg
 *
 */
public class InventoryItem {

	private String vin;
	private String vendor;
	private String model;
	private Long mileage;
	private Long price;
	private Date date;
	private boolean selected = false;
	
	/**
	 * @return the vin
	 */
	public String getVin() {
		return vin;
	}


	/**
	 * @param vin the vin to set
	 */
	public void setVin(String vin) {
		this.vin = vin;
	}


	/**
	 * @return the vendor
	 */
	public String getVendor() {
		return vendor;
	}


	/**
	 * @param vendor the vendor to set
	 */
	public void setVendor(String vendor) {
		this.vendor = vendor;
	}


	/**
	 * @return the model
	 */
	public String getModel() {
		return model;
	}


	/**
	 * @param model the model to set
	 */
	public void setModel(String model) {
		this.model = model;
	}


	/**
	 * @return the mileage
	 */
	public Long getMileage() {
		return mileage;
	}


	/**
	 * @param mileage the mileage to set
	 */
	public void setMileage(Long mileage) {
		this.mileage = mileage;
	}


	/**
	 * @return the price
	 */
	public Long getPrice() {
		return price;
	}


	/**
	 * @param price the price to set
	 */
	public void setPrice(Long price) {
		this.price = price;
	}


	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}


	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}


	/**
	 * @return the selected
	 */
	public boolean isSelected() {
		return selected;
	}


	/**
	 * @param selected the selected to set
	 */
	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	
	

}
