package com.thzm.eye025.service;


import java.sql.SQLException;


import com.thzm.eye025.dao.DepramentDAO;

public class DepramentService {
	public static boolean publish(String sname,String content,String ...piam) {
		boolean ok=true;
		
		try {
			
			String sql="insert into department(name,content,picture) values(?,?,?)";
			DepramentDAO.insert(sql, sname,content,piam);
			
				
			
			}catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
		return ok;
			}
	
				

		
}
