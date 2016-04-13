package com.cgi.test.test_primefaces.bean;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author galloisg
 *
 */
@ManagedBean(name="initBean")
@ApplicationScoped
public class InitBean {

	/** LOGGER for the class. */
	private static final Logger LOGGER = LoggerFactory.getLogger(InitBean.class);

	/** DATA param ... */
	private Map<String, Object> mapConfig = new HashMap<String, Object>();

	@PostConstruct
	public void init() {

		LOGGER.debug("Call for init ...");
		if(mapConfig.isEmpty()) {
			mapConfig.put("key1", "value1");
			//...
		}

	}

	/**
	 * @return the mapConfig
	 */
	public Map<String, Object> getMapConfig() {
		return mapConfig;
	}
	
	

}
