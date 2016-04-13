/**
 * 
 */
package com.manning.sbia.ch01.batch;

import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.jdbc.core.JdbcTemplate;

import com.manning.sbia.ch01.domain.Product;

/**
 * @author acogoluegnes
 *
 */
public class ProductJdbcItemWriter implements ItemWriter<Product> {
	
	/**
	 * logger
	 */
	Logger logger = LoggerFactory.getLogger("com.manning.sbia.ch01.batch.ProductJdbcItemWriter");
	
	private static final String INSERT_PRODUCT = "insert into product (id,name,description,price) values(?,?,?,?)";
	
	private static final String UPDATE_PRODUCT = "update product set name=?, description=?, price=? where id = ?";
	
	private JdbcTemplate jdbcTemplate;
	
	public ProductJdbcItemWriter(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	/**
	 * {@inheritDoc}
	 */
	public void write(List<? extends Product> items) throws Exception {
		
		logger.info("Call for write with [{}] items : [{}]", items.size(), items.toString());
		for(Product item : items) {
			
			// test error
//			if("PR....214".equals(item.getId())) {
//				throw new Exception("Error for PR....214");
//			}
			// ----------
			int updated = jdbcTemplate.update(UPDATE_PRODUCT,
				item.getName(),item.getDescription(),item.getPrice(),item.getId()
			);
			if(updated == 0) {
				jdbcTemplate.update(
					INSERT_PRODUCT,
					item.getId(),item.getName(),item.getDescription(),item.getPrice()
				);	
			}								
		}
	}

}
