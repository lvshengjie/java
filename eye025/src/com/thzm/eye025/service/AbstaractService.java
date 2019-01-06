package com.thzm.eye025.service;


import java.sql.SQLException;
import java.util.List;

import com.thzm.eye025.bean.Abstract;
import com.thzm.eye025.dao.AbstractDAO;

public class AbstaractService {
	public static boolean publish(String content,boolean publishStatus,String...pictures) {
		boolean ok=true;
		
		try {
			if(publishStatus) {
				removeAllPublishStatus();
			}
			String sql="insert into abstract(content,publish_status) values(?,?)";
			AbstractDAO.insert(sql, content,publishStatus);
			
			if(null!= pictures) {
				for(int i=0;i<pictures.length;i++) {
					String upsql="update abstract set picture"+(i+1)+"=? where content=? and publish_status=?";
							AbstractDAO.update(upsql, pictures[i],content,publishStatus);
				}
			}
		}catch (SQLException e) {
			ok=false;
			e.printStackTrace();
		}
		return ok;
	}

	private static boolean removeAllPublishStatus() {
		boolean ok =true;
		String sql="update abstract set publish_status=0";
		try {
			int count=AbstractDAO.update(sql, null);
			if(count<0) {
				ok=false;
			}
		} catch (SQLException e) {
			ok=false;
			e.printStackTrace();
		}
		return ok;
	}
	

	public static int setPublishStatus(int id) throws SQLException {
		removeAllPublishStatus();
		String sql = "update abstract set publish_status=1 where id=?";
		return AbstractDAO.update(sql, id);
}
	

		
	
	
	public static List<Abstract> listAll() throws SQLException{
			String sql = "select * from abstract";
			return AbstractDAO.select(sql, null);
	}
	

	public static int delByID(int id) throws SQLException {
		String sql = "delete from abstract where id=?";
		return AbstractDAO.update(sql, id);
}
	
	
	
	
	public static void main(String[] args) {
		boolean ok=publish("简介4 。。。。。。", false, "p1.gif");
		System.out.println(ok);
	}
}