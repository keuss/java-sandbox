package com.cgi.batch.spring;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.listener.ItemListenerSupport;

import com.cgi.batch.beans.Personne;

public class ItemFailureListener extends ItemListenerSupport<Personne, Personne> {

	/**
	 * Logger
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(ItemFailureListener.class);


	@Override
	public void onReadError(Exception ex) {
		LOGGER.error("Encountered error on read", ex);
	}

	@Override
	public void onWriteError(Exception ex, List<? extends Personne> item) {
		LOGGER.error("Encountered error on write", ex);
		if (item != null) {
			LOGGER.error("ERROR for items : [{}]", item.toString());
		} else  {
			LOGGER.error("ERROR for items for items null !");
		}
	}

}
