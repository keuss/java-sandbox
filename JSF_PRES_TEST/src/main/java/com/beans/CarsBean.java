package com.beans;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.models.InventoryItem;

/**
 * @author galloisg
 *
 */
@ManagedBean(name="carsBean")
@SessionScoped
public class CarsBean {

	/** LOGGER for the class. */
	private static final Logger LOGGER = LoggerFactory.getLogger(CarsBean.class);

	private List<String> vendorOptions = null;

	private List<InventoryItem> allInventoryItems = null;
	
	//Use to switch Extended Data Table to AJAX lazy-loading mode.
	//Specify number of rows rows to be loaded with one request. If this attribute is set to "0", all rows are loaded. (Default value: 0)
	private int clientRows = 5;

	/**
	 * @return the vendorOptions
	 */
	public List<String> getVendorOptions() {
		if(null == vendorOptions) {
			vendorOptions = new ArrayList<String>();
			vendorOptions.add("Ford");
			vendorOptions.add("Chevrolet");
			vendorOptions.add("GMC");
			vendorOptions.add("Nissan");
			vendorOptions.add("Fiat");
			vendorOptions.add("Merco");
			vendorOptions.add("Peugeot");
			vendorOptions.add("");
			LOGGER.info("init vendorOptions OK");
		}
		return vendorOptions;
	}

	/**
	 * @return List<InventoryItem>
	 * @throws ParseException 
	 */
	public List<InventoryItem> getAllInventoryItems() throws ParseException {

		LOGGER.info("Call for allInventoryItems ...");
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

		if(null == allInventoryItems) {
			InventoryItem i1 = new InventoryItem();
			i1.setMileage(1000L);
			i1.setModel("Corvette");
			i1.setPrice(4654L);
			i1.setVendor("Chevrolet");
			i1.setVin("WYJBRKKIWRBTYTKWW");
			i1.setDate(dateFormat.parse("07/02/2014"));

			InventoryItem i2 = new InventoryItem();
			i2.setMileage(800L);
			i2.setModel("Taurus");
			i2.setPrice(165464L);
			i2.setVendor("Ford");
			i2.setVin("ZGRFGDXGRNUGSCAAZ");
			i2.setDate(dateFormat.parse("01/02/2014"));
			
			InventoryItem i3 = new InventoryItem();
			i3.setMileage(800L);
			i3.setModel("500");
			i3.setPrice(165464L);
			i3.setVendor("Fiat");
			i3.setVin("ZGRFGDFGRNUGSCBBZ");
			i3.setDate(dateFormat.parse("01/02/2014"));
			
			
			InventoryItem i4 = new InventoryItem();
			i4.setMileage(800L);
			i4.setModel("SLK");
			i4.setPrice(165464L);
			i4.setVendor("Merco");
			i4.setVin("ZGRFGDFCGNUGSCAAZ");
			i4.setDate(dateFormat.parse("08/02/2014"));
			
			InventoryItem i5 = new InventoryItem();
			i5.setMileage(100L);
			i5.setModel("107");
			i5.setPrice(4654L);
			i5.setVendor("Peugeot");
			i5.setVin("AVCBRKKIWRBTYTKWW");
			i5.setDate(dateFormat.parse("07/02/2011"));
			
			InventoryItem i6 = new InventoryItem();
			i6.setMileage(710L);
			i6.setModel("308");
			i6.setPrice(4654L);
			i6.setVendor("Peugeot");
			i6.setVin("AVCBRKKIWRBTYTPOY");
			i6.setDate(dateFormat.parse("04/02/2014"));
			
			InventoryItem i7 = new InventoryItem();
			i7.setMileage(710L);
			i7.setModel("307");
			i7.setPrice(4654L);
			i7.setVendor("Peugeot");
			i7.setVin("AVCBRLSDWRBTYTPOY");
			i7.setDate(dateFormat.parse("04/02/1999"));
			
			InventoryItem i8 = new InventoryItem();
			i8.setMileage(710L);
			i8.setModel("307");
			i8.setPrice(4657L);
			i8.setVendor("Peugeot");
			i8.setVin("AVCBRKSDWRBTYTPOY");
			i8.setDate(dateFormat.parse("04/02/1998"));
			
			InventoryItem i9 = new InventoryItem();
			i9.setMileage(710L);
			i9.setModel("307");
			i9.setPrice(4604L);
			i9.setVendor("Peugeot");
			i9.setVin("AVHGDLSDWRBTYTPOY");
			i9.setDate(dateFormat.parse("04/02/1995"));
			
			InventoryItem i10 = new InventoryItem();
			i10.setMileage(710L);
			i10.setModel("307");
			i10.setPrice(4454L);
			i10.setVendor("Peugeot");
			i10.setVin("AVCBRLSDWRBTYTPGD");
			i10.setDate(dateFormat.parse("04/02/1991"));
			
			InventoryItem i11 = new InventoryItem();
			i11.setMileage(710L);
			i11.setModel("307");
			i11.setPrice(4454L);
			i11.setVendor("Peugeot");
			i11.setVin("AVCBRLSBFRBTYTPOY");
			i11.setDate(dateFormat.parse("01/02/1996"));

			allInventoryItems = new ArrayList<InventoryItem>();
			allInventoryItems.add(i1);
			allInventoryItems.add(i2);
			allInventoryItems.add(i3);
			allInventoryItems.add(i4);
			allInventoryItems.add(i5);
			allInventoryItems.add(i6);
			allInventoryItems.add(i7);
			allInventoryItems.add(i8);
			allInventoryItems.add(i9);
			allInventoryItems.add(i10);
			allInventoryItems.add(i11);
			for(int i = 0 ; i <= 50 ; i++) {
				allInventoryItems.add(i3);
			}
			for(int i = 0 ; i <= 50 ; i++) {
				allInventoryItems.add(i5);
			}
			LOGGER.info("init allInventoryItems OK");
		}
		
		return allInventoryItems;
	}

	/**
	 * @return the clientRows
	 */
	public int getClientRows() {
		return clientRows;
	}

}
