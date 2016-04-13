package com.cgi.test.test_primefaces.utils;

import javax.el.ELContext;
import javax.faces.FacesException;
import javax.faces.context.FacesContext;

/**
 * @author galloisg
 * @see http://www.javacodegeeks.com/2012/04/5-useful-methods-jsf-developers-should.html?utm_content=bufferb8bb5&utm_source=buffer&utm_medium=twitter&utm_campaign=Buffer
 */
public class FacesAccessor {

	/**
	 * get ManagedBean by name (Injection is good, but sometimes if beans are rare called, it’s not necessary to inject beans into each other)
	 * 
	 * @param beanName
	 * @return the ManagedBean
	 */
	public static Object getManagedBean(final String beanName) {
		FacesContext fc = FacesContext.getCurrentInstance();
		Object bean;

		try {
			ELContext elContext = fc.getELContext();
			bean = elContext.getELResolver().getValue(elContext, null, beanName);
		} catch (RuntimeException e) {
			throw new FacesException(e.getMessage(), e);
		}

		if (bean == null) {
			throw new FacesException("Managed bean with name '" + beanName
					+ "' was not found. Check your faces-config.xml or @ManagedBean annotation.");
		}

		return bean;
	}
}
