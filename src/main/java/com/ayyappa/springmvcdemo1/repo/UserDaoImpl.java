package com.ayyappa.springmvcdemo1.repo;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.ayyappa.springmvcdemo1.model.UserModel;
@Repository
public class UserDaoImpl implements UserDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	public UserModel isExist(UserModel userModel) {
		String sql="select id, name, password from users where name=? and password=?";
		RowMapper<UserModel> rowMapper = new RowMapper<UserModel>() {
			
			@Override
			public UserModel mapRow(ResultSet rs, int rowNum) throws SQLException {
				UserModel user = new UserModel();
				user.setId(rs.getInt("id"));
				user.setUserName(rs.getString("name"));
				user.setPassword(rs.getString("password"));
				return user;
			}
		};
		return jdbcTemplate.queryForObject(sql, rowMapper, userModel.getUserName(), userModel.getPassword());
	}
	@Override
	public int register(UserModel userModel) {
		String sql = "insert into users(name, password) values(?,?)";
		
		return jdbcTemplate.update(sql, userModel.getUserName(), userModel.getPassword());
	}

}
