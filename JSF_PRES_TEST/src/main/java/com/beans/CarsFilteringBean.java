package com.beans;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.richfaces.model.filter.Filter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.models.InventoryItem;

/**
 * @author galloisg
 *
 */
@ManagedBean(name="carsFilteringBean")
@ViewScoped
public class CarsFilteringBean implements Serializable {

	/** LOGGER for the class. */
	private static final Logger LOGGER = LoggerFactory.getLogger(CarsFilteringBean.class);
	
	private static final long serialVersionUID = -5680001353441022183L;
	private String vinFilter;
	private String vendorFilter;
	private String modelFilter;
	private Long mileageFilter;
	private Long priceFilter;
	private Date dateFilter;
	private boolean selectedFilter;
	
	
	/** for custom filter **/
	private Map<String, Object> filterValues = new HashMap<String, Object>();
	
	

	/**
	 * @return
	 */
	public Filter<?> getMileageFilterImpl() {
		LOGGER.info("getMileageFilterImpl ...");
		return new Filter<InventoryItem>() {
			public boolean accept(InventoryItem item) {
				Long mileage = getMileageFilter();
				if (mileage == null
						|| mileage == 0
						|| mileage.compareTo(item.getMileage().longValue()) >= 0) {
					return true;
				}
				return false;
			}
		};
	}

	/**
	 * @return
	 */
	public Filter<?> getFilterVendor() {
		LOGGER.info("getFilterVendor ...");
		return new Filter<InventoryItem>() {
			public boolean accept(InventoryItem t) {
				String vendor = getVendorFilter();
				if (vendor == null || vendor.length() == 0
						|| vendor.equals(t.getVendor())) {
					return true;
				}
				return false;
			}
		};
	}

	public Long getMileageFilter() {
		return mileageFilter;
	}

	public void setMileageFilter(Long mileageFilter) {
		LOGGER.info("setMileageFilter ... [" + mileageFilter + "]");
		this.mileageFilter = mileageFilter;
	}

	public String getVendorFilter() {
		return vendorFilter;
	}

	public void setVendorFilter(String vendorFilter) {
		LOGGER.info("setVendorFilter ... [" + vendorFilter + "]");
		this.vendorFilter = vendorFilter;
	}

	public String getVinFilter() {
		return vinFilter;
	}

	public void setVinFilter(String vinFilter) {
		LOGGER.info("setVinFilter ... [" + vinFilter + "]");
		this.vinFilter = vinFilter;
	}

	public String getModelFilter() {
		return modelFilter;
	}

	public void setModelFilter(String modelFilter) {
		LOGGER.info("setModelFilter ... [" + modelFilter + "]");
		this.modelFilter = modelFilter;
	}

	public Long getPriceFilter() {
		return priceFilter;
	}

	public void setPriceFilter(Long priceFilter) {
		LOGGER.info("setPriceFilter ... [" + priceFilter + "]");
		this.priceFilter = priceFilter;
	}

	/**
	 * @return the dateFilter
	 */
	public Date getDateFilter() {
		return dateFilter;
	}

	/**
	 * @param dateFilter the dateFilter to set
	 */
	public void setDateFilter(Date dateFilter) {
		LOGGER.info("setDateFilter ... [" + dateFilter + "]");
		this.dateFilter = dateFilter;
	}

	/**
	 * @return the filterValues
	 */
	public Map<String, Object> getFilterValues() {
		return filterValues;
	}

	/**
	 * @return the selectedFilter
	 */
	public boolean isSelectedFilter() {
		return selectedFilter;
	}

	/**
	 * @param selectedFilter the selectedFilter to set
	 */
	public void setSelectedFilter(boolean selectedFilter) {
		LOGGER.info("setSelectedFilter (boolean) ... [" + selectedFilter + "]");
		this.selectedFilter = selectedFilter;
	}
	
	
	
}