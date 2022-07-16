package com.userdetail.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.userdetail.entity.UserEntity;

@Repository
public class UserDao {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public List<UserEntity> getUser(int id){
		
		return jdbcTemplate.query("select * from users where id = " + id + " ",
				new RowMapper<UserEntity>() {
					public UserEntity mapRow(ResultSet rs, int rowNum) throws SQLException {

							UserEntity obj= new UserEntity();
							obj.setId(rs.getLong(1));
							obj.setName(rs.getString(2));
							obj.setCity(rs.getString(3));
							return obj;
					}}
		);
	}
	
public int updateUser(int id, String name, String city){
		return jdbcTemplate.update("update users set name = ?, city = ? where id = ? ", name, city, id);
	}
}
