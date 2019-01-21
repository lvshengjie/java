package com.thzm.eye025.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;


import com.thzm.eye025.bean.Subscribe;

public class SubscribeDAO {
	public static int insert(String sql, Object...args) throws SQLException {
		return JdbcTemplate.update(sql, args);
	}
	
//	public static int update(String sql, Object...args) throws SQLException {
//		return JdbcTemplate.update(sql, args);
//	}
//	
//	
//	public static List<Subscribe>  select(String sql, Object...args) throws SQLException{
//		ResultSetExtractor<List<Subscribe>> ext = new ResultSetExtractor<List<Subscribe>>() {
//
//			@Override
//			public List<Subscribe> extract(ResultSet rst) throws SQLException {
//				List<Subscribe> list = new ArrayList<>();
//				while(rst.next()) {
//					int id = rst.getInt("id");
//					String Name =rst.getString("name");
//					String conner=rst.getString("conner");
//					String email = rst.getString("email");
//					String gender=rst.getString("gender");
//					int age=rst.getInt("age");
//					String item=rst.getString("item");
//					Date date=rst.getDate("date");
//					String description=rst.getString("description");
//					
//					Subscribe abs=new Subscribe(Name, conner, email, gender, age, item, date, description);
//					list.add(abs);
//				}
//				return list;
//			}
//		
//		};
//		return  (List<Subscribe>) JdbcTemplate.select(sql, ext, args);
//		
//	}
//	public static void main(String[] args) throws SQLException {
//		List<Subscribe> list = select("select * from subscribe", null);
//		System.out.println(list);
//	}

	
}
