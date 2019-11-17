package cn.itcast.jdbcutil;
/**
 *  实现JDBC的工具类
 *  定义方法，直接返回数据库的连接对象
 *  
 *  定义方法，关闭资源
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.spi.DirStateFactory.Result;

public class JDBCUtils {
	
	//1.将构造器私有化
	/*
	 * 因为工具类一般情况下都是静态直接调用的，不需要对象，
	 * 所以将构造方法私有化，不让它创建对象
	 */
	private JDBCUtils() {}	
	
	private static Connection con;
	
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/test";
			String username = "root";
			String password = "root";
			con = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			throw new RuntimeException(e + "数据库连接失败!");
		}
	}
	
	public static Connection getConnection() {
		return con;
	}
	
	public static void close(Connection con, Statement stat) {
		if(stat!=null) {
			try {
				stat.close();
			} catch (SQLException e) {}
		}
		
		if(con!=null) {
			try {
				con.close();
			} catch (SQLException e) {}
		}
	}
	
	public static void close(Connection con, Statement stat, ResultSet rs) {
		if(rs!=null) {
			try {
				rs.close();
			} catch (SQLException e) {}
		}
		
		if(stat!=null) {
			try {
				stat.close();
			} catch (SQLException e) {}
		}
		
		if(con!=null) {
			try {
				con.close();
			} catch (SQLException e) {}
		}
	}
	
}
