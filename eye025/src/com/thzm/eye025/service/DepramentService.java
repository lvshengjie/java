package com.thzm.eye025.service;


import java.sql.SQLException;
import java.util.List;

import com.thzm.eye025.bean.Abstract;
import com.thzm.eye025.bean.Deprament;
import com.thzm.eye025.dao.AbstractDAO;
import com.thzm.eye025.dao.DepramentDAO;

public class DepramentService {
	public static boolean publish(String sname,String content,String piam) {
		boolean ok=true;
		
		try {
			
			String sql="insert into department(name,content,picture) values(?,?,?)";
			DepramentDAO.insert(sql, sname,content,piam);
			
				
			
			}catch (SQLException e) {
							ok=false;
							e.printStackTrace();
						}
		return ok;
			}
	public static List<Deprament> listAll() throws SQLException{
		String sql = "select * from department";
		return DepramentDAO.select(sql);
}
		public static void main(String[] args) throws SQLException {
			System.out.println(listAll());
		}
				

		
}
