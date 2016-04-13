package com.onlinetechvision.user;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

/**
 * @author galloisg
 *
 */
public class UserRowMapper implements RowMapper<User> {
	 
	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
 
		User user = new User();
 
		user.setId(rs.getInt("id"));
		user.setName(rs.getString("name"));
		user.setSurname(rs.getString("surname"));
 
		return user;
	}
 
}
