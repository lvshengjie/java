package com.thzm.eye025.dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.thzm.eye025.bean.Deprament;

public class DepramentDAO {
	public static int insert(String sql, Object...args) throws SQLException {
		return JdbcTemplate.update(sql, args);
	}
	
	public static int update(String sql, Object...args) throws SQLException {
		return JdbcTemplate.update(sql, args);
	}
	
public static List<Deprament>  select(String sql, Object...args) throws SQLException {
		
		ResultSetExtractor<List<Deprament>> ext = new ResultSetExtractor<List<Deprament>>() {
			@Override
			public List<Deprament> extract(ResultSet rst) throws SQLException {
				List<Deprament> list = new ArrayList<>();
				while(rst.next()) {
					int id = rst.getInt("id");
					String sname =rst.getString("name");
					String piam=rst.getString("picture");
					String content = rst.getString("content");
					
					
			
					Deprament abs = new Deprament(sname, piam, content);
				
					list.add(abs);
					
				}
				return list;
			}
		};
		
		
		return (List<Deprament>) JdbcTemplate.select(sql, ext, args);
	}
	
	public static void main(String[] args) throws SQLException {
		List<Deprament> list = select("select * from department", null);
		System.out.println(list);
	}
}

