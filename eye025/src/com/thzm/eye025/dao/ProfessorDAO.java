package com.thzm.eye025.dao;

import java.sql.SQLException;
import java.util.List;

import com.thzm.eye025.bean.Professor;

public class ProfessorDAO {
		
	public static int insert(String sql, Object...args) throws SQLException {
		return JdbcTemplate.update(sql, args);
	}
	
	public static int update(String sql, Object...args) throws SQLException {
		return JdbcTemplate.update(sql, args);
	}
	
	public static List<Professor> select(String sql, Object...args){
		
		return null;
		
	}
}
