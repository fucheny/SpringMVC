package com.zz.cc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.zz.model.User;

public class UserMapper implements RowMapper<User> {

	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User user = new User();
		user.setId(rs.getInt("id"));
		user.setName(rs.getString("name"));
		user.setSex(rs.getString("sex"));
		user.setPhone(rs.getString("phone"));
		user.setGroupz(rs.getString("groupz"));
		user.setLeader(rs.getString("leader"));
		return user;
	}

}
