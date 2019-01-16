package com.thzm.eye025.dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.thzm.eye025.bean.Professor;

public class ProfessorDAO {
		
	public static int insert(String sql, Object...args) throws SQLException {
		return JdbcTemplate.update(sql, args);
	}
	
	public static int update(String sql, Object...args) throws SQLException {
		return JdbcTemplate.update(sql, args);
	}
	
public static List<Professor>  select(String sql, Object...args) throws SQLException {
		
		ResultSetExtractor<List<Professor>> ext = new ResultSetExtractor<List<Professor>>() {
			@Override
			public List<Professor> extract(ResultSet rst) throws SQLException {
				List<Professor> list = new ArrayList<>();
				while(rst.next()) {
					int id = rst.getInt("id");
					String Name =rst.getString("name");
					String photo=rst.getString("photo");
					String content = rst.getString("summary");
					int depid=rst.getInt("department_id");
					
					
			
					Professor abs = new Professor(Name, content, photo, depid);
				
					list.add(abs);
					
				}
				return list;
			}
		};
		return (List<Professor>) JdbcTemplate.select(sql, ext, args);
}
public static void main(String[] args) throws SQLException {
	List<Professor> list = select("select * from professor", null);
	System.out.println(list);
}
}
