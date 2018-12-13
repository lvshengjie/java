package jdbcMsql;

import java.sql.Connection;
import java.sql.Date;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestDB {
	public static void main(String[] args) throws SQLException{
		Connection conn=null;
		Statement stm=null;
		ResultSet rst =null;
	try {

		//安装MaraDB JDB驱动
		Driver driver=new org.mariadb.jdbc.Driver();//子类为Driver接口，提供了实现，运行时多态
		DriverManager.registerDriver(driver);//注册驱动
		//获取数据库连接
		
		String url="jdbc:mariadb://127.0.0.1:3306/eye025";
		String user="eye025";
		String password="123456";
		conn=DriverManager.getConnection(url,user,password);//获取连接对象。该对象是访问数据库的核心
		//获取语句对象，向数据库发送SQL语句
		
		stm=conn.createStatement();//连接对象，创建语句对象
		String sql="select * from sys_admin";
		
		
		rst=stm.executeQuery(sql);//执行查询语句，语句对象将SQL语句，发送给数据库以执行。返回查询的结果集对象
		
		//处理（查询）返回的结果。结果集对象，是一个 基于连接的对象。其中存储的查询结果的游标（指针）
		while(rst.next()){
			int id =rst.getInt(1);
			String name=rst.getString(2);
			String pwd=rst.getString(3);
			String admin_name=rst.getString(4);
			int super_name=rst.getInt(5);
			
			System.out.println("id"+id+",name"+name+",pwd"+pwd+",admin_name"+admin_name+",super_name"+super_name);
		}
		
	}catch(Exception e) {
		e.printStackTrace();
	}finally {
		if(rst!=null) {rst.close();}
		if(stm!=null) {stm.close();}
		if(conn!=null) {conn.close();}
	}

	
		

	}

}
