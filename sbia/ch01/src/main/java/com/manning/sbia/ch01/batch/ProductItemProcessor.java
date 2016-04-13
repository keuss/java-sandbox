package com.manning.sbia.ch01.batch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

import com.manning.sbia.ch01.domain.Product;

public class ProductItemProcessor implements ItemProcessor<Product, Product>  {

	/**
	 * logger
	 */
	Logger logger = LoggerFactory.getLogger("com.manning.sbia.ch01.batch.ProductItemProcessor");
	
	/**
	 * {@inheritDoc}
	 */
	public Product process(Product item) throws Exception {
		// TODO business code ... filter, validation, transform, ...
		item.setDescription(item.getName().concat(" description ..."));
		return item;
	} 

}
