package com.thzm.eye025.service;

import java.sql.SQLException;
import java.util.List;

import com.thzm.eye025.bean.Professor;
import com.thzm.eye025.dao.ProfessorDAO;

public class ProfessorService {
	public static boolean publish(String...args) {
		boolean ok=true;
		
		try {
			
			String sql="insert into professor(name,photo,summary,department_id) values(?,?,?,?)";
			ProfessorDAO.insert(sql, args);
			
				
			
			}catch (SQLException e) {
							ok=false;
							e.printStackTrace();
						}
		return ok;
			}
	
			
	public static List<Professor> listAll() throws SQLException{
		String sql = "select * from professor";
		return ProfessorDAO.select(sql);
}
		public static void main(String[] args) throws SQLException {
			System.out.println(listAll());
		}

		
}


